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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.ratings.service.persistence.RatingsStatsPersistence;

import sample.lrdev05.database.NoSuchooksException;
import sample.lrdev05.database.model.Books;
import sample.lrdev05.database.model.impl.BooksImpl;
import sample.lrdev05.database.model.impl.BooksModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the books service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mshanmugam
 * @see BooksPersistence
 * @see BooksUtil
 * @generated
 */
public class BooksPersistenceImpl extends BasePersistenceImpl<Books>
	implements BooksPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BooksUtil} to access the books persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BooksImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			BooksModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			BooksModelImpl.UUID_COLUMN_BITMASK |
			BooksModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			BooksModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			BooksModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			BooksModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP_TITLE =
		new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup_Title",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP_TITLE =
		new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup_Title",
			new String[] { Long.class.getName(), String.class.getName() },
			BooksModelImpl.GROUPID_COLUMN_BITMASK |
			BooksModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP_TITLE = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup_Title",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP_AUTHOR =
		new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup_Author",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP_AUTHOR =
		new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup_Author",
			new String[] { Long.class.getName(), String.class.getName() },
			BooksModelImpl.GROUPID_COLUMN_BITMASK |
			BooksModelImpl.AUTHOR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUP_AUTHOR = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup_Author",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, BooksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the books in the entity cache if it is enabled.
	 *
	 * @param books the books
	 */
	public void cacheResult(Books books) {
		EntityCacheUtil.putResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksImpl.class, books.getPrimaryKey(), books);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { books.getUuid(), Long.valueOf(books.getGroupId()) },
			books);

		books.resetOriginalValues();
	}

	/**
	 * Caches the bookses in the entity cache if it is enabled.
	 *
	 * @param bookses the bookses
	 */
	public void cacheResult(List<Books> bookses) {
		for (Books books : bookses) {
			if (EntityCacheUtil.getResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
						BooksImpl.class, books.getPrimaryKey()) == null) {
				cacheResult(books);
			}
			else {
				books.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bookses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BooksImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BooksImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the books.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Books books) {
		EntityCacheUtil.removeResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksImpl.class, books.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(books);
	}

	@Override
	public void clearCache(List<Books> bookses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Books books : bookses) {
			EntityCacheUtil.removeResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
				BooksImpl.class, books.getPrimaryKey());

			clearUniqueFindersCache(books);
		}
	}

	protected void clearUniqueFindersCache(Books books) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { books.getUuid(), Long.valueOf(books.getGroupId()) });
	}

	/**
	 * Creates a new books with the primary key. Does not add the books to the database.
	 *
	 * @param bookId the primary key for the new books
	 * @return the new books
	 */
	public Books create(long bookId) {
		Books books = new BooksImpl();

		books.setNew(true);
		books.setPrimaryKey(bookId);

		String uuid = PortalUUIDUtil.generate();

		books.setUuid(uuid);

		return books;
	}

	/**
	 * Removes the books with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the books
	 * @return the books that was removed
	 * @throws sample.lrdev05.database.NoSuchooksException if a books with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books remove(long bookId)
		throws NoSuchooksException, SystemException {
		return remove(Long.valueOf(bookId));
	}

	/**
	 * Removes the books with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the books
	 * @return the books that was removed
	 * @throws sample.lrdev05.database.NoSuchooksException if a books with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books remove(Serializable primaryKey)
		throws NoSuchooksException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Books books = (Books)session.get(BooksImpl.class, primaryKey);

			if (books == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchooksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(books);
		}
		catch (NoSuchooksException nsee) {
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
	protected Books removeImpl(Books books) throws SystemException {
		books = toUnwrappedModel(books);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, books);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(books);

		return books;
	}

	@Override
	public Books updateImpl(sample.lrdev05.database.model.Books books,
		boolean merge) throws SystemException {
		books = toUnwrappedModel(books);

		boolean isNew = books.isNew();

		BooksModelImpl booksModelImpl = (BooksModelImpl)books;

		if (Validator.isNull(books.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			books.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, books, merge);

			books.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BooksModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((booksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { booksModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { booksModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((booksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(booksModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { Long.valueOf(booksModelImpl.getGroupId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((booksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(booksModelImpl.getOriginalCompanyId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { Long.valueOf(booksModelImpl.getCompanyId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((booksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(booksModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { Long.valueOf(booksModelImpl.getUserId()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((booksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP_TITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(booksModelImpl.getOriginalGroupId()),
						
						booksModelImpl.getOriginalTitle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP_TITLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP_TITLE,
					args);

				args = new Object[] {
						Long.valueOf(booksModelImpl.getGroupId()),
						
						booksModelImpl.getTitle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP_TITLE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP_TITLE,
					args);
			}

			if ((booksModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP_AUTHOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(booksModelImpl.getOriginalGroupId()),
						
						booksModelImpl.getOriginalAuthor()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP_AUTHOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP_AUTHOR,
					args);

				args = new Object[] {
						Long.valueOf(booksModelImpl.getGroupId()),
						
						booksModelImpl.getAuthor()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUP_AUTHOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP_AUTHOR,
					args);
			}
		}

		EntityCacheUtil.putResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
			BooksImpl.class, books.getPrimaryKey(), books);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
				new Object[] { books.getUuid(), Long.valueOf(books.getGroupId()) },
				books);
		}
		else {
			if ((booksModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						booksModelImpl.getOriginalUuid(),
						Long.valueOf(booksModelImpl.getOriginalGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
					new Object[] {
						books.getUuid(), Long.valueOf(books.getGroupId())
					}, books);
			}
		}

		return books;
	}

	protected Books toUnwrappedModel(Books books) {
		if (books instanceof BooksImpl) {
			return books;
		}

		BooksImpl booksImpl = new BooksImpl();

		booksImpl.setNew(books.isNew());
		booksImpl.setPrimaryKey(books.getPrimaryKey());

		booksImpl.setUuid(books.getUuid());
		booksImpl.setBookId(books.getBookId());
		booksImpl.setCompanyId(books.getCompanyId());
		booksImpl.setGroupId(books.getGroupId());
		booksImpl.setUserId(books.getUserId());
		booksImpl.setUserName(books.getUserName());
		booksImpl.setCreateDate(books.getCreateDate());
		booksImpl.setModifiedDate(books.getModifiedDate());
		booksImpl.setStatus(books.getStatus());
		booksImpl.setStatusByUserId(books.getStatusByUserId());
		booksImpl.setStatusByUserName(books.getStatusByUserName());
		booksImpl.setStatusDate(books.getStatusDate());
		booksImpl.setTitle(books.getTitle());
		booksImpl.setAuthor(books.getAuthor());
		booksImpl.setSummary(books.getSummary());
		booksImpl.setIsbn(books.getIsbn());

		return booksImpl;
	}

	/**
	 * Returns the books with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the books
	 * @return the books
	 * @throws com.liferay.portal.NoSuchModelException if a books with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the books with the primary key or throws a {@link sample.lrdev05.database.NoSuchooksException} if it could not be found.
	 *
	 * @param bookId the primary key of the books
	 * @return the books
	 * @throws sample.lrdev05.database.NoSuchooksException if a books with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books findByPrimaryKey(long bookId)
		throws NoSuchooksException, SystemException {
		Books books = fetchByPrimaryKey(bookId);

		if (books == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + bookId);
			}

			throw new NoSuchooksException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				bookId);
		}

		return books;
	}

	/**
	 * Returns the books with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the books
	 * @return the books, or <code>null</code> if a books with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Books fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the books with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the books
	 * @return the books, or <code>null</code> if a books with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books fetchByPrimaryKey(long bookId) throws SystemException {
		Books books = (Books)EntityCacheUtil.getResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
				BooksImpl.class, bookId);

		if (books == _nullBooks) {
			return null;
		}

		if (books == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				books = (Books)session.get(BooksImpl.class, Long.valueOf(bookId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (books != null) {
					cacheResult(books);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(BooksModelImpl.ENTITY_CACHE_ENABLED,
						BooksImpl.class, bookId, _nullBooks);
				}

				closeSession(session);
			}
		}

		return books;
	}

	/**
	 * Returns all the bookses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Books> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Books> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	public List<Books> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Books> list = (List<Books>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Books books : list) {
				if (!Validator.equals(uuid, books.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BOOKS_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BooksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<Books>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = fetchByUuid_First(uuid, orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchooksException(msg.toString());
	}

	/**
	 * Returns the first books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Books> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = fetchByUuid_Last(uuid, orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchooksException(msg.toString());
	}

	/**
	 * Returns the last books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		List<Books> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Books[] findByUuid_PrevAndNext(long bookId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Books[] array = new BooksImpl[3];

			array[0] = getByUuid_PrevAndNext(session, books, uuid,
					orderByComparator, true);

			array[1] = books;

			array[2] = getByUuid_PrevAndNext(session, books, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Books getByUuid_PrevAndNext(Session session, Books books,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKS_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(BooksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(books);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Books> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the books where uuid = &#63; and groupId = &#63; or throws a {@link sample.lrdev05.database.NoSuchooksException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching books
	 * @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books findByUUID_G(String uuid, long groupId)
		throws NoSuchooksException, SystemException {
		Books books = fetchByUUID_G(uuid, groupId);

		if (books == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchooksException(msg.toString());
		}

		return books;
	}

	/**
	 * Returns the books where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching books, or <code>null</code> if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
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
	public Books fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Books) {
			Books books = (Books)result;

			if (!Validator.equals(uuid, books.getUuid()) ||
					(groupId != books.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BOOKS_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			query.append(BooksModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Books> list = q.list();

				result = list;

				Books books = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					books = list.get(0);

					cacheResult(books);

					if ((books.getUuid() == null) ||
							!books.getUuid().equals(uuid) ||
							(books.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, books);
					}
				}

				return books;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Books)result;
			}
		}
	}

	/**
	 * Returns all the bookses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Books> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Books> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	public List<Books> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Books> list = (List<Books>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Books books : list) {
				if ((groupId != books.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BOOKS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BooksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				list = (List<Books>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first books in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = fetchByGroupId_First(groupId, orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchooksException(msg.toString());
	}

	/**
	 * Returns the first books in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Books> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last books in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = fetchByGroupId_Last(groupId, orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchooksException(msg.toString());
	}

	/**
	 * Returns the last books in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		List<Books> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Books[] findByGroupId_PrevAndNext(long bookId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Books[] array = new BooksImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, books, groupId,
					orderByComparator, true);

			array[1] = books;

			array[2] = getByGroupId_PrevAndNext(session, books, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Books getByGroupId_PrevAndNext(Session session, Books books,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKS_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(BooksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(books);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Books> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the bookses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Books> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<Books> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
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
	public List<Books> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Books> list = (List<Books>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Books books : list) {
				if ((companyId != books.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BOOKS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BooksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Books>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first books in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = fetchByCompanyId_First(companyId, orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchooksException(msg.toString());
	}

	/**
	 * Returns the first books in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Books> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last books in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = fetchByCompanyId_Last(companyId, orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchooksException(msg.toString());
	}

	/**
	 * Returns the last books in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		List<Books> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Books[] findByCompanyId_PrevAndNext(long bookId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Books[] array = new BooksImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, books, companyId,
					orderByComparator, true);

			array[1] = books;

			array[2] = getByCompanyId_PrevAndNext(session, books, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Books getByCompanyId_PrevAndNext(Session session, Books books,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKS_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(BooksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(books);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Books> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the bookses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Books> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Books> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	public List<Books> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Books> list = (List<Books>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Books books : list) {
				if ((userId != books.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BOOKS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BooksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<Books>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first books in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = fetchByUserId_First(userId, orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchooksException(msg.toString());
	}

	/**
	 * Returns the first books in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Books> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last books in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = fetchByUserId_Last(userId, orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchooksException(msg.toString());
	}

	/**
	 * Returns the last books in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		List<Books> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Books[] findByUserId_PrevAndNext(long bookId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Books[] array = new BooksImpl[3];

			array[0] = getByUserId_PrevAndNext(session, books, userId,
					orderByComparator, true);

			array[1] = books;

			array[2] = getByUserId_PrevAndNext(session, books, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Books getByUserId_PrevAndNext(Session session, Books books,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKS_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(BooksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(books);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Books> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the bookses where groupId = &#63; and title = &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @return the matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Books> findByGroup_Title(long groupId, String title)
		throws SystemException {
		return findByGroup_Title(groupId, title, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Books> findByGroup_Title(long groupId, String title, int start,
		int end) throws SystemException {
		return findByGroup_Title(groupId, title, start, end, null);
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
	public List<Books> findByGroup_Title(long groupId, String title, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP_TITLE;
			finderArgs = new Object[] { groupId, title };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP_TITLE;
			finderArgs = new Object[] {
					groupId, title,
					
					start, end, orderByComparator
				};
		}

		List<Books> list = (List<Books>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Books books : list) {
				if ((groupId != books.getGroupId()) ||
						!Validator.equals(title, books.getTitle())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_BOOKS_WHERE);

			query.append(_FINDER_COLUMN_GROUP_TITLE_GROUPID_2);

			if (title == null) {
				query.append(_FINDER_COLUMN_GROUP_TITLE_TITLE_1);
			}
			else {
				if (title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_GROUP_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_GROUP_TITLE_TITLE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BooksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (title != null) {
					qPos.add(title);
				}

				list = (List<Books>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first books in the ordered set where groupId = &#63; and title = &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books findByGroup_Title_First(long groupId, String title,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = fetchByGroup_Title_First(groupId, title, orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchooksException(msg.toString());
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
	public Books fetchByGroup_Title_First(long groupId, String title,
		OrderByComparator orderByComparator) throws SystemException {
		List<Books> list = findByGroup_Title(groupId, title, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Books findByGroup_Title_Last(long groupId, String title,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = fetchByGroup_Title_Last(groupId, title, orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchooksException(msg.toString());
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
	public Books fetchByGroup_Title_Last(long groupId, String title,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup_Title(groupId, title);

		List<Books> list = findByGroup_Title(groupId, title, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Books[] findByGroup_Title_PrevAndNext(long bookId, long groupId,
		String title, OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Books[] array = new BooksImpl[3];

			array[0] = getByGroup_Title_PrevAndNext(session, books, groupId,
					title, orderByComparator, true);

			array[1] = books;

			array[2] = getByGroup_Title_PrevAndNext(session, books, groupId,
					title, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Books getByGroup_Title_PrevAndNext(Session session, Books books,
		long groupId, String title, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKS_WHERE);

		query.append(_FINDER_COLUMN_GROUP_TITLE_GROUPID_2);

		if (title == null) {
			query.append(_FINDER_COLUMN_GROUP_TITLE_TITLE_1);
		}
		else {
			if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUP_TITLE_TITLE_3);
			}
			else {
				query.append(_FINDER_COLUMN_GROUP_TITLE_TITLE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(BooksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (title != null) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(books);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Books> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the bookses where groupId = &#63; and author = &#63;.
	 *
	 * @param groupId the group ID
	 * @param author the author
	 * @return the matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Books> findByGroup_Author(long groupId, String author)
		throws SystemException {
		return findByGroup_Author(groupId, author, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Books> findByGroup_Author(long groupId, String author,
		int start, int end) throws SystemException {
		return findByGroup_Author(groupId, author, start, end, null);
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
	public List<Books> findByGroup_Author(long groupId, String author,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUP_AUTHOR;
			finderArgs = new Object[] { groupId, author };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUP_AUTHOR;
			finderArgs = new Object[] {
					groupId, author,
					
					start, end, orderByComparator
				};
		}

		List<Books> list = (List<Books>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Books books : list) {
				if ((groupId != books.getGroupId()) ||
						!Validator.equals(author, books.getAuthor())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_BOOKS_WHERE);

			query.append(_FINDER_COLUMN_GROUP_AUTHOR_GROUPID_2);

			if (author == null) {
				query.append(_FINDER_COLUMN_GROUP_AUTHOR_AUTHOR_1);
			}
			else {
				if (author.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_GROUP_AUTHOR_AUTHOR_3);
				}
				else {
					query.append(_FINDER_COLUMN_GROUP_AUTHOR_AUTHOR_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(BooksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (author != null) {
					qPos.add(author);
				}

				list = (List<Books>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first books in the ordered set where groupId = &#63; and author = &#63;.
	 *
	 * @param groupId the group ID
	 * @param author the author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws sample.lrdev05.database.NoSuchooksException if a matching books could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Books findByGroup_Author_First(long groupId, String author,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = fetchByGroup_Author_First(groupId, author,
				orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", author=");
		msg.append(author);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchooksException(msg.toString());
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
	public Books fetchByGroup_Author_First(long groupId, String author,
		OrderByComparator orderByComparator) throws SystemException {
		List<Books> list = findByGroup_Author(groupId, author, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Books findByGroup_Author_Last(long groupId, String author,
		OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = fetchByGroup_Author_Last(groupId, author,
				orderByComparator);

		if (books != null) {
			return books;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", author=");
		msg.append(author);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchooksException(msg.toString());
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
	public Books fetchByGroup_Author_Last(long groupId, String author,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroup_Author(groupId, author);

		List<Books> list = findByGroup_Author(groupId, author, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Books[] findByGroup_Author_PrevAndNext(long bookId, long groupId,
		String author, OrderByComparator orderByComparator)
		throws NoSuchooksException, SystemException {
		Books books = findByPrimaryKey(bookId);

		Session session = null;

		try {
			session = openSession();

			Books[] array = new BooksImpl[3];

			array[0] = getByGroup_Author_PrevAndNext(session, books, groupId,
					author, orderByComparator, true);

			array[1] = books;

			array[2] = getByGroup_Author_PrevAndNext(session, books, groupId,
					author, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Books getByGroup_Author_PrevAndNext(Session session, Books books,
		long groupId, String author, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOOKS_WHERE);

		query.append(_FINDER_COLUMN_GROUP_AUTHOR_GROUPID_2);

		if (author == null) {
			query.append(_FINDER_COLUMN_GROUP_AUTHOR_AUTHOR_1);
		}
		else {
			if (author.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUP_AUTHOR_AUTHOR_3);
			}
			else {
				query.append(_FINDER_COLUMN_GROUP_AUTHOR_AUTHOR_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(BooksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (author != null) {
			qPos.add(author);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(books);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Books> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the bookses.
	 *
	 * @return the bookses
	 * @throws SystemException if a system exception occurred
	 */
	public List<Books> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Books> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Books> findAll(int start, int end,
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

		List<Books> list = (List<Books>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BOOKS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKS.concat(BooksModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Books>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Books>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the bookses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Books books : findByUuid(uuid)) {
			remove(books);
		}
	}

	/**
	 * Removes the books where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the books that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Books removeByUUID_G(String uuid, long groupId)
		throws NoSuchooksException, SystemException {
		Books books = findByUUID_G(uuid, groupId);

		return remove(books);
	}

	/**
	 * Removes all the bookses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupId(long groupId) throws SystemException {
		for (Books books : findByGroupId(groupId)) {
			remove(books);
		}
	}

	/**
	 * Removes all the bookses where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Books books : findByCompanyId(companyId)) {
			remove(books);
		}
	}

	/**
	 * Removes all the bookses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (Books books : findByUserId(userId)) {
			remove(books);
		}
	}

	/**
	 * Removes all the bookses where groupId = &#63; and title = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup_Title(long groupId, String title)
		throws SystemException {
		for (Books books : findByGroup_Title(groupId, title)) {
			remove(books);
		}
	}

	/**
	 * Removes all the bookses where groupId = &#63; and author = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param author the author
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroup_Author(long groupId, String author)
		throws SystemException {
		for (Books books : findByGroup_Author(groupId, author)) {
			remove(books);
		}
	}

	/**
	 * Removes all the bookses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Books books : findAll()) {
			remove(books);
		}
	}

	/**
	 * Returns the number of bookses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKS_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of bookses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BOOKS_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_G_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_G_UUID_2);
				}
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of bookses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupId(long groupId) throws SystemException {
		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of bookses where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKS_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of bookses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOOKS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of bookses where groupId = &#63; and title = &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @return the number of matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup_Title(long groupId, String title)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, title };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP_TITLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BOOKS_WHERE);

			query.append(_FINDER_COLUMN_GROUP_TITLE_GROUPID_2);

			if (title == null) {
				query.append(_FINDER_COLUMN_GROUP_TITLE_TITLE_1);
			}
			else {
				if (title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_GROUP_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_GROUP_TITLE_TITLE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (title != null) {
					qPos.add(title);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUP_TITLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of bookses where groupId = &#63; and author = &#63;.
	 *
	 * @param groupId the group ID
	 * @param author the author
	 * @return the number of matching bookses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroup_Author(long groupId, String author)
		throws SystemException {
		Object[] finderArgs = new Object[] { groupId, author };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUP_AUTHOR,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BOOKS_WHERE);

			query.append(_FINDER_COLUMN_GROUP_AUTHOR_GROUPID_2);

			if (author == null) {
				query.append(_FINDER_COLUMN_GROUP_AUTHOR_AUTHOR_1);
			}
			else {
				if (author.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_GROUP_AUTHOR_AUTHOR_3);
				}
				else {
					query.append(_FINDER_COLUMN_GROUP_AUTHOR_AUTHOR_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (author != null) {
					qPos.add(author);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUP_AUTHOR,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of bookses.
	 *
	 * @return the number of bookses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BOOKS);

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
	 * Initializes the books persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.sample.lrdev05.database.model.Books")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Books>> listenersList = new ArrayList<ModelListener<Books>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Books>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BooksImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = BooksPersistence.class)
	protected BooksPersistence booksPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = RatingsStatsPersistence.class)
	protected RatingsStatsPersistence ratingsStatsPersistence;
	private static final String _SQL_SELECT_BOOKS = "SELECT books FROM Books books";
	private static final String _SQL_SELECT_BOOKS_WHERE = "SELECT books FROM Books books WHERE ";
	private static final String _SQL_COUNT_BOOKS = "SELECT COUNT(books) FROM Books books";
	private static final String _SQL_COUNT_BOOKS_WHERE = "SELECT COUNT(books) FROM Books books WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "books.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "books.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(books.uuid IS NULL OR books.uuid = ?)";
	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "books.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "books.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(books.uuid IS NULL OR books.uuid = ?) AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "books.groupId = ?";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "books.groupId = ?";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "books.companyId = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "books.userId = ?";
	private static final String _FINDER_COLUMN_GROUP_TITLE_GROUPID_2 = "books.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUP_TITLE_TITLE_1 = "books.title IS NULL";
	private static final String _FINDER_COLUMN_GROUP_TITLE_TITLE_2 = "books.title = ?";
	private static final String _FINDER_COLUMN_GROUP_TITLE_TITLE_3 = "(books.title IS NULL OR books.title = ?)";
	private static final String _FINDER_COLUMN_GROUP_AUTHOR_GROUPID_2 = "books.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUP_AUTHOR_AUTHOR_1 = "books.author IS NULL";
	private static final String _FINDER_COLUMN_GROUP_AUTHOR_AUTHOR_2 = "books.author = ?";
	private static final String _FINDER_COLUMN_GROUP_AUTHOR_AUTHOR_3 = "(books.author IS NULL OR books.author = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "books.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Books exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Books exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BooksPersistenceImpl.class);
	private static Books _nullBooks = new BooksImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Books> toCacheModel() {
				return _nullBooksCacheModel;
			}
		};

	private static CacheModel<Books> _nullBooksCacheModel = new CacheModel<Books>() {
			public Books toEntityModel() {
				return _nullBooks;
			}
		};
}