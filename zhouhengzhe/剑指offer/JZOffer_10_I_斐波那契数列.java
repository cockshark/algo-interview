package com.zhz.SwordOffer;

public class JZOffer_10_I_斐波那契数列 {

    /**
     * 递归，会超时
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return (fib(n - 1) + fib(n - 2)) / 1000000007;
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

}
