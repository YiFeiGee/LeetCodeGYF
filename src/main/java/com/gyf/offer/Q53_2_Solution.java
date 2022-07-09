package com.gyf.offer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class Q53_2_Solution {

    /**
     * 求和再相减
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int sum = ((length+1) * length) / 2;
        int sumReal = 0;
        for (int num : nums) {
            sumReal += num;
        }
        return sum - sumReal;
    }

    /**
     * 异或运算，x异或y异或x = y;x异或0 = x
     * 所以只要把nums里的数挨个和0->n-1异或一遍，就得到了缺失的数，因为缺的数只能异或一次
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        int n = nums.length + 1;
        for (int i = 0; i <= n-1; i++) {
            result = result ^ i;
        }
        return result;
    }

}
