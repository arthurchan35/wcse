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

	public static Crawler getCrawlerSingleton() {
		if (crawler == null) crawler = new Crawler();
		return crawler;
	}
	
	public void start(int maxURL, String domain, String root) {
		this.maxURL = (maxURL > 0) ? maxURL : this.maxURL;
		this.domain = Validator.isNotNull(domain) ? domain : this.domain;
		this.root = Validator.isNotNull(root) ? root : this.root;
		
		queue.offer(this.root);
		fetchURL();
	}

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
			
			HashSet<String> set = new HashSet<>();// using hash set to remove duplicates words in a page

			for (String word : spl) {
				word = word.replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", ""); // removing leading and trailing non alphabetics
				if (Validator.isNull(word)) continue;
				if (word.length() > 32) continue;
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
		Page page = PageLocalServiceUtil.addPage(urlScanned, description.toString(), image, list);
	}

	/* BFS traversing websites */
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
}
