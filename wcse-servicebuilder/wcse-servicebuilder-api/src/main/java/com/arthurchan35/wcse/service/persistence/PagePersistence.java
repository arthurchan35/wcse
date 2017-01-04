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

import com.arthurchan35.wcse.exception.NoSuchPageException;
import com.arthurchan35.wcse.model.Page;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the page service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Arthur Chan
 * @see com.arthurchan35.wcse.service.persistence.impl.PagePersistenceImpl
 * @see PageUtil
 * @generated
 */
@ProviderType
public interface PagePersistence extends BasePersistence<Page> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PageUtil} to access the page persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the page where url = &#63; or throws a {@link NoSuchPageException} if it could not be found.
	*
	* @param url the url
	* @return the matching page
	* @throws NoSuchPageException if a matching page could not be found
	*/
	public Page findByURL(java.lang.String url) throws NoSuchPageException;

	/**
	* Returns the page where url = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param url the url
	* @return the matching page, or <code>null</code> if a matching page could not be found
	*/
	public Page fetchByURL(java.lang.String url);

	/**
	* Returns the page where url = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param url the url
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching page, or <code>null</code> if a matching page could not be found
	*/
	public Page fetchByURL(java.lang.String url, boolean retrieveFromCache);

	/**
	* Removes the page where url = &#63; from the database.
	*
	* @param url the url
	* @return the page that was removed
	*/
	public Page removeByURL(java.lang.String url) throws NoSuchPageException;

	/**
	* Returns the number of pages where url = &#63;.
	*
	* @param url the url
	* @return the number of matching pages
	*/
	public int countByURL(java.lang.String url);

	/**
	* Caches the page in the entity cache if it is enabled.
	*
	* @param page the page
	*/
	public void cacheResult(Page page);

	/**
	* Caches the pages in the entity cache if it is enabled.
	*
	* @param pages the pages
	*/
	public void cacheResult(java.util.List<Page> pages);

	/**
	* Creates a new page with the primary key. Does not add the page to the database.
	*
	* @param url_id the primary key for the new page
	* @return the new page
	*/
	public Page create(long url_id);

	/**
	* Removes the page with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param url_id the primary key of the page
	* @return the page that was removed
	* @throws NoSuchPageException if a page with the primary key could not be found
	*/
	public Page remove(long url_id) throws NoSuchPageException;

	public Page updateImpl(Page page);

	/**
	* Returns the page with the primary key or throws a {@link NoSuchPageException} if it could not be found.
	*
	* @param url_id the primary key of the page
	* @return the page
	* @throws NoSuchPageException if a page with the primary key could not be found
	*/
	public Page findByPrimaryKey(long url_id) throws NoSuchPageException;

	/**
	* Returns the page with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param url_id the primary key of the page
	* @return the page, or <code>null</code> if a page with the primary key could not be found
	*/
	public Page fetchByPrimaryKey(long url_id);

	@Override
	public java.util.Map<java.io.Serializable, Page> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the pages.
	*
	* @return the pages
	*/
	public java.util.List<Page> findAll();

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
	public java.util.List<Page> findAll(int start, int end);

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
	public java.util.List<Page> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Page> orderByComparator);

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
	public java.util.List<Page> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Page> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the pages from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of pages.
	*
	* @return the number of pages
	*/
	public int countAll();
}