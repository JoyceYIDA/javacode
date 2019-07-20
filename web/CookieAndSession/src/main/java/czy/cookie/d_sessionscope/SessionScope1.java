package czy.cookie.d_sessionscope;

import sun.rmi.log.LogInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * HttpSession作为域对象，可以在不同Servlet之间进行数据共享
 */
@WebServlet(name = "SessionScope1")
public class SessionScope1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session
        HttpSession session=request.getSession();
        //给session域中存储数据，可以String、list、Map
        List<String> list=new ArrayList<String>();
        list.add("JavaEE");
        list.add("Python");
        list.add("English");
        session.setAttribute("list",list);
        System.out.println("数据保存成功");
    }
}
