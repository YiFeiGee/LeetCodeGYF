package com.gyf.test;

import com.alibaba.fastjson.JSON;
import com.gyf.offer.*;
import com.gyf.offer.util.ListNode;
import com.gyf.offer.util.Node;
import com.gyf.offer.util.TreeNode;
import com.gyf.offer.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

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
        Q30_Solution minStack = new Q30_Solution();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        log.info("" +minStack.min());   // --> 返回 -3.
        minStack.pop();
        log.info("" + minStack.top());     // --> 返回 0.
        log.info("" + minStack.min());   //--> 返回 -2.
    }

    @Test
    public void testQ03() {
        Q03_Solution q03_solution = new Q03_Solution();
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(q03_solution.findRepeatNumber(arr));
    }

    @Test
    public void testQ06() {
        Q06_Solution q06_solution = new Q06_Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        ListNode tmp = head;
        tmp = tmp.next;
        System.out.println(tmp.val);
        System.out.println(head.val);
//        System.out.println(JSON.toJSONString(q06_solution.reversePrint(head)));
    }

    @Test
    public void testQ24() {
        Q24_Solution q24_solution = new Q24_Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode tmp = q24_solution.reverseList(head);
        Util.logList(tmp);
    }

    @Test
    public void testQ35() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        n1.random = null;
        n2.random = n1;
        n3.random = n2;
        n4.random = n4;
        Q35_Solution q35_solution = new Q35_Solution();
        Util.logNode(n1);
        Node node = q35_solution.copyRandomList(n1);
        System.out.println("-----------------------------------------");
        Util.logNode(node);
    }


    @Test
    public void testListArray() {
        List<String> list = new ArrayList<>(Arrays.asList("123","345"));
        Object[] objects = list.toArray();
        String[] strings = list.toArray(new String[0]);
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,2,3,4));
        Object[] objects1 = integerList.toArray();
        integerList.toArray(new Integer[0]);
    }

    @Test
    public void testQ04() {
        int[][] matrix = {
                {-5}
        };
        Q04_Solution q04_solution = new Q04_Solution();
        q04_solution.findNumberIn2DArray(matrix, -10);
    }

    @Test
    public void testQ32() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Q32_Solution_3 q32_solution3 = new Q32_Solution_3();

        log.info(JSON.toJSONString(q32_solution3.levelOrder(root)));
    }
}
