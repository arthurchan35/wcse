package com.arthurchan35.wcse.service.persistence.impl;

import java.util.List;

import com.arthurchan35.wcse.model.Word;
import com.arthurchan35.wcse.service.persistence.WordFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;

public class WordFinderImpl  extends WordFinderBaseImpl implements WordFinder {

	public static String FIND_PAGEIDS_BY_WORDS = WordFinder.class.getName() + ".findPageIDsByWords";
	
	@Override
	public List<Long> findPageIDsByWords(String words, int start, int end) {
		Session session = null;
		
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(getClass(), FIND_PAGEIDS_BY_WORDS);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar("url_id", Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(words);

			return (List<Long>)QueryUtil.list(q, getDialect(), start, end);

		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}
