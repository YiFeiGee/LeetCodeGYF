package com.gyf.niuke;

import com.gyf.offer.util.TreeNode;

public class BM31 {

    public boolean isSymmetrical (TreeNode pRoot) {
        // write code here
        if (pRoot == null) {
            return true;
        }
        return checkTree(pRoot, pRoot);
    }

    private boolean checkTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        // 注意不能在这就判断left.val == right.val，这样刚进来就结束了，后面的执行不了，可以把判断相等放到下面递归的前面
        // 或者直接像这样判断不相等，这才是不用继续下去的条件.
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return checkTree(left.left, right.right) && checkTree(left.right, right.left);
    }

}
