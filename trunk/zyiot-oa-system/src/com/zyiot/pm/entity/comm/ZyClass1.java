package com.zyiot.pm.entity.comm;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

// default package
// Generated 2013-12-2 11:01:13 by Hibernate Tools 3.4.0.CR1

/**
 * @author michaellou 行业分类实现类
 */
@ Entity
@ Table(name = "ZY_CLASS1")
public class ZyClass1 implements java.io.Serializable
{
	
	@ Id
	@ Column(name = "PK_ID", length = 60)
	private String		pkid;
	
	@ Column(name = "CLASS_CODE1", length = 4, nullable = false)
	private String		classcode1;
	
	@ Column(name = "CLASS_NAME1", length = 20, nullable = false)
	private String		classname1;
	
	@ Column(name = "MEMO", length = 120)
	private String		memo;
	
	@ Column(name = "CREATE_USER", length = 60)
	 private String create_user;
	
	@ Column(name = "CREATE_DATE")
	private Date		create_date;
	
	 @ Column(name = "LAST_UPDATE_USER", length = 60)
	 private String last_update_user;
	
	@ Column(name = "LAST_UPDATE_DATE")
	private Date		last_update_date;
	@Transient
	private int percent_test;
	
//	@ ManyToOne(cascade = CascadeType.ALL, targetEntity = DefaultUser.class, fetch = FetchType.EAGER)
//	@ Fetch(FetchMode.JOIN)
//	@ JoinColumn(name = "CREATE_USER", referencedColumnName = "USERNAME_")
//	private DefaultUser	CREATE_USER_NAME;
//	
//	@ ManyToOne(cascade = CascadeType.ALL, targetEntity = DefaultUser.class, fetch = FetchType.EAGER)
//	@ Fetch(FetchMode.JOIN)
//	@ JoinColumn(name = "LAST_UPDATE_USER", referencedColumnName = "USERNAME_")
//	private DefaultUser	LAST_UPDATE_USER_NAME;
	
	public ZyClass1()
	{
	}
	
	public ZyClass1(String pkid)
	{
		this.pkid = pkid;
	}

	public String getPkid()
	{
		return pkid;
	}

	public void setPkid(String pkid)
	{
		this.pkid = pkid;
	}

	public String getClasscode1()
	{
		return classcode1;
	}

	public void setClasscode1(String classcode1)
	{
		this.classcode1 = classcode1;
	}

	public String getClassname1()
	{
		return classname1;
	}

	public void setClassname1(String classname1)
	{
		this.classname1 = classname1;
	}

	public String getMemo()
	{
		return memo;
	}

	public void setMemo(String memo)
	{
		this.memo = memo;
	}

	public String getCreate_user()
	{
		return create_user;
	}

	public void setCreate_user(String create_user)
	{
		this.create_user = create_user;
	}

	public Date getCreate_date()
	{
		return create_date;
	}

	public void setCreate_date(Date create_date)
	{
		this.create_date = create_date;
	}

	public String getLast_update_user()
	{
		return last_update_user;
	}

	public void setLast_update_user(String last_update_user)
	{
		this.last_update_user = last_update_user;
	}

	public Date getLast_update_date()
	{
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date)
	{
		this.last_update_date = last_update_date;
	}

	public int getPercent_test()
	{
		return percent_test;
	}

	public void setPercent_test(int percent_test)
	{
		this.percent_test = percent_test;
	}
	
	
	
	
	
}
