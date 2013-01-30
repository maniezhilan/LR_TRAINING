package sample.lrdev05.listener;

import java.util.List;

import sample.lrdev05.database.model.Books;
import sample.lrdev05.database.service.BooksLocalServiceUtil;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.audit.hook.listeners.util.Attribute;
import com.liferay.portal.audit.hook.listeners.util.AttributesBuilder;
import com.liferay.portal.audit.hook.listeners.util.AuditMessageBuilder;
import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditRouterUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;

public class BookListener extends BaseModelListener<Books>
{
	  public void onBeforeUpdate(Books newBooks)
	    throws ModelListenerException
	  {
	    try
	    {
	      String className = newBooks.getClass().getName();

	      if (!className.equals(User.class.getName())) {
	        return;
	      }

	      Books oldBooks = BooksLocalServiceUtil.getBooks(
	        newBooks.getBookId());

	      List attributes = getModifiedAttributes(
	        newBooks, oldBooks);

	      if (!attributes.isEmpty()) {
	        AuditMessage auditMessage = 
	          AuditMessageBuilder.buildAuditMessage(
	          "UPDATE", Books.class.getName(), 
	          newBooks.getBookId(), attributes);

	        AuditRouterUtil.route(auditMessage);
	      }
	    }
	    catch (Exception e) {
	      throw new ModelListenerException(e);
	    }
	  }

	  protected List<Attribute> getModifiedAttributes(Books newBook, Books oldBook) {
			AttributesBuilder attributesBuilder = new AttributesBuilder(newBook,
					oldBook);

			attributesBuilder.add("title");
			attributesBuilder.add("author");
			attributesBuilder.add("isbn");
			attributesBuilder.add("summary");

			return attributesBuilder.getAttributes();
		}
	}
