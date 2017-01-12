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

import com.arthurchan35.wcse.exception.NoSuchWordException;
import com.arthurchan35.wcse.model.Word;
import com.arthurchan35.wcse.model.impl.WordImpl;
import com.arthurchan35.wcse.model.impl.WordModelImpl;
import com.arthurchan35.wcse.service.persistence.WordPersistence;

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
 * The persistence implementation for the word service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Arthur Chan
 * @see WordPersistence
 * @see com.arthurchan35.wcse.service.persistence.WordUtil
 * @generated
 */
@ProviderType
public class WordPersistenceImpl extends BasePersistenceImpl<Word>
	implements WordPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WordUtil} to access the word persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WordImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordModelImpl.FINDER_CACHE_ENABLED, WordImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordModelImpl.FINDER_CACHE_ENABLED, WordImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public WordPersistenceImpl() {
		setModelClass(Word.class);
	}

	/**
	 * Caches the word in the entity cache if it is enabled.
	 *
	 * @param word the word
	 */
	@Override
	public void cacheResult(Word word) {
		entityCache.putResult(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordImpl.class, word.getPrimaryKey(), word);

		word.resetOriginalValues();
	}

	/**
	 * Caches the words in the entity cache if it is enabled.
	 *
	 * @param words the words
	 */
	@Override
	public void cacheResult(List<Word> words) {
		for (Word word : words) {
			if (entityCache.getResult(WordModelImpl.ENTITY_CACHE_ENABLED,
						WordImpl.class, word.getPrimaryKey()) == null) {
				cacheResult(word);
			}
			else {
				word.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all words.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WordImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the word.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Word word) {
		entityCache.removeResult(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordImpl.class, word.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Word> words) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Word word : words) {
			entityCache.removeResult(WordModelImpl.ENTITY_CACHE_ENABLED,
				WordImpl.class, word.getPrimaryKey());
		}
	}

	/**
	 * Creates a new word with the primary key. Does not add the word to the database.
	 *
	 * @param wordId the primary key for the new word
	 * @return the new word
	 */
	@Override
	public Word create(long wordId) {
		Word word = new WordImpl();

		word.setNew(true);
		word.setPrimaryKey(wordId);

		return word;
	}

	/**
	 * Removes the word with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param wordId the primary key of the word
	 * @return the word that was removed
	 * @throws NoSuchWordException if a word with the primary key could not be found
	 */
	@Override
	public Word remove(long wordId) throws NoSuchWordException {
		return remove((Serializable)wordId);
	}

	/**
	 * Removes the word with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the word
	 * @return the word that was removed
	 * @throws NoSuchWordException if a word with the primary key could not be found
	 */
	@Override
	public Word remove(Serializable primaryKey) throws NoSuchWordException {
		Session session = null;

		try {
			session = openSession();

			Word word = (Word)session.get(WordImpl.class, primaryKey);

			if (word == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(word);
		}
		catch (NoSuchWordException nsee) {
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
	protected Word removeImpl(Word word) {
		word = toUnwrappedModel(word);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(word)) {
				word = (Word)session.get(WordImpl.class, word.getPrimaryKeyObj());
			}

			if (word != null) {
				session.delete(word);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (word != null) {
			clearCache(word);
		}

		return word;
	}

	@Override
	public Word updateImpl(Word word) {
		word = toUnwrappedModel(word);

		boolean isNew = word.isNew();

		Session session = null;

		try {
			session = openSession();

			if (word.isNew()) {
				session.save(word);

				word.setNew(false);
			}
			else {
				word = (Word)session.merge(word);
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

		entityCache.putResult(WordModelImpl.ENTITY_CACHE_ENABLED,
			WordImpl.class, word.getPrimaryKey(), word, false);

		word.resetOriginalValues();

		return word;
	}

	protected Word toUnwrappedModel(Word word) {
		if (word instanceof WordImpl) {
			return word;
		}

		WordImpl wordImpl = new WordImpl();

		wordImpl.setNew(word.isNew());
		wordImpl.setPrimaryKey(word.getPrimaryKey());

		wordImpl.setWordId(word.getWordId());
		wordImpl.setPageId(word.getPageId());
		wordImpl.setWord(word.getWord());

		return wordImpl;
	}

	/**
	 * Returns the word with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the word
	 * @return the word
	 * @throws NoSuchWordException if a word with the primary key could not be found
	 */
	@Override
	public Word findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWordException {
		Word word = fetchByPrimaryKey(primaryKey);

		if (word == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWordException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return word;
	}

	/**
	 * Returns the word with the primary key or throws a {@link NoSuchWordException} if it could not be found.
	 *
	 * @param wordId the primary key of the word
	 * @return the word
	 * @throws NoSuchWordException if a word with the primary key could not be found
	 */
	@Override
	public Word findByPrimaryKey(long wordId) throws NoSuchWordException {
		return findByPrimaryKey((Serializable)wordId);
	}

	/**
	 * Returns the word with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the word
	 * @return the word, or <code>null</code> if a word with the primary key could not be found
	 */
	@Override
	public Word fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(WordModelImpl.ENTITY_CACHE_ENABLED,
				WordImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Word word = (Word)serializable;

		if (word == null) {
			Session session = null;

			try {
				session = openSession();

				word = (Word)session.get(WordImpl.class, primaryKey);

				if (word != null) {
					cacheResult(word);
				}
				else {
					entityCache.putResult(WordModelImpl.ENTITY_CACHE_ENABLED,
						WordImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(WordModelImpl.ENTITY_CACHE_ENABLED,
					WordImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return word;
	}

	/**
	 * Returns the word with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param wordId the primary key of the word
	 * @return the word, or <code>null</code> if a word with the primary key could not be found
	 */
	@Override
	public Word fetchByPrimaryKey(long wordId) {
		return fetchByPrimaryKey((Serializable)wordId);
	}

	@Override
	public Map<Serializable, Word> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Word> map = new HashMap<Serializable, Word>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Word word = fetchByPrimaryKey(primaryKey);

			if (word != null) {
				map.put(primaryKey, word);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(WordModelImpl.ENTITY_CACHE_ENABLED,
					WordImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Word)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_WORD_WHERE_PKS_IN);

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

			for (Word word : (List<Word>)q.list()) {
				map.put(word.getPrimaryKeyObj(), word);

				cacheResult(word);

				uncachedPrimaryKeys.remove(word.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(WordModelImpl.ENTITY_CACHE_ENABLED,
					WordImpl.class, primaryKey, nullModel);
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
	 * Returns all the words.
	 *
	 * @return the words
	 */
	@Override
	public List<Word> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the words.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of words
	 * @param end the upper bound of the range of words (not inclusive)
	 * @return the range of words
	 */
	@Override
	public List<Word> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the words.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of words
	 * @param end the upper bound of the range of words (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of words
	 */
	@Override
	public List<Word> findAll(int start, int end,
		OrderByComparator<Word> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the words.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link WordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of words
	 * @param end the upper bound of the range of words (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of words
	 */
	@Override
	public List<Word> findAll(int start, int end,
		OrderByComparator<Word> orderByComparator, boolean retrieveFromCache) {
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

		List<Word> list = null;

		if (retrieveFromCache) {
			list = (List<Word>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_WORD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORD;

				if (pagination) {
					sql = sql.concat(WordModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Word>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Word>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the words from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Word word : findAll()) {
			remove(word);
		}
	}

	/**
	 * Returns the number of words.
	 *
	 * @return the number of words
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_WORD);

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
		return WordModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the word persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(WordImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_WORD = "SELECT word FROM Word word";
	private static final String _SQL_SELECT_WORD_WHERE_PKS_IN = "SELECT word FROM Word word WHERE wordId IN (";
	private static final String _SQL_COUNT_WORD = "SELECT COUNT(word) FROM Word word";
	private static final String _ORDER_BY_ENTITY_ALIAS = "word.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Word exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(WordPersistenceImpl.class);
}