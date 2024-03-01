package com.gyf.niuke.sort;

/**
 * 插入排序：稳定，o(n2)，最好o(n)，数组有序时
 */
public class InsertSort {

    public int[] insertSort(int[] arr) {
        // 模拟插入排序，插入排序最擅长于往有序的数组中插入一个新元素
        for (int i = 1; i < arr.length; i++) {
            //挨个与前面对比，小于则交换
            int j = i-1;
            int current = arr[i];
            while (j >= 0 && arr[j] > current) {
                // 只在这里挪位置，找到arr[i]应该放的位置就行
                arr[j+1] = arr[j];
                j -= 1;
            }
            arr[j+1] = current;
        }
        return arr;
    }

}
