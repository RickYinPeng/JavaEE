<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>
	<style type="text/css">
		ul,li{
			color:red;
			display: inline;
		}
			
	</style>	
  </head>
  
  <body>
  	<%--打印错误信息 --%>
  	<%-- <font color="red"><s:fielderror></s:fielderror></font> --%>
  	<font color="red"><s:fielderror fieldName="user.error"></s:fielderror></font>
	<form action="${pageContext.request.contextPath}/validate/user_register" method="post">
		<s:text name="user"></s:text>:<input type="text" name="user.name"/><s:fielderror fieldName="user.name"></s:fielderror><br/>
		<s:text name="password"></s:text>:<input type="password" name="user.password" style="width: 155px; "/><s:fielderror fieldName="user.password"></s:fielderror><br/>
		<input type="submit" value='<s:text name="register"></s:text>'/>
	</form>
  </body>
</html>
