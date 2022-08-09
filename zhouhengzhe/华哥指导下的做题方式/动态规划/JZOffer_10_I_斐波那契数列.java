package com.zhz.datastructures.swordfingeroffer.dynamic_programming;

/**
 * @author zhouhengzhe
 * @description: todo
 * @since v1
 */
public class JZOffer_10_I_斐波那契数列 {
    public int fib(int n) {
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
