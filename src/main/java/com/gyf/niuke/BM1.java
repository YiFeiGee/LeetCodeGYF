package com.gyf.niuke;

import com.gyf.offer.util.ListNode;

import java.util.Objects;

/**
 * 反转链表
 */
public class BM1 {
    public ListNode ReverseList (ListNode head) {
        // write code here
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        // p指向前一个，q指向后一个
        ListNode p = head;
        ListNode q = p.next;
        ListNode tmp = null;
        while (q != null) {
            tmp = q.next;
            q.next = p;
            p = q;
            q = tmp;
        }
        head.next = null;
        return p;
    }
}
