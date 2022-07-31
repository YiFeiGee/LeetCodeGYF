package com.gyf.offer;

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

解题思路：先走一步，剩f[n-1]个台阶走法，先走两步，剩f[n-2]个台阶走法
 */
public class Q10_Solution_2 {
    public static final int NUM = 1000000007;
    public int numWays1(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 3) {
            return n;
        }
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        for (int i = 4; i <= n; i++) {
            f[i] = (f[i-1] + f[i-2]) % NUM;
        }
        return f[n];
    }

    /**
     * 空间o[1]的写法，借助两个变量存储f[n-1]和f[n-2]的值
     * @param n
     * @return
     */
    public int numWays(int n) {
        int a = 1; // 存储f[n-2]
        int b = 1; // 存储f[n-1]
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum = (a+b) % NUM;
            a = b;
            b = sum;
        }
        return sum;
    }

}
