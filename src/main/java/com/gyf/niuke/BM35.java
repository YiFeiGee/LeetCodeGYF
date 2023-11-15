package com.gyf.niuke;

import cn.hutool.core.lang.tree.Tree;
import com.gyf.offer.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class BM35 {

    /**
     * 判断是否为完全二叉树，层次遍历时判断
     * 每层遍历时，前一个出现过null，后面若出现非空节点，就说明此树不符合完全二叉树要求
     * @param root
     * @return
     */
    public boolean isCompleteTree (TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 这不是纯层次遍历，这是单层循环，因为会存在上层有遗漏节点，依赖下层循环时判断
        // 一句话，完全二叉树这样遍历时肯定是非空-非空-非空-非空-非空。。。。后面全null，不可能出现前面有null，后面又有非null情况
        boolean layerFlag = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                layerFlag = true;
                // 当前节点为空，截断程序，继续下一个，因为当前层null-null连续是可以的
                continue;
            }
            // flag为true时还能访问到此，说明前面有过Null节点，后面又出现了非null节点，这是不允许的
            if (layerFlag) {
                return false;
            }
            // 这里就不能再只塞入非null节点了，因为下一层的判断(即上述判断依赖null节点)
            queue.offer(poll.left);
            queue.offer(poll.right);

        }
        return true;
    }

}
