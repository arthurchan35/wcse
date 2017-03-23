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

import com.arthurchan35.wcse.model.Page;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Page in entity cache.
 *
 * @author Arthur Chan
 * @see Page
 * @generated
 */
@ProviderType
public class PageCacheModel implements CacheModel<Page>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PageCacheModel)) {
			return false;
		}

		PageCacheModel pageCacheModel = (PageCacheModel)obj;

		if (pageId == pageCacheModel.pageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, pageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{pageId=");
		sb.append(pageId);
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
	public Page toEntityModel() {
		PageImpl pageImpl = new PageImpl();

		pageImpl.setPageId(pageId);

		if (url == null) {
			pageImpl.setUrl(StringPool.BLANK);
		}
		else {
			pageImpl.setUrl(url);
		}

		if (description == null) {
			pageImpl.setDescription(StringPool.BLANK);
		}
		else {
			pageImpl.setDescription(description);
		}

		if (image == null) {
			pageImpl.setImage(StringPool.BLANK);
		}
		else {
			pageImpl.setImage(image);
		}

		pageImpl.resetOriginalValues();

		return pageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		pageId = objectInput.readLong();
		url = objectInput.readUTF();
		description = objectInput.readUTF();
		image = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(pageId);

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

	public long pageId;
	public String url;
	public String description;
	public String image;
}