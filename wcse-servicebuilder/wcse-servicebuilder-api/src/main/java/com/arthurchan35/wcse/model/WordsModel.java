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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Words service. Represents a row in the &quot;UrlStorage_Words&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.arthurchan35.wcse.model.impl.WordsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.arthurchan35.wcse.model.impl.WordsImpl}.
 * </p>
 *
 * @author Arthur Chan
 * @see Words
 * @see com.arthurchan35.wcse.model.impl.WordsImpl
 * @see com.arthurchan35.wcse.model.impl.WordsModelImpl
 * @generated
 */
@ProviderType
public interface WordsModel extends BaseModel<Words> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a words model instance should use the {@link Words} interface instead.
	 */

	/**
	 * Returns the primary key of this words.
	 *
	 * @return the primary key of this words
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this words.
	 *
	 * @param primaryKey the primary key of this words
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the word_id of this words.
	 *
	 * @return the word_id of this words
	 */
	public long getWord_id();

	/**
	 * Sets the word_id of this words.
	 *
	 * @param word_id the word_id of this words
	 */
	public void setWord_id(long word_id);

	/**
	 * Returns the url_id of this words.
	 *
	 * @return the url_id of this words
	 */
	public long getUrl_id();

	/**
	 * Sets the url_id of this words.
	 *
	 * @param url_id the url_id of this words
	 */
	public void setUrl_id(long url_id);

	/**
	 * Returns the word of this words.
	 *
	 * @return the word of this words
	 */
	@AutoEscape
	public String getWord();

	/**
	 * Sets the word of this words.
	 *
	 * @param word the word of this words
	 */
	public void setWord(String word);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Words words);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Words> toCacheModel();

	@Override
	public Words toEscapedModel();

	@Override
	public Words toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}