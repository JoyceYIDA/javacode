package scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ScopeTest1")
public class ScopeTest1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取全局管理对象
        ServletContext context=this.getServletContext();
        //保存数据
//        context.setAttribute("name","jacky");

        List<String> list=new ArrayList<String>();
        list.add("jacky");
        list.add("java");
        list.add("jsp");
        context.setAttribute("name",list);

        //重定向或者请求转发到jsp页面
        System.out.println("保存数据成功了");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
