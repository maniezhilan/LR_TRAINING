package sample.lrdev05.util;




import javax.portlet.ActionRequest;

import sample.lrdev05.database.service.BooksLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;

public class BookActionUtil {
	
	 public static sample.lrdev02.database.model.Books getBookFromRequest(ActionRequest request)
	  {
	    String title = ParamUtil.getString(request, "title", 
	      "Title Not Availible");
	    String author = ParamUtil.getString(request, "author", 
	      "Author Not Availible");
	    String summary = ParamUtil.getString(request, "summary", "Summary Not Availible");
	    String isbn = ParamUtil.getString(request, "isbn");
	    sample.lrdev02.database.model.Books book = BooksLocalServiceUtil.getBooksInstance();
	    book.setIsbn(isbn);
	    book.setAuthor(author);
	    book.setTitle(title);
	    book.setSummary(summary);
	    return book;
	  }

}
