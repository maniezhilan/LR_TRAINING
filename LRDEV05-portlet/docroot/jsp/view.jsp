<%@ include file="/init.jsp"%>

<portlet:defineObjects />

<portlet:resourceURL var="testURL" id="view.jsp" escapeXml="false" />

<script type="text/javascript">
function <portlet:namespace/>Test(row_id,bookId) {
    $.ajax({
    type: "POST",
    url: "<%=renderResponse.encodeURL(testURL.toString())%>",
    data: {bookId:bookId},
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

	<%--

 WindowState windowState = null;
 PortletMode portletMode = null;
 PortletURL currentURLObj = null;
 if (renderRequest != null) {
          windowState = renderRequest.getWindowState();
          portletMode = renderRequest.getPortletMode();
          currentURLObj = PortletURLUtil.getCurrent(renderRequest, renderResponse);
} else if (resourceRequest != null) {
         windowState = resourceRequest.getWindowState();
          portletMode = resourceRequest.getPortletMode();
          currentURLObj = PortletURLUtil.getCurrent(resourceRequest, resourceResponse);
 }

String currentURL = currentURLObj.toString();

 --%> 
	
	<%
		List<Books> bookList = (List<Books>)request.getAttribute("bookList");
		if(bookList!=null && bookList.size() > 0){
	%>
	<div id="<portlet:namespace/>content">
	<form name="testform" id="testform">
	<table  class="taglib-search-iterator">
		<tr class="portlet-section-header results-header">
			<% if(prefs_title){ %>
			<th class="col-1 col-title first">Title</th>
			<% } if(prefs_author){ %>
			<th class="col-2 col-author">Author</th>
			<% } if(prefs_isbn){ %>
			<th class="col-3 col-isbn">ISBN</th>
			<% } if(prefs_summary){ %>
			<th class="col-4 col-summary">Summary</th>
			<% } %>
			<th></th>
		</tr>
		<%
			for(Books book:bookList){
		%>	
			<tr id="<portlet:namespace/><%=book.getBookId()%>">
			<% if(prefs_title){ %>
			<td>
			<portlet:actionURL name="bookDetails" var="bookDetailURL">
				<portlet:param name="bookId" value="<%=String.valueOf(book.getBookId())%>" />
			</portlet:actionURL> 
			<a href="<%=bookDetailURL.toString()%>"><%=book.getTitle() %></a> </td>
			<% } if(prefs_author){ %>
			<td><%=book.getAuthor() %></td>
			<% } if(prefs_isbn){ %>
			<td><%=book.getIsbn() %></td>
			<% } if(prefs_summary){ %>
			<td><%=book.getSummary() %></td>
			<% } %>
			<td>
			<input type="button" value = "Delete" onClick="<portlet:namespace/>Test(<portlet:namespace/><%=book.getBookId()%>,<%=book.getBookId()%>);return false;">
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

