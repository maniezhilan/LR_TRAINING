package sample.lrdev05.util;

import java.util.Date;

import javax.portlet.ActionRequest;

import sample.lrdev05.database.service.BooksLocalServiceUtil;

import com.liferay.portal.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class BookActionUtil {

	public static sample.lrdev05.database.model.Books getBookFromRequest(
			ActionRequest request)
			throws com.liferay.portal.kernel.exception.PortalException {
		sample.lrdev05.database.model.Books book = BooksLocalServiceUtil
				.getBooksInstance();
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		book.setCompanyId(themeDisplay.getCompanyId());
		book.setGroupId(themeDisplay.getScopeGroupId());
		book.setUserId(themeDisplay.getUserId());

		String title = ParamUtil.getString(request, "title",
				"Title Not Availible");
		String author = ParamUtil.getString(request, "author",
				"Author Not Availible");
		String summary = ParamUtil.getString(request, "summary",
				"Summary Not Availible");
		String isbn = ParamUtil.getString(request, "isbn");

		book.setIsbn(isbn);
		book.setAuthor(author);
		book.setTitle(title);
		book.setSummary(summary);
		return book;
	}

}
