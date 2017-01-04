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

package com.arthurchan35.wcse.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Page service. Represents a row in the &quot;UrlStorage_Page&quot; database table, with each column mapped to a property of this class.
 *
 * @author Arthur Chan
 * @see PageModel
 * @see com.arthurchan35.wcse.model.impl.PageImpl
 * @see com.arthurchan35.wcse.model.impl.PageModelImpl
 * @generated
 */
@ImplementationClassName("com.arthurchan35.wcse.model.impl.PageImpl")
@ProviderType
public interface Page extends PageModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.arthurchan35.wcse.model.impl.PageImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Page, Long> URL_ID_ACCESSOR = new Accessor<Page, Long>() {
			@Override
			public Long get(Page page) {
				return page.getUrl_id();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Page> getTypeClass() {
				return Page.class;
			}
		};
}