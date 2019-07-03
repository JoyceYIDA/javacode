package scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ScopeTeat2")
public class ScopeTest2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext context=this.getServletContext();
//        String name=(String)context.getAttribute("name");

        List<String> list= (List<String>) context.getAttribute("name");
        System.out.println("name:"+list);

        System.out.println("获取了域中的数据");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
