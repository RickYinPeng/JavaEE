<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录页面</title>

  </head>
  
  <body>
	<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
		用户名：<input type="text" name="userName"/><br/>
		<input type="submit" value="登录"/>
		
	</form>

  </body>
</html>
