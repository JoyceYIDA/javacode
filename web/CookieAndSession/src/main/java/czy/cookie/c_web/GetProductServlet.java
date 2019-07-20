package czy.cookie.c_web;

import czy.cookie.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "GetProductServlet")

/**
 * 记录上一次用户访问过的商品id
 */
public class GetProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String id=request.getParameter("id");
        //获取指定名称：ids的cookie对象
        Cookie c=CookieUtil.getCookieByName("ids",request.getCookies());
        //声明cookie内容是ids
        String ids="";
        //3）判断cookie是否为空
        if(c==null){
            ids=id;
        }else{
            //如果不为空，获取内容
            ids=c.getValue();
            //ids的内容是否通过“-”进行拼接
            String[] strArr=ids.split("-");
            //把strArr转为list集合:长度是固定的
            List<String> asList=Arrays.asList(strArr);
            //构造LinkedList
            LinkedList<String> list=new LinkedList<String>(asList);
            //判断当前list集合中是否包含该商品
            if(list.contains(id)){
                //ids:1-2-3 id=3（集合中包含该商品）
                list.remove(id);
                list.addFirst(id);
            }else{
                //长度能超过3的话,先把最后一个移除
                if(list.size()>=3){
                    list.removeLast();
                    list.addFirst(id);
                }else{
                    list.addFirst(id);
                }
            }
            //将ids内容清空，然后拼接
            ids="";
            for(String s:list){
                ids+=(s+"-");
            }
            //将ids中的内容获取到
            ids=ids.substring(0,ids.length()-1);
        }
        //4）创建cookie对象
        c=new Cookie("ids",ids);
        //5）设置有效期
        c.setMaxAge(3600);
        //6）写回到浏览器存储端
        response.addCookie(c);
        //7）通过id值重定向到具体商品详情页（拼接）
        response.sendRedirect("/product_info"+id+".htm");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
