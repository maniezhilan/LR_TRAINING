package sample.lrdev05.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import sample.lrdev05.database.model.Books;
import sample.lrdev05.database.service.BooksLocalServiceUtil;
import sample.lrdev05.util.BookActionUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class BooksPortlet extends MVCPortlet {

	private static String editJSP = "/jsp/edit.jsp";
	public static final String PATH_TO_JSP_PAGE = "/jsp/";

	public void addBook(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		Books book = BookActionUtil.getBookFromRequest(request);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Books.class.getName(), request);
		BooksLocalServiceUtil.addBooks(book, book.getUserId(), serviceContext);
	}

	public void listBook(ActionRequest request, ActionResponse response)
			throws PortletException, IOException, SystemException {
		request.setAttribute("bookList", BooksLocalServiceUtil.getAllBooks());
	}


	public void editBook(ActionRequest request, ActionResponse response)
			throws PortletException, IOException, PortalException {
		Books book = getBookUtil(request);
		request.setAttribute("book", book);
		response.setRenderParameter("jspPage", editJSP);
	}

	private Books getBookUtil(ActionRequest request) throws PortalException {
		long bookId = ParamUtil.getLong(request, "bookId");
		Books book = BookActionUtil.getBookFromRequest(request);
		Books viewbook = null;
		try {
			viewbook = BooksLocalServiceUtil.getBooks(bookId);
			viewbook.setUserId(book.getUserId());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return viewbook;
	}

	public void editPrefs(ActionRequest request, ActionResponse response)
			throws PortletException, IOException, PortalException,
			SystemException {
		PortletPreferences pref = request.getPreferences();
		String portletRes = ParamUtil.getString(request, "portletResource");
		String welcome_message = ParamUtil
				.getString(request, "welcome_message");
		if (Validator.isNotNull(portletRes)) {
			pref = PortletPreferencesFactoryUtil.getPortletSetup(request,
					portletRes);
		}

		pref.setValue("welcome_message", welcome_message);
		pref.store();
	}

	public void deleteBook(ActionRequest request, ActionResponse response)
			throws PortletException, IOException, PortalException {
		Books book = getBookUtil(request);
		BooksLocalServiceUtil.deleteBooks(book, book.getCompanyId());
	}

	public void updateBook(ActionRequest request, ActionResponse response)
			throws PortletException, IOException, PortalException {
		Books requestbook = BookActionUtil.getBookFromRequest(request);
		try {
			Books book = getBookUtil(request);
			book.setAuthor(requestbook.getAuthor());
			book.setTitle(requestbook.getTitle());
			book.setSummary(requestbook.getSummary());
			Books newBook = BooksLocalServiceUtil.addBooks(book);
			BooksLocalServiceUtil.updateMyBean(book, newBook);
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws PortletException, IOException {
		long bookId = ParamUtil.getLong(request, "bookId");
		Books book = null;
		int size = 0;
		try {
			book = BooksLocalServiceUtil.getBooks(bookId);
			BooksLocalServiceUtil.deleteBooks(book, book.getCompanyId());
			size = BooksLocalServiceUtil.getAllBooks().size();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setContentType("text");
		response.resetBuffer();
		response.getWriter().print(size);
		response.flushBuffer();
	}

}
