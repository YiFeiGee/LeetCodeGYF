package com.gyf.niuke;

import com.gyf.offer.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BM23 {

    int i = 0;

    public int[] preorderTraversal1 (TreeNode root) {
        List<Integer> list = new ArrayList();
        traversal(root, list);
        int[] arr = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            arr[i++] = integer;
        }
        return arr;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        list.add(root.val);
        if (root.left != null) {
            traversal(root.left, list);
        }
        if (root.right != null) {
            traversal(root.right, list);
        }
    }

    /**
     * 利用堆栈实现先序遍历,注意这个从右往左加子节点的过程
     * @param root
     * @return
     */
    public int[] preorderTraversal (TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pollFirst();
            list.add(treeNode.val);
            if (treeNode.right != null) {
                stack.offerFirst(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.offerFirst(treeNode.left);
            }
        }
        int[] arr = new int[list.size()];
        for (int i1 = 0; i1 < list.size(); i1++) {
            arr[i1] = list.get(i1);
        }
        return arr;
    }

}
