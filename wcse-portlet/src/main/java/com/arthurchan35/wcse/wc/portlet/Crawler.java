package com.arthurchan35.wcse.wc.portlet;
import java.io.*;
import java.sql.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.arthurchan35.wcse.model.Page;
import com.arthurchan35.wcse.service.PageLocalServiceUtil;
import com.arthurchan35.wcse.service.persistence.PageUtil;
import com.liferay.portal.kernel.util.Validator;

public class Crawler {
	
	static Crawler crawler;
	
	Queue<String> queue;
	int maxURL;
	String domain;
	
	private Crawler() {
		queue = new LinkedList<String>();
		maxURL = 50000;
		domain = "localHost";
	}

	public static Crawler getCrawlerSingleton() {
		if (crawler == null) crawler = new Crawler();
		return crawler;
	}
	
	public static void setProperty(int maxURL, String domain) {
		
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
/*
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
	}*/
/*
	public int returnMaxURLID() throws SQLException, IOException {
		Statement stat = connection.createStatement();
		ResultSet result = stat.executeQuery( "SELECT MAX(url_id) FROM url_table");
		if (result.next()) 
			return result.getInt("MAX(url_id)");
		return -1;
	}
*/
/*	public boolean urlInDB(String urlFound) throws SQLException, IOException {
		Statement stat = connection.createStatement();
		ResultSet result = stat.executeQuery( "SELECT * FROM url_table WHERE url LIKE '"+urlFound+"'");
		if (result.next()) return true;
		return false;
	}*/

	private void fetchPage(String urlScanned, Document doc) {
		StringBuilder description = new StringBuilder(150); //cautious, stringbuilder is not thread safe but faster

		Elements descriptionElements = doc.select("title, h0, h1, h2, h3, h4, h5, h6, p");

		List<String> list = new ArrayList<>();

		for (Element descriptionElement : descriptionElements) {
			String descriptionElementStr = descriptionElement.text();
			int descriptionLength = description.length();
			int elementLength = descriptionElementStr.length();
			if (descriptionLength + elementLength <= 128 - 2) {
				if (description.length() > 0)
					description.append(' ');
				description.append(descriptionElementStr);
			}
			String []spl = descriptionElementStr.split("[\\s|\\x80-\\xff]+");
			
			HashSet<String> set = new HashSet<>();// using hash set to remove duplicates

			for (String word : spl) {
				word = word.replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", ""); // removing leading and trailing non alphabetics
				if (Validator.isNull(word)) continue;
				if (word.length() > 32) continue;
				word = word.toLowerCase();
				if (set.contains(word)) continue;// using hashset to remove duplicates
				list.add(word);
				set.add(word);
			}
		}
		
		String image = "";

		Elements imageElements = doc.select("img[src~=(?i)\\.(png|jpe?g|gif|bmp)]");
		Element ele = imageElements.last();
		
		if (ele != null) image = ele.absUrl("src");

		//service builder auto-handles transaction roll back
		Page page = PageLocalServiceUtil.addPage(urlScanned, description.toString(), image, list);
	}

/*	public void removeRedundent(int maxID) throws SQLException, IOException{
		Statement stat = connection.createStatement();
		stat.executeQuery( "SET SQL_SAFE_UPDATES = 0");
		stat.executeUpdate( "DELETE FROM url_table WHERE url_id = '"+maxID+"'");
		stat.executeUpdate( "DELETE FROM word_table WHERE url_id = '"+maxID+"'");
	}*/

	public void fetchURL() {
		String url = queue.poll();
		long totalPages = PageLocalServiceUtil.getPagesCount();
		do {
			if (totalPages >= maxURL) break;
			if (url == null) return;
			if (!url.toLowerCase().contains(domain)) {
				url = queue.poll();
				continue;
			}
			Page page = PageUtil.fetchByURL(url);
			if (page != null) {
				url = queue.poll();
				continue;
			}

			Document doc = null;
			try {
			doc = Jsoup.connect(url).userAgent("Mozilla").get();
			}
			catch (Exception hse) {
				System.out.println("connection error to this url: " + url + " Skiping");
				url = queue.poll();
				continue;
			}

			fetchPage(url, doc);
			totalPages++;

			Elements links = doc.select("a[href]");

			for (Element link : links) 
				queue.offer(link.absUrl("href"));

			url = queue.poll();
		} while (url != null);		
	}

	/*public static void main(String[] args) {
		Crawler crawler = new Crawler();
		try {
			crawler.readProperties();
			String root = crawler.props.getProperty("crawler.root");
			crawler.openConnection();
			//ArrayList<MYURL> arrayList = crawler.getURL("Zhiyuan");
			//for (MYURL myURL: arrayList) {
			//	System.out.println(myURL.url_id + ": " + myURL.url);
			//	System.out.println(myURL.url_description);
			//	System.out.println(myURL.image);
			//}
			crawler.createDB();
			crawler.queue.offer(root);
			crawler.fetchURL();
		//	crawler.queue.offer("ftp://ftp.cs.purdue.edu/");
		//	crawler.fetchURL();
			
		}
		catch( Exception e) {
			e.printStackTrace();
			return;
		}
	}*/
}
