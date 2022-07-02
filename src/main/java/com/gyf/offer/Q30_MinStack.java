package com.gyf.offer;

import java.util.Deque;
import java.util.LinkedList;

public class Q30_MinStack {
    /** initialize your data structure here. */

    public Integer min;
    public Deque<Integer> stack;

    public Q30_MinStack() {
        min = 0;
        stack = new LinkedList<>();
    }

    public void push(int x) {
        if (x < min) {
            min = x;
        }
        stack.offerLast(x);
    }

    public void pop() {
        int pop = stack.pollLast();
        if (pop)
    }

    public int top() {
        return stack.getLast();
    }

    public int min() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
