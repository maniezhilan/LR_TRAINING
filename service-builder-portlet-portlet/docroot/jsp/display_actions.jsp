<%@ include file="/init.jsp"%>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Book book = (Book)row.getObject();
String name = Book.class.getName();
String isbn = String.valueOf(book.getIsbn());
%>
	<portlet:actionURL name="bookDetails" var="bookDetailURL">
		<portlet:param name="isbn" value="<%=isbn%>" />
	</portlet:actionURL>
	<liferay-ui:icon image="view" url="<%=bookDetailURL.toString() %>" />
	<portlet:actionURL name="deleteBook" var="deleteURL">
		<portlet:param name="isbn" value="<%=isbn%>" />
	</portlet:actionURL>
	<liferay-ui:icon image="delete" url="<%=deleteURL.toString() %>" />
	

