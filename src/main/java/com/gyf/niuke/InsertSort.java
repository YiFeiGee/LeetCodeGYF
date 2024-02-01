package com.gyf.niuke;

public class InsertSort {

    public void insertSort() {
        // 模拟插入排序，插入排序最擅长于往有序的数组中插入一个新元素
        int[] arr = {3,2,7,9,6};
        for (int i = 1; i < arr.length; i++) {
            //挨个与前面对比，小于则交换
            for (int j = i; j > 0; j--) {
                // 大小顺序不对则交换
                if (arr[j-1] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }

}
