package com.gyf.niuke.sort;

/**
 * 选择排序是每轮选一个最值，不稳定,o(n2)
 * 快选希堆
 */
public class SelectSort {

    public int[] selectSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        // 每轮以arr[i]为起点往后找最值，最后放到arr[i]位置上
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换，把最小的maxIndex放到arr[i]
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        return arr;
    }

}
