package com.zyiot.workflow.handler.qj;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.bstek.uflo.env.Context;
import com.bstek.uflo.model.ProcessInstance;
import com.bstek.uflo.process.handler.ActionHandler;
import com.zyiot.workflow.entity.ZYQingJiaDan;
@Component("qj.CompleteActionHandler")
public class CompleteActionHandler implements ActionHandler
{
	@Override
	public void handle(ProcessInstance processinstance , Context context)
	{
		
		Session session=context.getSession();
		String bid=processinstance.getBusinessId();
		ZYQingJiaDan zyqingjiadan=(ZYQingJiaDan) session.get(ZYQingJiaDan.class, bid);
		zyqingjiadan.setQjworkflowstate("complete");
		session.update(zyqingjiadan);
		
	}
	
}
