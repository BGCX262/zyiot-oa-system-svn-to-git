package com.zyiot.workflow.dao;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.core.Configure;

public class UFLOHibernateDao extends HibernateDao
{
	@Override
	protected String getModuleFixDataSourceName() {
		return Configure.getString("bdf2.ufloDataSourceName");
	}
}
