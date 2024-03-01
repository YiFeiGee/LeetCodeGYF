package com.gyf.niuke.sort;

/**
 * 希尔：最好o(nlogn),最差o(n2),这应该是逆序的情况，不稳定，相同值分配到不同组之后顺序就乱了
 * 不稳定的排序算法：：快选希堆；快排，选择排序，希尔排序，堆排序
 */
public class ShellSort {

    public int[] shellSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        // 希尔排序，需要一个增量，同一个gap的数字被分到一组先排序
        // gap逐渐递减，直到1，此时数组有序
        // 原理就是直接插入排序，当数组越有序的时候，效率越高
        int gap = arr.length / 2;
        while (gap > 0) {
            // 第一个arr[0]默认有序，同一组内第二个数就是arr[gap]
            for (int i = gap; i < arr.length; i++) {
                // 给arr[i]数据找一个合适位置
                int current = arr[i];
                // preIndex用于往前推，在同一组数据内做直接插入排序
                int preIndex = i-gap;
                while (preIndex >= 0 && arr[preIndex] > current) {
                    // 这就是在给current挪位置,类似于插入排序
                    arr[preIndex+gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = current;
            }
            gap /= 2;
        }
        return arr;
    }

}
