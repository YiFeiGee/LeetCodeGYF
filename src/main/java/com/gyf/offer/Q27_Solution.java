package com.gyf.offer;

import com.gyf.offer.util.TreeNode;

import java.util.Objects;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *    4
 *  /   \
 *  2   7
 * / \  / \
 * 1  3 6  9
 * 镜像输出：
 *
 *        4
 *      /  \
 *     7    2
 *    / \  / \
 *   9  6 3   1
 *
 *
 */
public class Q27_Solution {

    public TreeNode mirrorTree1(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        mirror(root);
        return root;
    }

    private void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return;
        }
        TreeNode mid = root.left;
        root.left = root.right;
        root.right = mid;
        mirror(root.left);
        mirror(root.right);
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
