package com.arthurchan35.wcse.service.persistence.impl;

import java.util.List;

import com.arthurchan35.wcse.model.Page;
import com.arthurchan35.wcse.model.impl.PageImpl;
import com.arthurchan35.wcse.service.persistence.PageFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;

public class PageFinderImpl extends PageFinderBaseImpl implements PageFinder{

	public static String FIND_PAGES_BY_PAGEIDS = PageFinder.class.getName() + ".findPagesByPageIDs";
	
	@Override
	public List<Page> findPagesByPageIDs(String urls, int start, int end) {
		Session session = null;
		
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(getClass(), FIND_PAGES_BY_PAGEIDS);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Page_Entity", PageImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(urls);

			return (List<Page>)QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}
