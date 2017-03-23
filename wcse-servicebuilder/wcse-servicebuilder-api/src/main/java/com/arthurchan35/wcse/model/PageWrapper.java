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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Page}.
 * </p>
 *
 * @author Arthur Chan
 * @see Page
 * @generated
 */
@ProviderType
public class PageWrapper implements Page, ModelWrapper<Page> {
	public PageWrapper(Page page) {
		_page = page;
	}

	@Override
	public Class<?> getModelClass() {
		return Page.class;
	}

	@Override
	public String getModelClassName() {
		return Page.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pageId", getPageId());
		attributes.put("url", getUrl());
		attributes.put("description", getDescription());
		attributes.put("image", getImage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long pageId = (Long)attributes.get("pageId");

		if (pageId != null) {
			setPageId(pageId);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String image = (String)attributes.get("image");

		if (image != null) {
			setImage(image);
		}
	}

	@Override
	public Page toEscapedModel() {
		return new PageWrapper(_page.toEscapedModel());
	}

	@Override
	public Page toUnescapedModel() {
		return new PageWrapper(_page.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _page.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _page.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _page.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _page.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Page> toCacheModel() {
		return _page.toCacheModel();
	}

	@Override
	public int compareTo(Page page) {
		return _page.compareTo(page);
	}

	@Override
	public int hashCode() {
		return _page.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _page.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PageWrapper((Page)_page.clone());
	}

	/**
	* Returns the description of this page.
	*
	* @return the description of this page
	*/
	@Override
	public java.lang.String getDescription() {
		return _page.getDescription();
	}

	/**
	* Returns the image of this page.
	*
	* @return the image of this page
	*/
	@Override
	public java.lang.String getImage() {
		return _page.getImage();
	}

	/**
	* Returns the url of this page.
	*
	* @return the url of this page
	*/
	@Override
	public java.lang.String getUrl() {
		return _page.getUrl();
	}

	@Override
	public java.lang.String toString() {
		return _page.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _page.toXmlString();
	}

	/**
	* Returns the page ID of this page.
	*
	* @return the page ID of this page
	*/
	@Override
	public long getPageId() {
		return _page.getPageId();
	}

	/**
	* Returns the primary key of this page.
	*
	* @return the primary key of this page
	*/
	@Override
	public long getPrimaryKey() {
		return _page.getPrimaryKey();
	}

	@Override
	public void persist() {
		_page.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_page.setCachedModel(cachedModel);
	}

	/**
	* Sets the description of this page.
	*
	* @param description the description of this page
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_page.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_page.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_page.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_page.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the image of this page.
	*
	* @param image the image of this page
	*/
	@Override
	public void setImage(java.lang.String image) {
		_page.setImage(image);
	}

	@Override
	public void setNew(boolean n) {
		_page.setNew(n);
	}

	/**
	* Sets the page ID of this page.
	*
	* @param pageId the page ID of this page
	*/
	@Override
	public void setPageId(long pageId) {
		_page.setPageId(pageId);
	}

	/**
	* Sets the primary key of this page.
	*
	* @param primaryKey the primary key of this page
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_page.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_page.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the url of this page.
	*
	* @param url the url of this page
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_page.setUrl(url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PageWrapper)) {
			return false;
		}

		PageWrapper pageWrapper = (PageWrapper)obj;

		if (Objects.equals(_page, pageWrapper._page)) {
			return true;
		}

		return false;
	}

	@Override
	public Page getWrappedModel() {
		return _page;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _page.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _page.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_page.resetOriginalValues();
	}

	private final Page _page;
}