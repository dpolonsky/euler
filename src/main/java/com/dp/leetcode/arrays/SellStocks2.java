package com.dp.leetcode.arrays;

public class SellStocks2 {
	public int maxProfit(int[] prices) {
		int maxprofit = 0;
		for (int i = 0, j = 1;j < prices.length; i++,j++) {
			if (prices[j] > prices[i]) {
				maxprofit += prices[j] - prices[i];
			}
		}
		return maxprofit;
	}
}
