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

import com.arthurchan35.wcse.model.Words;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Words in entity cache.
 *
 * @author Arthur Chan
 * @see Words
 * @generated
 */
@ProviderType
public class WordsCacheModel implements CacheModel<Words>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WordsCacheModel)) {
			return false;
		}

		WordsCacheModel wordsCacheModel = (WordsCacheModel)obj;

		if (word_id == wordsCacheModel.word_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, word_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{word_id=");
		sb.append(word_id);
		sb.append(", url_id=");
		sb.append(url_id);
		sb.append(", word=");
		sb.append(word);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Words toEntityModel() {
		WordsImpl wordsImpl = new WordsImpl();

		wordsImpl.setWord_id(word_id);
		wordsImpl.setUrl_id(url_id);

		if (word == null) {
			wordsImpl.setWord(StringPool.BLANK);
		}
		else {
			wordsImpl.setWord(word);
		}

		wordsImpl.resetOriginalValues();

		return wordsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		word_id = objectInput.readLong();

		url_id = objectInput.readLong();
		word = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(word_id);

		objectOutput.writeLong(url_id);

		if (word == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(word);
		}
	}

	public long word_id;
	public long url_id;
	public String word;
}