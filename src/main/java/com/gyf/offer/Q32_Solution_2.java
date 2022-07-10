package com.gyf.offer;

import com.gyf.offer.util.TreeNode;

import java.util.*;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Q32_Solution_2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int len = deque.size(); // 注意这个，不能在for循环里用deque.size动态获取长度，否则队列长度一直在变
            for (int i = 0; i < len; i++) {
                TreeNode poll = deque.poll();
                level.add(poll.val);
                if (Objects.nonNull(poll.left)) {
                    deque.add(poll.left);
                }
                if (Objects.nonNull(poll.right)) {
                    deque.add(poll.right);
                }
            }
            result.add(level);
        }
        return result;
    }

}
