<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

  </head>
  
  <body>
	<form action="${pageContext.request.contextPath}/user/user_login.action" method="post">
		用户名：<input type="text" name="user.name"/><br/>
		密码：<input type="password" name="user.password" /><br/>
		<input type="submit" value="登录"/>
	</form>
  </body>
</html>
