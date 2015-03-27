package cs390;
import java.io.*;
import java.sql.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	
	Connection connection;
	int urlID;
	public Properties props;
	Queue<String> queue;

	Crawler() {
		urlID = 0;
		queue = new LinkedList<String>();
	}

	public ArrayList<MYURL> getURL (String str) throws SQLException, IOException {
		Statement stat = connection.createStatement();
		ResultSet result = stat.executeQuery( "SELECT * FROM word_table WHERE word = '"+str+"'");
		ArrayList<Integer> url_id_list = new ArrayList<Integer>();
		ArrayList<MYURL> myURL_list = new ArrayList<MYURL>();
		while (result.next())
			url_id_list.add(result.getInt("url_id"));
		result.close();	
		
		for (int i : url_id_list) {
			ResultSet resultURL = stat.executeQuery("SELECT * FROM url_table WHERE url_id = '"+i+"'");
			if (resultURL.next()) {
				MYURL myURL = new MYURL(i, resultURL.getString("url"), resultURL.getString("url_description"), resultURL.getString("image"));
				myURL_list.add(myURL);
			}
			resultURL.close();
		}
		return myURL_list;
	}
	
	public void readProperties() throws IOException {
		props = new Properties();
		FileInputStream in = new FileInputStream("src\\cs390\\database.properties");
		props.load(in);
		in.close();
	}
	/*do you believe?*/
	public void openConnection() throws SQLException, IOException {
		String drivers = props.getProperty("jdbc.drivers");
		if (drivers != null) System.setProperty("jdbc.drivers", drivers);

		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");

		connection = DriverManager.getConnection( url, username, password);
	}

	public void createDB() throws SQLException, IOException {
		
		Statement stat = connection.createStatement();

		// Delete the table first if any
		try {
			stat.executeUpdate("DROP TABLE url_table");
			stat.executeUpdate("DROP TABLE word_table");
		}
		catch (Exception e) {}

		// Create the table
		stat.executeUpdate("CREATE TABLE url_table (url_id INT NOT NULL PRIMARY KEY, url VARCHAR(512) NOT NULL, url_description VARCHAR(128), image VARCHAR(512))");
		stat.executeUpdate("CREATE TABLE word_table (word VARCHAR(32) NOT NULL, url_id INT NOT NULL)");
	}

	public int returnMaxURLID() throws SQLException, IOException {
		Statement stat = connection.createStatement();
		ResultSet result = stat.executeQuery( "SELECT MAX(url_id) FROM url_table");
		if (result.next()) 
			return result.getInt("MAX(url_id)");
		return -1;
	}
	
	public boolean urlInDB(String urlFound) throws SQLException, IOException {
		Statement stat = connection.createStatement();
		ResultSet result = stat.executeQuery( "SELECT * FROM url_table WHERE url LIKE '"+urlFound+"'");
		if (result.next()) return true;
		return false;
	}

	public boolean insertURLInDB( String url, String des, String image) throws SQLException, IOException {
		System.out.println("url = " + url + "; descrption len = " + des.length());
		Statement stat = connection.createStatement();
		String query = "INSERT INTO url_table VALUES ('"+urlID+"','"+url+"','"+des+"', '"+image+"')";
		stat.executeUpdate( query );
		stat.close();
		urlID++;
		System.out.println("url = " + url + "; descrption len = " + des.length());
		return true;
	}
	
	public void insertWordsInDB(List<String> list) throws SQLException, IOException {
		PreparedStatement statement = connection.prepareStatement("INSERT INTO word_table (word, url_id) VALUES (?, ?)");
		urlID -= 1;

		HashSet<String> set = new HashSet<>();// using hashset to remove duplicates

		for (String temp: list) {
			
			temp = temp.replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", ""); // removing starting and ending non alphebetics
			if (temp.equals("") || temp.equals(" ") || temp.equals("\t") || temp.equals("\n")) continue;
			if (temp.length() > 32) continue;
			temp = temp.toLowerCase();
			
			if (!set.contains(temp)) { // using hashset to remove duplicates
				//System.out.println("word = " + temp + "; word len = " + temp.length());
				statement.setString(1, temp);
				statement.setInt(2, urlID);
				statement.addBatch();
				set.add(temp);
		    }

		}
		statement.executeBatch();
		statement.close();
		urlID += 1;
	}
		
	public void fetchPage(String urlScanned, Document doc) {
		String description = "";
		String image = "";

		Elements descriptionElements = doc.select("title, h0, h1, h2, h3, h4, h5, h6, p");
		int descriptionLength = 0;
		int elementLength = 0;
		List<String> list = new ArrayList<>();
		for (Element descriptionElement : descriptionElements) {
			String element = descriptionElement.text();
			descriptionLength = description.length();
			elementLength = element.length();
			if (descriptionLength + elementLength <= 128 - 2) {
				if (description.length() > 0) description += " ";
				description += element;
			}
			String []spl = element.split("[\\s|\\x80-\\xff]+");
			List<String> l = Arrays.asList(spl);
			list.addAll(l);
		}
		Elements imageElements = doc.select("img[src~=(?i)\\.(png|jpe?g|gif|bmp)]");
		Element ele = imageElements.last();
		if (ele != null) image = ele.absUrl("src");

		
		int backup = urlID;

		try{	
			insertURLInDB(urlScanned, description, image);
			insertWordsInDB(list);
		}
		catch (Exception e) {
			Statement stat = null;
			urlID = backup;
			try {
				stat = connection.createStatement();
				stat.executeQuery( "SET SQL_SAFE_UPDATES = 0");
				stat.executeUpdate( "DELETE FROM url_table WHERE url_id = '"+urlID+"'");
				stat.executeUpdate( "DELETE FROM word_table WHERE url_id = '"+urlID+"'");
			} catch (SQLException e1) { System.out.println("Somethin happened in deleting");}
			System.out.println("Somethin happen in insertin urls or words");
		}
	}
	
	public void removeRedundent(int maxID) throws SQLException, IOException{
		Statement stat = connection.createStatement();
		stat.executeQuery( "SET SQL_SAFE_UPDATES = 0");
		stat.executeUpdate( "DELETE FROM url_table WHERE url_id = '"+maxID+"'");
		stat.executeUpdate( "DELETE FROM word_table WHERE url_id = '"+maxID+"'");
		
	}
	
	public void fetchURL() {
		String url = queue.poll();

		String domain = props.getProperty("crawler.domain");

		do {
			if (url == null) return;
			if (!url.toLowerCase().contains(domain)) {
				url = queue.poll();
				continue;
			}
			try {
				boolean yn = false;
				try {
					yn = urlInDB(url);
				} catch (Exception e) {yn = true;}
				if (yn) {
					url = queue.poll();
					continue;
				}
				
				if (urlID >= 50000) break;
				Document doc = null;
				try {
				doc = Jsoup.connect(url).userAgent("Mozilla").get();
				}
				catch (Exception hse) {
					System.out.println("connection error to this url: " + url + ". Try to skip it.");
					url = queue.poll();
					continue;
				}
				fetchPage(url, doc);
				
				Elements links = doc.select("a[href]");
		
				for (Element link : links) 
					queue.offer(link.absUrl("href"));
				
			}
			catch (Exception e) {
				e.printStackTrace();
				return;
			}
	
			url = queue.poll();
		} while (url != null);		
	}
	
	public static void main(String[] args) {
		Crawler crawler = new Crawler();
		try {
			crawler.readProperties();
			String root = crawler.props.getProperty("crawler.root");
			crawler.openConnection();
			ArrayList<MYURL> arrayList = crawler.getURL("Zhiyuan");
			for (MYURL myURL: arrayList) {
				System.out.println(myURL.url_id + ": " + myURL.url);
				System.out.println(myURL.url_description);
				System.out.println(myURL.image);
			}
		//	crawler.createDB();
		//	crawler.queue.offer(root);
		//	crawler.fetchURL();
		//	crawler.queue.offer("ftp://ftp.cs.purdue.edu/");
		//	crawler.fetchURL();
			
		}
		catch( Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
