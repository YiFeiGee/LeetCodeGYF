package com.gyf.offer;

import com.gyf.offer.util.ListNode;

import java.util.Objects;

public class Q22_Solution {

    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     *
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        if (Objects.isNull(head) || k < 0) {
            return head;
        }
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int kk = length - k + 1;
        if (kk <= 0 || kk > length) {
            return head;
        }
        cur = head;
        while (cur != null && kk-- > 0) {
            if (0 == kk) {
                return cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 双指针法
     * 1 -> 2 -> 3 -> 4 -> 5
     * 比如要倒数第二个
     * 1 -> 2 -> 3 -> 4 -> 5
     *                latter   former
     * 使用两个指针，开始同时指向head,former先走k步，然后二者一起走，最后当former为空的时候，latter和former相差k步，latter即为倒数第k个
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (Objects.isNull(head) || k <= 0) {
            return head;
        }
        ListNode former = head;
        ListNode latter = head;
        while (former != null &&  k-- > 0) {
            former = former.next;
        }
        if (former == null) {
            return head;
        }
        while (former != null) {
            latter = latter.next;
            former = former.next;
        }
        return latter;
    }

}
