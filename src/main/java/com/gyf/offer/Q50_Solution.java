package com.gyf.offer;

import java.util.*;

public class Q50_Solution {

    /**
     * 用map记录次数，然后再遍历取第一个
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (Objects.isNull(s)) {
            return ' ';
        }
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : s.toCharArray()) {
            if (Objects.nonNull(map.get(c)) && map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 借助与队列，队列先进先出，可以记录先进入的顺序
     */
    public char firstUniqChar2(String s) {
        if (Objects.isNull(s)) {
            return ' ';
        }
        Deque<Character> deque = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
            // 刚刚塞过一个，所以只能是1，超过1就是重复字母
            if (map.get(c) == 1) {
                deque.offer(c);
            }
            while (!deque.isEmpty() && map.get(deque.peek()) > 1) {
                deque.poll();
            }
        }
        return deque.isEmpty() ? ' ' : deque.peek();
    }

}
