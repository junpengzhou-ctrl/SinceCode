package com.xinjiekou;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*接受来自客户端的消息
 */
public class ServerDemo1 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        Socket accept = serverSocket.accept();  //进行读取接受的对象来

        InputStream inputStream = accept.getInputStream();
        int b;
        while((b = inputStream.read())!= -1){
            System.out.print((char) b);  //b 表示的是字节，需要转为char类型才是我们看的懂的
            //System.out.println(b);
        }
        accept.close();
        serverSocket.close();
        inputStream.close();


    }
}
