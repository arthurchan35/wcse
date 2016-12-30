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

package com.arthurchan35.wcse.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WordsLocalService}.
 *
 * @author Arthur Chan
 * @see WordsLocalService
 * @generated
 */
@ProviderType
public class WordsLocalServiceWrapper implements WordsLocalService,
	ServiceWrapper<WordsLocalService> {
	public WordsLocalServiceWrapper(WordsLocalService wordsLocalService) {
		_wordsLocalService = wordsLocalService;
	}

	/**
	* Adds the words to the database. Also notifies the appropriate model listeners.
	*
	* @param words the words
	* @return the words that was added
	*/
	@Override
	public com.arthurchan35.wcse.model.Words addWords(
		com.arthurchan35.wcse.model.Words words) {
		return _wordsLocalService.addWords(words);
	}

	/**
	* Creates a new words with the primary key. Does not add the words to the database.
	*
	* @param word_id the primary key for the new words
	* @return the new words
	*/
	@Override
	public com.arthurchan35.wcse.model.Words createWords(long word_id) {
		return _wordsLocalService.createWords(word_id);
	}

	/**
	* Deletes the words from the database. Also notifies the appropriate model listeners.
	*
	* @param words the words
	* @return the words that was removed
	*/
	@Override
	public com.arthurchan35.wcse.model.Words deleteWords(
		com.arthurchan35.wcse.model.Words words) {
		return _wordsLocalService.deleteWords(words);
	}

	/**
	* Deletes the words with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param word_id the primary key of the words
	* @return the words that was removed
	* @throws PortalException if a words with the primary key could not be found
	*/
	@Override
	public com.arthurchan35.wcse.model.Words deleteWords(long word_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wordsLocalService.deleteWords(word_id);
	}

	@Override
	public com.arthurchan35.wcse.model.Words fetchWords(long word_id) {
		return _wordsLocalService.fetchWords(word_id);
	}

	/**
	* Returns the words with the primary key.
	*
	* @param word_id the primary key of the words
	* @return the words
	* @throws PortalException if a words with the primary key could not be found
	*/
	@Override
	public com.arthurchan35.wcse.model.Words getWords(long word_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wordsLocalService.getWords(word_id);
	}

	/**
	* Updates the words in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param words the words
	* @return the words that was updated
	*/
	@Override
	public com.arthurchan35.wcse.model.Words updateWords(
		com.arthurchan35.wcse.model.Words words) {
		return _wordsLocalService.updateWords(words);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _wordsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wordsLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _wordsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wordsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wordsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of wordses.
	*
	* @return the number of wordses
	*/
	@Override
	public int getWordsesCount() {
		return _wordsLocalService.getWordsesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wordsLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _wordsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arthurchan35.wcse.model.impl.WordsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _wordsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arthurchan35.wcse.model.impl.WordsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _wordsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the wordses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arthurchan35.wcse.model.impl.WordsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of wordses
	* @param end the upper bound of the range of wordses (not inclusive)
	* @return the range of wordses
	*/
	@Override
	public java.util.List<com.arthurchan35.wcse.model.Words> getWordses(
		int start, int end) {
		return _wordsLocalService.getWordses(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _wordsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _wordsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public WordsLocalService getWrappedService() {
		return _wordsLocalService;
	}

	@Override
	public void setWrappedService(WordsLocalService wordsLocalService) {
		_wordsLocalService = wordsLocalService;
	}

	private WordsLocalService _wordsLocalService;
}