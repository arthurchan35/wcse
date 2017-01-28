package com.arthurchan35.wcse.wc.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Crawler Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class WebCrawlerPortlet extends MVCPortlet {

	@Override
	public void processAction(ActionRequest request, ActionResponse response)
		throws IOException, PortletException {

		Crawler crawler = Crawler.getSingleton();
		int maxURL = ParamUtil.getInteger(request, "maxurl");
		String domain = ParamUtil.getString(request, "domain");
		String root = ParamUtil.getString(request, "root");
		
		System.out.println("maxURL1: " + maxURL + " domain1: " + domain + " root1: " + root);

		crawler.start(maxURL, domain, root);
		
		System.out.println("finished crawlering");

	}
}