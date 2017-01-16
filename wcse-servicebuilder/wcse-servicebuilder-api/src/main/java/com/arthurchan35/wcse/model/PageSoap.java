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

import java.io.Serializable;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.arthurchan35.wcse.service.http.PageServiceSoap}.
 *
 * @author Arthur Chan
 * @see com.arthurchan35.wcse.service.http.PageServiceSoap
 * @generated
 */
@ProviderType
public class PageSoap implements Serializable {
	public static PageSoap toSoapModel(Page model) {
		PageSoap soapModel = new PageSoap();

		soapModel.setPageId(model.getPageId());
		soapModel.setUrl(model.getUrl());
		soapModel.setDescription(model.getDescription());
		soapModel.setImage(model.getImage());

		return soapModel;
	}

	public static PageSoap[] toSoapModels(Page[] models) {
		PageSoap[] soapModels = new PageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PageSoap[][] toSoapModels(Page[][] models) {
		PageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PageSoap[] toSoapModels(List<Page> models) {
		List<PageSoap> soapModels = new ArrayList<PageSoap>(models.size());

		for (Page model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PageSoap[soapModels.size()]);
	}

	public PageSoap() {
	}

	public long getPrimaryKey() {
		return _pageId;
	}

	public void setPrimaryKey(long pk) {
		setPageId(pk);
	}

	public long getPageId() {
		return _pageId;
	}

	public void setPageId(long pageId) {
		_pageId = pageId;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Blob getImage() {
		return _image;
	}

	public void setImage(Blob image) {
		_image = image;
	}

	private long _pageId;
	private String _url;
	private String _description;
	private Blob _image;
}