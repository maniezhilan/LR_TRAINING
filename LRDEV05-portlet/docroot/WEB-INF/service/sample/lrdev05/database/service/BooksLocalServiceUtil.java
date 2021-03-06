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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the books local service. This utility wraps {@link sample.lrdev05.database.service.impl.BooksLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author mshanmugam
 * @see BooksLocalService
 * @see sample.lrdev05.database.service.base.BooksLocalServiceBaseImpl
 * @see sample.lrdev05.database.service.impl.BooksLocalServiceImpl
 * @generated
 */
public class BooksLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link sample.lrdev05.database.service.impl.BooksLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the books to the database. Also notifies the appropriate model listeners.
	*
	* @param books the books
	* @return the books that was added
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books addBooks(
		sample.lrdev05.database.model.Books books)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBooks(books);
	}

	/**
	* Creates a new books with the primary key. Does not add the books to the database.
	*
	* @param bookId the primary key for the new books
	* @return the new books
	*/
	public static sample.lrdev05.database.model.Books createBooks(long bookId) {
		return getService().createBooks(bookId);
	}

	/**
	* Deletes the books with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the books
	* @return the books that was removed
	* @throws PortalException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books deleteBooks(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBooks(bookId);
	}

	/**
	* Deletes the books from the database. Also notifies the appropriate model listeners.
	*
	* @param books the books
	* @return the books that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books deleteBooks(
		sample.lrdev05.database.model.Books books)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBooks(books);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static sample.lrdev05.database.model.Books fetchBooks(long bookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBooks(bookId);
	}

	/**
	* Returns the books with the primary key.
	*
	* @param bookId the primary key of the books
	* @return the books
	* @throws PortalException if a books with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books getBooks(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBooks(bookId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the books with the UUID in the group.
	*
	* @param uuid the UUID of books
	* @param groupId the group id of the books
	* @return the books
	* @throws PortalException if a books with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books getBooksByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBooksByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<sample.lrdev05.database.model.Books> getBookses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBookses(start, end);
	}

	/**
	* Returns the number of bookses.
	*
	* @return the number of bookses
	* @throws SystemException if a system exception occurred
	*/
	public static int getBooksesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBooksesCount();
	}

	/**
	* Updates the books in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param books the books
	* @return the books that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books updateBooks(
		sample.lrdev05.database.model.Books books)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBooks(books);
	}

	/**
	* Updates the books in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param books the books
	* @param merge whether to merge the books with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the books that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static sample.lrdev05.database.model.Books updateBooks(
		sample.lrdev05.database.model.Books books, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBooks(books, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static sample.lrdev05.database.model.Books addBooks(
		sample.lrdev02.database.model.Books booksParam, long userId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().addBooks(booksParam, userId, serviceContext);
	}

	public static sample.lrdev02.database.model.Books updateBooks(
		sample.lrdev02.database.model.Books booksParam, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().updateBooks(booksParam, userId);
	}

	public static sample.lrdev02.database.model.Books updateStatus(
		long userId, long resourcePrimKey, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, resourcePrimKey, status, serviceContext);
	}

	public static sample.lrdev02.database.model.Books getBooksInstance() {
		return getService().getBooksInstance();
	}

	public static java.util.List<sample.lrdev02.database.model.Books> getAllBooks(
		long companyId) {
		return getService().getAllBooks(companyId);
	}

	public static java.util.List<sample.lrdev02.database.model.Books> getAllBooks() {
		return getService().getAllBooks();
	}

	public static java.util.List<sample.lrdev02.database.model.Books> getAllBooks(
		long groupId, java.lang.String title) {
		return getService().getAllBooks(groupId, title);
	}

	public static java.util.List<sample.lrdev02.database.model.Books> getBooksByUserId(
		long userId) {
		return getService().getBooksByUserId(userId);
	}

	public static void deleteBooks(long booksId, long companyId) {
		getService().deleteBooks(booksId, companyId);
	}

	public static void deleteBooks(sample.lrdev02.database.model.Books book,
		long companyId) {
		getService().deleteBooks(book, companyId);
	}

	public static void clearService() {
		_service = null;
	}

	public static BooksLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BooksLocalService.class.getName());

			if (invokableLocalService instanceof BooksLocalService) {
				_service = (BooksLocalService)invokableLocalService;
			}
			else {
				_service = new BooksLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BooksLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(BooksLocalService service) {
	}

	private static BooksLocalService _service;
}