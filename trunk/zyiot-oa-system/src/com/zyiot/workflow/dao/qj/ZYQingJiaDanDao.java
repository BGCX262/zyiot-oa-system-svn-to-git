package com.zyiot.workflow.dao.qj;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bstek.bdf2.core.business.IUser;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.bstek.uflo.client.service.ProcessClient;
import com.bstek.uflo.client.service.TaskClient;
import com.bstek.uflo.service.StartProcessInfo;
import com.bstek.uflo.service.TaskOpinion;
import com.zyiot.framework.exception.ZYException;
import com.zyiot.workflow.dao.UFLOHibernateDao;
import com.zyiot.workflow.entity.ZYQingJiaDan;

@ Repository
public class ZYQingJiaDanDao extends UFLOHibernateDao
{
	@ Autowired
	@ Qualifier(ProcessClient.BEAN_ID)
	private ProcessClient	processclient;
	
	@ Autowired
	@ Qualifier(TaskClient.BEAN_ID)
	private TaskClient		taskclient;
	
	// view端datatype类型为default，不是Colletion
	public ZYQingJiaDan loadZYQingJiaDan(String businessid)
	{
		if (StringUtils.isEmpty(businessid))
		{
			ZYQingJiaDan zyqingjiadan = new ZYQingJiaDan();
			zyqingjiadan.setPkid(UUID.randomUUID().toString());
			IUser user = ContextHolder.getLoginUser();
			zyqingjiadan.setQjmakeuser(user.getUsername());
			zyqingjiadan.setQjmakedate(new Date());
			zyqingjiadan.setQjdept(user.getDepts().get(0).getId() == null ? " " : user.getDepts().get(0).getId());
			String Positionsid = user.getPositions().get(0).getId();
			zyqingjiadan.setQjposition(user.getPositions().get(0).getId() == null ? " " : user.getPositions().get(0).getId());
			zyqingjiadan.setQjworkflowstate("inprocess");
			return zyqingjiadan;
		}
		else
		{
			Session session = this.getSessionFactory().openSession();
			try
			{
				ZYQingJiaDan qj = (ZYQingJiaDan) session.get(ZYQingJiaDan.class, businessid);
				return qj;
			}
			finally
			{
				session.flush();
				session.close();
			}
		}
	}
	
	/**
	 * 提交请假单
	 * */
	public void submitQingJiaDan(ZYQingJiaDan zyqingjiadan) throws Exception
	{
		
		Session session = this.getSessionFactory().openSession();
		try
		{
			int qjhours = cal_qjhours(zyqingjiadan.getQjbegindate(), zyqingjiadan.getQjenddate());
			zyqingjiadan.setQjhours(qjhours);
			session.save(zyqingjiadan);
			
			StartProcessInfo info = new StartProcessInfo();
			info.setPromoter(ContextHolder.getLoginUserName());// 设置当前流程提交者
			info.setBusinessId(zyqingjiadan.getPkid());// 设置当前业务ID
			info.setCompleteStartTask(true);// 完成后开始任务
			Map<String, Object> variables = new HashMap<String, Object>();// 设置流程中的相关变量
			variables.put("dayCount", zyqingjiadan.getQjhours() / 8);
			info.setVariables(variables);
			processclient.startProcessByKey("QingJiaDan", info);// 开始流程
			
		}
		catch (Exception e)
		{
			session.delete(zyqingjiadan);
			throw new ZYException("流程提交异常，请联系管理员\n"+e.getMessage());
		}
		finally
		{
			session.flush();
			session.close();
		}
	}
	
	/**
	 * 更新请假单
	 * */
	public void updateQingJiaDan(ZYQingJiaDan zyqingjiadan , Map<String, Object> parameter) throws Exception
	{
		
		Session session = this.getSessionFactory().openSession();
		String tag = null;
		IUser user = ContextHolder.getLoginUser();
		String username = user.getUsername();
		
		if (parameter != null)
		{
			if (parameter.get("tag") != null && parameter.get("tag") != "")
			{
				tag = (String) parameter.get("tag");
			}
			
			if (tag.equals("dept"))
			{
				zyqingjiadan.setQjdeptmanager(username);
			}
			if (tag.equals("hr"))
			{
				zyqingjiadan.setQjhrmanager(username);
			}
		}
		try
		{
			session.update(zyqingjiadan);
		}
		finally
		{
			session.flush();
			session.close();
		}
		
	}
	
	/**
	 * 获取当前用户所有请假历史
	 * 
	 * @param parameter 条件参数
	 * */
	public void getAll(Page<ZYQingJiaDan> page , Map<String, Object> parameter)
	{
		// Map<String, Object> condition = (Map<String, Object>)
		// parameter.get("condition");
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(ZYQingJiaDan.class);
		
		detachedCriteria.addOrder(Order.desc("qjmakedate"));
		// 获取当前用户
		IUser user = ContextHolder.getLoginUser();
		detachedCriteria.add(Restrictions.eq("qjmakeuser", user.getUsername()));
		
		// zyclass.setCreate_user(user.getUsername());
		// zyclass.setCreate_date(new Date());
		
		// if (condition != null)
		// {
		// if (condition.get("classcode1") != null &&
		// condition.get("classcode1") != "")
		// {
		// String classCode1 = (String) condition.get("classcode1");
		// detachedCriteria.add(Restrictions.like("classcode1", classCode1,
		// MatchMode.ANYWHERE));
		// }
		// if (condition.get("classname1") != null &&
		// condition.get("classname1") != "")
		// {
		// String className1 = (String) condition.get("classname1");
		// detachedCriteria.add(Restrictions.like("classname1", className1,
		// MatchMode.ANYWHERE));
		// }
		// }
		
		this.pagingQuery(page, detachedCriteria);
	}
	
	/**
	 * 提交审批意见
	 * 
	 * @param taskid 任务ID
	 * @param opinion 审批意见
	 * @param State 审批状态
	 * */
	public void submitTaskDept(Map<String, Object> parameter)
	{
		String opinion = null;
		String state = null;
		String taskid = null;
		Date date = null;
		if (parameter != null)
		{
			if (parameter.get("opinion") != null && parameter.get("opinion") != "")
			{
				opinion = (String) parameter.get("opinion");
			}
			if (parameter.get("state") != null && parameter.get("state") != "")
			{
				state = (String) parameter.get("state");
			}
			if (parameter.get("taskid") != null && parameter.get("taskid") != "")
			{
				taskid = (String) parameter.get("taskid");
			}
			TaskOpinion taskopinion = new TaskOpinion(opinion);
			taskclient.start(Long.valueOf(taskid));
			
			if (state != null)
			{
				if (state.equals("pass"))
				{
					taskclient.complete(Long.valueOf(taskid), taskopinion);
					
				}
				
				if (state.equals("fail"))
				{
					taskclient.withdraw(Long.valueOf(taskid), taskopinion);
				}
			}
			else
			{
				
				taskclient.complete(Long.valueOf(taskid));
			}
		}
		else
		{
			throw new ZYException("请完善审批意见！");
		}
		
	}
	
	/**
	 * 计算请假时间
	 * 
	 * @param begin 开始时间
	 * @param end 结束时间
	 * */
	public int cal_qjhours(Date begin , Date end)
	{
		
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH");
		// begin=dfs.parse(begin);
		// end = dfs.parse(end);
		long between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒
		
		long day1 = between / (24 * 3600);
		long hour1 = between % (24 * 3600) / 3600;
		// long minute1 = between % 3600 / 60;
		// long second1 = between % 60 / 60;
		int hours = 0;
		if (day1 > 0)
		{
			hours = (int) (day1 * 8);
		}
		if (hour1 > 8)
		{
			hours = hours + 8;
		}
		return hours;
		
	}
}
