package com.gyf.offer;

import com.gyf.offer.util.TreeNode;

import java.util.*;
import java.util.logging.Level;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Q32_Solution_3 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 引入变量控制存值的方向
        boolean leftControl = Boolean.FALSE;
        while (!queue.isEmpty()) {
            int len = queue.size();
            Deque<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                if (leftControl) {
                    levelList.offerFirst(poll.val);
                } else {
                    levelList.offerLast(poll.val);
                }
                if (Objects.nonNull(poll.left)) {
                    queue.offer(poll.left);
                }
                if (Objects.nonNull(poll.right)) {
                    queue.offer(poll.right);
                }
            }
            leftControl = !leftControl;
            result.add(new LinkedList<>(levelList));
        }
        return result;
    }

}
