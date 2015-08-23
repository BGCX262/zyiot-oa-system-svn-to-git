package com.zyiot.framework.unit.interceptor;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.model.DefaultUser;
import com.bstek.dorado.annotation.DataProvider;
import com.zyiot.framework.unit.ZyDefaultUserDao;

@ Component
public class ZyDefaultUserPR
{
	@ Resource
	private ZyDefaultUserDao	zydefaultuserdao;
	
	@ DataProvider
	public List<DefaultUser> getAllUser()
	{
		return zydefaultuserdao.getAllUser();
	}
}
