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

package com.arthurchan35.wcse.service.base;

import com.arthurchan35.wcse.model.Word;
import com.arthurchan35.wcse.service.WordService;
import com.arthurchan35.wcse.service.persistence.PageFinder;
import com.arthurchan35.wcse.service.persistence.PagePersistence;
import com.arthurchan35.wcse.service.persistence.WordFinder;
import com.arthurchan35.wcse.service.persistence.WordPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the word remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.arthurchan35.wcse.service.impl.WordServiceImpl}.
 * </p>
 *
 * @author Arthur Chan
 * @see com.arthurchan35.wcse.service.impl.WordServiceImpl
 * @see com.arthurchan35.wcse.service.WordServiceUtil
 * @generated
 */
public abstract class WordServiceBaseImpl extends BaseServiceImpl
	implements WordService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.arthurchan35.wcse.service.WordServiceUtil} to access the word remote service.
	 */

	/**
	 * Returns the page local service.
	 *
	 * @return the page local service
	 */
	public com.arthurchan35.wcse.service.PageLocalService getPageLocalService() {
		return pageLocalService;
	}

	/**
	 * Sets the page local service.
	 *
	 * @param pageLocalService the page local service
	 */
	public void setPageLocalService(
		com.arthurchan35.wcse.service.PageLocalService pageLocalService) {
		this.pageLocalService = pageLocalService;
	}

	/**
	 * Returns the page remote service.
	 *
	 * @return the page remote service
	 */
	public com.arthurchan35.wcse.service.PageService getPageService() {
		return pageService;
	}

	/**
	 * Sets the page remote service.
	 *
	 * @param pageService the page remote service
	 */
	public void setPageService(
		com.arthurchan35.wcse.service.PageService pageService) {
		this.pageService = pageService;
	}

	/**
	 * Returns the page persistence.
	 *
	 * @return the page persistence
	 */
	public PagePersistence getPagePersistence() {
		return pagePersistence;
	}

	/**
	 * Sets the page persistence.
	 *
	 * @param pagePersistence the page persistence
	 */
	public void setPagePersistence(PagePersistence pagePersistence) {
		this.pagePersistence = pagePersistence;
	}

	/**
	 * Returns the page finder.
	 *
	 * @return the page finder
	 */
	public PageFinder getPageFinder() {
		return pageFinder;
	}

	/**
	 * Sets the page finder.
	 *
	 * @param pageFinder the page finder
	 */
	public void setPageFinder(PageFinder pageFinder) {
		this.pageFinder = pageFinder;
	}

	/**
	 * Returns the word local service.
	 *
	 * @return the word local service
	 */
	public com.arthurchan35.wcse.service.WordLocalService getWordLocalService() {
		return wordLocalService;
	}

	/**
	 * Sets the word local service.
	 *
	 * @param wordLocalService the word local service
	 */
	public void setWordLocalService(
		com.arthurchan35.wcse.service.WordLocalService wordLocalService) {
		this.wordLocalService = wordLocalService;
	}

	/**
	 * Returns the word remote service.
	 *
	 * @return the word remote service
	 */
	public WordService getWordService() {
		return wordService;
	}

	/**
	 * Sets the word remote service.
	 *
	 * @param wordService the word remote service
	 */
	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}

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

	/**
	 * Returns the word finder.
	 *
	 * @return the word finder
	 */
	public WordFinder getWordFinder() {
		return wordFinder;
	}

	/**
	 * Sets the word finder.
	 *
	 * @param wordFinder the word finder
	 */
	public void setWordFinder(WordFinder wordFinder) {
		this.wordFinder = wordFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return WordService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Word.class;
	}

	protected String getModelClassName() {
		return Word.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = wordPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.arthurchan35.wcse.service.PageLocalService.class)
	protected com.arthurchan35.wcse.service.PageLocalService pageLocalService;
	@BeanReference(type = com.arthurchan35.wcse.service.PageService.class)
	protected com.arthurchan35.wcse.service.PageService pageService;
	@BeanReference(type = PagePersistence.class)
	protected PagePersistence pagePersistence;
	@BeanReference(type = PageFinder.class)
	protected PageFinder pageFinder;
	@BeanReference(type = com.arthurchan35.wcse.service.WordLocalService.class)
	protected com.arthurchan35.wcse.service.WordLocalService wordLocalService;
	@BeanReference(type = WordService.class)
	protected WordService wordService;
	@BeanReference(type = WordPersistence.class)
	protected WordPersistence wordPersistence;
	@BeanReference(type = WordFinder.class)
	protected WordFinder wordFinder;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}