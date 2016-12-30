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
 * This class is a wrapper for {@link Words}.
 * </p>
 *
 * @author Arthur Chan
 * @see Words
 * @generated
 */
@ProviderType
public class WordsWrapper implements Words, ModelWrapper<Words> {
	public WordsWrapper(Words words) {
		_words = words;
	}

	@Override
	public Class<?> getModelClass() {
		return Words.class;
	}

	@Override
	public String getModelClassName() {
		return Words.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("word_id", getWord_id());
		attributes.put("url_id", getUrl_id());
		attributes.put("word", getWord());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long word_id = (Long)attributes.get("word_id");

		if (word_id != null) {
			setWord_id(word_id);
		}

		Long url_id = (Long)attributes.get("url_id");

		if (url_id != null) {
			setUrl_id(url_id);
		}

		String word = (String)attributes.get("word");

		if (word != null) {
			setWord(word);
		}
	}

	@Override
	public Words toEscapedModel() {
		return new WordsWrapper(_words.toEscapedModel());
	}

	@Override
	public Words toUnescapedModel() {
		return new WordsWrapper(_words.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _words.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _words.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _words.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _words.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Words> toCacheModel() {
		return _words.toCacheModel();
	}

	@Override
	public int compareTo(Words words) {
		return _words.compareTo(words);
	}

	@Override
	public int hashCode() {
		return _words.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _words.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WordsWrapper((Words)_words.clone());
	}

	/**
	* Returns the word of this words.
	*
	* @return the word of this words
	*/
	@Override
	public java.lang.String getWord() {
		return _words.getWord();
	}

	@Override
	public java.lang.String toString() {
		return _words.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _words.toXmlString();
	}

	/**
	* Returns the primary key of this words.
	*
	* @return the primary key of this words
	*/
	@Override
	public long getPrimaryKey() {
		return _words.getPrimaryKey();
	}

	/**
	* Returns the url_id of this words.
	*
	* @return the url_id of this words
	*/
	@Override
	public long getUrl_id() {
		return _words.getUrl_id();
	}

	/**
	* Returns the word_id of this words.
	*
	* @return the word_id of this words
	*/
	@Override
	public long getWord_id() {
		return _words.getWord_id();
	}

	@Override
	public void persist() {
		_words.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_words.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_words.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_words.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_words.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_words.setNew(n);
	}

	/**
	* Sets the primary key of this words.
	*
	* @param primaryKey the primary key of this words
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_words.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_words.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the url_id of this words.
	*
	* @param url_id the url_id of this words
	*/
	@Override
	public void setUrl_id(long url_id) {
		_words.setUrl_id(url_id);
	}

	/**
	* Sets the word of this words.
	*
	* @param word the word of this words
	*/
	@Override
	public void setWord(java.lang.String word) {
		_words.setWord(word);
	}

	/**
	* Sets the word_id of this words.
	*
	* @param word_id the word_id of this words
	*/
	@Override
	public void setWord_id(long word_id) {
		_words.setWord_id(word_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WordsWrapper)) {
			return false;
		}

		WordsWrapper wordsWrapper = (WordsWrapper)obj;

		if (Objects.equals(_words, wordsWrapper._words)) {
			return true;
		}

		return false;
	}

	@Override
	public Words getWrappedModel() {
		return _words;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _words.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _words.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_words.resetOriginalValues();
	}

	private final Words _words;
}