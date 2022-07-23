package com.zhz.SwordOffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * 提示：
 * <p>
 * 0 <= n <= 100
 */
public class JZOffer_10_II_青蛙跳台阶问题 {
    /**
     * 动态规划
     *
     * @param n
     * @return
     */
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

    public static void main(String[] args) {
        JZOffer_10_II_青蛙跳台阶问题 jzOffer_10_ii_青蛙跳台阶问题=new JZOffer_10_II_青蛙跳台阶问题();
        System.out.println(jzOffer_10_ii_青蛙跳台阶问题.numWays(7));
    }
}
