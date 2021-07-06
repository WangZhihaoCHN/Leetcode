package com.wzh.leetcode.solution;

public class BestTimeToBuyAndSellStock_121 {
    /**
     * 算法思路：
     * 考虑在第i天，如果要售出股票最多能赚多少呢？
     * 显然是当前值减掉历史最小值。因此只需要一遍遍历，遍历过程中记录最小值，
     * 同时计算当前点卖出股票的利润是否更小。
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            }
            result = Math.max(prices[i] - minValue, result);
        }
        return result;
    }
}
