package com.gyf.niuke;

import cn.hutool.core.lang.tree.Tree;
import com.gyf.offer.util.TreeNode;

public class BM32 {

    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        return preOrderMerge(t1, t2);
    }

    private TreeNode preOrderMerge(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = preOrderMerge(t1.left, t2.left);
        t1.right = preOrderMerge(t1.right, t2.right);
        return t1;


    }

}
