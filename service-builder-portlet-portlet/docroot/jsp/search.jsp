<%@ include file="/init.jsp"%>

<liferay-portlet:actionURL name="searchBook" var="searchBookURL"></liferay-portlet:actionURL>

<aui:form action="<%=searchBookURL.toString() %>" method="post" name="searchForm">
<table>
			<tr>
				<td>
				Enter ISBN
				</td>
				<td>
				<input name="isbnNumber" label="ISBN" type="text" value=""/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><aui:button class="aui-button-input" type="submit" value="Search" /></td>
			</tr>
</table>
</aui:form>