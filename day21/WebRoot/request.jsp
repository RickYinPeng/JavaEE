<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>request对象</title>
  </head>
  
  <body>
	客户的ip地址是：${sessionScope.ip}
	<%
		request.setAttribute("name", "eric");
		request.setAttribute("name", "rose");
		request.removeAttribute("name");
	 %>
  </body>
</html>
