package cs390;
import java.io.*;
import java.net.*;
import java.util.regex.*;
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
		stat.executeUpdate("CREATE TABLE url_table (url_id INT NOT NULL PRIMARY KEY, url VARCHAR(512) NOT NULL, url_description VARCHAR(128))");
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

	public boolean insertURLInDB( String url, String des) throws SQLException, IOException {
		System.out.println("url = " + url + "; descrption len = " + des.length());
		Statement stat = connection.createStatement();
		String query = "INSERT INTO url_table VALUES ('"+urlID+"','"+url+"','"+des+"')";
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
			if (!set.contains(temp)) { // using hashset to remove duplicates
				temp = temp.replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", ""); // removing starting and ending non alphebetics
				
				//Pattern stn = Pattern.compile("(\\s|\\t|\\n)*");
				//Matcher matcher = stn.matcher(temp);
				//if (matcher.matches()) continue;
				if (temp.equals("") || temp.equals(" ") || temp.equals("\t") || temp.equals("\n")) continue;
				if (temp.length() > 32) continue;
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
				//list.addAll(Arrays.asList(element.split("[,\\s]+")));
			}
			try {
			insertURLInDB(urlScanned, description);
			insertWordsInDB(list);
			}
			catch (Exception e) {
				System.out.println("Somethin happen in insertion");
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
		if (url == null) return;
		do {
			try {
				if (urlInDB(url)) {
					url = queue.poll();
					continue;
				}
				
				if (urlID >= 100) break;
				Document doc = null;
				try {
				doc = Jsoup.connect(url).get();
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
			crawler.createDB();
			crawler.queue.offer(root);
			crawler.fetchURL();
			//crawler.fetchPage("https://www.cco.purdue.edu/asp/aspnet/GradSurvey/");
			//crawler.fetchPage("https://www.cs.purdue.edu/corporate/internships/index.html");
		}
		catch( Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
