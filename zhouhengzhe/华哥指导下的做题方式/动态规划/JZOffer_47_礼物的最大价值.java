package com.zhz.datastructures.swordfingeroffer.dynamic_programming;

/**
 * @author zhouhengzhe
 * @description: todo
 * @since v1
 */
public class JZOffer_47_礼物的最大价值 {
    public int maxValue(int[][] grid) {
        int[][] dp=new int[grid.length+1][grid[0].length+1];
        dp[0][0]=grid[0][0];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
               dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
