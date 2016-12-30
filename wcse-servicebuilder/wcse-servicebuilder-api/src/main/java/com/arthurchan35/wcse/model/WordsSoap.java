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
 * This class is used by SOAP remote services, specifically {@link com.arthurchan35.wcse.service.http.WordsServiceSoap}.
 *
 * @author Arthur Chan
 * @see com.arthurchan35.wcse.service.http.WordsServiceSoap
 * @generated
 */
@ProviderType
public class WordsSoap implements Serializable {
	public static WordsSoap toSoapModel(Words model) {
		WordsSoap soapModel = new WordsSoap();

		soapModel.setWord_id(model.getWord_id());
		soapModel.setUrl_id(model.getUrl_id());
		soapModel.setWord(model.getWord());

		return soapModel;
	}

	public static WordsSoap[] toSoapModels(Words[] models) {
		WordsSoap[] soapModels = new WordsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WordsSoap[][] toSoapModels(Words[][] models) {
		WordsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WordsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WordsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WordsSoap[] toSoapModels(List<Words> models) {
		List<WordsSoap> soapModels = new ArrayList<WordsSoap>(models.size());

		for (Words model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WordsSoap[soapModels.size()]);
	}

	public WordsSoap() {
	}

	public long getPrimaryKey() {
		return _word_id;
	}

	public void setPrimaryKey(long pk) {
		setWord_id(pk);
	}

	public long getWord_id() {
		return _word_id;
	}

	public void setWord_id(long word_id) {
		_word_id = word_id;
	}

	public long getUrl_id() {
		return _url_id;
	}

	public void setUrl_id(long url_id) {
		_url_id = url_id;
	}

	public String getWord() {
		return _word;
	}

	public void setWord(String word) {
		_word = word;
	}

	private long _word_id;
	private long _url_id;
	private String _word;
}