<%@ include file="/init.jsp"%>
	<liferay-portlet:actionURL name="addBook" var="addBookURL"></liferay-portlet:actionURL>
	
	<%
	
	Books book = (Books)request.getAttribute("book");
	//ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
    //long scopeGroupIdBook = themeDisplay.getScopeGroupId();
	
	%>
	
	<portlet:renderURL portletMode="view" var="viewURL" />
	
	<aui:form action="<%=addBookURL.toString() %>" method="post" name="fm">
		<table id="mytable">
			<tr>
				<td><b>Title</b></td>
				<td><input name="title" label="Title" type="text" value="" style="width:650px"/></td>
				<td></td>
			</tr>
			<tr>
				<td><b>Author</b></td>
				<td><input name="author" label="Author" type="text" value="" style="width:650px"/></td>
				<td></td>
			</tr>
			<tr>
				<td><b>ISBN</b></td>
				<td><input name="isbn" label="ISBN" type="text" value="" style="width:650px"/></td>
				<td></td>
			</tr>
			<tr>
				<td><b>Summary</b></td>
				<td><liferay-ui:input-editor name="summary"/>
				<input name="<portlet:namespace />" type="hidden"/></td>
				<td></td>
			</tr>
			<tr>
			<td></td>
			<td align="left"><input type="image" src="<%= themeDisplay.getPathThemeImage() %>/icons/delete-icon.png" onClick="<%= viewURL %>"/></td>
			<%
    		if (permissionChecker.hasPermission(scopeGroupId, "sample.lrdev05.database.model.Books", scopeGroupId, "ADD_ENTRY")) { %>
			<td align="right"><input type="image" src="<%= themeDisplay.getPathThemeImage() %>/icons/add-icon.png" value="Add" /></td>
			<% } %>
			</tr>
		</table>
	</aui:form>
	
          