package com.zyiot.pm.entity.comm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *@author michaellou 自动编码存储类
 */
@ Entity
@ Table(name = "ZY_AUTONUMBER")
public class ZyAutoNumber implements java.io.Serializable
{
	@ Id
	@ Column(name = "PK_ID", length = 60)
	private String	pkid;
	@ Column(name = "TABLE_NAME", length = 60)
	private String	tablename;
	@ Column(name = "MAX_NUMBER")
	private String	maxnumber;
	
	public ZyAutoNumber()
	{
	}
	
	public ZyAutoNumber(String pkId)
	{
		this.pkid = pkId;
	}
	
	public String getPkId()
	{
		return this.pkid;
	}
	
	public void setPkId(String pkId)
	{
		this.pkid = pkId;
	}
	
	public String getTableName()
	{
		return this.tablename;
	}
	
	public void setTableName(String tableName)
	{
		this.tablename = tableName;
	}
	
	public String getMaxNumber()
	{
		return this.maxnumber;
	}
	
	public void setMaxNumber(String maxNumber)
	{
		this.maxnumber = maxNumber;
	}
	
}
