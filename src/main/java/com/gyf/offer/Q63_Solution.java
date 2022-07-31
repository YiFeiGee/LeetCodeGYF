package com.gyf.offer;

import java.util.Objects;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 *
 */
public class Q63_Solution {

    public int maxProfit1(int[] prices) {
        if (Objects.isNull(prices) || prices.length <=1) {
            return 0;
        }
        int n = prices.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    /**
     * 第i天最大利润是max[profit[i-1], price[i]-min]，前i-1天的最大利润和第i天价格-前i天最小值
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (Objects.isNull(prices) || prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }

}
