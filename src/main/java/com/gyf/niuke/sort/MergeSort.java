package com.gyf.niuke.sort;


/**
 * 归并排序：字问题分解，把大集合分成多个小集合，小集合排完序后再merge到一起
 * 稳定：o(nlogn),但是需要o(n)的空间复杂度，merge时用
 */
public class MergeSort {

    public int[] tmp;

    public int[] mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        tmp = new int[arr.length];
        merge(arr, 0,arr.length-1);
        return arr;
    }

    public void merge(int[] arr, int l, int r) {
        // 这是递归结束的标志
        if (l >= r) {
            return;
        }
        int mid = (l+r) / 2;
        merge(arr, l, mid);
        merge(arr, mid+1, r);
        mergeArray(arr, l, mid, r);
    }

    public void mergeArray(int[] arr, int l, int mid, int r) {
        int i = l;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] > arr[j]) {
                tmp[k++] = arr[j];
                j++;
            } else {
                tmp[k++] = arr[i];
                i++;
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i];
            i++;
        }
        while (j <= r) {
            tmp[k++] = arr[j];
            j++;
        }
        // 把tmp的值再送回到arr中
        for (int m = 0; m < k; m++) {
            arr[l+m] = tmp[m];
        }
    }
}
