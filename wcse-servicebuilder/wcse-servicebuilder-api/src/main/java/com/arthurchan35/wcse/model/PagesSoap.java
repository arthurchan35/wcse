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

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.arthurchan35.wcse.service.http.PagesServiceSoap}.
 *
 * @author Arthur Chan
 * @see com.arthurchan35.wcse.service.http.PagesServiceSoap
 * @generated
 */
@ProviderType
public class PagesSoap implements Serializable {
	public static PagesSoap toSoapModel(Pages model) {
		PagesSoap soapModel = new PagesSoap();

		soapModel.setUrl_id(model.getUrl_id());
		soapModel.setUrl(model.getUrl());
		soapModel.setDescription(model.getDescription());
		soapModel.setImage(model.getImage());

		return soapModel;
	}

	public static PagesSoap[] toSoapModels(Pages[] models) {
		PagesSoap[] soapModels = new PagesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PagesSoap[][] toSoapModels(Pages[][] models) {
		PagesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PagesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PagesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PagesSoap[] toSoapModels(List<Pages> models) {
		List<PagesSoap> soapModels = new ArrayList<PagesSoap>(models.size());

		for (Pages model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PagesSoap[soapModels.size()]);
	}

	public PagesSoap() {
	}

	public long getPrimaryKey() {
		return _url_id;
	}

	public void setPrimaryKey(long pk) {
		setUrl_id(pk);
	}

	public long getUrl_id() {
		return _url_id;
	}

	public void setUrl_id(long url_id) {
		_url_id = url_id;
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

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	private long _url_id;
	private String _url;
	private String _description;
	private String _image;
}