package com.mozhoudonglu;

public class SingleDemo {
    /*
    1.构造方法私有化
     */
    private SingleDemo(){}

    /*
    2.提供静态实例
     */
    private static SingleDemo Instence = new SingleDemo();      //初始化的时候创建对象是属于饿汉模式，时间换空间
//    private static SingleDemo Instence = null;

    /*
    3.返回实例对象
     */

    public static SingleDemo getInstance(){
//        if (Instence == null){                      //在调用的时候判断是属于懒汉模式，空间换时间
//            Instence =  new SingleDemo();
//        }

        return Instence;
    }
    public void show(){
        System.out.println("单例模式简单尝试！");
    }

}
class SingleDemoTest{
    public static void main(String[] args) {
        SingleDemo instance = SingleDemo.getInstance();
        instance.show();
    }
}
