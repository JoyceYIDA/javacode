package forword;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForwordTest")
/**
 * ServletContext:请求转发
 */
public class ForwordTest extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求转发的原理：
        // 1）获取全局管理对象
        // 2）获取转发对象 ：将请求转发到服务器的另一个资源
        // 3）获取当前请求分发对象
        ServletContext context=this.getServletContext();
        RequestDispatcher rd=context.getRequestDispatcher("/adv.html");
        rd.forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
