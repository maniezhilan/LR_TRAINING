package sample.lrdev05.database.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import sample.lrdev05.database.model.Books;
import sample.lrdev05.util.WebKeys;

import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class BooksAssetRenderer extends BaseAssetRenderer {

    public BooksAssetRenderer(Books book) {
        _book = book;
    }

    public long getClassPK() {
        return _book.getBookId();
    }

    public long getGroupId() {
        return _book.getGroupId();
    }

    public String getSummary() {
        return _book.getTitle();
    }

    public String getTitle() {
        return "Book Title";
    }

    public long getUserId() {
        return _book.getUserId();
    }

    public String getUuid() {
        return _book.getUuid();
    }

    public String render(
            RenderRequest request, RenderResponse response,
            String template)
        throws Exception {

        if (template.equals(TEMPLATE_FULL_CONTENT)) {
            request.setAttribute(WebKeys.ADD_ENTRY, _book);

            return "/jsp/" + template + ".jsp";
        }
        else {
            return null;
        }
    }
    
   

    private Books _book;



	public String getSummary(Locale arg0) {
		// TODO Auto-generated method stub
		return _book.getTitle();
	}

	public String getTitle(Locale arg0) {
		// TODO Auto-generated method stub
		return _book.getTitle();
	}

	public String getUserName() {
		// TODO Auto-generated method stub
		return _book.getUserName();
	}

}
