package SingleThread;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatRoomClient {
    public static void main(String[] args) throws Exception {
        //本机ip默认为127.0.0.1
        Socket socket=new Socket("127.0.0.1",666);

        Scanner scanner=new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("从服务器发来的信息是  "+scanner.nextLine());
        }
        PrintStream printStream=new PrintStream(socket.getOutputStream());
        printStream.println("hello,我是客户端！");

        printStream.close();
        scanner.close();
        socket.close();
    }
}
