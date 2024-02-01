package com.gyf.niuke;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BM45 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param num int整型一维数组
     * @param size int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> maxInWindows1 (int[] num, int size) {
        // write code here
        if (num == null) {
            return new ArrayList<>();
        }
        if (num.length < size || size <= 0) {
            return null;
        }
        int i = 0,j = size-1;
        ArrayList<Integer> result = new ArrayList<>();
        while (j < num.length) {
            int x = i;
            int max = Integer.MIN_VALUE;
            while (x <= j) {
                if (max < num[x]) {
                    max = num[x];
                }
                x++;
            }
            result.add(max);
            i++;j++;
        }
        return result;
    }

    public ArrayList<Integer> maxInWindows (int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size == 0 || size > num.length) {
            return list;
        }
        // 用一个双端队列控制窗口内元素
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            // 最后一个元素只要比当前小，就出队列
            while (!queue.isEmpty() && num[queue.peekLast()] < num[i]) {
                queue.pollLast();
            }
            // 当前元素入队，用下标入队，方便判断队头元素是否过期
            queue.offerLast(i);
            // 判断队头元素是否过期
            if (queue.peekFirst() + size <= i) {
                queue.pollFirst();
            }
            // 若当前i已形成窗口，就取队头元素作为当前窗口最大值
            if (i + 1 >= size) {
                list.add(num[queue.peekFirst()]);
            }
        }
        return list;
    }

}
