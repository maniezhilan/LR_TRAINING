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

package sample.lrdev05.database.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import sample.lrdev05.database.model.Books;

/**
 * The persistence interface for the books service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mshanmugam
 * @see BooksPersistenceImpl
 * @see BooksUtil
 * @generated
 */
public interface BooksPersistence extends BasePersistence<Books> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BooksUtil} to access the books persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the books in the entity cache if it is enabled.
	*
	* @param books the books
	*/
	public void cacheResult(sample.lrdev05.database.model.Books books);

	/**
	* Caches the bookses in the entity cache if it is enabled.
	*
	* @param bookses the bookses
	*/
	public void cacheResult(
		java.util.List<sample.lrdev05.database.model.Books> bookses);

	/**
	* Creates a new books with the primary key. Does not add the books to the database.
	*
	* @param bookId the primary key for the new books
	* @return the new books
	*/
	public sample.lrdev05.database.model.Books create(long bookId);

	/**
	* Removes the books with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the books
	* @return the books that was removed
	* @throws sample.lrdev05.database.NoSuchooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books remove(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	public sample.lrdev05.database.model.Books updateImpl(
		sample.lrdev05.database.model.Books books, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the books with the primary key or throws a {@link sample.lrdev05.database.NoSuchooksException} if it could not be found.
	*
	* @param bookId the primary key of the books
	* @return the books
	* @throws sample.lrdev05.database.NoSuchooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByPrimaryKey(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the books with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookId the primary key of the books
	* @return the books, or <code>null</code> if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByPrimaryKey(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bookses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bookses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bookses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first books in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the first books in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last books in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the last books in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bookses before and after the current books in the ordered set where uuid = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books[] findByUuid_PrevAndNext(
		long bookId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the books where uuid = &#63; and groupId = &#63; or throws a {@link sample.lrdev05.database.NoSuchooksException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching books
	* @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the books where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the books where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bookses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bookses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bookses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first books in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the first books in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last books in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the last books in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bookses before and after the current books in the ordered set where groupId = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books[] findByGroupId_PrevAndNext(
		long bookId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns all the bookses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bookses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bookses where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first books in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the first books in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last books in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the last books in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bookses before and after the current books in the ordered set where companyId = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books[] findByCompanyId_PrevAndNext(
		long bookId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns all the bookses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bookses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bookses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first books in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the first books in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last books in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the last books in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bookses before and after the current books in the ordered set where userId = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books[] findByUserId_PrevAndNext(
		long bookId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns all the bookses where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByGroup_Title(
		long groupId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bookses where groupId = &#63; and title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param title the title
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByGroup_Title(
		long groupId, java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bookses where groupId = &#63; and title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param title the title
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByGroup_Title(
		long groupId, java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first books in the ordered set where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByGroup_Title_First(
		long groupId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the first books in the ordered set where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByGroup_Title_First(
		long groupId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last books in the ordered set where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByGroup_Title_Last(
		long groupId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the last books in the ordered set where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByGroup_Title_Last(
		long groupId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bookses before and after the current books in the ordered set where groupId = &#63; and title = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param groupId the group ID
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books[] findByGroup_Title_PrevAndNext(
		long bookId, long groupId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns all the bookses where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByGroup_Author(
		long groupId, java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bookses where groupId = &#63; and author = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param author the author
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByGroup_Author(
		long groupId, java.lang.String author, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bookses where groupId = &#63; and author = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param author the author
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findByGroup_Author(
		long groupId, java.lang.String author, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first books in the ordered set where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByGroup_Author_First(
		long groupId, java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the first books in the ordered set where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByGroup_Author_First(
		long groupId, java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last books in the ordered set where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books findByGroup_Author_Last(
		long groupId, java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns the last books in the ordered set where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books fetchByGroup_Author_Last(
		long groupId, java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bookses before and after the current books in the ordered set where groupId = &#63; and author = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param groupId the group ID
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books[] findByGroup_Author_PrevAndNext(
		long bookId, long groupId, java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Returns all the bookses.
	*
	* @return the bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bookses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bookses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bookses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<sample.lrdev05.database.model.Books> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the books where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the books that was removed
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchooksException;

	/**
	* Removes all the bookses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookses where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookses where groupId = &#63; and title = &#63; from the database.
	*
	* @param groupId the group ID
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup_Title(long groupId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookses where groupId = &#63; and author = &#63; from the database.
	*
	* @param groupId the group ID
	* @param author the author
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroup_Author(long groupId, java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bookses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bookses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bookses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bookses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bookses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bookses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bookses where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup_Title(long groupId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bookses where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroup_Author(long groupId, java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bookses.
	*
	* @return the number of bookses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}