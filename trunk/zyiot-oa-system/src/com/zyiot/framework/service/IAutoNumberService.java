package com.zyiot.framework.service;

import java.util.List;
import org.springframework.stereotype.Component;

import com.zyiot.pm.entity.comm.ZyAutoNumber;

@ Component
public interface IAutoNumberService
{
	public static final String	BEAN_ID	= "zy.IAutoNumberService";
	
	List<ZyAutoNumber> get_table_data(String TABLE_NAME);
}
