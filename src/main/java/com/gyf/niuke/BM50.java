package com.gyf.niuke;

import java.util.HashMap;
import java.util.Map;

public class BM50 {

    /**
     * BM50 两数之和
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                // number[i]的i一定比target-number[i]值对应下标的序号大，因为只有前面出现了，后面才能利用上这个值
                return new int[]{map.get(target - numbers[i])+1, i+1};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[]{-1};
    }

}
