<%@ include file="/init.jsp"%>
<%
	Books book = (Books)request.getAttribute("book");
%>

<h1><%= book.getTitle() %></h1>

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