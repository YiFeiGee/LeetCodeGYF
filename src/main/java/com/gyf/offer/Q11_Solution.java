package com.gyf.offer;

import java.util.Objects;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，
 * 并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 *  输入：numbers = [2,2,2,0,1]
 *  输出：0
 */
public class Q11_Solution {

    /**
     * 二分的要求是
     *  1. 顺序存储
     *  2. 有序
     * 这道题能用二分的意义就在于通过与numbers[right]比较，分辨出数组旋转起点在何处
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (Objects.isNull(numbers) || numbers.length == 0) {
            return -1;
        }
        int left = 0;
        int right = numbers.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                // 如果mid和right相等，则high--;
                right--;
            }
        }
        return numbers[left];
    }

}
