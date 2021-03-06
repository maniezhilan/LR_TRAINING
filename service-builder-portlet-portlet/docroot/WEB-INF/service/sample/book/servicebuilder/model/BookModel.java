/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package sample.book.servicebuilder.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Book service. Represents a row in the &quot;servicebuilder_Book&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link sample.book.servicebuilder.model.impl.BookModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link sample.book.servicebuilder.model.impl.BookImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @see sample.book.servicebuilder.model.impl.BookImpl
 * @see sample.book.servicebuilder.model.impl.BookModelImpl
 * @generated
 */
public interface BookModel extends BaseModel<Book> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a book model instance should use the {@link Book} interface instead.
	 */

	/**
	 * Returns the primary key of this book.
	 *
	 * @return the primary key of this book
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this book.
	 *
	 * @param primaryKey the primary key of this book
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the book ID of this book.
	 *
	 * @return the book ID of this book
	 */
	public long getBookId();

	/**
	 * Sets the book ID of this book.
	 *
	 * @param bookId the book ID of this book
	 */
	public void setBookId(long bookId);

	/**
	 * Returns the title of this book.
	 *
	 * @return the title of this book
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this book.
	 *
	 * @param title the title of this book
	 */
	public void setTitle(String title);

	/**
	 * Returns the author of this book.
	 *
	 * @return the author of this book
	 */
	@AutoEscape
	public String getAuthor();

	/**
	 * Sets the author of this book.
	 *
	 * @param author the author of this book
	 */
	public void setAuthor(String author);

	/**
	 * Returns the isbn of this book.
	 *
	 * @return the isbn of this book
	 */
	public long getIsbn();

	/**
	 * Sets the isbn of this book.
	 *
	 * @param isbn the isbn of this book
	 */
	public void setIsbn(long isbn);

	/**
	 * Returns the summary of this book.
	 *
	 * @return the summary of this book
	 */
	@AutoEscape
	public String getSummary();

	/**
	 * Sets the summary of this book.
	 *
	 * @param summary the summary of this book
	 */
	public void setSummary(String summary);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Book book);

	public int hashCode();

	public CacheModel<Book> toCacheModel();

	public Book toEscapedModel();

	public String toString();

	public String toXmlString();
}