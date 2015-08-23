package com.zyiot.workflow.handler.qj;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.bstek.uflo.env.Context;
import com.bstek.uflo.model.ProcessInstance;
import com.bstek.uflo.process.handler.ActionHandler;
import com.zyiot.workflow.entity.ZYQingJiaDan;
@Component("qj.FinshActionHandler")
public class FinshActionHandler implements ActionHandler
{
	
	public void handle(ProcessInstance processinstance , Context context)
	{
		Session session=context.getSession();
		ZYQingJiaDan zyqingjiadan=(ZYQingJiaDan) session.get(ZYQingJiaDan.class, processinstance.getBusinessId());
		zyqingjiadan.setQjworkflowstate("finsh");
		session.update(zyqingjiadan);
		
	}
	
}
