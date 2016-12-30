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

import com.arthurchan35.wcse.exception.NoSuchPagesException;
import com.arthurchan35.wcse.model.Pages;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the pages service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Arthur Chan
 * @see com.arthurchan35.wcse.service.persistence.impl.PagesPersistenceImpl
 * @see PagesUtil
 * @generated
 */
@ProviderType
public interface PagesPersistence extends BasePersistence<Pages> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PagesUtil} to access the pages persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the pages in the entity cache if it is enabled.
	*
	* @param pages the pages
	*/
	public void cacheResult(Pages pages);

	/**
	* Caches the pageses in the entity cache if it is enabled.
	*
	* @param pageses the pageses
	*/
	public void cacheResult(java.util.List<Pages> pageses);

	/**
	* Creates a new pages with the primary key. Does not add the pages to the database.
	*
	* @param url_id the primary key for the new pages
	* @return the new pages
	*/
	public Pages create(long url_id);

	/**
	* Removes the pages with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param url_id the primary key of the pages
	* @return the pages that was removed
	* @throws NoSuchPagesException if a pages with the primary key could not be found
	*/
	public Pages remove(long url_id) throws NoSuchPagesException;

	public Pages updateImpl(Pages pages);

	/**
	* Returns the pages with the primary key or throws a {@link NoSuchPagesException} if it could not be found.
	*
	* @param url_id the primary key of the pages
	* @return the pages
	* @throws NoSuchPagesException if a pages with the primary key could not be found
	*/
	public Pages findByPrimaryKey(long url_id) throws NoSuchPagesException;

	/**
	* Returns the pages with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param url_id the primary key of the pages
	* @return the pages, or <code>null</code> if a pages with the primary key could not be found
	*/
	public Pages fetchByPrimaryKey(long url_id);

	@Override
	public java.util.Map<java.io.Serializable, Pages> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the pageses.
	*
	* @return the pageses
	*/
	public java.util.List<Pages> findAll();

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
	public java.util.List<Pages> findAll(int start, int end);

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
	public java.util.List<Pages> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pages> orderByComparator);

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
	public java.util.List<Pages> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Pages> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the pageses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of pageses.
	*
	* @return the number of pageses
	*/
	public int countAll();
}