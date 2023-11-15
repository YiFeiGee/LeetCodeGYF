package com.gyf.offer.util;

import cn.hutool.core.lang.tree.Tree;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Util {
    public static StringBuilder treeSb;
    public static void logList(ListNode head) {
        while (head != null) {
            log.info(head.val + " ");
            head = head.next;
        }
    }

    public static void logNode(Node n1) {
        while (n1 != null) {
            String randomVal;
            if (Objects.isNull(n1.random)) {
                randomVal = "null";
            } else {
                randomVal = ""+n1.random.val;
            }
            log.info(""+n1.val+"----"+randomVal);
            n1 = n1.next;
        }
    }

    public static ListNode getListByLength(Integer len) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 2; i <= len; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        return head;
    }

    public static String logTreeFirstOrder(TreeNode n1) {
        treeSb = new StringBuilder();
        if (Objects.isNull(n1)) {
            return "";
        }
        firstOrder(n1);
        return treeSb.toString();
    }

    private static void firstOrder(TreeNode n1) {
        if (Objects.isNull(n1)) {
            return;
        }
        treeSb.append(n1.val);
        firstOrder(n1.left);
        firstOrder(n1.right);
    }

    public static TreeNode getSimpleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        return root;
    }

    public static TreeNode getRightTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        return root;
    }

    public static TreeNode getSimpleBalanceTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        return root;
    }

    public static TreeNode getNotBalancetree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.left.left.right = new TreeNode(10);
        return root;
    }

    public static TreeNode getSymmetryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        return root;
    }

}
