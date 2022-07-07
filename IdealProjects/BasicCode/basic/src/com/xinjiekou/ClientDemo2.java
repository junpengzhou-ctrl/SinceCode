package com.xinjiekou;


import java.io.*;
import java.net.Socket;

public class ClientDemo2 {
    /*
   发送给服务端一句话"hello,this is Client!"，接受服务端的回话"你好，我是服务端"
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",10000);  //IP地址得是字符串

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,this is Client!".getBytes());

        socket.shutdownOutput();    //这段是关闭写出流但是不关闭连接，因为read方法是阻塞状态无法确定结束标记

        //因为服务端发送的是中文所以说要拿转换流去接受
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String b;
        while ((b = bufferedReader.readLine())!= null){
            System.out.print(b);
        }
        outputStream.close();
        inputStream.close();
        bufferedReader.close();
        socket.close();
    }
}
