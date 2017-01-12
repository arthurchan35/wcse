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
 * This class is used by SOAP remote services, specifically {@link com.arthurchan35.wcse.service.http.WordServiceSoap}.
 *
 * @author Arthur Chan
 * @see com.arthurchan35.wcse.service.http.WordServiceSoap
 * @generated
 */
@ProviderType
public class WordSoap implements Serializable {
	public static WordSoap toSoapModel(Word model) {
		WordSoap soapModel = new WordSoap();

		soapModel.setWordId(model.getWordId());
		soapModel.setPageId(model.getPageId());
		soapModel.setWord(model.getWord());

		return soapModel;
	}

	public static WordSoap[] toSoapModels(Word[] models) {
		WordSoap[] soapModels = new WordSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WordSoap[][] toSoapModels(Word[][] models) {
		WordSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WordSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WordSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WordSoap[] toSoapModels(List<Word> models) {
		List<WordSoap> soapModels = new ArrayList<WordSoap>(models.size());

		for (Word model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WordSoap[soapModels.size()]);
	}

	public WordSoap() {
	}

	public long getPrimaryKey() {
		return _wordId;
	}

	public void setPrimaryKey(long pk) {
		setWordId(pk);
	}

	public long getWordId() {
		return _wordId;
	}

	public void setWordId(long wordId) {
		_wordId = wordId;
	}

	public long getPageId() {
		return _pageId;
	}

	public void setPageId(long pageId) {
		_pageId = pageId;
	}

	public String getWord() {
		return _word;
	}

	public void setWord(String word) {
		_word = word;
	}

	private long _wordId;
	private long _pageId;
	private String _word;
}