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

package com.arthurchan35.wcse.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.util.List;

import com.arthurchan35.wcse.model.Page;
import com.arthurchan35.wcse.model.Word;
import com.arthurchan35.wcse.service.base.PageLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;

/**
 * The implementation of the page local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arthurchan35.wcse.service.PageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Arthur Chan
 * @see PageLocalServiceBaseImpl
 * @see com.arthurchan35.wcse.service.PageLocalServiceUtil
 */
@ProviderType
public class PageLocalServiceImpl extends PageLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.arthurchan35.wcse.service.PageLocalServiceUtil} to access the page local service.
	 */
	public Page addPage(String url, String description, byte[] image, List<String> words) {
		long pageId = counterLocalService.increment(Page.class.getName());
		Page page = pagePersistence.create(pageId);

		UnsyncByteArrayInputStream unsyncByteArrayInputStream =
				new UnsyncByteArrayInputStream(image);
		OutputBlob dataOutputBlob = new OutputBlob(
				unsyncByteArrayInputStream, image.length);

		page.setPageId(pageId);
		page.setUrl(url);
		page.setDescription(description);
		page.setImage(dataOutputBlob);
		
		pagePersistence.update(page);
		
		for (String wordstr : words) {
			long wordId = counterLocalService.increment(Word.class.getName());
			Word word = wordPersistence.create(wordId);
			
			word.setWordId(wordId);
			word.setPageId(pageId);
			word.setWord(wordstr);
			
			wordPersistence.update(word);
		}
		
		return page;
	}

	public List<Page> findPagesByWords(String wordsInput, int start, int end) {
		StringBuilder wordsBuilder = new StringBuilder();
		String wordsList[] = wordsInput.split("[\\s|\\x80-\\xff]+");
		for (String word : wordsList) {
			wordsBuilder.append(word);
			wordsBuilder.append(',');
		}
		
		if (wordsBuilder.length() > 0)
			wordsBuilder.setLength(wordsBuilder.length() - 1);
		
		String words = wordsBuilder.toString();
		List<Long> pageIDs = wordFinder.findPageIDsByWords(words, start, end);
		return findPagesByPageIDs(pageIDs, start, end);
	}

	public List<Page> findPagesByPageIDs(List<Long> pageIDs, int start, int end) {
		StringBuilder urlsBuilder = new StringBuilder();
		for (long pageID : pageIDs) {
			urlsBuilder.append(pageID);
			urlsBuilder.append(',');
		}
		
		if (urlsBuilder.length() > 0)
			urlsBuilder.setLength(urlsBuilder.length() - 1);
		
		String urls = urlsBuilder.toString();
		List<Page> test = pageFinder.findPagesByPageIDs(urls, start, end);
		return test;
	}

	public Page fetchByURL(String url) {
		return pagePersistence.fetchByURL(url);
	}
}