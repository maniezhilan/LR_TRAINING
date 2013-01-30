package sample.lrdev05.util;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

public class ConfigurationActionImpl implements ConfigurationAction
{
	@Override  
	public void processAction(PortletConfig config, ActionRequest actionRequest, ActionResponse actionResponse)
	    throws Exception
	  {
	    String cmd = ParamUtil.getString(actionRequest, "cmd");

	    if (!cmd.equals("update")) {
	      return;
	    }

	    boolean prefs_title = ParamUtil.getBoolean(actionRequest, "prefs_title");
	    boolean prefs_author = ParamUtil.getBoolean(actionRequest, "prefs_author");
	    boolean prefs_isbn = ParamUtil.getBoolean(actionRequest, "prefs_isbn");
	    boolean prefs_summary = ParamUtil.getBoolean(actionRequest, "prefs_summary");

	    String portletResource = ParamUtil.getString(actionRequest, "portletResource");
	    PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
	    preferences.setValue("prefs_title", String.valueOf(prefs_title));
	    preferences.setValue("prefs_author", String.valueOf(prefs_author));
	    preferences.setValue("prefs_isbn", String.valueOf(prefs_isbn));
	    preferences.setValue("prefs_summary", String.valueOf(prefs_summary));
	    preferences.store();
	    //essionMessages.add(actionRequest, config.getPortletName() + ".doConfigure");
	    SessionMessages.add(actionRequest, config.getPortletName() + ".doConfigure");
	  }

	  public String render(PortletConfig config, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
	    return "/jsp/configuration.jsp";
	  }
	}
