package com.xinjiekou;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo1 {
    /*
        客户端利用Tcp网络传输协议 来发送给服务器
     */
        public static void main(String[] args) throws IOException {
            Socket socket = new Socket("127.0.0.1",10000);

            //开始发送
            OutputStream outputStream = socket.getOutputStream();
            // BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            outputStream.write("hello".getBytes());
            // bufferedOutputStream.write("hello".getBytes());   //字节传输
            outputStream.close();
            socket.close();

    }


}
