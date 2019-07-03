package zzz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContextDome2")
public class ContextDome2 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 重定向的原理：
         * 1）响应头：响应对象setHeader("location","/xxx.html")
         * 2）设置状态码：302 进一步去请求
         */

//        response.setHeader("location","/hello.html");
//        response.setStatus(302);

        //简写
        response.sendRedirect("/hello.html");
        System.out.println("页面跳转了");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
