package com.xinjiekou;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class ServerDemo {
    /*
    接收方先启动，因为UDP是面向无连接的协议
     */
    public static void main(String[] args) throws SocketException {


        DatagramSocket ds;
        {
            try {
                ds = new DatagramSocket(10000);
                while (true) {
                    byte[] bytes = new byte[1024];
                    DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
                    ds.receive(dp);
                    byte[] ar = dp.getData();
                    int length = dp.getLength();
                    System.out.println(new String(ar, 0, length));

                }
              //  ds.close();  如果是while true的话就是不停的接受所以close方法就不需要了

            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
