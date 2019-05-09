package SingleThread;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatRoomServer {
    public static void main(String[] args) throws Exception {
        //1.建立基站
        ServerSocket serverSocket=new ServerSocket(666);
        //2.和客户端建立连接,等待连接
        System.out.println("等待客户端连接----------");
        Socket socket=serverSocket.accept();
        //3.输入输出流
        PrintStream print=new PrintStream(socket.getOutputStream());
        print.println("hi 我是服务端！！！");
        Scanner scanner=new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("客户端输入的内容为："+scanner.nextLine());
        }
        //4.关闭流
        scanner.close();
        print.close();
        serverSocket.close();
    }
}
