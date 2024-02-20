package com.gyf.niuke;

public class BM53 {

    /**
     * 这种题如果有一个辅助的工具记录其实就会简单，比如给你个Map或者数组，不就很容易标记了吗
     * 但是题目规定了O(1)的空间复杂度，这时候就可以考虑这个现成的自带数组Nums,就用自带的nums做标记不就满足题意了吗
     * 利用数组下标0---（n-1），标记1-n这些数就行了，但是呢在原数组上操作，就要考虑还原性，别把数组后面值搞坏了，就不能遍历后面数标记了，
     * 比如i=1时，n[1]=4,那就把n[4-1] = -n[4-1],这时候其实n[3]的值其实没破坏，当i=3时，取绝对值就行了
     * 第一步消灭所有负数，然后遍历并标记，最后遍历数组，第一个非0的，就是位置上没有对应值的
     * @param nums
     * @return
     */
    public int minNumberDisappeared (int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        // 第一步，干掉所有负数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                // 要选一个不影响后面判断的数，不能是负数，也不能是1-n之间的数
                nums[i] = length + 1;
            }
        }
        // 第二步，遍历并标记
        for (int i = 0; i < nums.length; i++) {
            // 只处理1-n之间的数
            if (Math.abs(nums[i]) <= length) {
                // 记得加绝对值,因为数组值可能被前面变成负数
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // i是下标，i+1才是返回值
                return i+1;
            }
        }
        // 这是没找到
        return length+1;

    }

}
