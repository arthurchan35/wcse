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

import com.arthurchan35.wcse.exception.NoSuchWordException;
import com.arthurchan35.wcse.model.Word;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the word service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Arthur Chan
 * @see com.arthurchan35.wcse.service.persistence.impl.WordPersistenceImpl
 * @see WordUtil
 * @generated
 */
@ProviderType
public interface WordPersistence extends BasePersistence<Word> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WordUtil} to access the word persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the word in the entity cache if it is enabled.
	*
	* @param word the word
	*/
	public void cacheResult(Word word);

	/**
	* Caches the words in the entity cache if it is enabled.
	*
	* @param words the words
	*/
	public void cacheResult(java.util.List<Word> words);

	/**
	* Creates a new word with the primary key. Does not add the word to the database.
	*
	* @param word_id the primary key for the new word
	* @return the new word
	*/
	public Word create(long word_id);

	/**
	* Removes the word with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param word_id the primary key of the word
	* @return the word that was removed
	* @throws NoSuchWordException if a word with the primary key could not be found
	*/
	public Word remove(long word_id) throws NoSuchWordException;

	public Word updateImpl(Word word);

	/**
	* Returns the word with the primary key or throws a {@link NoSuchWordException} if it could not be found.
	*
	* @param word_id the primary key of the word
	* @return the word
	* @throws NoSuchWordException if a word with the primary key could not be found
	*/
	public Word findByPrimaryKey(long word_id) throws NoSuchWordException;

	/**
	* Returns the word with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param word_id the primary key of the word
	* @return the word, or <code>null</code> if a word with the primary key could not be found
	*/
	public Word fetchByPrimaryKey(long word_id);

	@Override
	public java.util.Map<java.io.Serializable, Word> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the words.
	*
	* @return the words
	*/
	public java.util.List<Word> findAll();

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
	public java.util.List<Word> findAll(int start, int end);

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
	public java.util.List<Word> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Word> orderByComparator);

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
	public java.util.List<Word> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Word> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the words from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of words.
	*
	* @return the number of words
	*/
	public int countAll();
}