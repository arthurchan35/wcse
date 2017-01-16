<%@ include file="/init.jsp" %>

<portlet:actionURL name="startCrawler" var="startCrawlerURL" />

<aui:form action="<%= startCrawlerURL %>" method="post" name="fm">

		<aui:input name="maxurl" type="textarea" />
		<aui:input name="domain" type="textarea" />
		<aui:input name="root" type="textarea" />

		<aui:button onClick="" type="submit" value="send" />

</aui:form>