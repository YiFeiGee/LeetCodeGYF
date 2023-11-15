package com.gyf.niuke;

import com.gyf.offer.util.TreeNode;

public class BM29 {

    public boolean hasPathSum (TreeNode root, int sum) {
        // 类似深度优先，求和后要判断是否为叶子节点
        // 广度优先是一层一层往外扩展，深度是先一部分干到底
        if (root == null) {
            return false;
        }
        return trySum(root, sum, 0);
    }

    private boolean trySum(TreeNode root, int sum, int subSum) {
        if (root == null) {
            return false;
        }
        subSum = subSum + root.val;
        if (root.left == null && root.right == null && subSum == sum) {
            return true;
        }
        return trySum(root.left, sum, subSum) || trySum(root.right, sum, subSum);
    }

}
