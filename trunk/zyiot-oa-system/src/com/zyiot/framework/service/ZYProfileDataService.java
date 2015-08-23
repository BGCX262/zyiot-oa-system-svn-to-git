package com.zyiot.framework.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.bdf2.core.model.Url;
import com.bstek.bdf2.core.view.url.UrlMaintain;
import com.bstek.bdf2.profile.model.AssignTarget;
import com.bstek.bdf2.profile.model.UrlDefinition;
import com.bstek.bdf2.profile.service.IProfileDataService;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;

@ Component
public class ZYProfileDataService implements IProfileDataService
{
	
	@ Override
	public String getAssignTargetId(HttpServletRequest arg0)
	{
		return ContextHolder.getLoginUser() == null ? null : ContextHolder.getLoginUser().getCompanyId();
	}
	
	@Override
	public void loadAssignTargets(Page<AssignTarget> page , Criteria criteria)
	{
		List<AssignTarget> targets = new ArrayList<AssignTarget>();
		AssignTarget t1 = new AssignTarget();
		t1.setId("root-zyiot");
		t1.setName("江苏众瀛联合数据科技有限公司");
		targets.add(t1);
		
		// AssignTarget t2=new AssignTarget();
		// t2.setId("root-ibm");
		// t2.setName("IBM");
		// targets.add(t2);
		page.setEntities(targets);
	}
	
	@ Autowired
	@ Qualifier("bdf2.urlMaintain")
	private UrlMaintain	urlMaintain;
	
	@Override
	public List<UrlDefinition> loadUrls(String companyId , String parentId)
	{
		List<UrlDefinition> list = new ArrayList<UrlDefinition>();
		try
		{
			for (Url url : urlMaintain.loadUrls(parentId))
			{
				UrlDefinition def = new UrlDefinition();
				def.setId(url.getId());
				def.setUrl(url.getUrl());
				def.setName(url.getName());
				def.setParentId(parentId);
				list.add(def);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		return list;
	}
	
}
