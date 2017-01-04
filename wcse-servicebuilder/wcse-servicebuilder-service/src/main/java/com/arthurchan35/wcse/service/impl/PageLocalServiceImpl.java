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
	public Page addPage(String url, String description, String image, List<String> words) {
		long url_id = counterLocalService.increment(Page.class.getName());
		Page page = pagePersistence.create(url_id);
		
		page.setUrl_id(url_id);
		page.setUrl(url);
		page.setDescription(description);
		page.setImage(image);
		
		pagePersistence.update(page);
		
		for (String wordstr : words) {
			long word_id = counterLocalService.increment(Word.class.getName());
			Word word = wordPersistence.create(word_id);
			
			word.setUrl_id(word_id);
			word.setUrl_id(url_id);
			word.setWord(wordstr);
			
			wordPersistence.update(word);
		}
		
		return page;
	}

}