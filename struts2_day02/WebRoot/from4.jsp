<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>from4.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action="${pageContext.request.contextPath}/Demo11Action" method="post">
		list:<input type="text" name="list"/><br/>
		list:<input type="text" name="list[3]"/><br/>
		map:<input type="text" name="map['haha']"/><br/>
  		<input type="submit" value="提交"/>
  	</form>
  
  </body>
</html>
