package com.arthurchan35.wcse.wc.portlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.portlet.Portlet;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.osgi.service.component.annotations.Component;

import com.arthurchan35.wcse.model.Page;
import com.arthurchan35.wcse.service.PageLocalServiceUtil;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=webcrawler-portlet Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class WebCrawlerPortlet extends MVCPortlet {

	private void fetchPage(String urlScanned, Document doc) {
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
			
			HashSet<String> set = new HashSet<>();// using hash set to remove duplicates

			for (String temp : spl) {
				
				temp = temp.replaceAll("^[^a-zA-Z0-9\\s]+|[^a-zA-Z0-9\\s]+$", ""); // removing leading and trailing non alphabetics
				if (temp.equals("") || temp.equals(" ") || temp.equals("\t") || temp.equals("\n")) continue;
				if (temp.length() > 32) continue;
				temp = temp.toLowerCase();

				if (!set.contains(temp)) { // using hashset to remove duplicates
					list.add(temp);
					set.add(temp);
				}
			}
		}
		Elements imageElements = doc.select("img[src~=(?i)\\.(png|jpe?g|gif|bmp)]");
		Element ele = imageElements.last();
		if (ele != null) image = ele.absUrl("src");

		//service builder auto-handles transaction roll back
		Page page = PageLocalServiceUtil.addPage(urlScanned, description, image, list);

	}

}