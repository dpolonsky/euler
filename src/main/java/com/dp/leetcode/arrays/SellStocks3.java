package com.dp.leetcode.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class SellStocks3
{
    public int maxProfit(int[] prices)
    {
        int[] minPrices = new int[prices.length];
        minPrices[0] = 0;
		int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			minPrices[i] = Math.max(minPrices[i - 1], prices[i] - min);
        }

        int[] maxPrices = new int[prices.length];
        maxPrices[prices.length - 1] = 0;
		int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			maxPrices[i] = Math.max(maxPrices[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < minPrices.length; i++) {
			profit = Math.max(profit, minPrices[i] + maxPrices[i]);
        }
        return profit;
    }
}
