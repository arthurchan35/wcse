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

package com.arthurchan35.wcse.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.arthurchan35.wcse.model.Pages;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Pages in entity cache.
 *
 * @author Arthur Chan
 * @see Pages
 * @generated
 */
@ProviderType
public class PagesCacheModel implements CacheModel<Pages>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PagesCacheModel)) {
			return false;
		}

		PagesCacheModel pagesCacheModel = (PagesCacheModel)obj;

		if (url_id == pagesCacheModel.url_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, url_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{url_id=");
		sb.append(url_id);
		sb.append(", url=");
		sb.append(url);
		sb.append(", description=");
		sb.append(description);
		sb.append(", image=");
		sb.append(image);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Pages toEntityModel() {
		PagesImpl pagesImpl = new PagesImpl();

		pagesImpl.setUrl_id(url_id);

		if (url == null) {
			pagesImpl.setUrl(StringPool.BLANK);
		}
		else {
			pagesImpl.setUrl(url);
		}

		if (description == null) {
			pagesImpl.setDescription(StringPool.BLANK);
		}
		else {
			pagesImpl.setDescription(description);
		}

		if (image == null) {
			pagesImpl.setImage(StringPool.BLANK);
		}
		else {
			pagesImpl.setImage(image);
		}

		pagesImpl.resetOriginalValues();

		return pagesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		url_id = objectInput.readLong();
		url = objectInput.readUTF();
		description = objectInput.readUTF();
		image = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(url_id);

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (image == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(image);
		}
	}

	public long url_id;
	public String url;
	public String description;
	public String image;
}