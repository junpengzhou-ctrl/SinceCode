package com.mozhoudonglu;

class DuoTailmpll {
    /*
    多态前提条件 1，父子类具有继承和实现关系
                2. 子类重写父类的方法
                3. 父类引用指向子类对象
     */
    public static void main(String[] args) {
        getduotai(new Cat());    // 向上转型， 父类引用指向子类对象

    }

    public static void getduotai(DuoTai duoTai){
        duoTai.eat();

        if (duoTai instanceof Dog ){
            Dog dog = (Dog) duoTai;   //向下转型， 父类引用转为子类对象
        }else{
            Cat cat = (Cat) duoTai;
        }

    }

}


class Dog implements DuoTai{
    @Override
    public void eat() {
        System.out.println("狗狗吃狗粮");
    }

    public void watchHome(){
        System.out.println("狗狗在看家哦");
    }
}

class Cat implements DuoTai{
    @Override
    public void eat() {
        System.out.println("猫猫吃猫粮");
    }
}
