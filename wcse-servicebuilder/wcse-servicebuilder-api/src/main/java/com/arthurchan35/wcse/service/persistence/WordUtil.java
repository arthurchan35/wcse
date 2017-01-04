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

package com.arthurchan35.wcse.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.arthurchan35.wcse.model.Word;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the word service. This utility wraps {@link com.arthurchan35.wcse.service.persistence.impl.WordPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Arthur Chan
 * @see WordPersistence
 * @see com.arthurchan35.wcse.service.persistence.impl.WordPersistenceImpl
 * @generated
 */
@ProviderType
public class WordUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Word word) {
		getPersistence().clearCache(word);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Word> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Word> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Word> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Word> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Word update(Word word) {
		return getPersistence().update(word);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Word update(Word word, ServiceContext serviceContext) {
		return getPersistence().update(word, serviceContext);
	}

	/**
	* Caches the word in the entity cache if it is enabled.
	*
	* @param word the word
	*/
	public static void cacheResult(Word word) {
		getPersistence().cacheResult(word);
	}

	/**
	* Caches the words in the entity cache if it is enabled.
	*
	* @param words the words
	*/
	public static void cacheResult(List<Word> words) {
		getPersistence().cacheResult(words);
	}

	/**
	* Creates a new word with the primary key. Does not add the word to the database.
	*
	* @param word_id the primary key for the new word
	* @return the new word
	*/
	public static Word create(long word_id) {
		return getPersistence().create(word_id);
	}

	/**
	* Removes the word with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param word_id the primary key of the word
	* @return the word that was removed
	* @throws NoSuchWordException if a word with the primary key could not be found
	*/
	public static Word remove(long word_id)
		throws com.arthurchan35.wcse.exception.NoSuchWordException {
		return getPersistence().remove(word_id);
	}

	public static Word updateImpl(Word word) {
		return getPersistence().updateImpl(word);
	}

	/**
	* Returns the word with the primary key or throws a {@link NoSuchWordException} if it could not be found.
	*
	* @param word_id the primary key of the word
	* @return the word
	* @throws NoSuchWordException if a word with the primary key could not be found
	*/
	public static Word findByPrimaryKey(long word_id)
		throws com.arthurchan35.wcse.exception.NoSuchWordException {
		return getPersistence().findByPrimaryKey(word_id);
	}

	/**
	* Returns the word with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param word_id the primary key of the word
	* @return the word, or <code>null</code> if a word with the primary key could not be found
	*/
	public static Word fetchByPrimaryKey(long word_id) {
		return getPersistence().fetchByPrimaryKey(word_id);
	}

	public static java.util.Map<java.io.Serializable, Word> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the words.
	*
	* @return the words
	*/
	public static List<Word> findAll() {
		return getPersistence().findAll();
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
	public static List<Word> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Word> findAll(int start, int end,
		OrderByComparator<Word> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Word> findAll(int start, int end,
		OrderByComparator<Word> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the words from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of words.
	*
	* @return the number of words
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WordPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<WordPersistence, WordPersistence> _serviceTracker =
		ServiceTrackerFactory.open(WordPersistence.class);
}