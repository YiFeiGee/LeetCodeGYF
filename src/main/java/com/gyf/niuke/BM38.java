package com.gyf.niuke;

import com.gyf.offer.util.TreeNode;

import java.util.*;

public class BM38 {

    public int lowestCommonAncestor1 (TreeNode root, int o1, int o2) {
        if (root == null) {
            return -1;
        }
        // 利用层次遍历记录下每个节点的父节点
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Map<Integer, Integer> parentMap = new HashMap<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                parentMap.put(poll.left.val, poll.val);
                queue.add(poll.left);
            }
            if (poll.right != null) {
                parentMap.put(poll.right.val, poll.val);
                queue.add(poll.right);
            }
        }
        // 利用parentMap先记录下o1节点的路径
        int tmp = o1;
        List<Integer> o1Path = new ArrayList<>();
        o1Path.add(o1);
        while (parentMap.get(tmp) != null) {
            o1Path.add(parentMap.get(tmp));
            tmp = parentMap.get(tmp);
        }
        // 此时只需要在o2路径里找到一个o1Path有的节点就是最近公共祖先
        while (!o1Path.contains(o2)) {
            o2 = parentMap.get(o2);
        }
        return o2;
    }

    /**
     * 递归的方式还是老套路，究竟o1和o2是不是在当前节点的左右两边
     * 如果都在左边，就应该往左搜索
     * 如果都在右边，就该往右搜索
     * 若正好一左一右，当前节点就是最近公共祖先
     * -----因此：问题的重点在于怎么确定o1和o2在当前节点的哪边
     * ------遍历树的时候就需要同时判断o1和o2在哪
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        if (root == null) {
            return -1;
        }
        
        TreeNode same = getSameFather(root, o1, o2);
        return same.val;
    }

    /**
     * 在哪边找到节点就返回哪边节点
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    private TreeNode getSameFather(TreeNode root, int o1, int o2) {
        // 这种说明没找到，找到就该提前返回的
        if (root == null) {
            return null;
        }
        // 找到了就该返回，提前结束
        // 树内没有重复的值，不可能出现左右子树都找到o1
        if (root.val == o1 || root.val == o2) {
            return root;
        }
        // 此时就该搜索左右子树
        TreeNode left = getSameFather(root.left, o1, o2);
        TreeNode right = getSameFather(root.right, o1, o2);
        // 左边没找到，就在右边
        if (left == null) {
            return right;
        }
        // 右边没找到，就在左边，二叉树就是二选一
        if (right == null) {
            return left;
        }
        // 两个都不是空，说明正好一左一右，也就是最近的公共祖先
        return root;
    }

}
