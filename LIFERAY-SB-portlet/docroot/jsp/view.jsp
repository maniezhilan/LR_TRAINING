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
<%	
	request.setAttribute("bookList", BooksLocalServiceUtil.getAllBooks());
%> 


<portlet:renderURL var="addBookURL">
  <portlet:param name="jspPage" value="/jsp/add.jsp" />
</portlet:renderURL>

	<jsp:useBean id="bookList" class="java.util.ArrayList" scope="request"/>
	
	<!-- table starts here -->
	<div id="<portlet:namespace/>content">
	<form name="testform" id="testform">
	<table id="mytable">
		<tr>
			
			<c:if test="${prefs_title}">
				<th>Title</th>
			</c:if>	
			<c:if test="${prefs_author}">
				<th>Author</th>
			</c:if>
			<c:if test="${prefs_isbn}">
				<th>ISBN</th>
			</c:if>
			<c:if test="${prefs_summary}">
				<th>Summary</th>
			</c:if>
			<th></th>			
		</tr>
		<c:if test="${not empty bookList}">
		<c:forEach items="${bookList}" var="book">
		<c:set var="pk" value="${book.bookId}" scope="request"/>
		
		<tr id="<portlet:namespace/>${book.bookId}">
			<c:if test="${book.isApproved()}">
	  			<c:if test="${prefs_title}">
	  				<portlet:renderURL  var="bookDetailURL">
	  					<portlet:param name="jspPage" value="/jsp/bookDetails.jsp"/>
						<portlet:param name="bookId" value="${book.bookId}" />
					</portlet:renderURL> 
	  				<td><a href="${bookDetailURL}"><c:out value="${book.title}" escapeXml="true"/></a></td>
	  			</c:if>
	  			<c:if test="${prefs_author}">
	  				<td><c:out value="${book.author}"/></td>
	  			</c:if>	
	  			<c:if test="${prefs_isbn}">
	  				<td><c:out value="${book.isbn}"/></td>
	  			</c:if>
				<c:if test="${prefs_summary}">
	  				<td>${book.summary}</td>
	  			</c:if>
	  			<td>
	  			<% //if (permissionChecker.hasPermission(scopeGroupId, "sample.lrdev05.database.model.Books", scopeGroupId, "ADD_ENTRY")) { %>
					<input type="image" src="<%= themeDisplay.getPathThemeImage() %>/icons/delete-icon.png" onClick="<portlet:namespace/>Test(<portlet:namespace/><%=request.getAttribute("pk").toString()%>,<%=request.getAttribute("pk").toString()%>);return false;">
				<% //} %>
				</td>
			</c:if>
		</tr>
		</c:forEach>
		</c:if>
		<c:if test="${empty bookList}">
			<h3>No Books.</h3>
		</c:if>
	</table>
	</form>
	</div>
  			<% //if (permissionChecker.hasPermission(scopeGroupId, "sample.lrdev05.database.model.Books", scopeGroupId, "ADD_ENTRY")) { %>
				<c:if test='<%= PortletPermissionUtil.contains(permissionChecker, portletDisplay.getId(), "ADD_ENTRY") %>'>
  					<input type="image" src="<%= themeDisplay.getPathThemeImage() %>/icons/add-icon.png" onClick="location.href = '<%= addBookURL.toString() %>';" />
				</c:if>
			<% //} %>
