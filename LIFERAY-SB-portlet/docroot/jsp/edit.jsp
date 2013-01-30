<%@ include file="/init.jsp"%>
	
	<%
	Books book = (Books)request.getAttribute("book");
	%>
	<portlet:actionURL name="updateBook" var="updateBookURL"/>
	<aui:form action="<%=updateBookURL.toString() %>" method="post" name="fm">
	<input type="hidden" name="bookId" value="<%=String.valueOf(book.getBookId())%>"/>
	<table border="1">
			<tr>
				<td><b>Title</b></td>
				<td><input name="title" label="Title" type="text" value="<%= book.getTitle() %>" style="width:650px"/></td>
			</tr>
			<tr>
				<td><b>Author</b></td>
				<td><input name="author" label="Author" type="text" value="<%= book.getAuthor() %>" style="width:650px"/></td>
			</tr>
			<tr>
				<td><b>ISBN</b></td>
				<td><input name="isbn" label="ISBN" type="text" value="<%= book.getIsbn() %>" style="width:650px"/></td>
			</tr>
			<tr>
				<td><b>Summary</b></td>
				<td>
					<aui:field-wrapper>
		       			<liferay-ui:input-editor initMethod="initEditor" name="summary" />
		       			<script type="text/javascript">
				         function <portlet:namespace />initEditor() {
				          return "<%=UnicodeFormatter.toString(book.getSummary())%>";
				         }
				       </script>
	  			   </aui:field-wrapper>
				<input name="<portlet:namespace />" type="hidden" />
				</td>
			</tr>
			<tr><td><td align="center"><input type="image" src="<%= themeDisplay.getPathThemeImage() %>/icons/add-icon.png" value="Update" /> </td><td></td> </tr>
	</table>
		
	</aui:form>
