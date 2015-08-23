package com.zyiot.framework.unit;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.CoreHibernateDao;
import com.zyiot.framework.service.IAutoNumberService;
import com.zyiot.pm.entity.comm.ZyAutoNumber;

@ Repository
public class ZyAutoNumberDao extends CoreHibernateDao
{
	private int	table_size	= 0;
	
	/**
	 * @author michaellou
	 * @param TABLE_NAME 表名
	 * @param str_init_code 初始编码。ex: 1000001 初始化流水码
	 * */
	public void init_codes(String TABLE_NAME , String str_init_code)
	{
		Session session = this.getSessionFactory().openSession();
		try
		{
			ZyAutoNumber zyautonumber;
			zyautonumber = new ZyAutoNumber();
			zyautonumber.setPkId(UUID.randomUUID().toString());
			zyautonumber.setTableName(TABLE_NAME);
			// zyautonumber.setMaxNumber(str_init_code);
			session.save(zyautonumber);
		}
		finally
		{
			session.flush();
			session.close();
		}
		
	}
	
	/**
	 * @author michaellou 得到当前最大流水码
	 * */
	@ Resource
	private IAutoNumberService	iautonumberService;
	
	public String get_codes(String TABLE_NAME)
	{
		String str_curr_maxcode;
		
		List<ZyAutoNumber> table = iautonumberService.get_table_data(TABLE_NAME);
		table_size = table.size();
		if (table_size != 0)
		{
			str_curr_maxcode = table.get(0).getMaxNumber();
		}
		else
		{
			str_curr_maxcode = null;
		}
		
		return str_curr_maxcode;
		
	}
	
	/**
	 * @author michaellou 生成最大编码
	 * */
	public String generate_max_codes(String TABLE_NAME , String str_init_code)
	{
		
		String str_curr_maxcode;
		String str_curr_code = get_codes(TABLE_NAME);
		if (str_curr_code != null)
		{
			str_curr_maxcode = String.valueOf(Long.valueOf(str_curr_code) + 1);
		}
		else
		{
			// init_codes(TABLE_NAME, str_init_code);
			str_curr_maxcode = str_init_code;
		}
		return str_curr_maxcode;
		
	}
	
	/**
	 * @author michaellou 更新最大流水码
	 * */
	
	public void update_codes(String TABLE_NAME , String str_max_number)
	{
		Session session = this.getSessionFactory().openSession();
		try
		{
			if (table_size != 0)
			{
				List<ZyAutoNumber> table = iautonumberService.get_table_data(TABLE_NAME);
//				List<ZyAutoNumber> table = get_table_data(TABLE_NAME);
				ZyAutoNumber zyautonumber = table.get(0);
				zyautonumber.setMaxNumber(str_max_number);
				session.update(zyautonumber);
			}
			else
			{
				ZyAutoNumber zyautonumber;
				zyautonumber = new ZyAutoNumber();
				zyautonumber.setPkId(UUID.randomUUID().toString());
				zyautonumber.setTableName(TABLE_NAME);
				zyautonumber.setMaxNumber(str_max_number);
				session.save(zyautonumber);
			}
			
		}
		finally
		{
			session.flush();
			session.close();
		}
		
	}
	
	/**
	 * 获取编码的末尾流水码编码,如001
	 * 
	 * @param code 标准码
	 * @param codelength 流水码长度
	 * */
	public String get_nature_code(String code , int codelength)
	{
		return code.substring(code.length() - codelength);
		
	}
	
	/**
	 * 获取编码表记录
	 * 
	 * @param TABLE_NAME 表名
	 * */
	public List<ZyAutoNumber> get_table_data(String TABLE_NAME)
	{
		String hql = "from " + ZyAutoNumber.class.getName() + " a where a.tablename=:tablename";
		Map<String, Object> valueMap = new LinkedHashMap<String, Object>();
		valueMap.put("tablename", TABLE_NAME);
		return this.query(hql, valueMap);
	}
	
	public IAutoNumberService getIautonumberService()
	{
		return iautonumberService;
	}
	
	public void setIautonumberService(IAutoNumberService iautonumberService)
	{
		this.iautonumberService = iautonumberService;
	}
}
