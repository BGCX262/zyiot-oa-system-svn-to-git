package com.zyiot.framework.unit;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.CoreHibernateDao;
import com.bstek.bdf2.core.model.DefaultUser;
@ Repository
public class ZyDefaultUserDao extends CoreHibernateDao
{
	public  List<DefaultUser> getAllUser(){
		String hql = "FROM " + DefaultUser.class.getName();
		return this.query(hql);
		
	}
}
