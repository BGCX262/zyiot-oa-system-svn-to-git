package com.zyiot.pm.entity.comm;

// default package
// Generated 2013-12-2 11:01:13 by Hibernate Tools 3.4.0.CR1

/**
 * ZyArea generated by hbm2java
 */
public class ZyArea implements java.io.Serializable
{
	
	private Integer	areaid;
	private String	areacode;
	private String	areaname;
	private String	citycode;
	
	public ZyArea()
	{
	}
	
	public ZyArea(String areacode, String areaname, String citycode)
	{
		this.areacode = areacode;
		this.areaname = areaname;
		this.citycode = citycode;
	}
	
	public Integer getAreaid()
	{
		return this.areaid;
	}
	
	public void setAreaid(Integer areaid)
	{
		this.areaid = areaid;
	}
	
	public String getAreacode()
	{
		return this.areacode;
	}
	
	public void setAreacode(String areacode)
	{
		this.areacode = areacode;
	}
	
	public String getAreaname()
	{
		return this.areaname;
	}
	
	public void setAreaname(String areaname)
	{
		this.areaname = areaname;
	}
	
	public String getCitycode()
	{
		return this.citycode;
	}
	
	public void setCitycode(String citycode)
	{
		this.citycode = citycode;
	}
	
}
