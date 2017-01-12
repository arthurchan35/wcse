/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.arthurchan35.wcse.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.arthurchan35.wcse.exception.NoSuchPageException;
import com.arthurchan35.wcse.model.Page;
import com.arthurchan35.wcse.model.impl.PageImpl;
import com.arthurchan35.wcse.model.impl.PageModelImpl;
import com.arthurchan35.wcse.service.persistence.PagePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the page service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Arthur Chan
 * @see PagePersistence
 * @see com.arthurchan35.wcse.service.persistence.PageUtil
 * @generated
 */
@ProviderType
public class PagePersistenceImpl extends BasePersistenceImpl<Page>
	implements PagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PageUtil} to access the page persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PageModelImpl.ENTITY_CACHE_ENABLED,
			PageModelImpl.FINDER_CACHE_ENABLED, PageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PageModelImpl.ENTITY_CACHE_ENABLED,
			PageModelImpl.FINDER_CACHE_ENABLED, PageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PageModelImpl.ENTITY_CACHE_ENABLED,
			PageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_URL = new FinderPath(PageModelImpl.ENTITY_CACHE_ENABLED,
			PageModelImpl.FINDER_CACHE_ENABLED, PageImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByURL",
			new String[] { String.class.getName() },
			PageModelImpl.URL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_URL = new FinderPath(PageModelImpl.ENTITY_CACHE_ENABLED,
			PageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByURL",
			new String[] { String.class.getName() });

	/**
	 * Returns the page where url = &#63; or throws a {@link NoSuchPageException} if it could not be found.
	 *
	 * @param url the url
	 * @return the matching page
	 * @throws NoSuchPageException if a matching page could not be found
	 */
	@Override
	public Page findByURL(String url) throws NoSuchPageException {
		Page page = fetchByURL(url);

		if (page == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("url=");
			msg.append(url);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPageException(msg.toString());
		}

		return page;
	}

	/**
	 * Returns the page where url = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param url the url
	 * @return the matching page, or <code>null</code> if a matching page could not be found
	 */
	@Override
	public Page fetchByURL(String url) {
		return fetchByURL(url, true);
	}

	/**
	 * Returns the page where url = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param url the url
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching page, or <code>null</code> if a matching page could not be found
	 */
	@Override
	public Page fetchByURL(String url, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { url };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_URL,
					finderArgs, this);
		}

		if (result instanceof Page) {
			Page page = (Page)result;

			if (!Objects.equals(url, page.getUrl())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PAGE_WHERE);

			boolean bindUrl = false;

			if (url == null) {
				query.append(_FINDER_COLUMN_URL_URL_1);
			}
			else if (url.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_URL_URL_3);
			}
			else {
				bindUrl = true;

				query.append(_FINDER_COLUMN_URL_URL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUrl) {
					qPos.add(url);
				}

				List<Page> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_URL, finderArgs,
						list);
				}
				else {
					Page page = list.get(0);

					result = page;

					cacheResult(page);

					if ((page.getUrl() == null) || !page.getUrl().equals(url)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_URL,
							finderArgs, page);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_URL, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Page)result;
		}
	}

	/**
	 * Removes the page where url = &#63; from the database.
	 *
	 * @param url the url
	 * @return the page that was removed
	 */
	@Override
	public Page removeByURL(String url) throws NoSuchPageException {
		Page page = findByURL(url);

		return remove(page);
	}

	/**
	 * Returns the number of pages where url = &#63;.
	 *
	 * @param url the url
	 * @return the number of matching pages
	 */
	@Override
	public int countByURL(String url) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_URL;

		Object[] finderArgs = new Object[] { url };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PAGE_WHERE);

			boolean bindUrl = false;

			if (url == null) {
				query.append(_FINDER_COLUMN_URL_URL_1);
			}
			else if (url.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_URL_URL_3);
			}
			else {
				bindUrl = true;

				query.append(_FINDER_COLUMN_URL_URL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUrl) {
					qPos.add(url);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_URL_URL_1 = "page.url IS NULL";
	private static final String _FINDER_COLUMN_URL_URL_2 = "page.url = ?";
	private static final String _FINDER_COLUMN_URL_URL_3 = "(page.url IS NULL OR page.url = '')";

	public PagePersistenceImpl() {
		setModelClass(Page.class);
	}

	/**
	 * Caches the page in the entity cache if it is enabled.
	 *
	 * @param page the page
	 */
	@Override
	public void cacheResult(Page page) {
		entityCache.putResult(PageModelImpl.ENTITY_CACHE_ENABLED,
			PageImpl.class, page.getPrimaryKey(), page);

		finderCache.putResult(FINDER_PATH_FETCH_BY_URL,
			new Object[] { page.getUrl() }, page);

		page.resetOriginalValues();
	}

	/**
	 * Caches the pages in the entity cache if it is enabled.
	 *
	 * @param pages the pages
	 */
	@Override
	public void cacheResult(List<Page> pages) {
		for (Page page : pages) {
			if (entityCache.getResult(PageModelImpl.ENTITY_CACHE_ENABLED,
						PageImpl.class, page.getPrimaryKey()) == null) {
				cacheResult(page);
			}
			else {
				page.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pages.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the page.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Page page) {
		entityCache.removeResult(PageModelImpl.ENTITY_CACHE_ENABLED,
			PageImpl.class, page.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PageModelImpl)page);
	}

	@Override
	public void clearCache(List<Page> pages) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Page page : pages) {
			entityCache.removeResult(PageModelImpl.ENTITY_CACHE_ENABLED,
				PageImpl.class, page.getPrimaryKey());

			clearUniqueFindersCache((PageModelImpl)page);
		}
	}

	protected void cacheUniqueFindersCache(PageModelImpl pageModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { pageModelImpl.getUrl() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_URL, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_URL, args, pageModelImpl);
		}
		else {
			if ((pageModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_URL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { pageModelImpl.getUrl() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_URL, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_URL, args,
					pageModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(PageModelImpl pageModelImpl) {
		Object[] args = new Object[] { pageModelImpl.getUrl() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_URL, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_URL, args);

		if ((pageModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_URL.getColumnBitmask()) != 0) {
			args = new Object[] { pageModelImpl.getOriginalUrl() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_URL, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_URL, args);
		}
	}

	/**
	 * Creates a new page with the primary key. Does not add the page to the database.
	 *
	 * @param pageId the primary key for the new page
	 * @return the new page
	 */
	@Override
	public Page create(long pageId) {
		Page page = new PageImpl();

		page.setNew(true);
		page.setPrimaryKey(pageId);

		return page;
	}

	/**
	 * Removes the page with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pageId the primary key of the page
	 * @return the page that was removed
	 * @throws NoSuchPageException if a page with the primary key could not be found
	 */
	@Override
	public Page remove(long pageId) throws NoSuchPageException {
		return remove((Serializable)pageId);
	}

	/**
	 * Removes the page with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the page
	 * @return the page that was removed
	 * @throws NoSuchPageException if a page with the primary key could not be found
	 */
	@Override
	public Page remove(Serializable primaryKey) throws NoSuchPageException {
		Session session = null;

		try {
			session = openSession();

			Page page = (Page)session.get(PageImpl.class, primaryKey);

			if (page == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(page);
		}
		catch (NoSuchPageException nsee) {
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
	protected Page removeImpl(Page page) {
		page = toUnwrappedModel(page);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(page)) {
				page = (Page)session.get(PageImpl.class, page.getPrimaryKeyObj());
			}

			if (page != null) {
				session.delete(page);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (page != null) {
			clearCache(page);
		}

		return page;
	}

	@Override
	public Page updateImpl(Page page) {
		page = toUnwrappedModel(page);

		boolean isNew = page.isNew();

		PageModelImpl pageModelImpl = (PageModelImpl)page;

		Session session = null;

		try {
			session = openSession();

			if (page.isNew()) {
				session.save(page);

				page.setNew(false);
			}
			else {
				page = (Page)session.merge(page);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PageModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(PageModelImpl.ENTITY_CACHE_ENABLED,
			PageImpl.class, page.getPrimaryKey(), page, false);

		clearUniqueFindersCache(pageModelImpl);
		cacheUniqueFindersCache(pageModelImpl, isNew);

		page.resetOriginalValues();

		return page;
	}

	protected Page toUnwrappedModel(Page page) {
		if (page instanceof PageImpl) {
			return page;
		}

		PageImpl pageImpl = new PageImpl();

		pageImpl.setNew(page.isNew());
		pageImpl.setPrimaryKey(page.getPrimaryKey());

		pageImpl.setPageId(page.getPageId());
		pageImpl.setUrl(page.getUrl());
		pageImpl.setDescription(page.getDescription());
		pageImpl.setImage(page.getImage());

		return pageImpl;
	}

	/**
	 * Returns the page with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the page
	 * @return the page
	 * @throws NoSuchPageException if a page with the primary key could not be found
	 */
	@Override
	public Page findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPageException {
		Page page = fetchByPrimaryKey(primaryKey);

		if (page == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return page;
	}

	/**
	 * Returns the page with the primary key or throws a {@link NoSuchPageException} if it could not be found.
	 *
	 * @param pageId the primary key of the page
	 * @return the page
	 * @throws NoSuchPageException if a page with the primary key could not be found
	 */
	@Override
	public Page findByPrimaryKey(long pageId) throws NoSuchPageException {
		return findByPrimaryKey((Serializable)pageId);
	}

	/**
	 * Returns the page with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the page
	 * @return the page, or <code>null</code> if a page with the primary key could not be found
	 */
	@Override
	public Page fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PageModelImpl.ENTITY_CACHE_ENABLED,
				PageImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Page page = (Page)serializable;

		if (page == null) {
			Session session = null;

			try {
				session = openSession();

				page = (Page)session.get(PageImpl.class, primaryKey);

				if (page != null) {
					cacheResult(page);
				}
				else {
					entityCache.putResult(PageModelImpl.ENTITY_CACHE_ENABLED,
						PageImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PageModelImpl.ENTITY_CACHE_ENABLED,
					PageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return page;
	}

	/**
	 * Returns the page with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pageId the primary key of the page
	 * @return the page, or <code>null</code> if a page with the primary key could not be found
	 */
	@Override
	public Page fetchByPrimaryKey(long pageId) {
		return fetchByPrimaryKey((Serializable)pageId);
	}

	@Override
	public Map<Serializable, Page> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Page> map = new HashMap<Serializable, Page>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Page page = fetchByPrimaryKey(primaryKey);

			if (page != null) {
				map.put(primaryKey, page);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PageModelImpl.ENTITY_CACHE_ENABLED,
					PageImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Page)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PAGE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Page page : (List<Page>)q.list()) {
				map.put(page.getPrimaryKeyObj(), page);

				cacheResult(page);

				uncachedPrimaryKeys.remove(page.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PageModelImpl.ENTITY_CACHE_ENABLED,
					PageImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the pages.
	 *
	 * @return the pages
	 */
	@Override
	public List<Page> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pages
	 * @param end the upper bound of the range of pages (not inclusive)
	 * @return the range of pages
	 */
	@Override
	public List<Page> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pages
	 * @param end the upper bound of the range of pages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pages
	 */
	@Override
	public List<Page> findAll(int start, int end,
		OrderByComparator<Page> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pages
	 * @param end the upper bound of the range of pages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of pages
	 */
	@Override
	public List<Page> findAll(int start, int end,
		OrderByComparator<Page> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Page> list = null;

		if (retrieveFromCache) {
			list = (List<Page>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PAGE;

				if (pagination) {
					sql = sql.concat(PageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Page>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Page>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the pages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Page page : findAll()) {
			remove(page);
		}
	}

	/**
	 * Returns the number of pages.
	 *
	 * @return the number of pages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PAGE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the page persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PageImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PAGE = "SELECT page FROM Page page";
	private static final String _SQL_SELECT_PAGE_WHERE_PKS_IN = "SELECT page FROM Page page WHERE pageId IN (";
	private static final String _SQL_SELECT_PAGE_WHERE = "SELECT page FROM Page page WHERE ";
	private static final String _SQL_COUNT_PAGE = "SELECT COUNT(page) FROM Page page";
	private static final String _SQL_COUNT_PAGE_WHERE = "SELECT COUNT(page) FROM Page page WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "page.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Page exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Page exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(PagePersistenceImpl.class);
}