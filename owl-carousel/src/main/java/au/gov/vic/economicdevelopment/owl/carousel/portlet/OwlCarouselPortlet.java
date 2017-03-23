package au.gov.vic.economicdevelopment.owl.carousel.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Arthur Chan
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.footer-portlet-javascript=/owlcarousel/owl.carousel.min.js",
		"com.liferay.portlet.header-portlet-css=/owlcarousel/assets/owl.carousel.min.css",
		"com.liferay.portlet.header-portlet-css=/owlcarousel/assets/owl.theme.default.min.css",
		"com.liferay.portlet.system=false",
		"com.liferay.portlet.use-default-template=false",
		"javax.portlet.display-name=Owl Carousel",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=au_gov_vic_economicdevelopment_owl_carousel_portlet_OwlCarouselPortlet",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OwlCarouselPortlet extends MVCPortlet {
}