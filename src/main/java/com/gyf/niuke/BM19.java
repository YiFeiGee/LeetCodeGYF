package com.gyf.niuke;

/**
 * 寻找峰值
 */
public class BM19 {

    public int findPeakElement (int[] nums) {
        // write code here
        if ( nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        // 组窗口，大小是3
        int i = 0;
        int j = 2;
        while (j < nums.length) {
            if (nums[(i+j) / 2] > nums[i] && nums[(i+j)/2] > nums[j]) {
                return (i+j) / 2;
            } else {
                i++;j++;
            }
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length -1] > nums[nums.length-2]) {
            return nums.length-1;
        }
        return -1;
    }

}
