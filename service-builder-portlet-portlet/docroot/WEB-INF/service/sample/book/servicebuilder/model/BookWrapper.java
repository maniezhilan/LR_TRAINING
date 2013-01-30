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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Book}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Book
 * @generated
 */
public class BookWrapper implements Book, ModelWrapper<Book> {
	public BookWrapper(Book book) {
		_book = book;
	}

	public Class<?> getModelClass() {
		return Book.class;
	}

	public String getModelClassName() {
		return Book.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookId", getBookId());
		attributes.put("title", getTitle());
		attributes.put("author", getAuthor());
		attributes.put("isbn", getIsbn());
		attributes.put("summary", getSummary());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		Long isbn = (Long)attributes.get("isbn");

		if (isbn != null) {
			setIsbn(isbn);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}
	}

	/**
	* Returns the primary key of this book.
	*
	* @return the primary key of this book
	*/
	public long getPrimaryKey() {
		return _book.getPrimaryKey();
	}

	/**
	* Sets the primary key of this book.
	*
	* @param primaryKey the primary key of this book
	*/
	public void setPrimaryKey(long primaryKey) {
		_book.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the book ID of this book.
	*
	* @return the book ID of this book
	*/
	public long getBookId() {
		return _book.getBookId();
	}

	/**
	* Sets the book ID of this book.
	*
	* @param bookId the book ID of this book
	*/
	public void setBookId(long bookId) {
		_book.setBookId(bookId);
	}

	/**
	* Returns the title of this book.
	*
	* @return the title of this book
	*/
	public java.lang.String getTitle() {
		return _book.getTitle();
	}

	/**
	* Sets the title of this book.
	*
	* @param title the title of this book
	*/
	public void setTitle(java.lang.String title) {
		_book.setTitle(title);
	}

	/**
	* Returns the author of this book.
	*
	* @return the author of this book
	*/
	public java.lang.String getAuthor() {
		return _book.getAuthor();
	}

	/**
	* Sets the author of this book.
	*
	* @param author the author of this book
	*/
	public void setAuthor(java.lang.String author) {
		_book.setAuthor(author);
	}

	/**
	* Returns the isbn of this book.
	*
	* @return the isbn of this book
	*/
	public long getIsbn() {
		return _book.getIsbn();
	}

	/**
	* Sets the isbn of this book.
	*
	* @param isbn the isbn of this book
	*/
	public void setIsbn(long isbn) {
		_book.setIsbn(isbn);
	}

	/**
	* Returns the summary of this book.
	*
	* @return the summary of this book
	*/
	public java.lang.String getSummary() {
		return _book.getSummary();
	}

	/**
	* Sets the summary of this book.
	*
	* @param summary the summary of this book
	*/
	public void setSummary(java.lang.String summary) {
		_book.setSummary(summary);
	}

	public boolean isNew() {
		return _book.isNew();
	}

	public void setNew(boolean n) {
		_book.setNew(n);
	}

	public boolean isCachedModel() {
		return _book.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_book.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _book.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _book.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_book.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _book.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_book.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BookWrapper((Book)_book.clone());
	}

	public int compareTo(sample.book.servicebuilder.model.Book book) {
		return _book.compareTo(book);
	}

	@Override
	public int hashCode() {
		return _book.hashCode();
	}

	public com.liferay.portal.model.CacheModel<sample.book.servicebuilder.model.Book> toCacheModel() {
		return _book.toCacheModel();
	}

	public sample.book.servicebuilder.model.Book toEscapedModel() {
		return new BookWrapper(_book.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _book.toString();
	}

	public java.lang.String toXmlString() {
		return _book.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_book.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Book getWrappedBook() {
		return _book;
	}

	public Book getWrappedModel() {
		return _book;
	}

	public void resetOriginalValues() {
		_book.resetOriginalValues();
	}

	private Book _book;
}