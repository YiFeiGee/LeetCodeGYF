package com.gyf.niuke;

import com.gyf.offer.util.ListNode;
import com.gyf.offer.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BM30 {

    // 这只算定义了指针，不算定义了新节点
    TreeNode pre = null;
    TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        midOrder(pRootOfTree);
        return head;
    }

    private void midOrder(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        midOrder(pRootOfTree.left);
        // 说明这是最左边节点，也就是第一个打头的节点
        if (pre == null) {
            head = pRootOfTree;
        } else {
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        midOrder(pRootOfTree.right);
    }

}
