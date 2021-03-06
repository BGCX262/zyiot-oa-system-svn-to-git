package com.zyiot.framework.service;

import com.bstek.bdf2.componentprofile.service.IDataService;
import com.bstek.bdf2.core.context.ContextHolder;

public class ZYUserProfile implements IDataService
{
	
	public static String	UNKNOWN	= "unknown";
	
	@ Override
	public String getProfileKey()
	{
		String profileKey = null;
		try
		{
			profileKey = ContextHolder.getLoginUserName();
		}
		catch (Exception e)
		{
			profileKey = UNKNOWN;
		}
		return profileKey;
	}
	
}
