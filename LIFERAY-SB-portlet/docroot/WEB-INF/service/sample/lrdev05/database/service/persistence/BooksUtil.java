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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import sample.lrdev05.database.model.Books;

import java.util.List;

/**
 * The persistence utility for the books service. This utility wraps {@link BooksPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mshanmugam
 * @see BooksPersistence
 * @see BooksPersistenceImpl
 * @generated
 */
public class BooksUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Books books) {
		getPersistence().clearCache(books);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Books> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Books> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Books> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Books update(Books books, boolean merge)
		throws SystemException {
		return getPersistence().update(books, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Books update(Books books, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(books, merge, serviceContext);
	}

	/**
	* Caches the books in the entity cache if it is enabled.
	*
	* @param books the books
	*/
	public static void cacheResult(sample.lrdev05.database.model.Books books) {
		getPersistence().cacheResult(books);
	}

	/**
	* Caches the bookses in the entity cache if it is enabled.
	*
	* @param bookses the bookses
	*/
	public static void cacheResult(
		java.util.List<sample.lrdev05.database.model.Books> bookses) {
		getPersistence().cacheResult(bookses);
	}

	/**
	* Creates a new books with the primary key. Does not add the books to the database.
	*
	* @param bookId the primary key for the new books
	* @return the new books
	*/
	public static sample.lrdev05.database.model.Books create(long bookId) {
		return getPersistence().create(bookId);
	}

	/**
	* Removes the books with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the books
	* @return the books that was removed
	* @throws sample.lrdev05.database.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books remove(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence().remove(bookId);
	}

	public static sample.lrdev05.database.model.Books updateImpl(
		sample.lrdev05.database.model.Books books, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(books, merge);
	}

	/**
	* Returns the books with the primary key or throws a {@link sample.lrdev05.database.NoSuchBooksException} if it could not be found.
	*
	* @param bookId the primary key of the books
	* @return the books
	* @throws sample.lrdev05.database.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByPrimaryKey(
		long bookId)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence().findByPrimaryKey(bookId);
	}

	/**
	* Returns the books with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bookId the primary key of the books
	* @return the books, or <code>null</code> if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByPrimaryKey(
		long bookId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bookId);
	}

	/**
	* Returns all the bookses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the bookses before and after the current books in the ordered set where uuid = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books[] findByUuid_PrevAndNext(
		long bookId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByUuid_PrevAndNext(bookId, uuid, orderByComparator);
	}

	/**
	* Returns the books where uuid = &#63; and groupId = &#63; or throws a {@link sample.lrdev05.database.NoSuchBooksException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the books where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the books where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Returns all the bookses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the bookses before and after the current books in the ordered set where groupId = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books[] findByGroupId_PrevAndNext(
		long bookId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(bookId, groupId, orderByComparator);
	}

	/**
	* Returns all the bookses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching bookses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the bookses that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of matching bookses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the bookses that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bookses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the bookses before and after the current books in the ordered set of bookses that the user has permission to view where groupId = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books[] filterFindByGroupId_PrevAndNext(
		long bookId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(bookId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the bookses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the bookses before and after the current books in the ordered set where companyId = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books[] findByCompanyId_PrevAndNext(
		long bookId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(bookId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the bookses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the bookses before and after the current books in the ordered set where userId = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books[] findByUserId_PrevAndNext(
		long bookId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByUserId_PrevAndNext(bookId, userId, orderByComparator);
	}

	/**
	* Returns all the bookses where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> findByGroup_Title(
		long groupId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Title(groupId, title);
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findByGroup_Title(
		long groupId, java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Title(groupId, title, start, end);
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findByGroup_Title(
		long groupId, java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_Title(groupId, title, start, end,
			orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByGroup_Title_First(
		long groupId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByGroup_Title_First(groupId, title, orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByGroup_Title_First(
		long groupId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroup_Title_First(groupId, title, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByGroup_Title_Last(
		long groupId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByGroup_Title_Last(groupId, title, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByGroup_Title_Last(
		long groupId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroup_Title_Last(groupId, title, orderByComparator);
	}

	/**
	* Returns the bookses before and after the current books in the ordered set where groupId = &#63; and title = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param groupId the group ID
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books[] findByGroup_Title_PrevAndNext(
		long bookId, long groupId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByGroup_Title_PrevAndNext(bookId, groupId, title,
			orderByComparator);
	}

	/**
	* Returns all the bookses that the user has permission to view where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @return the matching bookses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> filterFindByGroup_Title(
		long groupId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup_Title(groupId, title);
	}

	/**
	* Returns a range of all the bookses that the user has permission to view where groupId = &#63; and title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param title the title
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of matching bookses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> filterFindByGroup_Title(
		long groupId, java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup_Title(groupId, title, start, end);
	}

	/**
	* Returns an ordered range of all the bookses that the user has permissions to view where groupId = &#63; and title = &#63;.
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
	* @return the ordered range of matching bookses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> filterFindByGroup_Title(
		long groupId, java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup_Title(groupId, title, start, end,
			orderByComparator);
	}

	/**
	* Returns the bookses before and after the current books in the ordered set of bookses that the user has permission to view where groupId = &#63; and title = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param groupId the group ID
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books[] filterFindByGroup_Title_PrevAndNext(
		long bookId, long groupId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .filterFindByGroup_Title_PrevAndNext(bookId, groupId, title,
			orderByComparator);
	}

	/**
	* Returns all the bookses where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> findByGroup_Author(
		long groupId, java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Author(groupId, author);
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findByGroup_Author(
		long groupId, java.lang.String author, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroup_Author(groupId, author, start, end);
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findByGroup_Author(
		long groupId, java.lang.String author, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroup_Author(groupId, author, start, end,
			orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByGroup_Author_First(
		long groupId, java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByGroup_Author_First(groupId, author, orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByGroup_Author_First(
		long groupId, java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroup_Author_First(groupId, author, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByGroup_Author_Last(
		long groupId, java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByGroup_Author_Last(groupId, author, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByGroup_Author_Last(
		long groupId, java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroup_Author_Last(groupId, author, orderByComparator);
	}

	/**
	* Returns the bookses before and after the current books in the ordered set where groupId = &#63; and author = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param groupId the group ID
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books[] findByGroup_Author_PrevAndNext(
		long bookId, long groupId, java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByGroup_Author_PrevAndNext(bookId, groupId, author,
			orderByComparator);
	}

	/**
	* Returns all the bookses that the user has permission to view where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @return the matching bookses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> filterFindByGroup_Author(
		long groupId, java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroup_Author(groupId, author);
	}

	/**
	* Returns a range of all the bookses that the user has permission to view where groupId = &#63; and author = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param author the author
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of matching bookses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> filterFindByGroup_Author(
		long groupId, java.lang.String author, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup_Author(groupId, author, start, end);
	}

	/**
	* Returns an ordered range of all the bookses that the user has permissions to view where groupId = &#63; and author = &#63;.
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
	* @return the ordered range of matching bookses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> filterFindByGroup_Author(
		long groupId, java.lang.String author, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroup_Author(groupId, author, start, end,
			orderByComparator);
	}

	/**
	* Returns the bookses before and after the current books in the ordered set of bookses that the user has permission to view where groupId = &#63; and author = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param groupId the group ID
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books[] filterFindByGroup_Author_PrevAndNext(
		long bookId, long groupId, java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .filterFindByGroup_Author_PrevAndNext(bookId, groupId,
			author, orderByComparator);
	}

	/**
	* Returns all the bookses where resourcePrimKey = &#63; and status = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @return the matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> findByR_S(
		long resourcePrimKey, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByR_S(resourcePrimKey, status);
	}

	/**
	* Returns a range of all the bookses where resourcePrimKey = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @return the range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> findByR_S(
		long resourcePrimKey, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByR_S(resourcePrimKey, status, start, end);
	}

	/**
	* Returns an ordered range of all the bookses where resourcePrimKey = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param start the lower bound of the range of bookses
	* @param end the upper bound of the range of bookses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> findByR_S(
		long resourcePrimKey, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByR_S(resourcePrimKey, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByR_S_First(
		long resourcePrimKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByR_S_First(resourcePrimKey, status, orderByComparator);
	}

	/**
	* Returns the first books in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByR_S_First(
		long resourcePrimKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByR_S_First(resourcePrimKey, status, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books
	* @throws sample.lrdev05.database.NoSuchBooksException if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books findByR_S_Last(
		long resourcePrimKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByR_S_Last(resourcePrimKey, status, orderByComparator);
	}

	/**
	* Returns the last books in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching books, or <code>null</code> if a matching books could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books fetchByR_S_Last(
		long resourcePrimKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByR_S_Last(resourcePrimKey, status, orderByComparator);
	}

	/**
	* Returns the bookses before and after the current books in the ordered set where resourcePrimKey = &#63; and status = &#63;.
	*
	* @param bookId the primary key of the current books
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next books
	* @throws sample.lrdev05.database.NoSuchBooksException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books[] findByR_S_PrevAndNext(
		long bookId, long resourcePrimKey, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence()
				   .findByR_S_PrevAndNext(bookId, resourcePrimKey, status,
			orderByComparator);
	}

	/**
	* Returns all the bookses.
	*
	* @return the bookses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<sample.lrdev05.database.model.Books> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<sample.lrdev05.database.model.Books> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bookses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes the books where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the books that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Removes all the bookses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the bookses where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the bookses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the bookses where groupId = &#63; and title = &#63; from the database.
	*
	* @param groupId the group ID
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup_Title(long groupId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup_Title(groupId, title);
	}

	/**
	* Removes all the bookses where groupId = &#63; and author = &#63; from the database.
	*
	* @param groupId the group ID
	* @param author the author
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroup_Author(long groupId,
		java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroup_Author(groupId, author);
	}

	/**
	* Removes all the bookses where resourcePrimKey = &#63; and status = &#63; from the database.
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByR_S(long resourcePrimKey, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByR_S(resourcePrimKey, status);
	}

	/**
	* Removes all the bookses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bookses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the number of bookses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of bookses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of bookses that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching bookses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of bookses where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of bookses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of bookses where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup_Title(long groupId, java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup_Title(groupId, title);
	}

	/**
	* Returns the number of bookses that the user has permission to view where groupId = &#63; and title = &#63;.
	*
	* @param groupId the group ID
	* @param title the title
	* @return the number of matching bookses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup_Title(long groupId,
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup_Title(groupId, title);
	}

	/**
	* Returns the number of bookses where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroup_Author(long groupId, java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroup_Author(groupId, author);
	}

	/**
	* Returns the number of bookses that the user has permission to view where groupId = &#63; and author = &#63;.
	*
	* @param groupId the group ID
	* @param author the author
	* @return the number of matching bookses that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroup_Author(long groupId,
		java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroup_Author(groupId, author);
	}

	/**
	* Returns the number of bookses where resourcePrimKey = &#63; and status = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param status the status
	* @return the number of matching bookses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByR_S(long resourcePrimKey, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByR_S(resourcePrimKey, status);
	}

	/**
	* Returns the number of bookses.
	*
	* @return the number of bookses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BooksPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BooksPersistence)PortletBeanLocatorUtil.locate(sample.lrdev05.database.service.ClpSerializer.getServletContextName(),
					BooksPersistence.class.getName());

			ReferenceRegistry.registerReference(BooksUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(BooksPersistence persistence) {
	}

	private static BooksPersistence _persistence;
}