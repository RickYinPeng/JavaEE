<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户主页</title>
  </head>
  
  <body>
	欢迎你回来，${sessionScope.user},<a href="${pageContext.request.contextPath }/LogoutServlet">【安全退出】</a><br/>
	<a href="${pageContext.request.contextPath }/GetOnLineServlet">【查看在线登录用户】</a>
  </body>
</html>
