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
	<form action="${pageContext.request.contextPath}/model/user_register" method="post">
		<s:text name="user"></s:text>:<input type="text" name="name"/><br/>
		<s:text name="password"></s:text>:<input type="password" name="password" style="width: 155px; "/><br/>
		<input type="submit" value='<s:text name="register"></s:text>'/>
	</form>
  </body>
</html>
