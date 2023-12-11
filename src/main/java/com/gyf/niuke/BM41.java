package com.gyf.niuke;

import cn.hutool.core.lang.tree.Tree;
import com.gyf.offer.util.TreeNode;

import java.util.*;

public class BM41 {

    Map<Integer, Integer> map;

    /**
     * 请根据二叉树的前序遍历，中序遍历恢复二叉树，并打印出二叉树的右视图
     *
     * 求二叉树的右视图
     * @param preOrder int整型一维数组 先序遍历
     * @param inOrder int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve (int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        map = new HashMap<>();
        for (int i = 0; i < preOrder.length; i++) {
            map.put(preOrder[i], i);
        }
        TreeNode tree = reconstract(preOrder, inOrder, 0, inOrder.length-1);
        // 层次遍历树，保留每层最后一个节点
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                if (size == 0) {
                    result.add(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        int[] r = new int[result.size()];
        int i = 0;
        for (Integer tmp : result) {
            r[i] = tmp;
            i++;
        }
        return r;
    }

    public TreeNode reconstract(int[] preOrder, int[] inOrder, int l, int r) {
        if (l > r) {
            return null;
        }
        // 找inorder中l-r之间最先在preOrder中出现的元素，就是当前的根，然后再以此分左右两边
        int preIndex = Integer.MAX_VALUE;
        int inIndex = 0;
        for (int i = l; i <= r; i++) {
            if (map.get(inOrder[i]) < preIndex) {
                inIndex = i;
                preIndex = map.get(inOrder[i]);
            }
        }
        TreeNode root = new TreeNode(inOrder[inIndex]);
        root.left = reconstract(preOrder, inOrder, l, inIndex-1);
        root.right = reconstract(preOrder, inOrder, inIndex+1, r);
        return root;
    }

}
