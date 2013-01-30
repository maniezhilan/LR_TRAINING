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

package sample.lrdev05.database.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Books}.
 * </p>
 *
 * @author    mshanmugam
 * @see       Books
 * @generated
 */
public class BooksWrapper implements Books, ModelWrapper<Books> {
	public BooksWrapper(Books books) {
		_books = books;
	}

	public Class<?> getModelClass() {
		return Books.class;
	}

	public String getModelClassName() {
		return Books.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("bookId", getBookId());
		attributes.put("resourcePrimKey", getResourcePrimKey());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("title", getTitle());
		attributes.put("author", getAuthor());
		attributes.put("summary", getSummary());
		attributes.put("isbn", getIsbn());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		Long resourcePrimKey = (Long)attributes.get("resourcePrimKey");

		if (resourcePrimKey != null) {
			setResourcePrimKey(resourcePrimKey);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		String isbn = (String)attributes.get("isbn");

		if (isbn != null) {
			setIsbn(isbn);
		}
	}

	/**
	* Returns the primary key of this books.
	*
	* @return the primary key of this books
	*/
	public long getPrimaryKey() {
		return _books.getPrimaryKey();
	}

	/**
	* Sets the primary key of this books.
	*
	* @param primaryKey the primary key of this books
	*/
	public void setPrimaryKey(long primaryKey) {
		_books.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this books.
	*
	* @return the uuid of this books
	*/
	public java.lang.String getUuid() {
		return _books.getUuid();
	}

	/**
	* Sets the uuid of this books.
	*
	* @param uuid the uuid of this books
	*/
	public void setUuid(java.lang.String uuid) {
		_books.setUuid(uuid);
	}

	/**
	* Returns the book ID of this books.
	*
	* @return the book ID of this books
	*/
	public long getBookId() {
		return _books.getBookId();
	}

	/**
	* Sets the book ID of this books.
	*
	* @param bookId the book ID of this books
	*/
	public void setBookId(long bookId) {
		_books.setBookId(bookId);
	}

	/**
	* Returns the resource prim key of this books.
	*
	* @return the resource prim key of this books
	*/
	public long getResourcePrimKey() {
		return _books.getResourcePrimKey();
	}

	/**
	* Sets the resource prim key of this books.
	*
	* @param resourcePrimKey the resource prim key of this books
	*/
	public void setResourcePrimKey(long resourcePrimKey) {
		_books.setResourcePrimKey(resourcePrimKey);
	}

	public boolean isResourceMain() {
		return _books.isResourceMain();
	}

	/**
	* Returns the company ID of this books.
	*
	* @return the company ID of this books
	*/
	public long getCompanyId() {
		return _books.getCompanyId();
	}

	/**
	* Sets the company ID of this books.
	*
	* @param companyId the company ID of this books
	*/
	public void setCompanyId(long companyId) {
		_books.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this books.
	*
	* @return the group ID of this books
	*/
	public long getGroupId() {
		return _books.getGroupId();
	}

	/**
	* Sets the group ID of this books.
	*
	* @param groupId the group ID of this books
	*/
	public void setGroupId(long groupId) {
		_books.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this books.
	*
	* @return the user ID of this books
	*/
	public long getUserId() {
		return _books.getUserId();
	}

	/**
	* Sets the user ID of this books.
	*
	* @param userId the user ID of this books
	*/
	public void setUserId(long userId) {
		_books.setUserId(userId);
	}

	/**
	* Returns the user uuid of this books.
	*
	* @return the user uuid of this books
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _books.getUserUuid();
	}

	/**
	* Sets the user uuid of this books.
	*
	* @param userUuid the user uuid of this books
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_books.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this books.
	*
	* @return the user name of this books
	*/
	public java.lang.String getUserName() {
		return _books.getUserName();
	}

	/**
	* Sets the user name of this books.
	*
	* @param userName the user name of this books
	*/
	public void setUserName(java.lang.String userName) {
		_books.setUserName(userName);
	}

	/**
	* Returns the create date of this books.
	*
	* @return the create date of this books
	*/
	public java.util.Date getCreateDate() {
		return _books.getCreateDate();
	}

	/**
	* Sets the create date of this books.
	*
	* @param createDate the create date of this books
	*/
	public void setCreateDate(java.util.Date createDate) {
		_books.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this books.
	*
	* @return the modified date of this books
	*/
	public java.util.Date getModifiedDate() {
		return _books.getModifiedDate();
	}

	/**
	* Sets the modified date of this books.
	*
	* @param modifiedDate the modified date of this books
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_books.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the status of this books.
	*
	* @return the status of this books
	*/
	public int getStatus() {
		return _books.getStatus();
	}

	/**
	* Sets the status of this books.
	*
	* @param status the status of this books
	*/
	public void setStatus(int status) {
		_books.setStatus(status);
	}

	/**
	* Returns the status by user ID of this books.
	*
	* @return the status by user ID of this books
	*/
	public long getStatusByUserId() {
		return _books.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this books.
	*
	* @param statusByUserId the status by user ID of this books
	*/
	public void setStatusByUserId(long statusByUserId) {
		_books.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this books.
	*
	* @return the status by user uuid of this books
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _books.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this books.
	*
	* @param statusByUserUuid the status by user uuid of this books
	*/
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_books.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this books.
	*
	* @return the status by user name of this books
	*/
	public java.lang.String getStatusByUserName() {
		return _books.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this books.
	*
	* @param statusByUserName the status by user name of this books
	*/
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_books.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this books.
	*
	* @return the status date of this books
	*/
	public java.util.Date getStatusDate() {
		return _books.getStatusDate();
	}

	/**
	* Sets the status date of this books.
	*
	* @param statusDate the status date of this books
	*/
	public void setStatusDate(java.util.Date statusDate) {
		_books.setStatusDate(statusDate);
	}

	/**
	* Returns the title of this books.
	*
	* @return the title of this books
	*/
	public java.lang.String getTitle() {
		return _books.getTitle();
	}

	/**
	* Sets the title of this books.
	*
	* @param title the title of this books
	*/
	public void setTitle(java.lang.String title) {
		_books.setTitle(title);
	}

	/**
	* Returns the author of this books.
	*
	* @return the author of this books
	*/
	public java.lang.String getAuthor() {
		return _books.getAuthor();
	}

	/**
	* Sets the author of this books.
	*
	* @param author the author of this books
	*/
	public void setAuthor(java.lang.String author) {
		_books.setAuthor(author);
	}

	/**
	* Returns the summary of this books.
	*
	* @return the summary of this books
	*/
	public java.lang.String getSummary() {
		return _books.getSummary();
	}

	/**
	* Sets the summary of this books.
	*
	* @param summary the summary of this books
	*/
	public void setSummary(java.lang.String summary) {
		_books.setSummary(summary);
	}

	/**
	* Returns the isbn of this books.
	*
	* @return the isbn of this books
	*/
	public java.lang.String getIsbn() {
		return _books.getIsbn();
	}

	/**
	* Sets the isbn of this books.
	*
	* @param isbn the isbn of this books
	*/
	public void setIsbn(java.lang.String isbn) {
		_books.setIsbn(isbn);
	}

	/**
	* @deprecated Renamed to {@link #isApproved()}
	*/
	public boolean getApproved() {
		return _books.getApproved();
	}

	/**
	* Returns <code>true</code> if this books is approved.
	*
	* @return <code>true</code> if this books is approved; <code>false</code> otherwise
	*/
	public boolean isApproved() {
		return _books.isApproved();
	}

	/**
	* Returns <code>true</code> if this books is denied.
	*
	* @return <code>true</code> if this books is denied; <code>false</code> otherwise
	*/
	public boolean isDenied() {
		return _books.isDenied();
	}

	/**
	* Returns <code>true</code> if this books is a draft.
	*
	* @return <code>true</code> if this books is a draft; <code>false</code> otherwise
	*/
	public boolean isDraft() {
		return _books.isDraft();
	}

	/**
	* Returns <code>true</code> if this books is expired.
	*
	* @return <code>true</code> if this books is expired; <code>false</code> otherwise
	*/
	public boolean isExpired() {
		return _books.isExpired();
	}

	/**
	* Returns <code>true</code> if this books is inactive.
	*
	* @return <code>true</code> if this books is inactive; <code>false</code> otherwise
	*/
	public boolean isInactive() {
		return _books.isInactive();
	}

	/**
	* Returns <code>true</code> if this books is incomplete.
	*
	* @return <code>true</code> if this books is incomplete; <code>false</code> otherwise
	*/
	public boolean isIncomplete() {
		return _books.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this books is pending.
	*
	* @return <code>true</code> if this books is pending; <code>false</code> otherwise
	*/
	public boolean isPending() {
		return _books.isPending();
	}

	/**
	* Returns <code>true</code> if this books is scheduled.
	*
	* @return <code>true</code> if this books is scheduled; <code>false</code> otherwise
	*/
	public boolean isScheduled() {
		return _books.isScheduled();
	}

	public boolean isNew() {
		return _books.isNew();
	}

	public void setNew(boolean n) {
		_books.setNew(n);
	}

	public boolean isCachedModel() {
		return _books.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_books.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _books.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _books.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_books.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _books.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_books.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BooksWrapper((Books)_books.clone());
	}

	public int compareTo(sample.lrdev05.database.model.Books books) {
		return _books.compareTo(books);
	}

	@Override
	public int hashCode() {
		return _books.hashCode();
	}

	public com.liferay.portal.model.CacheModel<sample.lrdev05.database.model.Books> toCacheModel() {
		return _books.toCacheModel();
	}

	public sample.lrdev05.database.model.Books toEscapedModel() {
		return new BooksWrapper(_books.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _books.toString();
	}

	public java.lang.String toXmlString() {
		return _books.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_books.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Books getWrappedBooks() {
		return _books;
	}

	public Books getWrappedModel() {
		return _books;
	}

	public void resetOriginalValues() {
		_books.resetOriginalValues();
	}

	private Books _books;
}