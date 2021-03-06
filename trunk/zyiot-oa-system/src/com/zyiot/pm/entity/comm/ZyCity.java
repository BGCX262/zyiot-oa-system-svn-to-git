package com.zyiot.pm.entity.comm;

// default package
// Generated 2013-12-2 11:01:13 by Hibernate Tools 3.4.0.CR1

/**
 * ZyCity generated by hbm2java
 */
public class ZyCity implements java.io.Serializable
{
	
	private Integer	cityid;
	private String	citycode;
	private String	cityname;
	private String	provincecode;
	
	public ZyCity()
	{
	}
	
	public ZyCity(String citycode, String cityname, String provincecode)
	{
		this.citycode = citycode;
		this.cityname = cityname;
		this.provincecode = provincecode;
	}
	
	public Integer getCityid()
	{
		return this.cityid;
	}
	
	public void setCityid(Integer cityid)
	{
		this.cityid = cityid;
	}
	
	public String getCitycode()
	{
		return this.citycode;
	}
	
	public void setCitycode(String citycode)
	{
		this.citycode = citycode;
	}
	
	public String getCityname()
	{
		return this.cityname;
	}
	
	public void setCityname(String cityname)
	{
		this.cityname = cityname;
	}
	
	public String getProvincecode()
	{
		return this.provincecode;
	}
	
	public void setProvincecode(String provincecode)
	{
		this.provincecode = provincecode;
	}
	
}
