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

import com.arthurchan35.wcse.exception.NoSuchWordsException;
import com.arthurchan35.wcse.model.Words;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the words service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Arthur Chan
 * @see com.arthurchan35.wcse.service.persistence.impl.WordsPersistenceImpl
 * @see WordsUtil
 * @generated
 */
@ProviderType
public interface WordsPersistence extends BasePersistence<Words> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WordsUtil} to access the words persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the words in the entity cache if it is enabled.
	*
	* @param words the words
	*/
	public void cacheResult(Words words);

	/**
	* Caches the wordses in the entity cache if it is enabled.
	*
	* @param wordses the wordses
	*/
	public void cacheResult(java.util.List<Words> wordses);

	/**
	* Creates a new words with the primary key. Does not add the words to the database.
	*
	* @param word_id the primary key for the new words
	* @return the new words
	*/
	public Words create(long word_id);

	/**
	* Removes the words with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param word_id the primary key of the words
	* @return the words that was removed
	* @throws NoSuchWordsException if a words with the primary key could not be found
	*/
	public Words remove(long word_id) throws NoSuchWordsException;

	public Words updateImpl(Words words);

	/**
	* Returns the words with the primary key or throws a {@link NoSuchWordsException} if it could not be found.
	*
	* @param word_id the primary key of the words
	* @return the words
	* @throws NoSuchWordsException if a words with the primary key could not be found
	*/
	public Words findByPrimaryKey(long word_id) throws NoSuchWordsException;

	/**
	* Returns the words with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param word_id the primary key of the words
	* @return the words, or <code>null</code> if a words with the primary key could not be found
	*/
	public Words fetchByPrimaryKey(long word_id);

	@Override
	public java.util.Map<java.io.Serializable, Words> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the wordses.
	*
	* @return the wordses
	*/
	public java.util.List<Words> findAll();

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
	public java.util.List<Words> findAll(int start, int end);

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
	public java.util.List<Words> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Words> orderByComparator);

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
	public java.util.List<Words> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Words> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the wordses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of wordses.
	*
	* @return the number of wordses
	*/
	public int countAll();
}