package com.zyiot.pm.entity.comm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ Entity
@ Table(name = "ZY_BASE_CODE")
public class ZyBaseCode implements Serializable
{
	@ Id
	@ Column(name = "PK_ID", length = 60)
	private String	pkid;
	@ Column(name = "CODE_CLASS", length = 20)
	private String	codeclass;
	@ Column(name = "CODE_ID",length = 20)
	private String	codeid;
	@ Column(name = "CODE_NAME",length = 20)
	private String	codename;
	
	public ZyBaseCode()
	{
	}
	public String getPkid()
	{
		return pkid;
	}
	public void setPkid(String pkid)
	{
		this.pkid = pkid;
	}
	public String getCodeclass()
	{
		return codeclass;
	}
	public void setCodeclass(String codeclass)
	{
		this.codeclass = codeclass;
	}
	public String getCodeid()
	{
		return codeid;
	}
	public void setCodeid(String codeid)
	{
		this.codeid = codeid;
	}
	public String getCodename()
	{
		return codename;
	}
	public void setCodename(String codename)
	{
		this.codename = codename;
	}
}
