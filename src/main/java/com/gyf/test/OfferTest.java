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

    @Test
    public void testQ26() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode child = new TreeNode(4);
        child.left = new TreeNode(1);
        Q26_Solution q26_solution = new Q26_Solution();
        log.info(JSON.toJSONString(q26_solution.isSubStructure(root,child)));
    }

    @Test
    public void testQ27() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        log.info(Util.logTreeFirstOrder(root));
        Q27_Solution q27_solution = new Q27_Solution();
        TreeNode treeNode = q27_solution.mirrorTree(root);
        log.info(JSON.toJSONString(Util.logTreeFirstOrder(treeNode)));
    }

    @Test
    public void testQ28() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(1);
        log.info(Util.logTreeFirstOrder(root));
        Q28_Solution q28_solution = new Q28_Solution();
        log.info(JSON.toJSONString(q28_solution.isSymmetric(root)));
    }

    @Test
    public void testQ10_1() {
        Q10_Solution_1 q10_solution1 = new Q10_Solution_1();
        log.info(q10_solution1.fib(100)+"");
    }

    @Test
    public void testQ10_2() {
        Q10_Solution_2 q10_solution_2 = new Q10_Solution_2();
        log.info(String.valueOf(q10_solution_2.numWays(5)));
    }

    @Test
    public void testQ63() {
        Q63_Solution q63_solution = new Q63_Solution();
        int[] x = {7,1,5,3,6,4};
        log.info(String.valueOf(q63_solution.maxProfit(x)));
    }

    @Test
    public void testQ42() {
        Q42_Solution q42_solution = new Q42_Solution();
        int[] x = {-2,1,-3,4,-1,2,1,-5,4};
        log.info(String.valueOf(q42_solution.maxSubArray(x)));
    }

    @Test
    public void testQ47() {
        Q47_Solution q47_solution = new Q47_Solution();
        int[][] x = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        log.info(String.valueOf(q47_solution.maxValue(x)));
    }

    @Test
    public void testQ46() {
        Q46_Solution q46_solution = new Q46_Solution();
        int i = q46_solution.translateNum(12258);
        log.info(String.valueOf(i));
    }

    @Test
    public void testQ48() {
        Q48_Solution q48_solution = new Q48_Solution();
        log.info(String.valueOf(q48_solution.lengthOfLongestSubstring1("abba")));
    }

    @Test
    public void testQ18() {
        Q18_Solution q18_solution = new Q18_Solution();
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(8);
        Util.logList(head);
        q18_solution.deleteNode(head, 5);
        Util.logList(head);
    }

    @Test
    public void testQ22() {
        Q22_Solution q22_solution = new Q22_Solution();
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(8);
        Util.logList(head);
        ListNode kthFromEnd = q22_solution.getKthFromEnd(head, 2);
        Util.logList(kthFromEnd);
    }

    @Test
    public void testQ25() {
        Q25_Solution q25_solution = new Q25_Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = q25_solution.mergeTwoLists(l1, l2);
        Util.logList(listNode);
    }

    @Test
    public void test26() {
        log.info("hello world");
    }
}
