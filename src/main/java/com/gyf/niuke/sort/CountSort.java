package com.gyf.niuke.sort;

/**
 * 计数排序，稳定，o(n+k),空间复杂度是o(k)
 * 这个k是数组内最大值，空间换时间的操作；计数排序要求输入的数据必须是有确定范围的整数，且最大值最小值相差不大的情况
 * 利用一个辅助数组，把原数组的值投影到辅助数组的下标，就可以分辨出值的大小（辅助数组内下标越小，在原数组内的值就越小）
 */
public class CountSort {

    public int[] countSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        // 寻找最大值最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // 建立辅助数组，长度是最大值-最小值+1
        int[] index = new int[max-min+1];
        // arr[i]-min作为index数组的下标，index数组存储不同值出现的次数
        for (int i = 0; i < arr.length; i++) {
            index[arr[i]-min]++;
        }
        int[] result = new int[arr.length];
        // 遍历index，index内下标越小，说明arr内对应的原值越小,因为arr-min = index
        for (int i = 0,j=0; i < index.length; i++) {
            int count = index[i];
            while (count > 0) {
                result[j++] = i+min;
                count--;
            }
        }
        return result;
    }

}
