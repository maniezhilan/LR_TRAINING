<%@ include file="/init.jsp"%>
<%
	Books book = (Books)request.getAttribute("book");
	if(book == null){
		out.println("No Book found.");
		return;
	}
%>
<h2>Book Details</h2>
<table border="1">
<tr>
<td bgcolor="#99CCFF"><b>Title</b></td><td><%=book.getTitle()%></td>
</tr>
<tr>
<td bgcolor="#99CCFF"><b>Author</b></td><td><%=book.getAuthor()%></td>
</tr>
<tr>
<td bgcolor="#99CCFF"><b>ISBN</b></td><td><%=book.getIsbn()%></td>
</tr>
<tr>
<td bgcolor="#99CCFF"><b>Summary</b></td><td><%=book.getSummary()%></td>
</tr>
</table>
<br></br>
<liferay-portlet:actionURL name="editBook" var="editURL">
		<portlet:param name="bookId" value="<%=String.valueOf(book.getBookId())%>" />
</liferay-portlet:actionURL>
<liferay-ui:icon image="edit" url="<%=editURL.toString() %>" />