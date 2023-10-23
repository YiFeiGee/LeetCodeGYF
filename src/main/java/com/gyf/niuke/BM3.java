package com.gyf.niuke;

import cn.hutool.Hutool;
import cn.hutool.core.util.NumberUtil;
import com.gyf.offer.util.ListNode;
import com.gyf.offer.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表中的节点每k个一组翻转
 */
public class BM3 {

    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }
        int time = len / k ;
        ListNode llist = new ListNode(-1);
        llist.next = head;
        // 循环，每k个一组反转
        ListNode sonHead = head;
        ListNode groupPre = llist;
        ListNode p = llist;
        ListNode q = llist.next;
        while (time-- > 0) {
            int i = 0;
            p = q;
            q = q.next;
            ListNode x = null;
            // k个数字一组只需要反转k-1次
            while (i++ < k-1 && q != null) {
                x = q.next;
                q.next = p;
                p = q;
                q = x;
            }
            // 把当前反转后的和前后组连一起
            sonHead.next = q;
            groupPre.next = p;
            groupPre = sonHead;
            sonHead = q;
        }
        return llist.next;
    }

}
