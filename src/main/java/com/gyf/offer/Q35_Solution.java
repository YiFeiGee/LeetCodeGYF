package com.gyf.offer;

import com.gyf.offer.util.Node;

import java.util.*;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 */
public class Q35_Solution {

    // 用map保存各个random对应node 的 index
    public Node copyRandomList1(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        // 遍历head,并使用map存储链表内各节点
        Node cur = head;
        int index = 0;
        Map<Node, Integer> map = new HashMap();
        Map<Integer, Node> myMap = new HashMap<>();
        cur = head.next;
        Node myHead = new Node(head.val);
        Node myCur = myHead;
        map.put(head, index);
        myMap.put(index, myHead);
        index++;
        while (cur != null) {
            Node nodeTmp = new Node(cur.val);
            myCur.next = nodeTmp;
            nodeTmp.next = null;
            // 记录原链表内各Node的序号
            map.put(cur, index);
            // 记录新链表节点的序号
            myCur = myCur.next; // 先移动到新节点
            myMap.put(index, myCur);
            cur = cur.next;
            index++;
        }
        myCur = myHead;
        cur = head;
        while (cur != null) {
            if (cur.random == null) {
                myCur.random = null;
            }else {
                Integer i = map.get(cur.random);
                myCur.random = myMap.get(i);
            }
            cur = cur.next;
            myCur = myCur.next;
        }
        return myHead;
    }

    // 方法2：因为是一一对应的，所以可以直接用List存各自节点，然后用list.indexOf()确认random是哪个node
//    public Node copyRandomList2(Node head) {
//        if (Objects.isNull(head)) {
//            return null;
//        }
//        List<Node> list = new ArrayList<>();
//        List<Node> myList = new ArrayList<>();
//        Node cur = head;
//        while (cur != null) {
//            list.add(cur);
//            myList.add(new Node(cur.val));
//            cur = cur.next;
//        }
//        for (int i = 0; i < list.size(); i++) {
//            if (i != list.size()-1) {
//                myList.get(i).next = myList.get(i+1);
//            }
//            myList.get(i).random = list.get(i).random == null ? null : myList.get(list.indexOf(list.get(i).random));
//        }
//        return myList.get(0);
//    }

    // 方法3： 回溯，同样需要记录node和新链表Node的对应关系，先利用递归往里深入创建新链表，然后等待回溯执行别的赋值操作
    // 利用新老链表的一对一关系 new.random = map.get(old.random)
    public Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!map.containsKey(head)) {
            Node headNew = new Node(head.val);
            map.put(head, headNew);
            // 递归深入创建链表，利用map获取到head.random对应的新节点random
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

}
