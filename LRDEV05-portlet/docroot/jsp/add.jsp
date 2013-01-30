<%@ include file="/init.jsp"%>
	<liferay-portlet:actionURL name="addBook" var="addBookURL"></liferay-portlet:actionURL>
	
	<%
	
	Books book = (Books)request.getAttribute("book");
	
	%>
	
	<portlet:renderURL portletMode="view" var="viewURL" />
	
	<aui:form action="<%=addBookURL.toString() %>" method="post" name="fm">
		<table border="1">
			<tr>
				<td bgcolor="#99CCFF"><b>Title</b></td>
				<td><input name="title" label="Title" type="text" value=""/></td>
			</tr>
			<tr>
				<td bgcolor="#99CCFF"><b>Author</td></b>
				<td><input name="author" label="Author" type="text" value=""/></td>
			</tr>
			<tr>
				<td bgcolor="#99CCFF"><b>ISBN</b></td>
				<td><input name="isbn" label="ISBN" type="text" value=""/></td>
			</tr>
			<tr>
				<td bgcolor="#99CCFF"><b>Summary</b></td>
				<td><liferay-ui:input-editor name="summary"/>
				<input name="<portlet:namespace />" type="hidden"/></td>
			</tr>
			<tr>
			<td></td>
			<td align="right"><aui:button class="aui-button-input" type="submit" value="Add" /></td>
			</tr>
		</table>
	</aui:form>
	<aui:button
          type="cancel"
          value="Cancel"
          onClick="<%= viewURL %>"/>
          