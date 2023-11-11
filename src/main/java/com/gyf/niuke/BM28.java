package com.gyf.niuke;

import com.gyf.offer.util.TreeNode;

public class BM28 {

    public int maxDepth (TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        return depth(root, 0);
    }

    private int depth(TreeNode root, int length) {
        if (root == null) {
            return length;
        }
        length++;
        return Math.max(depth(root.left, length), depth(root.right,length));
    }

}
