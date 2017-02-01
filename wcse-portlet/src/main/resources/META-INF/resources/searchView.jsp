<%@ include file="/init.jsp" %>

<liferay-ui:search-container emptyResultsMessage="no-results-found-please-try-a-different-search-criteria">
	<liferay-ui:search-container-results>

<%
	results = SimpleUserLocalServiceUtil.findByZip(zip, searchContainer.getStart(), searchContainer.getEnd());
	total = SimpleUserLocalServiceUtil.countByZip(zip);
	searchContainer.setResults(results);
	searchContainer.setTotal(total);
%>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row
		className="com.liferay.portal.model.User"
		escapedModel="<%= true %>"
		keyProperty="userId"
		modelVar="currUser"
	>

		<%
		StringBundler sb = new StringBundler(7);
		sb.append(currUser.getFirstName());
		sb.append(' ');
		sb.append(currUser.getLastName().charAt(0));
		sb.append(". (");
		sb.append(currUser.getScreenName());
		sb.append(") - ");
		sb.append(currUser.getEmailAddress());
		String userInfo = sb.toString();
		%>

		<liferay-ui:search-container-column-text name="userInfo" value="<%= userInfo %>" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>