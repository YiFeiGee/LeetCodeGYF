package com.gyf.niuke;

import com.gyf.offer.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BM25 {

    public int[] postorderTraversal (TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        int[] arr = new int[list.size()];
        int i = 0;
        for (Integer x : list) {
            arr[i++] = x;
        }
        return arr;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traversal(root.left, list);
        traversal(root.right, list);
        list.add(root.val);
    }

}
