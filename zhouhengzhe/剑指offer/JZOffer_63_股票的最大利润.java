package com.zhz.SwordOffer;

/**
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 10^5
 */
public class JZOffer_63_股票的最大利润 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            cost = Math.min(cost, prices[i]);
            max = Math.max(max, prices[i] - cost);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,0,4,3,1};
        JZOffer_63_股票的最大利润 jzOffer_63_股票的最大利润 = new JZOffer_63_股票的最大利润();
        System.out.println(jzOffer_63_股票的最大利润.maxProfit(prices));
    }
}
