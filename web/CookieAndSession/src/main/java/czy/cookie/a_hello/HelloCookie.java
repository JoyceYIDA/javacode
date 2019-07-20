package czy.cookie.a_hello;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * cookie的基本使用
 *
 */
public class HelloCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer=resp.getWriter();

        //服务器创建cookie
        Cookie cookie=new Cookie("name1","yida");
        Cookie cookie1=new Cookie("name2","jackson");
        Cookie cookie2=new Cookie("name3","mark");

        //写回到浏览器端，设置cookie有效期  setMaxAge(单位秒)
        cookie.setMaxAge(50);
        cookie1.setMaxAge(50);
        cookie2.setMaxAge(50);

        //服务器写回到浏览器存储
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        writer.print("cookie已写回");

        //再次请求服务器
        Cookie[] cookies=req.getCookies();
        if(cookies!=null){
            for (Cookie c:cookies
                 ) {
                System.out.println(c.getName()+"="+c.getValue());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
