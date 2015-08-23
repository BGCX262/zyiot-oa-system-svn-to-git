package com.zyiot.framework.comm;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.CoreJdbcDao;
import com.bstek.bdf2.core.business.IDept;
import com.bstek.bdf2.core.business.IPosition;
import com.bstek.bdf2.core.service.IDeptService;
import com.bstek.bdf2.core.service.IPositionService;
import com.bstek.bdf2.core.service.IUserService;
import com.bstek.dorado.annotation.DataProvider;

@ Component
public class DropDownManage extends CoreJdbcDao
{
	@ Resource
	IDeptService		ideptservice;
	@ Resource
	IUserService		iuserservice;
	@ Resource
	IPositionService	ipositionservice;
	
	/**
	 * 根据编码类别获取编码信息
	 * 
	 * @return
	 */
	@ DataProvider
	public List<Map<String, Object>> getCodes(String codeclass)
	{
		String sql = "SELECT * FROM ZY_BASE_CODE WHERE CODE_CLASS=? ORDER BY CODE_ID ASC";
		Object args[] = new Object[] { codeclass };
		return this.getJdbcTemplate().queryForList(sql, args);
	}
	
	@ DataProvider
	public IDept loadDeptById(String deptId)
	{
		return ideptservice.loadDeptById(deptId);
	}
	
	@ DataProvider
	public UserDetails loadUserByUsername(String username)
	{
		return iuserservice.loadUserByUsername(username);
	}
	
	@ DataProvider
	public IPosition loadPositionById(String positionId)
	{
		return ipositionservice.loadPositionById(positionId);
	}
}
