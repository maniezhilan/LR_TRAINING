package sample.book.servicebuilder.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import sample.book.servicebuilder.model.Book;
import sample.book.servicebuilder.service.BookLocalServiceUtil;
import sample.book.servicebuilder.util.BookActionUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class SampleBookPortlet extends MVCPortlet{
	
	private static String bookDetailsJSP = "/jsp/bookDetails.jsp";
	  private static String editJSP = "/jsp/edit.jsp";
	  private static String editPrefJSP = "/jsp/editPrefs.jsp";
	  public static final String PATH_TO_JSP_PAGE = "/jsp/";
	
	public void addBook(ActionRequest request, ActionResponse response) throws SystemException{
		Book book = BookActionUtil.getBookFromRequest(request);
		BookLocalServiceUtil.addBook(book);
	}
	
	public void listBook(ActionRequest request, ActionResponse response) throws PortletException, IOException, SystemException {
		int count = BookLocalServiceUtil.getBooksCount();
		request.setAttribute("bookList", BookLocalServiceUtil.getBooks(0, count ) );
	}
	
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException
	  {
	    String bookId = (String)request.getPortletSession().getAttribute("bookId", 1);
	    if (bookId != null) {
	    	
	      Book book = null;
		try {
			book = BookLocalServiceUtil.getBook(Long.parseLong(bookId));
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
	      request.setAttribute("book", book);

	      request.getPortletSession().setAttribute("bookId", null, 1);
	      getPortletContext().getRequestDispatcher(
	        response.encodeURL("/jsp/bookDetails.jsp"))
	        .include(request, response);
	    }
	    else {
	      getPortletContext().getRequestDispatcher(
	        response.encodeURL("/jsp/view.jsp"))
	        .include(request, response);
	    }
	  }
	
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
		    throws IOException, PortletException
		  {
		    getPortletContext().getRequestDispatcher(
		      renderResponse.encodeURL(editPrefJSP)).include(renderRequest, renderResponse);
		  }

		  public void bookDetails(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		    Book book = getBookUtil(request);
		    request.setAttribute("book", book);
		    response.setRenderParameter("jspPage", bookDetailsJSP);
		  }

		  public void editBook(ActionRequest request, ActionResponse response)
		    throws PortletException, IOException
		  {
		    Book book = getBookUtil(request);
		    request.setAttribute("book", book);
		    response.setRenderParameter("jspPage", editJSP);
		  }

		private Book getBookUtil(ActionRequest request) {
			long bookId = ParamUtil.getLong(request, "bookId");
		    Book book = null;
			try {
				book = BookLocalServiceUtil.getBook(bookId);
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
			return book;
		}

		  public void editPrefs(ActionRequest request, ActionResponse response) throws PortletException, IOException, PortalException, SystemException {
		    PortletPreferences pref = request.getPreferences();
		    String portletRes = ParamUtil.getString(request, "portletResource");
		    String welcome_message = ParamUtil.getString(request, "welcome_message");
		    if (Validator.isNotNull(portletRes)) {
		      pref = PortletPreferencesFactoryUtil.getPortletSetup(request, portletRes);
		    }

		    pref.setValue("welcome_message", welcome_message);
		    pref.store();
		  }
		  
		  public void deleteBook(ActionRequest request, ActionResponse response) throws PortletException, IOException {
			    Book book = getBookUtil(request);
			    try {
					BookLocalServiceUtil.deleteBook(book);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }

		  public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException
		  {
			  long bookId = ParamUtil.getLong(request, "bookId");
			    Book book = null;
			    int size = 0;
				try {
					book = BookLocalServiceUtil.getBook(bookId);
					BookLocalServiceUtil.deleteBook(book);
					size = BookLocalServiceUtil.getBooksCount();
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
