<%@ include file="/init.jsp"%>
<%
	PortletPreferences pref = renderRequest.getPreferences();
	String portletRes = ParamUtil.getString(request, "portletResource");
	if (Validator.isNotNull(portletRes)) {
   		pref = PortletPreferencesFactoryUtil.getPortletSetup(request, portletRes);
	}
 	String welcome_message = pref.getValue("welcome_message", "Personalizable welcome message");
%>
<liferay-portlet:actionURL name="editPrefs" var="editPrefsURL"></liferay-portlet:actionURL>
<form action="<%=editPrefsURL.toString()%>" method="POST" name="<portlet:namespace />fm"> 
  <table>
    <tr>
      <td class="lfr-label">Edit welcome message</td>
      <td><input name="welcome_message" type="text" value="<%= welcome_message%>"/></td>
    </tr> 
  </table>
  <input type="submit" value="<liferay-ui:message key="save" />" /> 
</form>