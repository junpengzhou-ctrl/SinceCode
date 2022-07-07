package com.xinjiekou;

import static com.xinjiekou.Produce_AND_Consume.*;

public class Producter extends Thread {
    //生产汉堡包
    //把汉堡包放在桌子上
    //叫醒等待的吃货开吃

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (count==0){break;}
                if (!hum) {
                    hum = true;
                    System.out.println("厨师在做");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notifyAll();
                }else {
                    try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }

        }

    }
}
