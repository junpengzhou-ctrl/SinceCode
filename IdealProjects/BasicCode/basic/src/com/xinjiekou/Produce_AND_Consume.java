package com.xinjiekou;

public class Produce_AND_Consume {
    public static Object lock = new Object();  //锁对象
    public static volatile boolean hum = false;   //一开始没有汉堡包

    public static int count = 10;

    public static void main(String[] args) {
        Producter cooker = new Producter();
        Consumer foodie = new Consumer();
        cooker.start();
        foodie.start();

    }

}
