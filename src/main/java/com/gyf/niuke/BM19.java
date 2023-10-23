package com.gyf.niuke;

/**
 * 寻找峰值
 */
public class BM19 {

    public int findPeakElement1 (int[] nums) {
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


    // 抓住一个特点，任意一个峰值，就把一个大问题拆成了小问题
    // 关键在于如何实现这种log2n的时间复杂度，必须可以用条件一次性过滤掉一半数据
    // 凸峰如果出现，一定是在大的一边，只要右边大，就继续往右找，因为这种情况下一定会出行凸峰
    // 所以需要用nums[mid]和nums[mid+1]比较
    public int findPeakElement (int[] nums) {
        if (nums == null) {
            return -1;
        }
        int l = 0, r = nums.length-1, mid = 0;
        while (l < r) {
            mid = (l+r) / 2;
            // 注意这里mid要保留，不能用mid-1；因为nums[mid]是大的数，很可能这就是一个峰
            // 题目强调了相邻元素不会相等，其实如果没有这个条件，不能这样直接二分
            if (nums[mid] > nums[mid+1]) {
                r = mid;
            //右边是往上，一定能找到波峰
            } else {
                l = mid+1;
            }
        }
        return l;
    }



}
