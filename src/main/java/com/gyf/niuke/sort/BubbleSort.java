package com.gyf.niuke.sort;

/**
 * 冒泡排序的精髓是交换，每一个交换把最值放到正确位置上
 * 稳定，o(n2)，最好o(n):数组有序，带flag校验
 */
public class BubbleSort {

    public int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;
            // 第二个循环就是控制交换的次数，第一次需要交换length-1次
            for (int j = 0; j < arr.length-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

}
