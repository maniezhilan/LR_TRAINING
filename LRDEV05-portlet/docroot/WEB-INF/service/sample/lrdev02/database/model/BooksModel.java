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

package sample.lrdev02.database.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Books service. Represents a row in the &quot;B_Books&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link sample.lrdev02.database.model.impl.BooksModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link sample.lrdev02.database.model.impl.BooksImpl}.
 * </p>
 *
 * @author mshanmugam
 * @see Books
 * @see sample.lrdev02.database.model.impl.BooksImpl
 * @see sample.lrdev02.database.model.impl.BooksModelImpl
 * @generated
 */
public interface BooksModel extends BaseModel<Books>, GroupedModel,
	WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a books model instance should use the {@link Books} interface instead.
	 */

	/**
	 * Returns the primary key of this books.
	 *
	 * @return the primary key of this books
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this books.
	 *
	 * @param primaryKey the primary key of this books
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this books.
	 *
	 * @return the uuid of this books
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this books.
	 *
	 * @param uuid the uuid of this books
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the book ID of this books.
	 *
	 * @return the book ID of this books
	 */
	public long getBookId();

	/**
	 * Sets the book ID of this books.
	 *
	 * @param bookId the book ID of this books
	 */
	public void setBookId(long bookId);

	/**
	 * Returns the company ID of this books.
	 *
	 * @return the company ID of this books
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this books.
	 *
	 * @param companyId the company ID of this books
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this books.
	 *
	 * @return the group ID of this books
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this books.
	 *
	 * @param groupId the group ID of this books
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this books.
	 *
	 * @return the user ID of this books
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this books.
	 *
	 * @param userId the user ID of this books
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this books.
	 *
	 * @return the user uuid of this books
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this books.
	 *
	 * @param userUuid the user uuid of this books
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this books.
	 *
	 * @return the user name of this books
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this books.
	 *
	 * @param userName the user name of this books
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this books.
	 *
	 * @return the create date of this books
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this books.
	 *
	 * @param createDate the create date of this books
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this books.
	 *
	 * @return the modified date of this books
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this books.
	 *
	 * @param modifiedDate the modified date of this books
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this books.
	 *
	 * @return the status of this books
	 */
	public int getStatus();

	/**
	 * Sets the status of this books.
	 *
	 * @param status the status of this books
	 */
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this books.
	 *
	 * @return the status by user ID of this books
	 */
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this books.
	 *
	 * @param statusByUserId the status by user ID of this books
	 */
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this books.
	 *
	 * @return the status by user uuid of this books
	 * @throws SystemException if a system exception occurred
	 */
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this books.
	 *
	 * @param statusByUserUuid the status by user uuid of this books
	 */
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this books.
	 *
	 * @return the status by user name of this books
	 */
	@AutoEscape
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this books.
	 *
	 * @param statusByUserName the status by user name of this books
	 */
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this books.
	 *
	 * @return the status date of this books
	 */
	public Date getStatusDate();

	/**
	 * Sets the status date of this books.
	 *
	 * @param statusDate the status date of this books
	 */
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this books.
	 *
	 * @return the title of this books
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this books.
	 *
	 * @param title the title of this books
	 */
	public void setTitle(String title);

	/**
	 * Returns the author of this books.
	 *
	 * @return the author of this books
	 */
	@AutoEscape
	public String getAuthor();

	/**
	 * Sets the author of this books.
	 *
	 * @param author the author of this books
	 */
	public void setAuthor(String author);

	/**
	 * Returns the summary of this books.
	 *
	 * @return the summary of this books
	 */
	@AutoEscape
	public String getSummary();

	/**
	 * Sets the summary of this books.
	 *
	 * @param summary the summary of this books
	 */
	public void setSummary(String summary);

	/**
	 * Returns the isbn of this books.
	 *
	 * @return the isbn of this books
	 */
	@AutoEscape
	public String getIsbn();

	/**
	 * Sets the isbn of this books.
	 *
	 * @param isbn the isbn of this books
	 */
	public void setIsbn(String isbn);

	/**
	 * @deprecated Renamed to {@link #isApproved()}
	 */
	public boolean getApproved();

	/**
	 * Returns <code>true</code> if this books is approved.
	 *
	 * @return <code>true</code> if this books is approved; <code>false</code> otherwise
	 */
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this books is denied.
	 *
	 * @return <code>true</code> if this books is denied; <code>false</code> otherwise
	 */
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this books is a draft.
	 *
	 * @return <code>true</code> if this books is a draft; <code>false</code> otherwise
	 */
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this books is expired.
	 *
	 * @return <code>true</code> if this books is expired; <code>false</code> otherwise
	 */
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this books is inactive.
	 *
	 * @return <code>true</code> if this books is inactive; <code>false</code> otherwise
	 */
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this books is incomplete.
	 *
	 * @return <code>true</code> if this books is incomplete; <code>false</code> otherwise
	 */
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this books is pending.
	 *
	 * @return <code>true</code> if this books is pending; <code>false</code> otherwise
	 */
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this books is scheduled.
	 *
	 * @return <code>true</code> if this books is scheduled; <code>false</code> otherwise
	 */
	public boolean isScheduled();

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

	public int compareTo(Books books);

	public int hashCode();

	public CacheModel<Books> toCacheModel();

	public Books toEscapedModel();

	public String toString();

	public String toXmlString();
}