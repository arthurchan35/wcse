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

import com.arthurchan35.wcse.exception.NoSuchWordsException;
import com.arthurchan35.wcse.model.Words;
import com.arthurchan35.wcse.model.impl.WordsImpl;
import com.arthurchan35.wcse.model.impl.WordsModelImpl;
import com.arthurchan35.wcse.service.persistence.WordsPersistence;

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
 * The persistence implementation for the words service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Arthur Chan
 * @see WordsPersistence
 * @see com.arthurchan35.wcse.service.persistence.WordsUtil
 * @generated
 */
@ProviderType
public class WordsPersistenceImpl extends BasePersistenceImpl<Words>
	implements WordsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WordsUtil} to access the words persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WordsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WordsModelImpl.ENTITY_CACHE_ENABLED,
			WordsModelImpl.FINDER_CACHE_ENABLED, WordsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WordsModelImpl.ENTITY_CACHE_ENABLED,
			WordsModelImpl.FINDER_CACHE_ENABLED, WordsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WordsModelImpl.ENTITY_CACHE_ENABLED,
			WordsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public WordsPersistenceImpl() {
		setModelClass(Words.class);
	}

	/**
	 * Caches the words in the entity cache if it is enabled.
	 *
	 * @param words the words
	 */
	@Override
	public void cacheResult(Words words) {
		entityCache.putResult(WordsModelImpl.ENTITY_CACHE_ENABLED,
			WordsImpl.class, words.getPrimaryKey(), words);

		words.resetOriginalValues();
	}

	/**
	 * Caches the wordses in the entity cache if it is enabled.
	 *
	 * @param wordses the wordses
	 */
	@Override
	public void cacheResult(List<Words> wordses) {
		for (Words words : wordses) {
			if (entityCache.getResult(WordsModelImpl.ENTITY_CACHE_ENABLED,
						WordsImpl.class, words.getPrimaryKey()) == null) {
				cacheResult(words);
			}
			else {
				words.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all wordses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WordsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the words.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Words words) {
		entityCache.removeResult(WordsModelImpl.ENTITY_CACHE_ENABLED,
			WordsImpl.class, words.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Words> wordses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Words words : wordses) {
			entityCache.removeResult(WordsModelImpl.ENTITY_CACHE_ENABLED,
				WordsImpl.class, words.getPrimaryKey());
		}
	}

	/**
	 * Creates a new words with the primary key. Does not add the words to the database.
	 *
	 * @param word_id the primary key for the new words
	 * @return the new words
	 */
	@Override
	public Words create(long word_id) {
		Words words = new WordsImpl();

		words.setNew(true);
		words.setPrimaryKey(word_id);

		return words;
	}

	/**
	 * Removes the words with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param word_id the primary key of the words
	 * @return the words that was removed
	 * @throws NoSuchWordsException if a words with the primary key could not be found
	 */
	@Override
	public Words remove(long word_id) throws NoSuchWordsException {
		return remove((Serializable)word_id);
	}

	/**
	 * Removes the words with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the words
	 * @return the words that was removed
	 * @throws NoSuchWordsException if a words with the primary key could not be found
	 */
	@Override
	public Words remove(Serializable primaryKey) throws NoSuchWordsException {
		Session session = null;

		try {
			session = openSession();

			Words words = (Words)session.get(WordsImpl.class, primaryKey);

			if (words == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWordsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(words);
		}
		catch (NoSuchWordsException nsee) {
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
	protected Words removeImpl(Words words) {
		words = toUnwrappedModel(words);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(words)) {
				words = (Words)session.get(WordsImpl.class,
						words.getPrimaryKeyObj());
			}

			if (words != null) {
				session.delete(words);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (words != null) {
			clearCache(words);
		}

		return words;
	}

	@Override
	public Words updateImpl(Words words) {
		words = toUnwrappedModel(words);

		boolean isNew = words.isNew();

		Session session = null;

		try {
			session = openSession();

			if (words.isNew()) {
				session.save(words);

				words.setNew(false);
			}
			else {
				words = (Words)session.merge(words);
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

		entityCache.putResult(WordsModelImpl.ENTITY_CACHE_ENABLED,
			WordsImpl.class, words.getPrimaryKey(), words, false);

		words.resetOriginalValues();

		return words;
	}

	protected Words toUnwrappedModel(Words words) {
		if (words instanceof WordsImpl) {
			return words;
		}

		WordsImpl wordsImpl = new WordsImpl();

		wordsImpl.setNew(words.isNew());
		wordsImpl.setPrimaryKey(words.getPrimaryKey());

		wordsImpl.setWord_id(words.getWord_id());
		wordsImpl.setUrl_id(words.getUrl_id());
		wordsImpl.setWord(words.getWord());

		return wordsImpl;
	}

	/**
	 * Returns the words with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the words
	 * @return the words
	 * @throws NoSuchWordsException if a words with the primary key could not be found
	 */
	@Override
	public Words findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWordsException {
		Words words = fetchByPrimaryKey(primaryKey);

		if (words == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWordsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return words;
	}

	/**
	 * Returns the words with the primary key or throws a {@link NoSuchWordsException} if it could not be found.
	 *
	 * @param word_id the primary key of the words
	 * @return the words
	 * @throws NoSuchWordsException if a words with the primary key could not be found
	 */
	@Override
	public Words findByPrimaryKey(long word_id) throws NoSuchWordsException {
		return findByPrimaryKey((Serializable)word_id);
	}

	/**
	 * Returns the words with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the words
	 * @return the words, or <code>null</code> if a words with the primary key could not be found
	 */
	@Override
	public Words fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WordsModelImpl.ENTITY_CACHE_ENABLED,
				WordsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Words words = (Words)serializable;

		if (words == null) {
			Session session = null;

			try {
				session = openSession();

				words = (Words)session.get(WordsImpl.class, primaryKey);

				if (words != null) {
					cacheResult(words);
				}
				else {
					entityCache.putResult(WordsModelImpl.ENTITY_CACHE_ENABLED,
						WordsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WordsModelImpl.ENTITY_CACHE_ENABLED,
					WordsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return words;
	}

	/**
	 * Returns the words with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param word_id the primary key of the words
	 * @return the words, or <code>null</code> if a words with the primary key could not be found
	 */
	@Override
	public Words fetchByPrimaryKey(long word_id) {
		return fetchByPrimaryKey((Serializable)word_id);
	}

	@Override
	public Map<Serializable, Words> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Words> map = new HashMap<Serializable, Words>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Words words = fetchByPrimaryKey(primaryKey);

			if (words != null) {
				map.put(primaryKey, words);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WordsModelImpl.ENTITY_CACHE_ENABLED,
					WordsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Words)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WORDS_WHERE_PKS_IN);

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

			for (Words words : (List<Words>)q.list()) {
				map.put(words.getPrimaryKeyObj(), words);

				cacheResult(words);

				uncachedPrimaryKeys.remove(words.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WordsModelImpl.ENTITY_CACHE_ENABLED,
					WordsImpl.class, primaryKey, nullModel);
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
	 * Returns all the wordses.
	 *
	 * @return the wordses
	 */
	@Override
	public List<Words> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the wordses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WordsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wordses
	 * @param end the upper bound of the range of wordses (not inclusive)
	 * @return the range of wordses
	 */
	@Override
	public List<Words> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the wordses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WordsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wordses
	 * @param end the upper bound of the range of wordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of wordses
	 */
	@Override
	public List<Words> findAll(int start, int end,
		OrderByComparator<Words> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the wordses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WordsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of wordses
	 * @param end the upper bound of the range of wordses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of wordses
	 */
	@Override
	public List<Words> findAll(int start, int end,
		OrderByComparator<Words> orderByComparator, boolean retrieveFromCache) {
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

		List<Words> list = null;

		if (retrieveFromCache) {
			list = (List<Words>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WORDS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORDS;

				if (pagination) {
					sql = sql.concat(WordsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Words>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Words>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the wordses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Words words : findAll()) {
			remove(words);
		}
	}

	/**
	 * Returns the number of wordses.
	 *
	 * @return the number of wordses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WORDS);

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
		return WordsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the words persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WordsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WORDS = "SELECT words FROM Words words";
	private static final String _SQL_SELECT_WORDS_WHERE_PKS_IN = "SELECT words FROM Words words WHERE word_id IN (";
	private static final String _SQL_COUNT_WORDS = "SELECT COUNT(words) FROM Words words";
	private static final String _ORDER_BY_ENTITY_ALIAS = "words.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Words exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(WordsPersistenceImpl.class);
}