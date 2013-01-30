<%@ include file="/init.jsp"%>
<%
	Book book = (Book)request.getAttribute("book");
	if(book == null){
		out.println("No Book found.");
		return;
	}
%>
<h2>Book Details</h2>
<table>
<tr>
<td>Title</td><td><%=book.getTitle()%></td>
</tr>
<tr>
<td>Author</td><td><%=book.getAuthor()%></td>
</tr>
<tr>
<td>ISBN</td><td><%=book.getIsbn()%></td>
</tr>
<tr>
<td>Summary<td><td><%=book.getSummary()%></td>
</tr>
</table>

<liferay-portlet:actionURL name="editBook" var="editURL">
		<portlet:param name="isbn" value="<%=String.valueOf(book.getIsbn())%>" />
</liferay-portlet:actionURL>
<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />