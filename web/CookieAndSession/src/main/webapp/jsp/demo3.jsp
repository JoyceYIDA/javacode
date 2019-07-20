<%--
  Created by IntelliJ IDEA.
  User: 储昭玥
  Date: 2019/7/18
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el中的操作域对象</title>
</head>
<body>
<%--
${域中属性名称}：如果这个属性名称在多个域对象中都存在，先获取最小域对象中内容：

--%>
<%
    /*pageContext.setAttribute("akey","avalue");
    request.setAttribute("akey","bvalue");
    session.setAttribute("akey","cvalue");
    application.setAttribute("akey","dvalue");
    */
//    pageContext.findAttribute("akey");这个方法和下面的${域中属性名称}是相同的
    //pageContext作用：可以将当前数据存储到另外三个域对象中
    pageContext.setAttribute("akey","avalue",PageContext.REQUEST_SCOPE);

%>
<%--el操作是从小到大的范围来查找--%>
<%=request.getAttribute("akey")%><br>
el操作：<br>
${akey}
</body>
</html>
