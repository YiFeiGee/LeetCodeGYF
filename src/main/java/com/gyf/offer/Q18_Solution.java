package com.gyf.offer;

import com.gyf.offer.util.ListNode;

import java.util.Objects;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class Q18_Solution {

    public ListNode deleteNode(ListNode head, int val) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        head = pre;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return head.next;
    }

}
