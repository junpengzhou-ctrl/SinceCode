package com.mozhoudonglu;

public class Analog_conversion {
    public static void main(String[] args) {
        conver_to_anpei(24678);


    }

//模拟量转为电流
    public static void conver_to_anpei(int iv){
        //ov = [(osh - osl)*(iv - isl)/(ish - isl)] + osl
        //ov 换算结果
        //osh  换算结果的高限           20 mA
//        osl 换算结果的低限            4 mA
//        iv 换算对象                  模数转换后的数
//        isl 换算对象的底限            6400           32000 / 20 *4
//        ish 换算对象的高限            32000
        int ov;
        ov = ((20 - 4)*(iv - 6400)/(32000 - 6400)) +4 ;
        System.out.println("换算结果是"+ov+" 安培");
    }

}


