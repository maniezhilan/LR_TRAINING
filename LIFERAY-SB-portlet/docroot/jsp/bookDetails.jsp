<%@ include file="/init.jsp"%>
<%
	long bookId = ParamUtil.getLong(request, "bookId");
	Books book = BooksLocalServiceUtil.getBooks(bookId);
%>

<h3>Book Details</h3>
<table id="mytable">
<tr>
<td><b>Title</b></td><td><%=book.getTitle()%></td>
</tr>
<tr>
<td><b>Author</b></td><td><%=book.getAuthor()%></td>
</tr>
<tr>
<td><b>ISBN</b></td><td><%=book.getIsbn()%></td>
</tr>
<tr>
<td><b>Summary</b></td><td><%=book.getSummary()%></td>
</tr>
</table>
<br></br>
<table>
<tr>
	<td>
		<liferay-portlet:actionURL name="listBook" var="backURL"/>
	  		<a href = "<%= backURL.toString() %>">Home </a>
	</td>
	<%
	  			if(permissionChecker.isSignedIn()){ %>
	<td>&nbsp;&nbsp;&nbsp;</td>
	<td>
		<liferay-portlet:actionURL name="editBook" var="editURL">
			<portlet:param name="bookId" value="<%=String.valueOf(book.getBookId())%>" />
		</liferay-portlet:actionURL>
	  		<a href = "<%= editURL.toString() %>">Edit </a> 
	</td>
	<% } %>
</tr>
</table>

<br></br>
<liferay-ui:ratings className="<%= Books.class.getName() %>"
    classPK="<%= book.getBookId() %>" type="stars" />

<liferay-ui:panel-container extended="<%= false %>"
    id="BooksCommentsPanelContainer" persistState="<%= true %>">

  <liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
      id="BooksCommentsPanel" persistState="<%= true %>"
      title='Comments'>

    <portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL"/>
	    <liferay-ui:discussion className="<%= Books.class.getName() %>"
	        classPK="<%=book.getBookId()%>" 
	        formAction="<%= discussionURL%>" formName="fm2"
	        ratingsEnabled="<%= true %>" redirect="<%= currentURL%>"
	        subject="<%= book.getTitle() %>"
	        userId="<%= book.getUserId() %>" />
	
  </liferay-ui:panel>

</liferay-ui:panel-container>

