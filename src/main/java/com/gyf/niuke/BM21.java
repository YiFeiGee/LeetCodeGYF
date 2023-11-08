package com.gyf.niuke;

/**
 * 旋转数组的最小数字
 *  -- 双指针，一个头，一个尾，然后用中间的和尾比较大小，判断最小数在左半边还是右半边，达到二分的目的
 */
public class BM21 {

    public int getMinNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0, j = nums.length-1;
        while (i < j) {
            int mid = (i + j) / 2;
            // 最小值在左边 51234
            if (nums[mid] < nums[j]) {
                j = mid;
                // 最小值在右边34512
            } else if (nums[mid] > nums[j]) {
                i = mid + 1;
                // 等于时不确定，左右都有可能，只能试探一下
            } else {
                j--;
            }
        }
        return nums[i];
    }

}
