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

import aQute.bnd.annotation.ProviderType;

import com.arthurchan35.wcse.model.Page;
import com.arthurchan35.wcse.service.PageLocalService;
import com.arthurchan35.wcse.service.persistence.PageFinder;
import com.arthurchan35.wcse.service.persistence.PagePersistence;
import com.arthurchan35.wcse.service.persistence.WordFinder;
import com.arthurchan35.wcse.service.persistence.WordPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the page local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.arthurchan35.wcse.service.impl.PageLocalServiceImpl}.
 * </p>
 *
 * @author Arthur Chan
 * @see com.arthurchan35.wcse.service.impl.PageLocalServiceImpl
 * @see com.arthurchan35.wcse.service.PageLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class PageLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements PageLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.arthurchan35.wcse.service.PageLocalServiceUtil} to access the page local service.
	 */

	/**
	 * Adds the page to the database. Also notifies the appropriate model listeners.
	 *
	 * @param page the page
	 * @return the page that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Page addPage(Page page) {
		page.setNew(true);

		return pagePersistence.update(page);
	}

	/**
	 * Creates a new page with the primary key. Does not add the page to the database.
	 *
	 * @param pageId the primary key for the new page
	 * @return the new page
	 */
	@Override
	public Page createPage(long pageId) {
		return pagePersistence.create(pageId);
	}

	/**
	 * Deletes the page with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pageId the primary key of the page
	 * @return the page that was removed
	 * @throws PortalException if a page with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Page deletePage(long pageId) throws PortalException {
		return pagePersistence.remove(pageId);
	}

	/**
	 * Deletes the page from the database. Also notifies the appropriate model listeners.
	 *
	 * @param page the page
	 * @return the page that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Page deletePage(Page page) {
		return pagePersistence.remove(page);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Page.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return pagePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arthurchan35.wcse.model.impl.PageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return pagePersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arthurchan35.wcse.model.impl.PageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return pagePersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return pagePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return pagePersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Page fetchPage(long pageId) {
		return pagePersistence.fetchByPrimaryKey(pageId);
	}

	/**
	 * Returns the page with the primary key.
	 *
	 * @param pageId the primary key of the page
	 * @return the page
	 * @throws PortalException if a page with the primary key could not be found
	 */
	@Override
	public Page getPage(long pageId) throws PortalException {
		return pagePersistence.findByPrimaryKey(pageId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(pageLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Page.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("pageId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(pageLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Page.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("pageId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(pageLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Page.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("pageId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return pageLocalService.deletePage((Page)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return pagePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the pages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.arthurchan35.wcse.model.impl.PageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pages
	 * @param end the upper bound of the range of pages (not inclusive)
	 * @return the range of pages
	 */
	@Override
	public List<Page> getPages(int start, int end) {
		return pagePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of pages.
	 *
	 * @return the number of pages
	 */
	@Override
	public int getPagesCount() {
		return pagePersistence.countAll();
	}

	/**
	 * Updates the page in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param page the page
	 * @return the page that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Page updatePage(Page page) {
		return pagePersistence.update(page);
	}

	/**
	 * Returns the page local service.
	 *
	 * @return the page local service
	 */
	public PageLocalService getPageLocalService() {
		return pageLocalService;
	}

	/**
	 * Sets the page local service.
	 *
	 * @param pageLocalService the page local service
	 */
	public void setPageLocalService(PageLocalService pageLocalService) {
		this.pageLocalService = pageLocalService;
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
		persistedModelLocalServiceRegistry.register("com.arthurchan35.wcse.model.Page",
			pageLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.arthurchan35.wcse.model.Page");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PageLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Page.class;
	}

	protected String getModelClassName() {
		return Page.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = pagePersistence.getDataSource();

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

	@BeanReference(type = PageLocalService.class)
	protected PageLocalService pageLocalService;
	@BeanReference(type = PagePersistence.class)
	protected PagePersistence pagePersistence;
	@BeanReference(type = PageFinder.class)
	protected PageFinder pageFinder;
	@BeanReference(type = com.arthurchan35.wcse.service.WordLocalService.class)
	protected com.arthurchan35.wcse.service.WordLocalService wordLocalService;
	@BeanReference(type = WordPersistence.class)
	protected WordPersistence wordPersistence;
	@BeanReference(type = WordFinder.class)
	protected WordFinder wordFinder;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}