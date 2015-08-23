<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="org.springframework.security.web.WebAttributes"%>
<%@page import="com.bstek.bdf2.core.context.ContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head runat="server">
    <title>江苏众瀛内部管理系统</title>
    <link href="style/alogin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%!
private String getAuthenticationExceptionMessage(){
    Exception exp=(Exception)ContextHolder.getHttpSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    if(exp==null){
        exp=(Exception)ContextHolder.getRequest().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
    if(exp!=null){
        return exp.getMessage();
    }
    return null;
     
}
%>
<%
String error=getAuthenticationExceptionMessage();
String message="";
if(StringUtils.isNotEmpty(error)){
	message=error;
   //out.println("Login Error:"+error);    
}
%>

<form action="security_check_" method="post">
    <div class="Main">
        <ul>
            <li class="top"></li>
            <li class="top2"></li>
            <li class="topA"></li>
            <li class="topB"><span>
                <img src="images/login/logo.gif" alt="" style="" />
            </span></li>
            <li class="topC"></li>
            <li class="topD">
                <ul class="login">
                 	<li><font color="red"><%=message%></font>
                 	
                    <li><span class="left">员工号：</span> <span style="left">
                       <input type="text" name="username_">
                    </span></li>
                    <li><span class="left">密 码：</span> <span style="left">
                       <input type="password" name="password_">
                    </span></li>
                    <li>
                    <span class="left">记住我：</span>
                       <input type="checkbox" name="remember_me_">
                    </li>
                </ul>
            </li>
            <li class="topE"></li>
            <li class="middle_A"></li>
            <li class="middle_B"></li>
            <li class="middle_C">
            
            <span class="btn">
            <input type="submit"  value=" "   style="background:url(images/login/btnlogin.gif); border-style:none;  width:100px; height:35px; background-repeat:no-repeat;"  /> 
            </span>
            </li>
            <li class="middle_D"></li>
            <li class="bottom_A"></li>
            <li class="bottom_B">
            </li>
        </ul>
    </div>
    </form>
</body>
</html>