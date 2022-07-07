package com.xinjiekou;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo2 {
    /*
    接受客户端的话"hello,this is Client!"，发送给客户端一句话"你好，我是服务端"
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();

        int r;
        while((r = inputStream.read())!=-1){
            System.out.print((char) r);
        }

        OutputStream outputStream = accept.getOutputStream();

        outputStream.write("你好，我是服务器".getBytes());

        inputStream.close();
        outputStream.close();

        serverSocket.close();


    }
}
