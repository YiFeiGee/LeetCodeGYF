package com.gyf.niuke.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序：稳定，o(n+k),空间复杂度o(n+k)
 *
 * 基数排序 vs 计数排序 vs 桶排序
 * 这三种排序算法都利用了桶的概念，但对桶的使用方法上有明显差异(分桶的计算方式)：
 * 基数排序：根据键值的每位数字来分配桶,相当于对每一位数字都做了一次桶排序
 * 计数排序：每个桶只存储单一键值
 * 桶排序：每个桶存储一定范围的数值
 */
public class RadixSort {

    public int[] radixSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        // 取最大的数，检查需要循环几次，有几位就需要循环几次
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        int maxCnt = 0;
        while (max > 0) {
            max /= 10;
            maxCnt++;
        }
        // 最大数有maxCnt位，那整个按位分桶就要进行三次
        int num = 1;
        while (maxCnt-- > 0) {
            // 基数排序是根据每位键值来分配，每一位数字范围是0-9，所以辅助数组len=10
            // 每一位都需要新建，因为每位情况不一样，上一位结果如果带入就会影响当前位数据
            List<List<Integer>> radixes = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                radixes.add(new ArrayList<>());
            }
            //  先进行第一次分桶
            for (int i : arr) {
                radixes.get((i / num) % 10).add(i);
            }
            // arr的下标，把radixes 桶数组内数据重新送入arr中
            int k = 0;
            // 把lists内结果打散送入result数组内
            for (List<Integer> list : radixes) {
                for (Integer i : list) {
                    arr[k++] = i;
                }
            }
            num *= 10;
        }
        return arr;
    }
}
