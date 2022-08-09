package com.zhz.datastructures.swordfingeroffer.dynamic_programming;

/**
 * @author zhouhengzhe
 * @description: 把数字翻译成字符串
 * @since v1
 */
public class JZOffer_46_把数字翻译成字符串 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i < s.length(); i++) {
           if (s.substring(i-2,i).compareTo("10")>=0 && s.substring(i-2,i).compareTo("25")<=0){
                dp[i]=dp[i-1]+dp[i-2];
           }else {
               dp[i]=dp[i-1];
           }
        }
        return dp[s.length()];
    }
}
