<%
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<script type="text/javascript">
function <portlet:namespace/>fire_txt(){
console.log(" value ",document.getElementById("txt_data").value);	
Liferay.fire(
   "siteWideUniqueEventName",
   {
      paramKey1 : document.getElementById("txt_data").value,
   }
);
}
</script>


Enter the text 
<input id="txt_data" type="text" name="data" value=""/>
<input type="button" value="Submit" onClick="<portlet:namespace/>fire_txt();return false;"/>