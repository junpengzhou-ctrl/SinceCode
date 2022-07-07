package com.xinjiekou;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

/*
上传一个文件给服务端，服务端接受文件并返回上传成功
 */
public class ClientDemo3 {
    public static void main(String[] args) throws IOException {
        //1.读入文件到本地，并写到服务器里面
        Socket socket = new Socket("127.0.0.1",10000);

        OutputStream outputStream = socket.getOutputStream();

        FileInputStream fileInputStream = new FileInputStream(new File("E:\\Test\\cat.jpg"));
        //FileOutputStream fileOutputStream1 = new FileOutputStream(new File("E:\\Test\\test1\\" + UUID.randomUUID() + ".jpg"));

        int b;
        while ((b = fileInputStream.read())!= -1){
            outputStream.write(b);
        }
        socket.shutdownOutput();


        //2.接受服务端的上传成功的标识
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));  //利用转换流来获取字符内容
        String s;
        while((s = bufferedReader.readLine())!=null){
            System.out.println(s);
        }

        outputStream.close();
        inputStream.close();
        fileInputStream.close();
        bufferedReader.close();
        socket.close();


    }
}
