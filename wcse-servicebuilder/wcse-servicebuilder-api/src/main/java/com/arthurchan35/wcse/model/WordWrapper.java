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
 * This class is a wrapper for {@link Word}.
 * </p>
 *
 * @author Arthur Chan
 * @see Word
 * @generated
 */
@ProviderType
public class WordWrapper implements Word, ModelWrapper<Word> {
	public WordWrapper(Word word) {
		_word = word;
	}

	@Override
	public Class<?> getModelClass() {
		return Word.class;
	}

	@Override
	public String getModelClassName() {
		return Word.class.getName();
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
	public Word toEscapedModel() {
		return new WordWrapper(_word.toEscapedModel());
	}

	@Override
	public Word toUnescapedModel() {
		return new WordWrapper(_word.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _word.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _word.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _word.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _word.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Word> toCacheModel() {
		return _word.toCacheModel();
	}

	@Override
	public int compareTo(Word word) {
		return _word.compareTo(word);
	}

	@Override
	public int hashCode() {
		return _word.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _word.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new WordWrapper((Word)_word.clone());
	}

	/**
	* Returns the word of this word.
	*
	* @return the word of this word
	*/
	@Override
	public java.lang.String getWord() {
		return _word.getWord();
	}

	@Override
	public java.lang.String toString() {
		return _word.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _word.toXmlString();
	}

	/**
	* Returns the primary key of this word.
	*
	* @return the primary key of this word
	*/
	@Override
	public long getPrimaryKey() {
		return _word.getPrimaryKey();
	}

	/**
	* Returns the url_id of this word.
	*
	* @return the url_id of this word
	*/
	@Override
	public long getUrl_id() {
		return _word.getUrl_id();
	}

	/**
	* Returns the word_id of this word.
	*
	* @return the word_id of this word
	*/
	@Override
	public long getWord_id() {
		return _word.getWord_id();
	}

	@Override
	public void persist() {
		_word.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_word.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_word.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_word.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_word.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_word.setNew(n);
	}

	/**
	* Sets the primary key of this word.
	*
	* @param primaryKey the primary key of this word
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_word.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_word.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the url_id of this word.
	*
	* @param url_id the url_id of this word
	*/
	@Override
	public void setUrl_id(long url_id) {
		_word.setUrl_id(url_id);
	}

	/**
	* Sets the word of this word.
	*
	* @param word the word of this word
	*/
	@Override
	public void setWord(java.lang.String word) {
		_word.setWord(word);
	}

	/**
	* Sets the word_id of this word.
	*
	* @param word_id the word_id of this word
	*/
	@Override
	public void setWord_id(long word_id) {
		_word.setWord_id(word_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WordWrapper)) {
			return false;
		}

		WordWrapper wordWrapper = (WordWrapper)obj;

		if (Objects.equals(_word, wordWrapper._word)) {
			return true;
		}

		return false;
	}

	@Override
	public Word getWrappedModel() {
		return _word;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _word.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _word.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_word.resetOriginalValues();
	}

	private final Word _word;
}