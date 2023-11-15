package com.gyf.niuke;

import com.gyf.offer.util.TreeNode;

public class BM36 {

    boolean flag = true;
    public boolean IsBalanced_Solution (TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        getLayerHighAndCheck(pRoot);
        return flag;
    }

    private int getLayerHighAndCheck(TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }
        int left = getLayerHighAndCheck(pRoot.left);
        int right = getLayerHighAndCheck(pRoot.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }

}
