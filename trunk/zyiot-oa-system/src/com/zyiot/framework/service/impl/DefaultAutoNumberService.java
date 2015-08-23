package com.zyiot.framework.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.CoreJdbcDao;
import com.zyiot.framework.service.IAutoNumberService;
import com.zyiot.pm.entity.comm.ZyAutoNumber;

@ Component
public class DefaultAutoNumberService extends CoreJdbcDao implements IAutoNumberService
{
	
	/**
	 * 获取编码表记录
	 * 
	 * @param TABLE_NAME 表名
	 * */
	@Override
	public List<ZyAutoNumber> get_table_data(String TABLE_NAME)
	{
		String sql = "SELECT A.PK_ID,A.TABLE_NAME,A.MAX_NUMBER FROM ZY_AUTONUMBER A WHERE A.TABLE_NAME=?";
		List<ZyAutoNumber> list_zyautonumber = this.getJdbcTemplate().query(sql, new Object[] { TABLE_NAME }, new DefaultAutoNumberMapper());
		return list_zyautonumber;
	}
	
	class DefaultAutoNumberMapper implements RowMapper<ZyAutoNumber>
	{
		@Override
		public ZyAutoNumber mapRow(ResultSet rs , int rowNum) throws SQLException
		{
			ZyAutoNumber zyautonumber = new ZyAutoNumber();
			zyautonumber.setPkId(rs.getString("PK_ID"));
			zyautonumber.setMaxNumber(rs.getString("MAX_NUMBER"));
			zyautonumber.setTableName(rs.getString("TABLE_NAME"));
			return zyautonumber;
		}
	}
}
