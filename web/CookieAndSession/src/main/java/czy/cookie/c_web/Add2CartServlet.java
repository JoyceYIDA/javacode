package czy.cookie.c_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 将商品添加到购物车中
 */
@WebServlet(name = "Add2CartServlet")
public class Add2CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=response.getWriter();
        //获取参数
        String name=request.getParameter("name");
        //手动解码
        name=new String(name.getBytes("ISO-8859-1"),"UTF-8");
        //获取购物车
        Map<String,Integer> map= (Map<String, Integer>) request.getSession().getAttribute("cart");
        //声明当前商品数量
        Integer count=null;
        //判断购物车是否为空
        if(map==null){
            map=new HashMap<String, Integer>();
            count=1;
            //将购物车添加session中
            request.getSession().setAttribute("cart",map);
        }else{
            //若不为空，判断当前购物车是否包含该商品
            count=map.get(name);
            if(count==null) {
                //不包含
                count = 1;
            }else{
                count++;
            }
        }
        //将当前数据添加到购物车
        map.put(name,count);
        //提示：当前商品已成功添加
        writer.print("当前商品<b>"+name+"</b>已成功加入购物车");
        writer.print("您可以选择<a href='/prodect_list.jsp'>继续购物</a>&nbsp;&nbsp;&nbsp;");
        writer.print("<a href='/cart.jsp'>查看购物车</a>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
