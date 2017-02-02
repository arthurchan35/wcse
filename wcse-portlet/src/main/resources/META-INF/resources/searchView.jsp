<%@ include file="/init.jsp" %>

<portlet:actionURL name="search" var="searchURL" windowState="normal" />

<aui:form action="<%= searchURL %>" method="post" name="fm">
	<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />

	<aui:input label="search" name="search" required="<%= true %>" type="text" />

	<aui:button-row>
		<aui:button type="submit" value="submit" />
	</aui:button-row>
</aui:form>

<liferay-ui:search-container emptyResultsMessage="no-results-found-please-try-a-different-search-criteria">
	
	<liferay-ui:search-container-results>
		<%
			String wordsInput = ParamUtil.getString(request, "search");
			results = PageLocalServiceUtil.findPagesByWords(wordsInput, searchContainer.getStart(), searchContainer.getEnd());
			total = results.size();
			searchContainer.setResults(results);
			searchContainer.setTotal(total);
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="com.arthurchan35.wcse.model.Page" escapedModel="<%= true %>" keyProperty="pageId" modelVar="currPage" >

		<%
			String url = currPage.getUrl();
			String des = currPage.getDescription();
			Blob imgBlob = currPage.getImage();
			String img = new String(imgBlob.getBytes(1, (int) imgBlob.length()));
		%>

		<liferay-ui:search-container-column-text name="pageURL" value="<%= url %>" />
		<liferay-ui:search-container-column-text name="pageDescription" value="<%= des %>" />
		<liferay-ui:search-container-column-image src="<%= img %>" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>