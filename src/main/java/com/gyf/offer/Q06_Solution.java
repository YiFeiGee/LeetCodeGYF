package com.gyf.offer;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import com.gyf.offer.util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Q06_Solution {

    // 1、 借助栈\或者读取到list然后逆序输出
    public int[] reversePrint1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(size-i-1);
        }
        return result;
    }

    // 2.若一直链表长度，则放的时候反过来放就可以了

    // 3.递归获取链表长度，利用回溯放置元素
    int[] res;
    public int[] reversePrint(ListNode head) {
        backReverse(head, 0);
        return res;
    }

    /**
     * 方法内一定有个参数代表递归的深度，即链表长度
     * @param cur
     * @param length
     * @return
     */
    private int backReverse(ListNode cur, int length) {
        if (Objects.isNull(cur)) {
            res = new int[length];
            return 0;// 结束标志
        }
        int index = backReverse(cur.next, length+1);
        res[index] = cur.val;
        return index + 1;
    }


}
