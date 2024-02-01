package com.gyf.niuke;

public class QSort {

    public void quickSearch(int[] input, int low, int high) {
        if (low > high) {
            return;
        }
        int start = low;
        int last = high;
        // 一直循环，直到前面都比num[start]小，后面都比num[start]大
        while (low < high) {
            // 从后往前找个比num[start]小的
            while (low < high && input[high] >= input[start]) {
                high--;
            }
            // 从前往后找个比num[start]大的
            while (low < high && input[low] <= input[start]) {
                low++;
            }
            // 两个值交换
            if (low < high) {
                swapArr(input, low, high);
            }
        }
        // 到这里一定是low==high
        swapArr(input, start, high);
        quickSearch(input, start, high-1);
        quickSearch(input, high+1, last);
    }

    public void swapArr(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

}
