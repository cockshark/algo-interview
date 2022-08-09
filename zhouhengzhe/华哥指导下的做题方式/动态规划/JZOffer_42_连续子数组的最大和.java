package com.zhz.datastructures.swordfingeroffer.dynamic_programming;

/**
 * @author zhouhengzhe
 * @description: todo
 * @since v1
 */
public class JZOffer_42_连续子数组的最大和 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
            }else {
                dp[i]=nums[i];
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
