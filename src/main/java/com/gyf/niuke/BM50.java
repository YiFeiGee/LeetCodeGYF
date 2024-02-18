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
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[]{-1};
    }

}
