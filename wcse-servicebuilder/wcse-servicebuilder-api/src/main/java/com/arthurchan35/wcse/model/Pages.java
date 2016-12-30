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
 * The extended model interface for the Pages service. Represents a row in the &quot;UrlStorage_Pages&quot; database table, with each column mapped to a property of this class.
 *
 * @author Arthur Chan
 * @see PagesModel
 * @see com.arthurchan35.wcse.model.impl.PagesImpl
 * @see com.arthurchan35.wcse.model.impl.PagesModelImpl
 * @generated
 */
@ImplementationClassName("com.arthurchan35.wcse.model.impl.PagesImpl")
@ProviderType
public interface Pages extends PagesModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.arthurchan35.wcse.model.impl.PagesImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Pages, Long> URL_ID_ACCESSOR = new Accessor<Pages, Long>() {
			@Override
			public Long get(Pages pages) {
				return pages.getUrl_id();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Pages> getTypeClass() {
				return Pages.class;
			}
		};
}