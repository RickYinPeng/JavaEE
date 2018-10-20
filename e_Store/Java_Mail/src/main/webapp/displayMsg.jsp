<%--
  Created by IntelliJ IDEA.
  User: 鹏鹏
  Date: 2018/10/18
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<frameset rows="25%,*">
    <frame src="/DisplayHead?msgnum=<%=request.getParameter("msgnum")%>" scrolling="no">
    <frame src="/DisplayContent?msgnum=<%=request.getParameter("msgnum")%>" scrolling="no">
</frameset>
</body>
</html>
