package com.zyiot.workflow.interceptor.qj;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.zyiot.workflow.dao.qj.ZYQingJiaDanDao;
import com.zyiot.workflow.entity.ZYQingJiaDan;

@Component
public class ZyQingJiaDanPR
{
	@ Resource
	private ZYQingJiaDanDao zyqingjiadandao;
	@ DataProvider
	public ZYQingJiaDan loadZYQingJiaDan(String businessid)
	{
		return zyqingjiadandao.loadZYQingJiaDan(businessid);
	}
	@ DataProvider
	public void getAll(Page<ZYQingJiaDan> page , Map<String, Object> parameter)
	{
		zyqingjiadandao.getAll(page, parameter);
	}
	@DataResolver
	public void submitQingJiaDan(ZYQingJiaDan zyqingjiadan) throws Exception
	{
		zyqingjiadandao.submitQingJiaDan(zyqingjiadan);
	}
	@DataResolver
	public void updateQingJiaDan(ZYQingJiaDan zyqingjiadan, Map<String, Object> parameter) throws Exception
	{
		zyqingjiadandao.updateQingJiaDan(zyqingjiadan, parameter);
	}
	@Expose
	public void submitTaskDept(Map<String, Object> parameter)
	{
		zyqingjiadandao.submitTaskDept(parameter);
	}
	
}
