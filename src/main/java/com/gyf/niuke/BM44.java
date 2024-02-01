package com.gyf.niuke;

import java.util.Deque;
import java.util.LinkedList;

public class BM44 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if ('(' == charArray[i] || '{' == charArray[i] || '[' == charArray[i]) {
                stack.offerFirst(charArray[i]);
            }
            if (')' == charArray[i] || '}' == charArray[i] || ']' == charArray[i]) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (checkIsPair(stack.peekFirst(), charArray[i])) {
                    stack.pollFirst();
                } else {
                    stack.offerFirst(charArray[i]);
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean checkIsPair(char a, char b) {
        if (a == '('  && b == ')') {
            return true;
        }
        if (a == '{' && b == '}') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }
        return false;
    }

}
