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

package com.arthurchan35.wcse.service.persistence.impl;

import com.arthurchan35.wcse.model.Word;
import com.arthurchan35.wcse.service.persistence.WordPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Arthur Chan
 * @generated
 */
public class WordFinderBaseImpl extends BasePersistenceImpl<Word> {
	/**
	 * Returns the word persistence.
	 *
	 * @return the word persistence
	 */
	public WordPersistence getWordPersistence() {
		return wordPersistence;
	}

	/**
	 * Sets the word persistence.
	 *
	 * @param wordPersistence the word persistence
	 */
	public void setWordPersistence(WordPersistence wordPersistence) {
		this.wordPersistence = wordPersistence;
	}

	@BeanReference(type = WordPersistence.class)
	protected WordPersistence wordPersistence;
}