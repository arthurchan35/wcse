package com.arthurchan35.wcse.se.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name= Site Search Engine",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/searchView.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SearchEnginePortlet extends MVCPortlet {

	@Override
	public void processAction(ActionRequest request, ActionResponse response)
		throws IOException, PortletException {

		String keyWords = ParamUtil.getString(request, "keyWords");
		response.setRenderParameter("keyWords", keyWords);
		response.setRenderParameter("mvcPath", "/searchView.jsp");
	}

}
