package com.dp.leetcode.arrays;

import java.util.Arrays;

public class SellStocks4
{
    public int maxProfit(int k, int[] prices)
    {
        if (prices.length <= 1 || k == 0) {
            return 0;
        }

        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                buy[j] = Math.max(buy[j], j == 0 ? 0 - prices[i] : sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return  sell[k-1];
    }
}
