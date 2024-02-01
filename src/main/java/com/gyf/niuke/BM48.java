package com.gyf.niuke;

import com.alibaba.fastjson.JSON;

import java.util.PriorityQueue;

public class BM48 {
    /**
     * 取中位数
     * 核心在于把数据分别存放于两个堆中，动态维护堆的太小，保证左边的大顶堆size>=右边的小顶堆；
     * 如果两个堆大小相同，则中位数就是堆顶元素相加/2。如果左边大顶堆size大，则直接取大顶堆最大元素
     */
    public PriorityQueue<Integer> left_max = new PriorityQueue<>((o1,o2) -> o2-o1);
    public PriorityQueue<Integer> right_min = new PriorityQueue<>();
    public void Insert(Integer num) {
        left_max.offer(num);
        right_min.offer(left_max.poll());
        // 保证左边大顶堆size高于右边
        if (left_max.size() < right_min.size()) {
            left_max.offer(right_min.poll());
        }
    }

    public Double GetMedian() {
        if (left_max.size() == right_min.size()) {
            return (double) ((left_max.peek() + right_min.peek()) / 2.0);
        } else {
            return Double.valueOf(left_max.peek());
        }
    }

}
