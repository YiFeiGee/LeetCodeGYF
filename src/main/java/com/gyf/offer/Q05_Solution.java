package com.gyf.offer;

public class Q05_Solution {

    /**
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     */
    /**
     * 可以用双指针法，C++可以在原str内存里扩展大小，实现o(1)的空间，但是时间还是o(n)
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                sb.append("%20");
            } else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }
}
