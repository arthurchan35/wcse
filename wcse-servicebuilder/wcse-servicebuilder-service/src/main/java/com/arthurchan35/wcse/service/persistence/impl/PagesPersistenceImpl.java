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

import com.arthurchan35.wcse.exception.NoSuchPagesException;
import com.arthurchan35.wcse.model.Pages;
import com.arthurchan35.wcse.model.impl.PagesImpl;
import com.arthurchan35.wcse.model.impl.PagesModelImpl;
import com.arthurchan35.wcse.service.persistence.PagesPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import java.util.Set;

/**
 * The persistence implementation for the pages service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Arthur Chan
 * @see PagesPersistence
 * @see com.arthurchan35.wcse.service.persistence.PagesUtil
 * @generated
 */
@ProviderType
public class PagesPersistenceImpl extends BasePersistenceImpl<Pages>
	implements PagesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PagesUtil} to access the pages persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PagesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PagesModelImpl.ENTITY_CACHE_ENABLED,
			PagesModelImpl.FINDER_CACHE_ENABLED, PagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PagesModelImpl.ENTITY_CACHE_ENABLED,
			PagesModelImpl.FINDER_CACHE_ENABLED, PagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PagesModelImpl.ENTITY_CACHE_ENABLED,
			PagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PagesPersistenceImpl() {
		setModelClass(Pages.class);
	}

	/**
	 * Caches the pages in the entity cache if it is enabled.
	 *
	 * @param pages the pages
	 */
	@Override
	public void cacheResult(Pages pages) {
		entityCache.putResult(PagesModelImpl.ENTITY_CACHE_ENABLED,
			PagesImpl.class, pages.getPrimaryKey(), pages);

		pages.resetOriginalValues();
	}

	/**
	 * Caches the pageses in the entity cache if it is enabled.
	 *
	 * @param pageses the pageses
	 */
	@Override
	public void cacheResult(List<Pages> pageses) {
		for (Pages pages : pageses) {
			if (entityCache.getResult(PagesModelImpl.ENTITY_CACHE_ENABLED,
						PagesImpl.class, pages.getPrimaryKey()) == null) {
				cacheResult(pages);
			}
			else {
				pages.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pageses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PagesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pages.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Pages pages) {
		entityCache.removeResult(PagesModelImpl.ENTITY_CACHE_ENABLED,
			PagesImpl.class, pages.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Pages> pageses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Pages pages : pageses) {
			entityCache.removeResult(PagesModelImpl.ENTITY_CACHE_ENABLED,
				PagesImpl.class, pages.getPrimaryKey());
		}
	}

	/**
	 * Creates a new pages with the primary key. Does not add the pages to the database.
	 *
	 * @param url_id the primary key for the new pages
	 * @return the new pages
	 */
	@Override
	public Pages create(long url_id) {
		Pages pages = new PagesImpl();

		pages.setNew(true);
		pages.setPrimaryKey(url_id);

		return pages;
	}

	/**
	 * Removes the pages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param url_id the primary key of the pages
	 * @return the pages that was removed
	 * @throws NoSuchPagesException if a pages with the primary key could not be found
	 */
	@Override
	public Pages remove(long url_id) throws NoSuchPagesException {
		return remove((Serializable)url_id);
	}

	/**
	 * Removes the pages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pages
	 * @return the pages that was removed
	 * @throws NoSuchPagesException if a pages with the primary key could not be found
	 */
	@Override
	public Pages remove(Serializable primaryKey) throws NoSuchPagesException {
		Session session = null;

		try {
			session = openSession();

			Pages pages = (Pages)session.get(PagesImpl.class, primaryKey);

			if (pages == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(pages);
		}
		catch (NoSuchPagesException nsee) {
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
	protected Pages removeImpl(Pages pages) {
		pages = toUnwrappedModel(pages);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(pages)) {
				pages = (Pages)session.get(PagesImpl.class,
						pages.getPrimaryKeyObj());
			}

			if (pages != null) {
				session.delete(pages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (pages != null) {
			clearCache(pages);
		}

		return pages;
	}

	@Override
	public Pages updateImpl(Pages pages) {
		pages = toUnwrappedModel(pages);

		boolean isNew = pages.isNew();

		Session session = null;

		try {
			session = openSession();

			if (pages.isNew()) {
				session.save(pages);

				pages.setNew(false);
			}
			else {
				pages = (Pages)session.merge(pages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(PagesModelImpl.ENTITY_CACHE_ENABLED,
			PagesImpl.class, pages.getPrimaryKey(), pages, false);

		pages.resetOriginalValues();

		return pages;
	}

	protected Pages toUnwrappedModel(Pages pages) {
		if (pages instanceof PagesImpl) {
			return pages;
		}

		PagesImpl pagesImpl = new PagesImpl();

		pagesImpl.setNew(pages.isNew());
		pagesImpl.setPrimaryKey(pages.getPrimaryKey());

		pagesImpl.setUrl_id(pages.getUrl_id());
		pagesImpl.setUrl(pages.getUrl());
		pagesImpl.setDescription(pages.getDescription());
		pagesImpl.setImage(pages.getImage());

		return pagesImpl;
	}

	/**
	 * Returns the pages with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the pages
	 * @return the pages
	 * @throws NoSuchPagesException if a pages with the primary key could not be found
	 */
	@Override
	public Pages findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPagesException {
		Pages pages = fetchByPrimaryKey(primaryKey);

		if (pages == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return pages;
	}

	/**
	 * Returns the pages with the primary key or throws a {@link NoSuchPagesException} if it could not be found.
	 *
	 * @param url_id the primary key of the pages
	 * @return the pages
	 * @throws NoSuchPagesException if a pages with the primary key could not be found
	 */
	@Override
	public Pages findByPrimaryKey(long url_id) throws NoSuchPagesException {
		return findByPrimaryKey((Serializable)url_id);
	}

	/**
	 * Returns the pages with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pages
	 * @return the pages, or <code>null</code> if a pages with the primary key could not be found
	 */
	@Override
	public Pages fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(PagesModelImpl.ENTITY_CACHE_ENABLED,
				PagesImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Pages pages = (Pages)serializable;

		if (pages == null) {
			Session session = null;

			try {
				session = openSession();

				pages = (Pages)session.get(PagesImpl.class, primaryKey);

				if (pages != null) {
					cacheResult(pages);
				}
				else {
					entityCache.putResult(PagesModelImpl.ENTITY_CACHE_ENABLED,
						PagesImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(PagesModelImpl.ENTITY_CACHE_ENABLED,
					PagesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return pages;
	}

	/**
	 * Returns the pages with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param url_id the primary key of the pages
	 * @return the pages, or <code>null</code> if a pages with the primary key could not be found
	 */
	@Override
	public Pages fetchByPrimaryKey(long url_id) {
		return fetchByPrimaryKey((Serializable)url_id);
	}

	@Override
	public Map<Serializable, Pages> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Pages> map = new HashMap<Serializable, Pages>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Pages pages = fetchByPrimaryKey(primaryKey);

			if (pages != null) {
				map.put(primaryKey, pages);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(PagesModelImpl.ENTITY_CACHE_ENABLED,
					PagesImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Pages)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_PAGES_WHERE_PKS_IN);

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

			for (Pages pages : (List<Pages>)q.list()) {
				map.put(pages.getPrimaryKeyObj(), pages);

				cacheResult(pages);

				uncachedPrimaryKeys.remove(pages.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(PagesModelImpl.ENTITY_CACHE_ENABLED,
					PagesImpl.class, primaryKey, nullModel);
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
	 * Returns all the pageses.
	 *
	 * @return the pageses
	 */
	@Override
	public List<Pages> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pageses
	 * @param end the upper bound of the range of pageses (not inclusive)
	 * @return the range of pageses
	 */
	@Override
	public List<Pages> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pageses
	 * @param end the upper bound of the range of pageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pageses
	 */
	@Override
	public List<Pages> findAll(int start, int end,
		OrderByComparator<Pages> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pageses
	 * @param end the upper bound of the range of pageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of pageses
	 */
	@Override
	public List<Pages> findAll(int start, int end,
		OrderByComparator<Pages> orderByComparator, boolean retrieveFromCache) {
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

		List<Pages> list = null;

		if (retrieveFromCache) {
			list = (List<Pages>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PAGES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PAGES;

				if (pagination) {
					sql = sql.concat(PagesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Pages>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Pages>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the pageses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Pages pages : findAll()) {
			remove(pages);
		}
	}

	/**
	 * Returns the number of pageses.
	 *
	 * @return the number of pageses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PAGES);

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
		return PagesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pages persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(PagesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_PAGES = "SELECT pages FROM Pages pages";
	private static final String _SQL_SELECT_PAGES_WHERE_PKS_IN = "SELECT pages FROM Pages pages WHERE url_id IN (";
	private static final String _SQL_COUNT_PAGES = "SELECT COUNT(pages) FROM Pages pages";
	private static final String _ORDER_BY_ENTITY_ALIAS = "pages.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Pages exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(PagesPersistenceImpl.class);
}