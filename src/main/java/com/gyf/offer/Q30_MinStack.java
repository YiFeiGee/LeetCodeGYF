package com.gyf.offer;

import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;

public class Q30_MinStack {
    /** initialize your data structure here. */

    public Deque<Integer> stack;
    public Deque<Integer> minStack;

    public Q30_MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.offerLast(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.offerLast(x);
        minStack.offerLast(Math.min(minStack.peekLast(),x));
    }

    public void pop() {
        stack.pollLast();
        minStack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int min() {
        return minStack.peekLast();
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
