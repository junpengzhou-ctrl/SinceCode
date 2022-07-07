package com.ruanjiandadao;

public class TenThread {


    public static void main(String[] args) {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            threadee threadee = new threadee(i);
            threadee.start();
            try {
                threadee.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = result+threadee.temp;
            System.out.println(result);

        }
    }
}

class threadee extends Thread {
    private int ith;   //线程数
     int temp;

    public threadee(int ith) {
        this.ith = ith;
    }

    //每个线程对象执行的操作
    /*当前线程的id *10 就相当于当前要加的值
     */
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            temp += 10*ith + i;
        }
    }
}
