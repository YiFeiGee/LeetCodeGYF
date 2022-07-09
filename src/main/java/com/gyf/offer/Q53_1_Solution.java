package com.gyf.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 */
public class Q53_1_Solution {

    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * 二分查找，先找第一次出现位置，再找最后一次，然后相减+1(注意，二分前提是数组有序)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int firstPosition = findFirstPosition(nums,target);
        if (-1 == firstPosition) {
            return 0;
        }
        int lastPosition = findLastPosition(nums,target);
        return lastPosition - firstPosition + 1;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right +1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid -1;
            }
        }
        // 其实这里没必要，因为findFirstPosition有值，这个一定有值
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

}
