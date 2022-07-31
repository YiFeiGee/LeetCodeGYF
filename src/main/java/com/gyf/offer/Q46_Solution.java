package com.gyf.offer;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class Q46_Solution {

    public int translateNum(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        if (chars.length <= 1) {
            return 1;
        }
        int[] dp = new int[chars.length];
        dp[0] = 1;
        int sum = (chars[0] - '0') * 10 + (chars[1]-'0');
        if (sum > 25) {
            dp[1] = 1;
        } else {
            dp[1] = 2;
        }
        for (int i = 2; i < chars.length; i++) {
            int result = (chars[i - 1] - '0') * 10 + (chars[i] - '0');
            if (10 <= result && result <= 25) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[chars.length-1];
    }

}
