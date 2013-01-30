<%@ include file="/init.jsp"%>

<portlet:defineObjects />

<portlet:resourceURL var="testURL" id="view.jsp" escapeXml="false" />

<script type="text/javascript">
function <portlet:namespace/>Test(row_id,isbn) {
    $.ajax({
    type: "POST",
    url: "<%=renderResponse.encodeURL(testURL.toString())%>",
    data: {isbn:isbn},
    success: function(msg) {
    	var div = document.getElementById(row_id.id);
	    if(msg == 0){
	    	div.innerHTML = "No books";		
	    }else{
        	div.innerHTML = "";
	    }
	    
    }
    });
}
</script>
	
	<%
		List<Book> bookList = (List<Book>)request.getAttribute("bookList");
		if(bookList!=null && bookList.size() > 0){
	%>
	<div id="<portlet:namespace/>content">
	<form name="testform" id="testform">
	<table  class="taglib-search-iterator">
		<tr class="portlet-section-header results-header">
			<th class="col-1 col-title first">Title</th>
			<th class="col-2 col-author">Author</th>
			<th class="col-3 col-isbn">ISBN</th>
			<th class="col-4 col-summary">Summary</th>
			<th></th>
		</tr>
		<%
			for(Book book:bookList){
		%>	
			<tr id="<portlet:namespace/><%=book.getIsbn()%>">
			<td>
			<portlet:actionURL name="bookDetails" var="bookDetailURL">
				<portlet:param name="isbn" value="<%=String.valueOf(book.getIsbn())%>" />
			</portlet:actionURL> 
			<a href="<%=bookDetailURL.toString()%>"><%=book.getTitle() %></a> </td>
			<td><%=book.getAuthor() %></td>
			<td><%=book.getIsbn() %></td>
			<td><%=book.getSummary() %></td>
			<td>
			<input type="button" value = "Delete" onClick="<portlet:namespace/>Test(<portlet:namespace/><%=book.getIsbn()%>,<%=book.getIsbn()%>);return false;">
			</td>
			</tr>
		<% } 
		} else {
			out.println("No books.");
		}
		%>
	</table>
	</form>
	</div>
<liferay-portlet:renderURL var="addBookURL">
	<portlet:param name="mvcPath" value="/jsp/add.jsp" />
</liferay-portlet:renderURL>
<liferay-ui:icon image="add" url="<%=addBookURL.toString() %>" />

