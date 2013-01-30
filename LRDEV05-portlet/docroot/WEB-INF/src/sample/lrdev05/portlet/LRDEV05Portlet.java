package sample.lrdev05.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import sample.lrdev02.database.model.Books;
import sample.lrdev02.database.service.BooksLocalServiceUtil;
import sample.lrdev05.util.BookActionUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LRDEV05Portlet
 */
public class LRDEV05Portlet extends MVCPortlet {
 
	private static String bookDetailsJSP = "/jsp/bookDetails.jsp";
	  private static String editJSP = "/jsp/edit.jsp";
	  private static String editPrefJSP = "/jsp/editPrefs.jsp";
	  public static final String PATH_TO_JSP_PAGE = "/jsp/";
	
	public void addBook(ActionRequest request, ActionResponse response) throws SystemException{
		Books book = BookActionUtil.getBookFromRequest(request);
		BooksLocalServiceUtil.addBooks(book);
	}
	
	public void listBook(ActionRequest request, ActionResponse response) throws PortletException, IOException, SystemException {
		//request.setAttribute("bookList", BooksLocalServiceUtil.getAllBooks());
	}
	
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException
	  {
	    String bookId = (String)request.getPortletSession().getAttribute("bookId", 1);
	    if (bookId != null) {
	    	
	      Books book = null;
		try {
			book = BooksLocalServiceUtil.getBooks(Long.parseLong(bookId));
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
	    //request.setAttribute("bookList", BooksLocalServiceUtil.getAllBooks());	
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
		    Books book = getBookUtil(request);
		    request.setAttribute("book", book);
		    response.setRenderParameter("jspPage", bookDetailsJSP);
		  }

		  public void editBook(ActionRequest request, ActionResponse response)
		    throws PortletException, IOException
		  {
		    Books book = getBookUtil(request);
		    request.setAttribute("book", book);
		    response.setRenderParameter("jspPage", editJSP);
		  }

		private Books getBookUtil(ActionRequest request) {
			long bookId = ParamUtil.getLong(request, "bookId");
		    Books book = null;
			try {
				book = BooksLocalServiceUtil.getBooks(bookId);
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
			    Books book = getBookUtil(request);
			    try {
					BooksLocalServiceUtil.deleteBooks(book);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
		  public void updateBook(ActionRequest request, ActionResponse response) throws PortletException, IOException, PortalException {
			    Books requestbook = BookActionUtil.getBookFromRequest(request);
			    try {
			    	Books book = getBookUtil(request); 
				    book.setAuthor(requestbook.getAuthor());
				    book.setTitle(requestbook.getTitle());
				    book.setSummary(requestbook.getSummary());
					BooksLocalServiceUtil.updateBooks(book);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }

		  public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException
		  {
			  long bookId = ParamUtil.getLong(request, "bookId");
			    Books book = null;
			    int size = 0;
				try {
					book = BooksLocalServiceUtil.getBooks(bookId);
					BooksLocalServiceUtil.deleteBooks(book);
					//size = BooksLocalServiceUtil.getAllBooks().size();
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
		  
		  /*public void invokeTaglibDiscussion(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

			  PortletConfig portletConfig = getPortletConfig();

			   PortalClassInvoker .invoke(true, "com.liferay.portlet.messageboards.action.EditDiscussionAction",       
			                    "processAction", new String[] {
			                                    "org.apache.struts.action.ActionMapping",
			                                    "org.apache.struts.action.ActionForm",
			                                    PortletConfig.class.getName(),
			                                    ActionRequest.class.getName(),
			                                   ActionResponse.class.getName()
			                    }, null, null, portletConfig, actionRequest, actionResponse);
			  } */

}


