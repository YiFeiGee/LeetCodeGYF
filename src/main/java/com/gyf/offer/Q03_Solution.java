package com.gyf.offer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 */
@Slf4j
public class Q03_Solution {

    public int findRepeatNumber1(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        log.info(JSON.toJSONString(collect));
        int x = 0;
        for (int i = 1; i < collect.size(); i++) {
            if (Objects.equals(collect.get(i),collect.get(i-1))) {
                x = collect.get(i);
                break;
            }
        }
        return x;
    }

    /**
     * i和nums[i]对应上，如果对不上，就进行交换，交换过程中如果发生nums[nums[i]] == nums[i]，则说明重复了
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                // 交换直至相等 把下标为i和nums[i]的值交互
                while (nums[i] != i) {
                    if (nums[nums[i]] == nums[i]) {
                        return nums[i];
                    }
                    int x = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = x;
                }
            }
        }
        return 0;
    }

}
