package com.mozhoudonglu;

public class HomeTest {
    public static void main(String[] args) {
        int s[] = {12, 344, 54, 454, 6, 7, 23, 6};
        quickSort(s, 0, s.length - 1);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i] + " ");
        }
    }


    public static void quickSort(int s[], int l, int r) {
        int i = l;
        int j = r;
        int priovt;  //基准数
        if (l < r) {
            priovt = s[l];   //挖坑
            while (i != j) {
                while (i < j && s[j] > priovt) {
                    j--;
                }
                if (i < j) {
                    //填坑
                    s[i] = s[j];
                }
                while (i < j && s[i] < priovt) {
                    i++;
                }
                if (i < j) {
                    //tian
                    s[j] = s[i];
                }
            }
            //基准数归位
            s[i] = priovt;
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);

        }

    }
}
