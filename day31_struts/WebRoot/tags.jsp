<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'struts-ui.jsp' starting page</title>
	<style type="text/css">
		/*奇数行样式*/
		.odd{
			background: gray;
		}
		/*偶数行样式*/
		.even{
			background: red;
		}
	
	</style>
</head>

<body>
	<%--ognl表达式：在jsp页面中创建List集合 --%>
	<s:iterator value="{'eric','jacky','rose','lucy'}" var="name">
		<%-- 这个var中的name是放在值栈中的，所以用#来取 --%>
		<s:property value="#name" />
		<br />
	</s:iterator>

	<%--ognl表达式：在jsp页面中创建Map集合 --%>
	<s:iterator value="#{1:'eric',2:'jacky',3:'rose',4:'lucy'}" var="entry">
		编号：<s:property value="#entry.key" />-姓名：<s:property
			value="#entry.value" />
		<br />
	</s:iterator>
	<hr />
	<s:set var="userName" value="'rose'" scope=""></s:set>
	<%--如果没有设置 scope属性，则默认放在action中--%>
	<%--问题：这里的value属性的值，struts不把它的内容当作ognl内容解析 --%>
	<s:textfield name="userName" value="%{#request.userName}"></s:textfield>
	<hr />

	<s:bean name="yp.itcast.b_validate.User" var="user">
		<%-- 放入request域中 --%>
		<s:param name="name" value="'admin'"></s:param>
		<s:param name="password" value="12314123"></s:param>
	</s:bean>
	<s:property value="%{#request.user.name}" />
	--
	<s:property value="%{#request.user.password}" />

	<table border="1">
		<tr>
			<th>序号</th>
			<th>编号</th>
			<th>姓名</th>
		</tr>
		<s:iterator value="#{1:'eric',2:'jacky',3:'rose',4:'lucy'}"
			var="entry" status="sta">
			<tr class="<s:property value="#sta.even?'even':'odd'"/>">
				<td><s:property value="#sta.count" /></td>
				<td><s:property value="#entry.key" /></td>
				<td><s:property value="#entry.value" /></td>
			</tr>
		</s:iterator>
	</table>
	
	<hr/>
	
	<s:set name="age" value="22"></s:set>
	<s:if test="#age==23">
		23
	</s:if>
	<s:elseif test="#age==21">
		21
	</s:elseif>
	<s:else>
		都不等
	</s:else>
	
	<hr/>
	<%--生成了一个链接的url内容 --%>
	<s:url action="user_register" namespace="/validate" var="myurl">
	</s:url>
	<%--使用这个链接 --%>
	<a href="<s:property value='#myurl'/>">链接到userAction</a>
	
	
	
	<s:debug></s:debug>
</body>
</html>
