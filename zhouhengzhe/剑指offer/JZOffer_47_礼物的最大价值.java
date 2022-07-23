package com.zhz.SwordOffer;

/**
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class JZOffer_47_礼物的最大价值 {
    public int maxValue(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        dp[0][0] = grid[0][0];
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[grid.length][grid[0].length];
    }

    public static void main(String[] args) {
        JZOffer_47_礼物的最大价值 jzOffer_47_礼物的最大价值 = new JZOffer_47_礼物的最大价值();
        System.out.println(jzOffer_47_礼物的最大价值.maxValue(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        }));
    }

}
