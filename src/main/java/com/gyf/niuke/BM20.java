package com.gyf.niuke;


import com.alibaba.fastjson.JSON;

/**
 * 数组中的逆序对
 */
public class BM20 {

    public int mod = 1000000007;
    public int[] tmp;
    public int ret = 0;
    // 归并排序，归并是两两合并，合并的时候会比较子集大小，正好可以逆序对的个数
    // 递归子问题->归并排序
    public int InversePairs (int[] nums) {
        // write code here
        if (nums == null || nums.length <= 1 ) {
            return 0;
        }
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1);
        return ret;
    }

    private void mergeSort(int[] nums, int l, int r) {
        // 决定递归退出条件,只有一个数时退出
        if (l >= r) {
            return;
        }
        // 分左右两边
        int mid = l + (r - l) / 2;
        // 左边排序
        mergeSort(nums, l, mid);
        // 右边排序
        mergeSort(nums, mid + 1, r);
        // 两组合并
        merge(nums, l, mid, r);
    }

    // 合并两个有序数组
    private void merge(int[] nums, int l, int mid, int r) {
        int i = l, j = mid+1, k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                // 这里是属于逆序对
                ret = (ret + mid- i + 1) % mod;
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= r) {
            tmp[k++] = nums[j++];
        }
        for (k = 0, i = l; k < r-l+1; k++, i++) {
            nums[i] = tmp[k];
        }
    }
}
