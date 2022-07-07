package com.xinjiekou;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ServerDemo3 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);

        // 用死循环表示服务器端不停止，只要有客户端连接就接受保存并回复
//        while (true) {
//            Socket accept = serverSocket.accept();
//            //建立连接，保存到本地
//            InputStream inputStream = accept.getInputStream();
//            FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\Test\\test1\\" + UUID.randomUUID() + ".jpg"));
//            int b;
//            while ((b = inputStream.read())!= -1){
//                fileOutputStream.write(b);
//            }
//
//            //向客户端回复上传成功
//            OutputStream bf = accept.getOutputStream();   //这边直接用字节流进行传输，如果加入BUfferedOUtPutstream有问题
//            bf.write("上传成功".getBytes());
//
//            inputStream.close();
//            fileOutputStream.close();
//        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,    //核心线程数
                10,  //最大线程数
                10,         //线程空闲时间 值
                TimeUnit.SECONDS,           //线程空闲时间 单位
                new ArrayBlockingQueue(5),  //阻塞队列 为5
                Executors.defaultThreadFactory(),    //默认的方式来创建线程
                new ThreadPoolExecutor.AbortPolicy()   //默认拒绝策略
        );

        while(true){
            Socket accept = serverSocket.accept();
            ThreadSocket ts = new ThreadSocket(accept);
           // new Thread(thread).start();
            threadPoolExecutor.submit(ts);
        }



        // serverSocket.close();
    }
}
