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

package sample.book.servicebuilder.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import sample.book.servicebuilder.NoSuchBookException;
import sample.book.servicebuilder.model.Book;
import sample.book.servicebuilder.model.impl.BookImpl;
import sample.book.servicebuilder.model.impl.BookModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookPersistence
 * @see BookUtil
 * @generated
 */
public class BookPersistenceImpl extends BasePersistenceImpl<Book>
	implements BookPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BookUtil} to access the book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BookImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the book in the entity cache if it is enabled.
	 *
	 * @param book the book
	 */
	public void cacheResult(Book book) {
		EntityCacheUtil.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookImpl.class, book.getPrimaryKey(), book);

		book.resetOriginalValues();
	}

	/**
	 * Caches the books in the entity cache if it is enabled.
	 *
	 * @param books the books
	 */
	public void cacheResult(List<Book> books) {
		for (Book book : books) {
			if (EntityCacheUtil.getResult(BookModelImpl.ENTITY_CACHE_ENABLED,
						BookImpl.class, book.getPrimaryKey()) == null) {
				cacheResult(book);
			}
			else {
				book.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all books.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BookImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BookImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the book.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Book book) {
		EntityCacheUtil.removeResult(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookImpl.class, book.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Book> books) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Book book : books) {
			EntityCacheUtil.removeResult(BookModelImpl.ENTITY_CACHE_ENABLED,
				BookImpl.class, book.getPrimaryKey());
		}
	}

	/**
	 * Creates a new book with the primary key. Does not add the book to the database.
	 *
	 * @param bookId the primary key for the new book
	 * @return the new book
	 */
	public Book create(long bookId) {
		Book book = new BookImpl();

		book.setNew(true);
		book.setPrimaryKey(bookId);

		return book;
	}

	/**
	 * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the book
	 * @return the book that was removed
	 * @throws sample.book.servicebuilder.NoSuchBookException if a book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Book remove(long bookId) throws NoSuchBookException, SystemException {
		return remove(Long.valueOf(bookId));
	}

	/**
	 * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the book
	 * @return the book that was removed
	 * @throws sample.book.servicebuilder.NoSuchBookException if a book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Book remove(Serializable primaryKey)
		throws NoSuchBookException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Book book = (Book)session.get(BookImpl.class, primaryKey);

			if (book == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(book);
		}
		catch (NoSuchBookException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Book removeImpl(Book book) throws SystemException {
		book = toUnwrappedModel(book);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, book);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(book);

		return book;
	}

	@Override
	public Book updateImpl(sample.book.servicebuilder.model.Book book,
		boolean merge) throws SystemException {
		book = toUnwrappedModel(book);

		boolean isNew = book.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, book, merge);

			book.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
			BookImpl.class, book.getPrimaryKey(), book);

		return book;
	}

	protected Book toUnwrappedModel(Book book) {
		if (book instanceof BookImpl) {
			return book;
		}

		BookImpl bookImpl = new BookImpl();

		bookImpl.setNew(book.isNew());
		bookImpl.setPrimaryKey(book.getPrimaryKey());

		bookImpl.setBookId(book.getBookId());
		bookImpl.setTitle(book.getTitle());
		bookImpl.setAuthor(book.getAuthor());
		bookImpl.setIsbn(book.getIsbn());
		bookImpl.setSummary(book.getSummary());

		return bookImpl;
	}

	/**
	 * Returns the book with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the book
	 * @return the book
	 * @throws com.liferay.portal.NoSuchModelException if a book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Book findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the book with the primary key or throws a {@link sample.book.servicebuilder.NoSuchBookException} if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book
	 * @throws sample.book.servicebuilder.NoSuchBookException if a book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Book findByPrimaryKey(long bookId)
		throws NoSuchBookException, SystemException {
		Book book = fetchByPrimaryKey(bookId);

		if (book == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bookId);
			}

			throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bookId);
		}

		return book;
	}

	/**
	 * Returns the book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the book
	 * @return the book, or <code>null</code> if a book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Book fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the book with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the book
	 * @return the book, or <code>null</code> if a book with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Book fetchByPrimaryKey(long bookId) throws SystemException {
		Book book = (Book)EntityCacheUtil.getResult(BookModelImpl.ENTITY_CACHE_ENABLED,
				BookImpl.class, bookId);

		if (book == _nullBook) {
			return null;
		}

		if (book == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				book = (Book)session.get(BookImpl.class, Long.valueOf(bookId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (book != null) {
					cacheResult(book);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
						BookImpl.class, bookId, _nullBook);
				}

				closeSession(session);
			}
		}

		return book;
	}

	/**
	 * Returns all the books.
	 *
	 * @return the books
	 * @throws SystemException if a system exception occurred
	 */
	public List<Book> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @return the range of books
	 * @throws SystemException if a system exception occurred
	 */
	public List<Book> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the books.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of books
	 * @param end the upper bound of the range of books (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of books
	 * @throws SystemException if a system exception occurred
	 */
	public List<Book> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Book> list = (List<Book>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BOOK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOK;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Book>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the books from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Book book : findAll()) {
			remove(book);
		}
	}

	/**
	 * Returns the number of books.
	 *
	 * @return the number of books
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOOK);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the book persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.sample.book.servicebuilder.model.Book")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Book>> listenersList = new ArrayList<ModelListener<Book>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Book>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BookImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = BookPersistence.class)
	protected BookPersistence bookPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_BOOK = "SELECT book FROM Book book";
	private static final String _SQL_COUNT_BOOK = "SELECT COUNT(book) FROM Book book";
	private static final String _ORDER_BY_ENTITY_ALIAS = "book.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Book exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BookPersistenceImpl.class);
	private static Book _nullBook = new BookImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Book> toCacheModel() {
				return _nullBookCacheModel;
			}
		};

	private static CacheModel<Book> _nullBookCacheModel = new CacheModel<Book>() {
			public Book toEntityModel() {
				return _nullBook;
			}
		};
}