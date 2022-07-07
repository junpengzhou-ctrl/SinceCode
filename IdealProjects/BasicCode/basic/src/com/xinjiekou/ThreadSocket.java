package com.xinjiekou;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class ThreadSocket implements Runnable {
    private Socket accept;
    public ThreadSocket(Socket accept){    //传过来的Socket类型；
        this.accept = accept;
    }


    @Override
    public void run() {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //建立连接，保存到本地
            inputStream = accept.getInputStream();
            fileOutputStream = new FileOutputStream(new File("E:\\Test\\test1\\" + UUID.randomUUID() + ".jpg"));
            int b;
            while ((b = inputStream.read())!= -1){
                fileOutputStream.write(b);
            }

            //向客户端回复上传成功
            OutputStream bf = accept.getOutputStream();   //这边直接用字节流进行传输，如果加入BUfferedOUtPutstream有问题
            bf.write("上传成功".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fileOutputStream != null)  //一般都这么用
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
