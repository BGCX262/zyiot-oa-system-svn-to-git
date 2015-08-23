package com.zyiot.pm.dao.ht;

import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.core.Configure;
@ Repository
public class BaseHibernateDao extends HibernateDao
{
	@Override
	protected String getModuleFixDataSourceName() {
		return Configure.getString("bdf2.coreDataSourceName");
	}
}
