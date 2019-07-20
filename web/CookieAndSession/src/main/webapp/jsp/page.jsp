<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="czy.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 储昭玥
  Date: 2019/7/18
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="utf-8" buffer="8kb" session="true"  isELIgnored="false" %>
<%--contentType和pageEncoding：通用
buffer属性：指定当前输出的缓冲区的大小
session：在当前页面中是否启用HttpSession对象：session(默认值true，默认启用)
isELIgnored:是否忽略EL表达式 true忽略；

EL表达式就代替了<%=%>获取数据;默认是false，默认不忽略
--%>
<html>
<head>
    <title>page指令的属性</title>
</head>
<body>
<%
    //给session域中添加数据
    session.setAttribute("name","zhangsan");
//    String name= (String) session.getAttribute("name");

    //创建list集合
    List list=new ArrayList<>();
    list.add("11");
    list.add("22");
    list.add("33");
    request.setAttribute("list",list);
    User user=new User();
    user.setName("joyce");
    user.setPassword("123456");
    application.setAttribute("user",user);


%>
<%--使用jsp输出表达式--%>
<%=(String)session.getAttribute("name")%><hr>
EL表达式获取域中的数据：<br>
${sessionScope.name}
<hr>
//获取第一个元素
<%=((List)request.getAttribute("list")).get(0)
%>
//用EL表达式获取集合中的某个元素
${requestScope.list[0]}
</body>
</html>
