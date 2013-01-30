package sample.lrdev05.database.asset;

import sample.lrdev05.database.model.Books;
import sample.lrdev05.database.service.BooksLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

public class BooksAssetRendererFactory extends BaseAssetRendererFactory {


    public static final String CLASS_NAME = Books.class.getName();

    public static final String TYPE = "books";

    public AssetRenderer getAssetRenderer(long classPK, int type)
        throws PortalException, SystemException {

        Books book = BooksLocalServiceUtil.getBooks(classPK);

        return new BooksAssetRenderer(book);
    }

    public String getClassName() {
        return CLASS_NAME;
    }

    public String getType() {
        return TYPE;
    }
}