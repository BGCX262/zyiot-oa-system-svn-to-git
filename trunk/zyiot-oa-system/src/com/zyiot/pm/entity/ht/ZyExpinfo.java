package com.zyiot.pm.entity.ht;

// default package
// Generated 2013-12-2 11:01:13 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.zyiot.pm.entity.comm.ZyClass1;

/**
 * @author michaellou 拓展商信息管理
 */
@ Entity
@ Table(name = "ZY_EXPINFO")
public class ZyExpinfo implements java.io.Serializable {
	@ Id
	@Column(name = "PK_ID", length = 60, nullable = false)
	private String pkid;

	@Column(name = "EXP_CODE", length = 10, nullable = false)
	private String expcode;

	@Column(name = "EXP_JOIN_DATE")
	private Date expjoindate;

	@Column(name = "EXP_NAME", length = 20, nullable = false)
	private String expname;

	@Column(name = "EXP_RATE", length = 3, nullable = false)
	private float exprate;

	@Column(name = "EXP_PHONE", length = 13, nullable = false)
	private String expphone;

	@Column(name = "EXP_TECH_COST", length = 10)
	private float exptechcost;

	@Column(name = "EXP_HARD_COST", length = 10)
	private float  exphardcost;

	@Column(name = "EXP_ACCONT_NAME", length = 10, nullable = false)
	private String expaccontname;

	@Column(name = "EXP_BANK_NAME", length = 60, nullable = false)
	private String expbankname;

	@Column(name = "EXP_ACCONT_NO", length = 20, nullable = false)
	private String expaccontno;

	@Column(name = "EXP_ID", length = 18, nullable = false)
	private String expid;

	@Column(name = "EXP_ADDR", length = 120, nullable = false)
	private String expaddr;

	@Column(name = "EXP_EMAIL", length = 50)
	private String expemail;

	@Column(name = "MAKE_USER", length = 60)
	private String make_user;

	@Column(name = "MEMO", length = 120)
	private String memo;

	@Column(name = "CREATE_USER", length = 60)
	private String create_user;

	@Column(name = "CREATE_DATE")
	private Date create_date;

	@Column(name = "LAST_UPDATE_USER", length = 60)
	private String last_update_user;

	@Column(name = "LAST_UPDATE_DATE")
	private Date last_update_date;
	
	@Column(name = "class1_id")
	private Date class1_id;
	
	public Date getClass1_id() {
		return class1_id;
	}
	public void setClass1_id(Date class1_id) {
		this.class1_id = class1_id;
	}

	@Transient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private List<ZyClass1> zyclass1;

	
	
	public ZyExpinfo() {
	}
	public ZyExpinfo(String pkid) {
		this.pkid = pkid;
	}

	public String getPkid() {
		return pkid;
	}

	public void setPkid(String pkid) {
		this.pkid = pkid;
	}

	public String getExpcode() {
		return expcode;
	}

	public void setExpcode(String expcode) {
		this.expcode = expcode;
	}

	public Date getExpjoindate() {
		return expjoindate;
	}

	public void setExpjoindate(Date expjoindate) {
		this.expjoindate = expjoindate;
	}

	public String getExpname() {
		return expname;
	}

	public void setExpname(String expname) {
		this.expname = expname;
	}

	public float getExprate() {
		return exprate;
	}

	public void setExprate(float exprate) {
		this.exprate = exprate;
	}

	public String getExpphone() {
		return expphone;
	}

	public float getExptechcost()
	{
		return exptechcost;
	}
	public void setExptechcost(float exptechcost)
	{
		this.exptechcost = exptechcost;
	}
	public float getExphardcost()
	{
		return exphardcost;
	}
	public void setExphardcost(float exphardcost)
	{
		this.exphardcost = exphardcost;
	}
	public void setExpphone(String expphone) {
		this.expphone = expphone;
	}

	

	public String getExpaccontname() {
		return expaccontname;
	}

	public String getExpbankname()
	{
		return expbankname;
	}
	public void setExpbankname(String expbankname)
	{
		this.expbankname = expbankname;
	}
	public void setExpaccontname(String expaccontname) {
		this.expaccontname = expaccontname;
	}


	public String getExpaccontno() {
		return expaccontno;
	}

	public void setExpaccontno(String expaccontno) {
		this.expaccontno = expaccontno;
	}

	public String getExpid() {
		return expid;
	}

	public void setExpid(String expid) {
		this.expid = expid;
	}

	public String getExpaddr() {
		return expaddr;
	}

	public void setExpaddr(String expaddr) {
		this.expaddr = expaddr;
	}

	public String getExpemail() {
		return expemail;
	}

	public void setExpemail(String expemail) {
		this.expemail = expemail;
	}

	public String getMake_user() {
		return make_user;
	}

	public void setMake_user(String make_user) {
		this.make_user = make_user;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getLast_update_user() {
		return last_update_user;
	}

	public void setLast_update_user(String last_update_user) {
		this.last_update_user = last_update_user;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

}
