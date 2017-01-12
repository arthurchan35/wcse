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
 * Provides a wrapper for {@link WordLocalService}.
 *
 * @author Arthur Chan
 * @see WordLocalService
 * @generated
 */
@ProviderType
public class WordLocalServiceWrapper implements WordLocalService,
	ServiceWrapper<WordLocalService> {
	public WordLocalServiceWrapper(WordLocalService wordLocalService) {
		_wordLocalService = wordLocalService;
	}

	/**
	* Adds the word to the database. Also notifies the appropriate model listeners.
	*
	* @param word the word
	* @return the word that was added
	*/
	@Override
	public com.arthurchan35.wcse.model.Word addWord(
		com.arthurchan35.wcse.model.Word word) {
		return _wordLocalService.addWord(word);
	}

	/**
	* Creates a new word with the primary key. Does not add the word to the database.
	*
	* @param wordId the primary key for the new word
	* @return the new word
	*/
	@Override
	public com.arthurchan35.wcse.model.Word createWord(long wordId) {
		return _wordLocalService.createWord(wordId);
	}

	/**
	* Deletes the word from the database. Also notifies the appropriate model listeners.
	*
	* @param word the word
	* @return the word that was removed
	*/
	@Override
	public com.arthurchan35.wcse.model.Word deleteWord(
		com.arthurchan35.wcse.model.Word word) {
		return _wordLocalService.deleteWord(word);
	}

	/**
	* Deletes the word with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param wordId the primary key of the word
	* @return the word that was removed
	* @throws PortalException if a word with the primary key could not be found
	*/
	@Override
	public com.arthurchan35.wcse.model.Word deleteWord(long wordId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wordLocalService.deleteWord(wordId);
	}

	@Override
	public com.arthurchan35.wcse.model.Word fetchWord(long wordId) {
		return _wordLocalService.fetchWord(wordId);
	}

	/**
	* Returns the word with the primary key.
	*
	* @param wordId the primary key of the word
	* @return the word
	* @throws PortalException if a word with the primary key could not be found
	*/
	@Override
	public com.arthurchan35.wcse.model.Word getWord(long wordId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wordLocalService.getWord(wordId);
	}

	/**
	* Updates the word in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param word the word
	* @return the word that was updated
	*/
	@Override
	public com.arthurchan35.wcse.model.Word updateWord(
		com.arthurchan35.wcse.model.Word word) {
		return _wordLocalService.updateWord(word);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _wordLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _wordLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _wordLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wordLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _wordLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of words.
	*
	* @return the number of words
	*/
	@Override
	public int getWordsCount() {
		return _wordLocalService.getWordsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _wordLocalService.getOSGiServiceIdentifier();
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
		return _wordLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arthurchan35.wcse.model.impl.WordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wordLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arthurchan35.wcse.model.impl.WordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _wordLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<java.lang.Long> findUrlIdsByWords(
		java.lang.String words, int start, int end) {
		return _wordLocalService.findUrlIdsByWords(words, start, end);
	}

	/**
	* Returns a range of all the words.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arthurchan35.wcse.model.impl.WordModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of words
	* @param end the upper bound of the range of words (not inclusive)
	* @return the range of words
	*/
	@Override
	public java.util.List<com.arthurchan35.wcse.model.Word> getWords(
		int start, int end) {
		return _wordLocalService.getWords(start, end);
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
		return _wordLocalService.dynamicQueryCount(dynamicQuery);
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
		return _wordLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public WordLocalService getWrappedService() {
		return _wordLocalService;
	}

	@Override
	public void setWrappedService(WordLocalService wordLocalService) {
		_wordLocalService = wordLocalService;
	}

	private WordLocalService _wordLocalService;
}