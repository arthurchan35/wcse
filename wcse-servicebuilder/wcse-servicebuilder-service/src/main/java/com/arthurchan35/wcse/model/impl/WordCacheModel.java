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

package com.arthurchan35.wcse.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.arthurchan35.wcse.model.Word;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Word in entity cache.
 *
 * @author Arthur Chan
 * @see Word
 * @generated
 */
@ProviderType
public class WordCacheModel implements CacheModel<Word>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WordCacheModel)) {
			return false;
		}

		WordCacheModel wordCacheModel = (WordCacheModel)obj;

		if (wordId == wordCacheModel.wordId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, wordId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{wordId=");
		sb.append(wordId);
		sb.append(", pageId=");
		sb.append(pageId);
		sb.append(", word=");
		sb.append(word);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Word toEntityModel() {
		WordImpl wordImpl = new WordImpl();

		wordImpl.setWordId(wordId);
		wordImpl.setPageId(pageId);

		if (word == null) {
			wordImpl.setWord(StringPool.BLANK);
		}
		else {
			wordImpl.setWord(word);
		}

		wordImpl.resetOriginalValues();

		return wordImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		wordId = objectInput.readLong();

		pageId = objectInput.readLong();
		word = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(wordId);

		objectOutput.writeLong(pageId);

		if (word == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(word);
		}
	}

	public long wordId;
	public long pageId;
	public String word;
}