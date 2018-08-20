<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'session.jsp' starting page</title>

  </head>
  
  <body>
  	<%
  		//修改session的过期时间
  		session.setMaxInactiveInterval(20);//20秒
  	 %>
	当前网站的在线访客人数为：${applicationScope.onLine}
  </body>
</html>
