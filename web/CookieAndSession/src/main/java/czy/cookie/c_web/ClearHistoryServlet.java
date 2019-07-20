package czy.cookie.c_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClearHistoryServlet")
public class ClearHistoryServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //服务器创建cookie，名称"ids"
        Cookie c=new Cookie("ids","");
        //设置cookie有效期
        c.setMaxAge(0);
        //写回浏览器
        response.addCookie(c);
        //重定向到商品列表页面：product_list.jsp
        response.sendRedirect("/product_list.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
