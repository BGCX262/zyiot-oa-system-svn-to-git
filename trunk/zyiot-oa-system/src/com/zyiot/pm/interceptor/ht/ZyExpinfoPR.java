package com.zyiot.pm.interceptor.ht;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.zyiot.pm.dao.ht.ZyExpinfoDao;
import com.zyiot.pm.entity.comm.ZyClass1;
import com.zyiot.pm.entity.ht.ZyExpinfo;

@ Component
public class ZyExpinfoPR
{
	@ Resource
	private ZyExpinfoDao	zyexpinfodao;
	@ DataProvider
	public Collection<ZyExpinfo> getAll()
	{
		return zyexpinfodao.getAll();
	}
	@ DataProvider
	public void getAll(Page<ZyExpinfo> page , Map<String, Object> parameter)
	{
		zyexpinfodao.getAll(page,parameter);
	}
	
	@ DataResolver
	public void saveZyExpinfo(Collection<ZyExpinfo> zyexpinfos) throws Exception
	{
		zyexpinfodao.saveZyExpinfo(zyexpinfos);
		
	}
	
	@ Expose
	public String generate_code()
	{
		return zyexpinfodao.generate_code();
	}
	
	@ Expose
	public void update_codes(String str_max_number)
	{
		zyexpinfodao.update_codes(str_max_number);
		
	}
	
}
