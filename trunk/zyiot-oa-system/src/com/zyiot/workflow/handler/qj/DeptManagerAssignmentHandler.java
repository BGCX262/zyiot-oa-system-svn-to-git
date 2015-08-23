package com.zyiot.workflow.handler.qj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bstek.uflo.env.Context;
import com.bstek.uflo.model.ProcessInstance;
import com.bstek.uflo.process.handler.AssignmentHandler;
import com.bstek.uflo.process.node.TaskNode;

@ Component("qj.DeptManagerAssignmentHandler")
public class DeptManagerAssignmentHandler implements AssignmentHandler
{
	
	@ Override
	public Collection<String> handle(TaskNode taskNode , ProcessInstance processInstance , Context context)
	{
		List<String> users = new ArrayList<String>();
		String user = processInstance.getPromoter();
		users.add(user);
		return users;
	}
	
}
