package com.gyf.offer;


import java.util.Objects;

public class Q58_Solution {
    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *  输入: s = "abcdefg", k = 2
     *  输出: "cdefgab"
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords1(String s, int n) {
        if (Objects.isNull(s)) {
            return null;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0,n);
    }

    /**
     * 分享一个C++的做法，这个解法是解旋转数组的一个办法，有兴趣的可以先做一下 189.旋转数组，解法是一样的
     */

    /*
    class Solution {
    private:
    void reverse(string&s,int left,int right)
    {
        while(left<=right)
        {
            swap(s[left],s[right]);
            ++left;
            --right;
        }
    }
public:
    string reverseLeftWords(string s, int n) {
        int num = s.size()-1;

        reverse(s,0,num);
        reverse(s,0,num-n);
        reverse(s,num-n+1,num);

        return s;
    }
};
     */
}
