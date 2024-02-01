package com.gyf.niuke;

import cn.hutool.core.util.NumberUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BM46 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param input int整型一维数组
     * @param k int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null) {
            return result;
        }
        quickSearch(input, 0, input.length-1, result, k);
        return result;
    }

    public void quickSearch(int[] input, int low, int high, ArrayList<Integer> result, int k) {
        if (low > high) {
            return;
        }
        int start = low;
        int last = high;
        // 一直循环，直到前面都比num[start]小，后面都比num[start]大
        while (low < high) {
            // 从前往后找个比num[start]大的，带个等号的目的也是跳过low==start，即跳过第一个
            while (low < high && input[low] <= input[start]) {
                low++;
            }
            // 从后往前找个比num[start]小的
            while (low < high && input[high] >= input[start]) {
                high--;
            }
            // 两个值交换, low==high的交换没有意义
            if (low < high) {
                swapArr(input, low, high);
            }
        }
        // 到这里一定是low==high
        swapArr(input, start, high);
        if (k == high) {
            for (int i = 0; i < high; i++) {
                result.add(input[i]);
            }
            return;
        }
        // 这里就是截断，只要最小的前k个数，前面有序无序没关系，是小数就行
        if (k < high) {
            quickSearch(input, start, high-1, result, k);
        }
        if (k > high) {
            quickSearch(input, high+1, last, result, k);
        }
    }

    public void swapArr(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

}
