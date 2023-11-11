package com.gyf.niuke;

import com.gyf.offer.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BM23 {

    int i = 0;

    public int[] preorderTraversal (TreeNode root) {
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

}
