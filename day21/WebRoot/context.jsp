<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>context对象监听器</title>

  </head>
  
  <body>
	<%
		application.setAttribute("name", "eric");
		application.setAttribute("name", "jacky");
		application.removeAttribute("name");
	 %>

  </body>
</html>
