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

package sample.lrdev05.database.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import sample.lrdev05.database.model.Books;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Books in entity cache.
 *
 * @author mshanmugam
 * @see Books
 * @generated
 */
public class BooksCacheModel implements CacheModel<Books>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bookId=");
		sb.append(bookId);
		sb.append(", resourcePrimKey=");
		sb.append(resourcePrimKey);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", author=");
		sb.append(author);
		sb.append(", summary=");
		sb.append(summary);
		sb.append(", isbn=");
		sb.append(isbn);
		sb.append("}");

		return sb.toString();
	}

	public Books toEntityModel() {
		BooksImpl booksImpl = new BooksImpl();

		if (uuid == null) {
			booksImpl.setUuid(StringPool.BLANK);
		}
		else {
			booksImpl.setUuid(uuid);
		}

		booksImpl.setBookId(bookId);
		booksImpl.setResourcePrimKey(resourcePrimKey);
		booksImpl.setCompanyId(companyId);
		booksImpl.setGroupId(groupId);
		booksImpl.setUserId(userId);

		if (userName == null) {
			booksImpl.setUserName(StringPool.BLANK);
		}
		else {
			booksImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			booksImpl.setCreateDate(null);
		}
		else {
			booksImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			booksImpl.setModifiedDate(null);
		}
		else {
			booksImpl.setModifiedDate(new Date(modifiedDate));
		}

		booksImpl.setStatus(status);
		booksImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			booksImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			booksImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			booksImpl.setStatusDate(null);
		}
		else {
			booksImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			booksImpl.setTitle(StringPool.BLANK);
		}
		else {
			booksImpl.setTitle(title);
		}

		if (author == null) {
			booksImpl.setAuthor(StringPool.BLANK);
		}
		else {
			booksImpl.setAuthor(author);
		}

		if (summary == null) {
			booksImpl.setSummary(StringPool.BLANK);
		}
		else {
			booksImpl.setSummary(summary);
		}

		if (isbn == null) {
			booksImpl.setIsbn(StringPool.BLANK);
		}
		else {
			booksImpl.setIsbn(isbn);
		}

		booksImpl.resetOriginalValues();

		return booksImpl;
	}

	public String uuid;
	public long bookId;
	public long resourcePrimKey;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String title;
	public String author;
	public String summary;
	public String isbn;
}