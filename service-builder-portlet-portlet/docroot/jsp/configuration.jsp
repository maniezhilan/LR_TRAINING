<%@ include file="/init.jsp"%>
<portlet:defineObjects />

<form action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post" name="<portlet:namespace />fm"> 
	<input name="<portlet:namespace /><%=Constants.CMD%>" type="hidden" value="<%=Constants.UPDATE%>" /> 
	<h3>Display Options</h3>
	<table>
	<tr>
		<td><liferay-ui:input-checkbox defaultValue="<%=prefs_title%>" param="prefs_title"/></td><td>Title</td>
	</tr>
	<tr>
		<td><liferay-ui:input-checkbox defaultValue="<%=prefs_author%>" param="prefs_author"/></td><td>Author</td>
	</tr>
	<tr>
		<td><liferay-ui:input-checkbox defaultValue="<%=prefs_isbn%>" param="prefs_isbn"/></td><td>ISBN</td>
	</tr>
	<tr>
	    <td><liferay-ui:input-checkbox defaultValue="<%=prefs_summary%>" param="prefs_summary"/></td><td>Summary</td>
	</tr>
	</table>
	
	<input type="button" value="<liferay-ui:message key="save" />" onClick="submitForm(document.<portlet:namespace />fm);" /> 
</form>