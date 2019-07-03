package zzz;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext
 * 作用1：作为全局管理者对象-获取全局参数信息
 *
 */
public class ContextDome1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1)获取全局管理者对象
        ServletContext context = this.getServletContext();
        String encoding = context.getInitParameter("encoding");
        System.out.println(encoding);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
