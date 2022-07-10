package com.gyf.offer;

import com.gyf.offer.util.TreeNode;

import java.util.*;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *    [3,9,20,15,7]
 */
public class Q32_Solution_1 {

    public int[] levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            result.add(poll.val);
            if (Objects.nonNull(poll.left)) {
                queue.add(poll.left);
            }
            if (Objects.nonNull(poll.right)) {
                queue.add(poll.right);
            }
        }
        int[] retArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            retArr[i] = result.get(i);
        }
        return retArr;
    }

}
