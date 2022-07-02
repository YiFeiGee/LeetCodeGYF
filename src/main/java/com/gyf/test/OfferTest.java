package com.gyf.test;

import com.gyf.offer.Q30_MinStack;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

@Slf4j
public class OfferTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(12);
        deque.addLast(13);
        deque.pollFirst();
        System.out.println(deque);
    }

    @Test
    public void testQ30() {
        Q30_MinStack minStack = new Q30_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        log.info("" +minStack.min());   // --> 返回 -3.
        minStack.pop();
        log.info("" + minStack.top());     // --> 返回 0.
        log.info("" + minStack.min());   //--> 返回 -2.
    }
}
