package zzz;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * servletConfig:servlet的配置对象（一个web工程中，servletConfig可以有多个）
 * 配置初始化参数
 * web.xml中servlet中配置
 *
 * doGet如何获取servletConfig
 *
 * URLEncoder加密
 * URLDecoder解密
 */
public class ConfigTest extends HttpServlet {

//    public ConfigTest(){
//        //声明一个servletConfig对象
//
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //HttpServletRequest：封装一些方法【会话技术有关的方法】
        //getSession():获取session域对象
        //getCookie():获取cookie数组（cookie信息）
        ServletConfig con=this.getServletConfig();
        //获取servlet中的初始化参数
        //通过初试化验参数名称获取参数值
        String path=con.getInitParameter("path");

        //有多个初始化参数使用getInitParameterNames（）：获取所有参数名称对应的参数名

        //读取磁盘上一个文件的内容  E:\con1.txt:将内容输出到控制台
        BufferedReader br=new BufferedReader(new FileReader(path));
        String line=null;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
