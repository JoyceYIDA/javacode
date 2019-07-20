<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 储昭玥
  Date: 2019/7/13
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车页面</title>
</head>
<body>
<table border="1px" align="center" width="40%">
    <tr>
        <td>商品名称</td>
        <td>商品数量</td>
    </tr>
    <%
        //从session中获取购物车
        Map<String,Integer> map= (Map<String, Integer>) session.getAttribute("cart");
        //判断map集合是否为空
        if(map==null){
            //jsp内置对象：out(JSPWriter)
            out.print("<tr><td colspan='2'>购物车空空如也，可以再逛逛~~~</td></tr>");
        }else{
            //不为空，遍历map集合，获取商品名称和商品数量
            for(String name:map.keySet()){
                out.print("<tr>");
                out.print("<td>");
                out.print(name);
                out.print("</td>");
                out.print("<td>");
                out.print(map.get(name));
                out.print("</td>");
                out.print("</tr>");
            }
        }
    %>
    <hr>
    <center>
        <a href="/product_list.jsp">继续购物&nbsp;&nbsp;&nbsp;</a>
        <a href="/clearCart">清空购物车&nbsp;&nbsp;&nbsp;</a>
    </center>
</table>
</body>
</html>
