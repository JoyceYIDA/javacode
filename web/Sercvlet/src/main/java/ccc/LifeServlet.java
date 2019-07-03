package ccc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet生命周期：
 *    初始化：public void init(ServletConfig config)
 *    服务方法：service
 *    初始化一次，每访问一次服务方法执行一次
 *
 *
 */
public class LifeServlet extends HttpServlet {

    //创建new LifeServlet()
    public LifeServlet(){

        System.out.println("Servlet对象被创建了...");
    }

    /**
     * init方法：初始化【无参的init是用户自定义时使用】
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet被初始化了...");
    }

    /**
     * Servlet服务方法，再访问servlet默认执行service方法（要根据不同的提交方式判断）
     * 一般情况下都是覆盖doXXX（）方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了service服务方法...");
    }
//        //get方式提交
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("servlet默认执行doGet方法...");
//    }
//
//    //post方式提交
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }


    @Override
    public void destroy() {
        System.out.println("servlet销毁了");
    }
}
