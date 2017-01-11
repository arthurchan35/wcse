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

import com.arthurchan35.wcse.model.Page;
import com.arthurchan35.wcse.service.persistence.PagePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Arthur Chan
 * @generated
 */
public class PageFinderBaseImpl extends BasePersistenceImpl<Page> {
	/**
	 * Returns the page persistence.
	 *
	 * @return the page persistence
	 */
	public PagePersistence getPagePersistence() {
		return pagePersistence;
	}

	/**
	 * Sets the page persistence.
	 *
	 * @param pagePersistence the page persistence
	 */
	public void setPagePersistence(PagePersistence pagePersistence) {
		this.pagePersistence = pagePersistence;
	}

	@BeanReference(type = PagePersistence.class)
	protected PagePersistence pagePersistence;
}