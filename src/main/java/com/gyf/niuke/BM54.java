package com.gyf.niuke;

import java.util.*;
import java.util.stream.Collectors;

public class BM54 {

    /**
     * BM54 三数之和
     * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
     * 难点：去重和双指针
     */
    public ArrayList<ArrayList<Integer>> threeSum (int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (num == null) {
            return result;
        }
        List<Integer> numList = Arrays.stream(num).boxed().sorted().collect(Collectors.toList());
        for (int i = 0; i < numList.size(); i++) {
            // 这里去重一定要用num[i]对比num[i-1]，因为i-1是已经处理过的，此时相邻可直接跳过，num[i-1]的搜索范围一定高于num[i],因为num[i-1]的时候，left和right范围广一些
            if (i > 0 && Objects.equals(numList.get(i), numList.get(i - 1))) {
                continue;
            }
            // 可以直接避开i是因为前面已经搜索过的，能组合尝试的都试过了
            int left = i+1;
            int right = numList.size()-1;
            while (left < right) {
                if (numList.get(left) + numList.get(right) == -numList.get(i)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(numList.get(i));list.add(numList.get(left));list.add(numList.get(right));
                    ArrayList<Integer> collect = (ArrayList<Integer>) list.stream().sorted().collect(Collectors.toList());
                    result.add(collect);
                    // 去重，相邻的相同值去掉
                    if (numList.get(left) == numList.get(left+1) && left + 1 < right) {
                        left++;
                    }
                    if (numList.get(right) == numList.get(right -1) && right - 1 > left) {
                        right--;
                    }
                    right--;left++;
                } else if (numList.get(left) + numList.get(right) > -numList.get(i)) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

}
