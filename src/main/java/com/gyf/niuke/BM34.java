package com.gyf.niuke;

import com.gyf.offer.util.TreeNode;

public class BM34 {

    int pre = Integer.MIN_VALUE;
    public boolean isValidBST (TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        int val = root.val;
        if (val < pre) {
            return false;
        }
        pre = val;
        return left && isValidBST(root.right);
    }

}
