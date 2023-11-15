package com.gyf.niuke;

import com.gyf.offer.util.TreeNode;

public class BM33 {

    public TreeNode Mirror (TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        TreeNode tmp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right =tmp;
        pRoot.left = Mirror(pRoot.left);
        pRoot.right = Mirror(pRoot.right);
        return pRoot;
    }

}
