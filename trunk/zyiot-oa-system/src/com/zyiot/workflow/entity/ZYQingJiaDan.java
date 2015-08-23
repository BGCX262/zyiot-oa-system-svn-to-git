package com.zyiot.workflow.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author michaellou
 */
@Entity
@Table(name="ZY_QingJiaDan")
public class ZYQingJiaDan {
	
	@Id
	@Column(name="PK_ID",length=60)
	private String pkid;
	
	@Column(name="QJ_MAKE_USER",length=60, nullable = false)
	private String qjmakeuser;
	
	@Column(name="QJ_MAKE_DATE", nullable = false)
	private Date qjmakedate;
	
	@Column(name="QJ_DEPT",length=60, nullable = false)
	private String qjdept;
	
	@Column(name="QJ_POSITION",length=60, nullable = false)
	private String qjposition;
	
	@Column(name="QJ_BEGIN_DATE", nullable = false)
	private Date qjbegindate;
	
	@Column(name="QJ_END_DATE", nullable = false)
	private Date qjenddate;
	
	@Column(name="QJ_HOURS", nullable = false)
	private int qjhours;
	
	@Column(name="QJ_TYPE",length=60, nullable = false)
	private String qjtype;
	
	@Column(name="QJ_CONTENT",length=120, nullable = false)
	private String qjcontent;
	
	@Column(name="QJ_MEMO",length=120)
	private String qjmemo;
	
	@Column(name="QJ_DEPT_MANAGER",length=120)
	private String qjdeptmanager;
	
	@Column(name="QJ_DEPT_APPROVAL",length=120)
	private String qjdeptapproval;
	
	@Column(name="QJ_HR_MANAGER",length=120)
	private String qjhrmanager;
	
	@Column(name="QJ_HR_APPROVAL",length=120)
	private String qjhrapproval;
	
	@Column(name="QJ_CANCEL_DATE")
	private Date qjcanceldate;
	
	@Column(name="QJ_WORKFLOW_STATE",length=20)
	private String qjworkflowstate;
	
	@Column(name="QJ_DEPT_STATE",length=20)
	private String qjdeptstate;
	
	@Column(name="QJ_HR_STATE",length=20)
	private String qjhrstate;

	public String getPkid()
	{
		return pkid;
	}

	public void setPkid(String pkid)
	{
		this.pkid = pkid;
	}

	public String getQjmakeuser()
	{
		return qjmakeuser;
	}

	public void setQjmakeuser(String qjmakeuser)
	{
		this.qjmakeuser = qjmakeuser;
	}

	public Date getQjmakedate()
	{
		return qjmakedate;
	}

	public void setQjmakedate(Date qjmakedate)
	{
		this.qjmakedate = qjmakedate;
	}

	public String getQjdept()
	{
		return qjdept;
	}

	public void setQjdept(String qjdept)
	{
		this.qjdept = qjdept;
	}

	public String getQjposition()
	{
		return qjposition;
	}

	public void setQjposition(String qjposition)
	{
		this.qjposition = qjposition;
	}

	public Date getQjbegindate()
	{
		return qjbegindate;
	}

	public void setQjbegindate(Date qjbegindate)
	{
		this.qjbegindate = qjbegindate;
	}

	public Date getQjenddate()
	{
		return qjenddate;
	}

	public void setQjenddate(Date qjenddate)
	{
		this.qjenddate = qjenddate;
	}

	public int getQjhours()
	{
		return qjhours;
	}

	public void setQjhours(int qjhours)
	{
		this.qjhours = qjhours;
	}

	public String getQjtype()
	{
		return qjtype;
	}

	public void setQjtype(String qjtype)
	{
		this.qjtype = qjtype;
	}

	public String getQjcontent()
	{
		return qjcontent;
	}

	public void setQjcontent(String qjcontent)
	{
		this.qjcontent = qjcontent;
	}

	public String getQjmemo()
	{
		return qjmemo;
	}

	public void setQjmemo(String qjmemo)
	{
		this.qjmemo = qjmemo;
	}

	public String getQjdeptmanager()
	{
		return qjdeptmanager;
	}

	public void setQjdeptmanager(String qjdeptmanager)
	{
		this.qjdeptmanager = qjdeptmanager;
	}

	public String getQjdeptapproval()
	{
		return qjdeptapproval;
	}

	public void setQjdeptapproval(String qjdeptapproval)
	{
		this.qjdeptapproval = qjdeptapproval;
	}

	public String getQjhrmanager()
	{
		return qjhrmanager;
	}

	public void setQjhrmanager(String qjhrmanager)
	{
		this.qjhrmanager = qjhrmanager;
	}

	public String getQjdeptstate() {
		return qjdeptstate;
	}

	public void setQjdeptstate(String qjdeptstate) {
		this.qjdeptstate = qjdeptstate;
	}

	public String getQjhrstate() {
		return qjhrstate;
	}

	public void setQjhrstate(String qjhrstate) {
		this.qjhrstate = qjhrstate;
	}

	public String getQjhrapproval()
	{
		return qjhrapproval;
	}

	public void setQjhrapproval(String qjhrapproval)
	{
		this.qjhrapproval = qjhrapproval;
	}

	public Date getQjcanceldate()
	{
		return qjcanceldate;
	}

	public void setQjcanceldate(Date qjcanceldate)
	{
		this.qjcanceldate = qjcanceldate;
	}

	public String getQjworkflowstate()
	{
		return qjworkflowstate;
	}

	public void setQjworkflowstate(String qjworkflowstate)
	{
		this.qjworkflowstate = qjworkflowstate;
	}

	

}
