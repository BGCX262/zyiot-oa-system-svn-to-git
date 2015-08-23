package com.zyiot.framework.exception;

import org.aopalliance.intercept.MethodInvocation;

import com.bstek.bdf2.core.exception.IAjaxExceptionHandler;
import com.bstek.dorado.view.resolver.ClientRunnableException;

public class ZYExceptionHandler implements IAjaxExceptionHandler
{
	
	@Override
	public void handle(Throwable exception , MethodInvocation invocation)
	{
		String message = exception.getMessage();
		StringBuffer sb = new StringBuffer();
		sb.append("dorado.MessageBox.alert(\"" + message + "\"");
		sb.append(",{ icon: \"ERROR\"})");
		throw new ClientRunnableException(sb.toString());
	}
	
	@Override
	public boolean support(Throwable exception)
	{
		return (exception instanceof ZYException);
	}
	
}
