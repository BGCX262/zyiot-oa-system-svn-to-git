package com.zyiot.framework.exception;

public class ZYException extends RuntimeException
{
	
	/**
	 * 自定义异常报错
	 */
	private static final long	serialVersionUID	= -8761339322245426170L;
	
	public ZYException(String message)
	{
		super(message);
	}
	
}
