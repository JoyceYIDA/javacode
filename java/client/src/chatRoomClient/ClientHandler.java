package chatRoomClient;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


//读取客户端发送信息的线程
class ReadFromServer implements Runnable{
    private Socket client;

    ReadFromServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Scanner scanner=new Scanner(client.getInputStream());
            while(true) {
                if (client.isClosed()) {
                    System.out.println("客户端已经关闭了！！！");
                    scanner.close();
                }
                if(scanner.hasNext()){
                    System.out.println("客户端发送的内容为："+scanner.nextLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//发送客户端信息的线程
class SendToServer implements Runnable{
    private Socket client;

    SendToServer(Socket client) {
        this.client = client;
    }
    @Override
    public void run() {
        //获取输出流
        try {
            PrintStream printStream=new PrintStream(client.getOutputStream());
            System.out.print("请输入>");
            Scanner in=new Scanner(System.in);

            while(true){
                String sendStr="";
                if(in.hasNext()){
                    System.out.println(in.nextLine());
                }
                printStream.println(sendStr);
                //通过字符串来控制关闭
                if(sendStr.contains("bye")){
                    in.close();
                    printStream.close();
                    client.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ClientHandler {

    public static void main(String[] args) throws Exception{
        Socket client=new Socket("127.0.0.1",8080);
        Thread readThread=new Thread(new ReadFromServer(client));
        Thread sendThread=new Thread(new SendToServer(client));
        readThread.start();
        sendThread.start();
    }
}
