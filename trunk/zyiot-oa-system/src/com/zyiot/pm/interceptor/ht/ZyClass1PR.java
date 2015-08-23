package com.zyiot.pm.interceptor.ht;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.zyiot.pm.dao.ht.ZyClass1Dao;
import com.zyiot.pm.entity.comm.ZyClass1;

@ Component
public class ZyClass1PR
{
	@ Resource
	private ZyClass1Dao	zyclass1dao;
	
	@ DataProvider
	public Collection<ZyClass1> getAll() throws Exception
	{
		return zyclass1dao.getAll();
	}
	
	@ DataProvider
	public void getAll(Page<ZyClass1> page , Map<String, Object> parameter) throws Exception
	{
		zyclass1dao.getAll(page, parameter);
	}
	
	@ DataResolver
	public void saveZyClass(Collection<ZyClass1> zyclasses) throws Exception
	{
		zyclass1dao.saveZyClass(zyclasses);
		
	}
	
	@ Expose
	public String generate_code()
	{
		return zyclass1dao.generate_code();
	}
	
	@ Expose
	public void update_codes(String str_max_number)
	{
		zyclass1dao.update_codes(str_max_number);
		
	}
	
}
