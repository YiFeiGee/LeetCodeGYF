package com.gyf.offer;

import com.gyf.offer.util.TreeNode;

import java.util.Objects;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *  给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 */
public class Q26_Solution {
    public StringBuilder sbA = new StringBuilder();
    public StringBuilder sbB = new StringBuilder();
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (Objects.isNull(A) || Objects.isNull(B)) {
            return false;
        }
        firstOrder(A);
        firstOrder(B);
        return sbA.toString().contains(sbB.toString());
    }

    private void firstOrder(TreeNode a) {
        if (Objects.nonNull(a)) {
            sbA.append(a.val);
            firstOrder(a.left);
            firstOrder(a.right);
        }
    }
}
