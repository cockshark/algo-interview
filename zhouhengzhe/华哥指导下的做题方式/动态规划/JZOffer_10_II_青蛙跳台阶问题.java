package com.zhz.datastructures.swordfingeroffer.dynamic_programming;

/**
 * @author zhouhengzhe
 * @description: todo
 * @since v1
 */
public class JZOffer_10_II_青蛙跳台阶问题 {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for (int i = 2; i <=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
