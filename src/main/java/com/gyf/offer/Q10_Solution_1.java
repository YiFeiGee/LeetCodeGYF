package com.gyf.offer;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 */
public class Q10_Solution_1 {

    public int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i-1]%1000000007 + f[i-2]%1000000007;
        }
        return f[n] % 1000000007;
    }

}
