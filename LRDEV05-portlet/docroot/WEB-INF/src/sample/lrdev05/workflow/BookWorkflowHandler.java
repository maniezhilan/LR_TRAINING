package sample.lrdev05.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import sample.lrdev02.database.model.Books;
import sample.lrdev02.database.service.BooksLocalServiceUtil;

import com.liferay.portal.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;

public class BookWorkflowHandler extends BaseWorkflowHandler {

    public String getClassName() {
        return CLASS_NAME;
    }

    public String getType(Locale locale) {
        return LanguageUtil.get(locale, "model.resource." + CLASS_NAME);
    }

    public Object updateStatus(
            int status, Map<String, Serializable> workflowContext)
        throws PortalException, SystemException {

        long userId = GetterUtil.getLong(
            workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

        long resourcePrimKey = GetterUtil.getLong(
            workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext =
            (ServiceContext) workflowContext.get("serviceContext");

        return "";
    }

    public static final String CLASS_NAME = Books.class.getName();
}


