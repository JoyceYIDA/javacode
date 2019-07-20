<%@ page import="czy.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 储昭玥
  Date: 2019/7/18
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user=new User();
    user.setName("joyce");
    user.setPassword("123456");
    application.setAttribute("user",user);
%>
${applicationScope.user.name} - ${applicationScope.user.password}
<hr>
<%--el表达式简写方式：${域中属性名称.bean属性}--%>
${user.name} *** ${user.password}
</body>
</html>
