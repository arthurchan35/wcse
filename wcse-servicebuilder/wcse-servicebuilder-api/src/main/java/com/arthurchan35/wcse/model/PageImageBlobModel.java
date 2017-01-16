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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the image column in Page.
 *
 * @author Arthur Chan
 * @see Page
 * @generated
 */
@ProviderType
public class PageImageBlobModel {
	public PageImageBlobModel() {
	}

	public PageImageBlobModel(long pageId) {
		_pageId = pageId;
	}

	public PageImageBlobModel(long pageId, Blob imageBlob) {
		_pageId = pageId;
		_imageBlob = imageBlob;
	}

	public long getPageId() {
		return _pageId;
	}

	public void setPageId(long pageId) {
		_pageId = pageId;
	}

	public Blob getImageBlob() {
		return _imageBlob;
	}

	public void setImageBlob(Blob imageBlob) {
		_imageBlob = imageBlob;
	}

	private long _pageId;
	private Blob _imageBlob;
}