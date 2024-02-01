package com.gyf.niuke;

import java.util.Deque;
import java.util.LinkedList;

public class BM43 {

    public Deque<Integer> stack1 = new LinkedList<>();

    public Deque<Integer> stack2 = new LinkedList<>();

    public void push(int node) {
        stack1.offerFirst(node);
        if (stack2.isEmpty()) {
            stack2.offerFirst(node);
        } else {
            if (stack2.peekFirst() < node) {
                stack2.offerFirst(stack2.peekFirst());
            } else {
                stack2.offerFirst(node);
            }
        }
    }

    public void pop() {
        stack1.pollFirst();
        stack2.pollFirst();
    }

    public int top() {
        return stack1.peekFirst();
    }

    public int min() {
        return stack2.peekFirst();
    }

}
