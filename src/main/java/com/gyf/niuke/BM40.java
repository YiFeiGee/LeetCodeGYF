package com.gyf.niuke;

import com.gyf.offer.util.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BM40 {

    Map<Integer, Integer> map;
    /**
     * 先序和中序遍历结果重建二叉树
     *
     *
     * @param preOrder int整型一维数组
     * @param vinOrder int整型一维数组
     * @return TreeNode类
     */
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        // write code here
       map = new HashMap<>();
       // 记录先序遍历下标，后面会用这个比较谁先出现，谁是根
        for (int i = 0; i < preOrder.length; i++) {
            map.put(preOrder[i], i);
        }
        return tryConstract(preOrder, vinOrder, 0, preOrder.length-1);
    }

    /**
     *
     * @param preOrder
     * @param vinOrder
     * @param l 中序遍历中当前子树范围的左区间
     * @param r 右区间
     * @return
     */
    private TreeNode tryConstract(int[] preOrder, int[] vinOrder, int l, int r) {
        // 递归结束条件
        if (l > r) {
            return null;
        }
        // 先生成当前根节点，根节点应是l-r之间先出现的,这里是最关键的
        int preIndex = Integer.MAX_VALUE;
        int vinIndex = 0;
        for (int i = l; i <= r; i++) {
            // map.get()是得到在preOrder内的Index，rootIndex是vinOrder内的下标
            if (map.get(vinOrder[i]) < preIndex) {
                preIndex = map.get(vinOrder[i]);
                vinIndex = i;
            }
        }
        // 生成新根节点
        TreeNode root = new TreeNode(vinOrder[vinIndex]);
        // rootIndex这里一分为二
        root.left = tryConstract(preOrder, vinOrder, l, vinIndex-1);
        root.right = tryConstract(preOrder, vinOrder, vinIndex+1, r);
        return root;
    }

    

}
