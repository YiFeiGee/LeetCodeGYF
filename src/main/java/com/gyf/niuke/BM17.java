package com.gyf.niuke;


/**
 * 请实现无重复数字的升序数组的二分查找
 */
public class BM17 {

    public int search (int[] nums, int target) {
        // write code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        int l = 0;
        int r = len-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return - 1;
    }

}
