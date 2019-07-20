package czy.cookie.b_rem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "RememberServlet")

/**
 *  记录上一次用户访问时间
 */
public class RememberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1.编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        //2.获取指定名称的cookie对象
        Cookie c=getCookieByName("lastTime",request.getCookies());
        //3.判断cookie对象是否为空
        if(c==null){
            writer.print("当前是您第一次访问。。。。");
        }else{
            String value=c.getValue();
            long time=Long.parseLong(value);
            Date date=new Date(time);
            writer.print("您上次访问的系统时间为："+date.toLocaleString());

        }
        //将当前cookie写回去
        c=new Cookie("lastTime",new Date().getTime()+"");
        //设置有效期
        c.setMaxAge(3600);
//        c.setPath("/");
        response.addCookie(c);
    }

    /**
     * 在cookie数组中获取指定名称的cookie对象
     * @param name 存储cookie名称
     * @param cookies 页面中存储的所有信息
     * @return
     */
    private Cookie getCookieByName(String name, Cookie[] cookies) {
        if(cookies!=null){
            for(Cookie c:cookies){
                if(name.equals(c.getName())){
                    return c;
                }
            }
        }
        return null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
