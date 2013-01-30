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
Liferay.on(
		   "siteWideUniqueEventName",
		   function(data) {
			console.log(" data ",data,data.paramKey1);   
			//alert("I'm portlet 2 and the value is" + data.paramKey2);
			document.getElementById("cons_txt").innerHTML=data.paramKey1;
		   }
		);
</script>

<div id="cons_txt"/>
