<%@ page import="yp.Mail.POP3Help" language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="javax.mail.Folder" %>
<%@ page import="javax.mail.Message" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    String host = request.getParameter("host");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    System.out.println(host);
    System.out.println(username);
    System.out.println(password);
    String from = "";
    String subject = "";
    Date date = null;
    Folder folder = POP3Help.getFolder(host, username, password);
    session.setAttribute("folder", folder);
    Message[] messages = folder.getMessages();

    for (int i = 0; i < messages.length; i++) {
        try {
            from = messages[i].getFrom()[0].toString();
            subject = messages[i].getSubject();
            date = messages[i].getSentDate();
            out.print(i + 1);
%>
发件人地址：<%=from %>  邮件主题：<%=subject %>  发送时间：<%=date%>
<a href="displayMsg.jsp?msgnum=<%=i+1%>">查看邮件</a><br/>
<%
        } catch (Exception e) {
        }
    }
%>

</body>
</html>