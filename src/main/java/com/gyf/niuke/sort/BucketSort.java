package com.gyf.niuke.sort;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

/**
 * 桶排序：稳定，最好o(n+k),最差o(n2),空间复杂度：o(n+k)
 * 桶排序其实是一种计数排序的优化版，计数排序有个很大的问题就是最大值和最小值差应该是有范围的
 * 否则辅助数组的大小没办法控制，这时候就应该考虑限制辅助数组的大小，延伸出了桶排序，做一个二维数组，纵向延伸桶
 */
public class BucketSort {

    /**
     *
     * @param arr
     * @param bucketSize 桶的大小，纵向数组的大小
     * @return
     */
    public int[] bucketSort(int[] arr, int bucketSize) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        // 计算最大值最小值
        int max = arr[0];
        int min = arr[1];
        for (int k : arr) {
            if (k > max) {
                max = k;
            }
            if (k < min) {
                min = k;
            }
        }
        // 计算辅助数组的大小，横向的桶长度(max-min)/bucketSize+1
        // 从这里就能看出来桶排序和计数排序的区别，桶排序希望控制横向数组的大小，通过纵向延伸减少横向数组的空间浪费
        // 原数组值映射到辅助数组，就应该用(value-min)/bucketSize
        int bucketCnt = (max-min)/bucketSize + 1;
        // 创建辅助数组
        List<List<Integer>> buckets = new ArrayList<>(bucketCnt);
        // 注意这里循环用bucketCnt，因为buckets还没有初始化
        for (int i = 0; i < bucketCnt; i++) {
            buckets.add(new ArrayList<>());
        }
        // 遍历原值数组，将值映射到桶中
        for (int j : arr) {
            // arr[i]落到哪个桶的计算方式，(arr[i]-min)/bucketSize，bucketCnt是长度所以要加一，这里是下标就不需要+1
            buckets.get((j - min) / bucketSize).add(j);
        }
        // 将桶内的子数组排序
        for (List<Integer> bucket : buckets) {
            sort(bucket);
        }
        // 将桶内所有元素取出
        List<Integer> result = new ArrayList<>();
        for (List<Integer> bucket : buckets) {
            result.addAll(bucket);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
