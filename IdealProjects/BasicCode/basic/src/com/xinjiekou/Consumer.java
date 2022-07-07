package com.xinjiekou;

import static com.xinjiekou.Produce_AND_Consume.*;

public class Consumer extends Thread {

//判断桌子上右没有汉堡包
// 没有就等待
    @Override
    public void run() {
        while (true){
            synchronized (lock) {
                if (count==0){break;}
                if (!hum) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    hum = false;  //开吃
                    System.out.println("吃货在吃");
                    count--;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notifyAll();     //吃完继续做
                }
            }
        }

    }
}
