package com.arthurchan35.wcse.wc.portlet;
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
	String root;
	
	private Crawler() {
		queue = new LinkedList<String>();
		maxURL = 50000;
		domain = "localHost";
		root = "localHost:8080";
	}
	/* portal db service has limit of 75 chars for String type
	 * and parameters after question mark or hashtag should be removed
	 * and avoid duplicate urls like:
	 * http://bla.com/xxx, bla.com/xxx/
	 * and remove leading bla:// and bla://
	 * and remove email
	 *  */
	private String trimURL(String url, String domain) {

		if (url.contains("mailto") || !url.contains(domain) || url.length() > 75)
			return "";

		int begin = url.indexOf("://");
		begin = (begin < 0) ? 0 : (begin + 3);
		
		int qm = url.indexOf('?');
		qm = (qm < 0) ? (url.length()) : qm;
		
		int ht = url.indexOf('#');
		ht = (ht < 0) ? (url.length()) : ht;
		
		int end = (qm < ht) ? qm : ht;
		
		while (url.charAt(end - 1) == '/') end--;
		return url.substring(begin, end);
	}

	private void fetchPage(String urlScanned, Document doc) {
		StringBuilder description = new StringBuilder(150); //cautious, stringbuilder is not thread safe but faster
	
		Elements descriptionElements = doc.select("title, h0, h1, h2, h3, h4, h5, h6, p");
	
		List<String> list = new ArrayList<>();
	
		for (Element descriptionElement : descriptionElements) {
			String descriptionElementStr = descriptionElement.text();
			int descriptionLength = description.length();
			int elementLength = descriptionElementStr.length();
			if (descriptionLength + elementLength <= 74) {
				if (description.length() > 0)
					description.append(' ');
				description.append(descriptionElementStr);
			}
			String []spl = descriptionElementStr.split("[\\s|\\x80-\\xff]+");
			
			HashSet<String> set = new HashSet<>();// using hash set to remove duplicates words in a page
	
			for (String word : spl) {
				word = word.replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", ""); // removing leading and trailing non alphabetics
				if (Validator.isNull(word)) continue;
				if (word.length() > 75) continue;
				word = word.toLowerCase();
				if (set.contains(word)) continue;// using hashset to remove duplicate words in a page
				list.add(word);
				set.add(word);
			}
		}
		
		String image = "";
	
		Elements imageElements = doc.select("img[src~=(?i)\\.(png|jpe?g|gif|bmp)]");
		Element ele = imageElements.last();
		
		if (ele != null) image = ele.absUrl("src");
	
		//service builder auto-handles transaction roll back
		Page page = PageLocalServiceUtil.addPage(urlScanned, description.toString(), image.getBytes(), list);
	}

	public static Crawler getSingleton() {
		if (crawler == null) crawler = new Crawler();
		return crawler;
	}
	
	public void start(int maxURL, String domain, String root) {
		this.maxURL = (maxURL > 0) ? maxURL : this.maxURL;
		this.domain = Validator.isNotNull(domain) ? domain : this.domain;
		this.root = Validator.isNotNull(root) ? root : this.root;
		
		queue.offer(root);
		fetchURL();
	}

	/* BFS traversing websites */
	public void fetchURL() {
		String url = queue.poll();

		long totalPages = PageLocalServiceUtil.getPagesCount();

		while (url != null && totalPages <= maxURL) {

			try {
				Page page = PageLocalServiceUtil.fetchByURL(url);
				if (page != null) throw new Exception();
			}
			catch (Exception e) {
				url = queue.poll();
				continue;
			}

			Document doc = null;
			try {
				doc = Jsoup.connect("http://" + url).userAgent("Mozilla").get();
			}
			catch (Exception hse) {
				System.out.println("connection error to this url: " + url + " Skiping");
				url = queue.poll();
				continue;
			}

			fetchPage(url, doc);
			totalPages++;

			Elements links = doc.select("a[href]");
			
			HashSet<String> uniqueURL = new HashSet<String>();
			for (Element link : links) {
				String linkStr = link.absUrl("href");
				System.out.println("before: " + linkStr);
				linkStr = trimURL(linkStr, domain);
				if (! linkStr.equals("") && !uniqueURL.contains(linkStr)) {
					uniqueURL.add(linkStr);
					queue.offer(linkStr);
				}
				System.out.println("after: " + linkStr);
			}
		} 
	}
}
