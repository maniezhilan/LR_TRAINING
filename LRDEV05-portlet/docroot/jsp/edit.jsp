<%@ include file="/init.jsp"%>
	
	<%
	Books book = (Books)request.getAttribute("book");
	%>
	<portlet:actionURL name="updateBook" var="updateBookURL"/>
	<aui:form action="<%=updateBookURL.toString() %>" method="post" name="fm">
	<input type="hidden" name="bookId" value="<%=String.valueOf(book.getBookId())%>"/>
	<table border="1">
			<tr>
				<td bgcolor="#99CCFF"><b>Title</b></td>
				<td><input name="title" label="Title" type="text" value="<%= book.getTitle() %>"/></td>
			</tr>
			<tr>
				<td bgcolor="#99CCFF"><b>Author</b></td>
				<td><input name="author" label="Author" type="text" value="<%= book.getAuthor() %>"/></td>
			</tr>
			<tr>
				<td bgcolor="#99CCFF"><b>ISBN</b></td>
				<td><input name="isbn" label="ISBN" type="text" value="<%= book.getIsbn() %>"/></td>
			</tr>
			<tr>
				<td bgcolor="#99CCFF"><b>Summary</b></td>
				<td>
					<aui:field-wrapper>
		       			<liferay-ui:input-editor initMethod="initEditor" name="summary"/>
		       			<script type="text/javascript">
				         function <portlet:namespace />initEditor() {
				          return "<%=UnicodeFormatter.toString(book.getSummary())%>";
				         }
				       </script>
	  			   </aui:field-wrapper>
				<input name="<portlet:namespace />" type="hidden" />
				</td>
			</tr>
	
	</table>
	<aui:button-row>
		<aui:button class="aui-button-input" type="submit" value="Update" />
	</aui:button-row>
	</aui:form>
