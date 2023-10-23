package com.gyf.niuke;

import com.gyf.offer.util.ListNode;

import java.util.Objects;

/**
 * 链表内指定区间反转
 */
public class BM2 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        if (Objects.isNull(head) || head.next == null || m == n) {
            return head;
        }
        // 找到第m-1和n+1节点
        ListNode tmp = head;
        ListNode p = null;
        ListNode q = null;
        // 找到第m-1和n+1节点
        int i = 1;
        while(tmp != null) {
            if (i == m-1) {
                p = tmp;
            }
            if (i == n+1) {
                q = tmp;
            }
            i = i + 1;
            tmp = tmp.next;
        }
        // 反转m->n之间链表
        ListNode sonHead = head;
        if (p != null) {
            sonHead = p.next;
            p.next = null;
        }
        ListNode x = sonHead;
        ListNode y = sonHead.next;
        // 注意循环条件，y也不能等于q,即n+1节点
        while (y != null && y != q) {
            tmp = y.next;
            y.next = x;
            x = y;
            y = tmp;
        }
        // 此时子链表头是sonHead,尾是x;
        // 用m-1和n+1节点连接反转后的子链表
        // p==null情况就是m=1，头结点也在反转子链表内
        if (p != null) {
            p.next = x;
        } else {
            head.next = null;
        }
        sonHead.next = q;
        return p == null ? x : head;
    }

}
