package zzz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ThreadSer")

/**
 * servlet
 * 单实例多线程
 * 统计访客人数
 *
 * 校验多线程安全问题的标准
 * 1）查看当前环境是否是多线程环境
 * 2）是否存在共享数据
 * 3）是否有多条语句对共享数据操作
 *     将多条语句对共享数据的操作使用synchronized
 *     同步代码块
 *
 */
public class ThreadSer extends HttpServlet {

    private static int count=1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //防止出现乱码
        response.setContentType("text/html;charset=utf-8");
        //锁对象可以是任意对象
        //同步方法（非静态）：this
        //静态的同步方法：类名.class
        synchronized (ThreadSer.class) {
            response.getWriter().print("当前访客是第" + count + "个");

            //延迟
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }
}
