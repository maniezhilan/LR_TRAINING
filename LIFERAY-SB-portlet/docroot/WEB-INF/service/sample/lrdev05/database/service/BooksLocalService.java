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

package sample.lrdev05.database.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the books local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author mshanmugam
 * @see BooksLocalServiceUtil
 * @see sample.lrdev05.database.service.base.BooksLocalServiceBaseImpl
 * @see sample.lrdev05.database.service.impl.BooksLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface BooksLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BooksLocalServiceUtil} to access the books local service. Add custom service methods to {@link sample.lrdev05.database.service.impl.BooksLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the books to the database. Also notifies the appropriate model listeners.
	*
	* @param books the books
	* @return the books that was added
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books addBooks(
		sample.lrdev05.database.model.Books books)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new books with the primary key. Does not add the books to the database.
	*
	* @param bookId the primary key for the new books
	* @return the new books
	*/
	public sample.lrdev05.database.model.Books createBooks(long bookId);

	/**
	* Deletes the books with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the books
	* @return the books that was removed
	* @throws PortalException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books deleteBooks(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the books from the database. Also notifies the appropriate model listeners.
	*
	* @param books the books
	* @return the books that was removed
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books deleteBooks(
		sample.lrdev05.database.model.Books books)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public sample.lrdev05.database.model.Books fetchBooks(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the books with the primary key.
	*
	* @param bookId the primary key of the books
	* @return the books
	* @throws PortalException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws sample.lrdev05.database.NoSuchBooksException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public sample.lrdev05.database.model.Books getBooks(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the books with the UUID in the group.
	*
	* @param uuid the UUID of books
	* @param groupId the group id of the books
	* @return the books
	* @throws PortalException if a books with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	* @throws sample.lrdev05.database.NoSuchBooksException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public sample.lrdev05.database.model.Books getBooksByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			sample.lrdev05.database.NoSuchBooksException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<sample.lrdev05.database.model.Books> getBookses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bookses.
	*
	* @return the number of bookses
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBooksesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the books in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param books the books
	* @return the books that was updated
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books updateBooks(
		sample.lrdev05.database.model.Books books)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the books in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param books the books
	* @param merge whether to merge the books with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the books that was updated
	* @throws SystemException if a system exception occurred
	*/
	public sample.lrdev05.database.model.Books updateBooks(
		sample.lrdev05.database.model.Books books, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public sample.lrdev05.database.model.Books addBooks(
		sample.lrdev05.database.model.Books booksParam, long userId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public sample.lrdev05.database.model.Books updateStatus(long userId,
		long resourcePrimKey, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public sample.lrdev05.database.model.Books getBooksInstance();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<sample.lrdev05.database.model.Books> getAllBooks(
		long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<sample.lrdev05.database.model.Books> getAllBooks();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<sample.lrdev05.database.model.Books> getAllBooks(
		long groupId, java.lang.String title);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<sample.lrdev05.database.model.Books> getBooksByUserId(
		long userId);

	public void deleteBooks(long booksId, long companyId);

	public void deleteBooks(sample.lrdev05.database.model.Books book,
		long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public sample.lrdev05.database.model.Books getLatestBook(
		long resourcePrimKey, int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public sample.lrdev05.database.model.Books updateBooks(
		sample.lrdev05.database.model.Books booksParam, long userId)
		throws com.liferay.portal.kernel.exception.PortalException;

	public void updateMyBean(sample.lrdev05.database.model.Books oldBean,
		sample.lrdev05.database.model.Books newBean);

	public com.liferay.portal.kernel.audit.AuditMessage buildAuditMessage(
		java.lang.String eventType, java.lang.String className, long classPK,
		java.util.List<com.liferay.portal.audit.hook.listeners.util.Attribute> attributes);
}