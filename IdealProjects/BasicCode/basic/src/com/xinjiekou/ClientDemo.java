package com.xinjiekou;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientDemo {
    /*
    发送端
     */
    public static void main(String[] args) {


        DatagramSocket ds;

        {
            try {
                ds = new DatagramSocket();
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String s = scanner.nextLine();
                    if (s.equals("886")) {
                        break;
                    }
                    byte[] bytes = s.getBytes();
                    InetAddress address = InetAddress.getByName("127.0.0.1");
                    int port = 10000;
                    DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
                    ds.send(dp);
                }
                    ds.close();

            } catch (SocketException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
