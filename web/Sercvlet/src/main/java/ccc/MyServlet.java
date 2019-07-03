package ccc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 自定义类 继承自HttpServlet
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //响应解决乱码
        resp.setContentType("text/html;charset=utf-8");


        resp.getWriter().print("这是我的第一个servlet"+"<br/>");
        resp.getWriter().print("当前系统时间是"+new Date());
    }
}
