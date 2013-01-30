<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortalPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.model.User" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@page import="sample.lrdev05.database.model.Books"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.ActionRequest" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="javax.portlet.PortletMode" %>
<%@ page import="com.liferay.portlet.PortletURLUtil" %>
<%@ page import="sample.lrdev05.util.*" %>
<%@ page import="sample.lrdev05.database.service.BooksLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page isELIgnored ="false" %>

<script type="text/javascript">
 
$(document).ready(function(){
        $(".portlet-msg-success").slideUp(2000);
});
 
</script>


<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String currentURL = PortalUtil.getCurrentURL(request);
PortletPreferences preferences = null;
boolean  prefs_title = false;
boolean  prefs_author = false;
boolean  prefs_isbn = false;
boolean  prefs_summary = false;

if(renderRequest!=null){
preferences = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

prefs_title = Boolean.parseBoolean(preferences.getValue("prefs_title", StringPool.BLANK));
prefs_author = Boolean.parseBoolean(preferences.getValue("prefs_author", StringPool.BLANK));
prefs_isbn = Boolean.parseBoolean(preferences.getValue("prefs_isbn", StringPool.BLANK));
prefs_summary = Boolean.parseBoolean(preferences.getValue("prefs_summary", StringPool.BLANK));
request.setAttribute("prefs_title",prefs_title);
request.setAttribute("prefs_author",prefs_author);
request.setAttribute("prefs_isbn",prefs_isbn);
request.setAttribute("prefs_summary",prefs_summary);

}else{
	out.println("Application Not available.");
}
%>
<c:set var="prefs_title" value="${prefs_title}" scope="request"/>
<c:set var="prefs_author" value="${prefs_author}" scope="request"/>
<c:set var="prefs_isbn" value="${prefs_isbn}" scope="request"/>
<c:set var="prefs_summary" value="${prefs_summary}" scope="request"/>

