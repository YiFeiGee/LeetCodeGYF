package com.gyf.niuke;

import cn.hutool.core.lang.tree.Tree;
import com.gyf.offer.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class BM27 {

    public ArrayList<ArrayList<Integer>> Print (TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> collect = new LinkedList<>();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                collect.offer(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            if (flag) {
                while (!collect.isEmpty()) {
                    list.add(collect.pollLast());
                }
            } else {
                while (!collect.isEmpty()) {
                    list.add(collect.pollFirst());
                }
            }
            flag = !flag;
            result.add(list);
        }
        return result;
    }

}
