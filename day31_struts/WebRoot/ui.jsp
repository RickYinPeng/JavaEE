<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Struts2的ui标签</title>
  </head>
  
  <body>
	<s:form action="/validate/user_register" method="post" name="userForm" theme="xhtml">
		<s:textfield name="userName" label="用户名"></s:textfield>
		<s:password name="password" label="密码"></s:password>	
		<s:submit value="登录"></s:submit>
	</s:form>
	<hr/>
	<h3>checkboxlist 标签</h3>
	<%--
		list:显示的内容 
		value:默认值（出现哪个值，就勾选哪个复选框）
	--%>
	<s:checkboxlist name="hobit" list="{'篮球','足球','羽毛球'}" value="{'足球'}"></s:checkboxlist><hr/><br/>
	<s:checkboxlist name="hobit2" list="#{'101':'篮球','102':'足球','103':'羽毛球'}" ></s:checkboxlist><br/>
	
	<%--获取后台的数据作为checkboxlist的内容
		listKey:用哪个数据作为显示数据
		listValue:用哪个数据作为checkbox的value
	 --%>
	<s:checkboxlist name="hobit3" list="#request.userList" listKey="#request.password" listValue="#request.name"></s:checkboxlist><br/>
	<hr/>
	<s:checkboxlist name="hobit4" list="#userMap"></s:checkboxlist><br/>
	
	<hr/>
	<%--下面代码将userName放到request中，并没有放在request外面（struts2值栈的特性） --%>
	<s:set var="userName" value="'eric'" scope="request"></s:set>
	<%--数据回显： 在编辑数据需求下需要用到数据回显 --%>
	<s:textfield name="userName" label="用户名" ></s:textfield>	
	<s:password name="password" label="密码" showPassword="true"></s:password>
	<s:debug></s:debug>
  </body>
</html>
