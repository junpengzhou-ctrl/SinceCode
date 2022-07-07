package com.mozhoudonglu;

public class ArrayTest {
    public static void main(String[] args) {
        /*
        数组反转
        方法一：初始化起始点指针和结束点的指针并交换位置，并向内移动
         */
        int arr[] = {12, 34, 45, 55, 22, 66};

        int start = 0;
        int end = arr.length - 1;
        for (; start < end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        /*
        方法二：用位运算来进行反转 ,一个数连续亦或两次是他本身
         */
        for (; start < end; start++, end--) {
            int a = arr[start];
            int b = arr[end];
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        /*
        二维数组的常用
         */
        int twoDem[][] = new int[3][3];
        int twoDemo[][] = {{22, 33, 55}, {21, 343, 5445}, {123, 34, 56}};
        System.out.print(twoDemo[2][2] + " ");
        System.out.println();
        /*
        遍历二维数组
         */
        for (int i = 0; i < twoDemo.length; i++) {
            for (int i1 = 0; i1 < twoDemo[i].length; i1++) {
                System.out.print(twoDemo[i][i1] + " ");
            }
        }
        System.out.println();

        /*
        打印正星星
         */
        for (int i = 1; i <= 5; i++) {
            /*
            打印空格
             */
            for (int j = 1; j <= 6 - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();

        }

        /*
        打印倒星星
         */
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 6 - i; j++) {
                System.out.print("* ");
            }
            System.out.println();

        }
        /*
        打印9 * 9 乘法表
         */
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(i+"*"+j + "=" + i*j + " ");
            }
            System.out.println();
        }


    }
}
