package com.zhz.SwordOffer;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
 * 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * String s=String.valueOf(num);
 * int[] dp=new int[s.length()+1];
 * dp[0]=1;
 * dp[1]=1;
 * for (int i = 2; i <= s.length(); i++) {
 * String temp=s.substring(i-2,i);
 * if (temp.compareTo("10")>=0&&temp.compareTo("25")<=0){
 * dp[i] =dp[i-1]+dp[i-2];
 * }else {
 * dp[i]=dp[i-1];
 * }
 * }
 * return dp[s.length()];
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class JZOffer_46_把数字翻译成字符串 {
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            String temp=s.substring(i-2,i);
            if (temp.compareTo("10")>=0 && temp.compareTo("25")<=0){
                dp[i]=dp[i-1]+dp[i-2];
            }else {
                dp[i]=dp[i-1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(JZOffer_46_把数字翻译成字符串.translateNum(12258));
    }
}
