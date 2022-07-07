package com.mozhoudonglu;

public class SearchSort {
    public static void main(String[] args) {
        int arr[] = {22, 33, 55, 77, 88, 99};
        int need = 0;
        // BinarySearch(arr,need);

        int arr1[] = {6, 1, 2, 7, 9,  3, 4, 5, 10,8};
        // BubbleSort(arr1);
        System.out.println();
        quicksort2(arr1, 0, arr1.length-1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+" ");
        }

    }

    /*
    二分查找
     */
    public static void BinarySearch(int arr[], int need) {
        int start = 0;
        int end = arr.length - 1;   //记录开始结束索引位置

        while (start < end) {
            int mid = (start + end) >> 1;  //记录一半的索引位置
            if (need == arr[mid]) {
                System.out.println("找到了，您找到的数的数组下标是：" + mid);
                return;
            } else if (need < arr[mid]) {
                end = mid - 1;      //替换索引的位置
            } else {
                start = mid + 1;
            }
        }
    }

    /*
    冒泡排序
     */
    public static void BubbleSort(int arr[]) {
        //外层循环控制需要交换arr.length -1 次 且数组的下标是从0开始可以当作索引位置
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环控制的是每找到一个最大的数就能少一次交换的次数，索引位置为arr.length -1 -i,
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /*
    快速排序：{33,56,22,11,55,88,0,464,749797};
     */
    public static void quick_sort(int s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }


    //快速排序理解实现
    public  static void quicksort2(int arr[],int left,int right){
        if (left>right){
            return;
        }
        //传入最左边和最右边 的数此处是抽象的
        int _left = left;   //最左边的数
        int _right = right; //最右边的数
        int privot = arr[_left];



        while(left!=right){
            while (right>left &&arr[right]>=privot){
                right--;
            }
            while (right>left&&arr[left]<=privot){
                left++;
            }
            //停下来的时候交换左右两边数的位置
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

        }
        //基准数归位   找到的最后的基准数数就是arr[left] he原先的最左边的数交换
        int temp1 = arr[left];
        arr[left] = arr[_left];
        arr[_left] = temp1;

        quicksort2(arr, _left, left-1);
        quicksort2(arr, left+1, _right);
    }





}


