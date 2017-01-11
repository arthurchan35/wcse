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
 * Provides a wrapper for {@link PageLocalService}.
 *
 * @author Arthur Chan
 * @see PageLocalService
 * @generated
 */
@ProviderType
public class PageLocalServiceWrapper implements PageLocalService,
	ServiceWrapper<PageLocalService> {
	public PageLocalServiceWrapper(PageLocalService pageLocalService) {
		_pageLocalService = pageLocalService;
	}

	/**
	* Adds the page to the database. Also notifies the appropriate model listeners.
	*
	* @param page the page
	* @return the page that was added
	*/
	@Override
	public com.arthurchan35.wcse.model.Page addPage(
		com.arthurchan35.wcse.model.Page page) {
		return _pageLocalService.addPage(page);
	}

	@Override
	public com.arthurchan35.wcse.model.Page addPage(java.lang.String url,
		java.lang.String description, java.lang.String image,
		java.util.List<java.lang.String> words) {
		return _pageLocalService.addPage(url, description, image, words);
	}

	/**
	* Creates a new page with the primary key. Does not add the page to the database.
	*
	* @param url_id the primary key for the new page
	* @return the new page
	*/
	@Override
	public com.arthurchan35.wcse.model.Page createPage(long url_id) {
		return _pageLocalService.createPage(url_id);
	}

	/**
	* Deletes the page from the database. Also notifies the appropriate model listeners.
	*
	* @param page the page
	* @return the page that was removed
	*/
	@Override
	public com.arthurchan35.wcse.model.Page deletePage(
		com.arthurchan35.wcse.model.Page page) {
		return _pageLocalService.deletePage(page);
	}

	/**
	* Deletes the page with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param url_id the primary key of the page
	* @return the page that was removed
	* @throws PortalException if a page with the primary key could not be found
	*/
	@Override
	public com.arthurchan35.wcse.model.Page deletePage(long url_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pageLocalService.deletePage(url_id);
	}

	@Override
	public com.arthurchan35.wcse.model.Page fetchPage(long url_id) {
		return _pageLocalService.fetchPage(url_id);
	}

	/**
	* Returns the page with the primary key.
	*
	* @param url_id the primary key of the page
	* @return the page
	* @throws PortalException if a page with the primary key could not be found
	*/
	@Override
	public com.arthurchan35.wcse.model.Page getPage(long url_id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pageLocalService.getPage(url_id);
	}

	/**
	* Updates the page in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param page the page
	* @return the page that was updated
	*/
	@Override
	public com.arthurchan35.wcse.model.Page updatePage(
		com.arthurchan35.wcse.model.Page page) {
		return _pageLocalService.updatePage(page);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _pageLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _pageLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _pageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pageLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _pageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of pages.
	*
	* @return the number of pages
	*/
	@Override
	public int getPagesCount() {
		return _pageLocalService.getPagesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _pageLocalService.getOSGiServiceIdentifier();
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
		return _pageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arthurchan35.wcse.model.impl.PageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _pageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arthurchan35.wcse.model.impl.PageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _pageLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.arthurchan35.wcse.model.Page> findPagesByUrlIds(
		java.lang.String urls, int start, int end) {
		return _pageLocalService.findPagesByUrlIds(urls, start, end);
	}

	/**
	* Returns a range of all the pages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arthurchan35.wcse.model.impl.PageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of pages
	* @param end the upper bound of the range of pages (not inclusive)
	* @return the range of pages
	*/
	@Override
	public java.util.List<com.arthurchan35.wcse.model.Page> getPages(
		int start, int end) {
		return _pageLocalService.getPages(start, end);
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
		return _pageLocalService.dynamicQueryCount(dynamicQuery);
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
		return _pageLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public PageLocalService getWrappedService() {
		return _pageLocalService;
	}

	@Override
	public void setWrappedService(PageLocalService pageLocalService) {
		_pageLocalService = pageLocalService;
	}

	private PageLocalService _pageLocalService;
}