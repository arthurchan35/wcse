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
 * This class is a wrapper for {@link Pages}.
 * </p>
 *
 * @author Arthur Chan
 * @see Pages
 * @generated
 */
@ProviderType
public class PagesWrapper implements Pages, ModelWrapper<Pages> {
	public PagesWrapper(Pages pages) {
		_pages = pages;
	}

	@Override
	public Class<?> getModelClass() {
		return Pages.class;
	}

	@Override
	public String getModelClassName() {
		return Pages.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("url_id", getUrl_id());
		attributes.put("url", getUrl());
		attributes.put("description", getDescription());
		attributes.put("image", getImage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long url_id = (Long)attributes.get("url_id");

		if (url_id != null) {
			setUrl_id(url_id);
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
	public Pages toEscapedModel() {
		return new PagesWrapper(_pages.toEscapedModel());
	}

	@Override
	public Pages toUnescapedModel() {
		return new PagesWrapper(_pages.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _pages.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _pages.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _pages.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _pages.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Pages> toCacheModel() {
		return _pages.toCacheModel();
	}

	@Override
	public int compareTo(Pages pages) {
		return _pages.compareTo(pages);
	}

	@Override
	public int hashCode() {
		return _pages.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pages.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PagesWrapper((Pages)_pages.clone());
	}

	/**
	* Returns the description of this pages.
	*
	* @return the description of this pages
	*/
	@Override
	public java.lang.String getDescription() {
		return _pages.getDescription();
	}

	/**
	* Returns the image of this pages.
	*
	* @return the image of this pages
	*/
	@Override
	public java.lang.String getImage() {
		return _pages.getImage();
	}

	/**
	* Returns the url of this pages.
	*
	* @return the url of this pages
	*/
	@Override
	public java.lang.String getUrl() {
		return _pages.getUrl();
	}

	@Override
	public java.lang.String toString() {
		return _pages.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _pages.toXmlString();
	}

	/**
	* Returns the primary key of this pages.
	*
	* @return the primary key of this pages
	*/
	@Override
	public long getPrimaryKey() {
		return _pages.getPrimaryKey();
	}

	/**
	* Returns the url_id of this pages.
	*
	* @return the url_id of this pages
	*/
	@Override
	public long getUrl_id() {
		return _pages.getUrl_id();
	}

	@Override
	public void persist() {
		_pages.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_pages.setCachedModel(cachedModel);
	}

	/**
	* Sets the description of this pages.
	*
	* @param description the description of this pages
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_pages.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_pages.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_pages.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_pages.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the image of this pages.
	*
	* @param image the image of this pages
	*/
	@Override
	public void setImage(java.lang.String image) {
		_pages.setImage(image);
	}

	@Override
	public void setNew(boolean n) {
		_pages.setNew(n);
	}

	/**
	* Sets the primary key of this pages.
	*
	* @param primaryKey the primary key of this pages
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_pages.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_pages.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the url of this pages.
	*
	* @param url the url of this pages
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_pages.setUrl(url);
	}

	/**
	* Sets the url_id of this pages.
	*
	* @param url_id the url_id of this pages
	*/
	@Override
	public void setUrl_id(long url_id) {
		_pages.setUrl_id(url_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PagesWrapper)) {
			return false;
		}

		PagesWrapper pagesWrapper = (PagesWrapper)obj;

		if (Objects.equals(_pages, pagesWrapper._pages)) {
			return true;
		}

		return false;
	}

	@Override
	public Pages getWrappedModel() {
		return _pages;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _pages.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _pages.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_pages.resetOriginalValues();
	}

	private final Pages _pages;
}