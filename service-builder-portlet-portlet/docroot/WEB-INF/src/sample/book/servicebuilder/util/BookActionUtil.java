package sample.book.servicebuilder.util;

import javax.portlet.ActionRequest;

import sample.book.servicebuilder.model.Book;
import sample.book.servicebuilder.model.impl.BookImpl;

import com.liferay.portal.kernel.util.ParamUtil;


public class BookActionUtil {
	
	 public static Book getBookFromRequest(ActionRequest request)
	  {
	    String title = ParamUtil.getString(request, "title", 
	      "Title Not Availible");
	    String author = ParamUtil.getString(request, "author", 
	      "Author Not Availible");
	    String summary = ParamUtil.getString(request, "summary", "Summary Not Availible");
	    long isbn = ParamUtil.getLong(request, "isbn", 0L);
	    Book book = new BookImpl();
	    book.setIsbn(isbn);
	    book.setAuthor(author);
	    book.setTitle(title);
	    book.setSummary(summary);
	    return book;
	  }

}
