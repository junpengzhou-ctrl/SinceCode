package com.mozhoudonglu;

public interface DuoTai {
    public default void show(){
        System.out.println("default关键字可以在接口中实现方法体");
    }

    public abstract void eat();



}
