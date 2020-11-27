package com.dp.leetcode.arrays;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class SellStocks2Test {

	@Test
	void maxProfit() {
		SellStocks2 s = new SellStocks2();
		int res = s.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
		Assert.check(res == 7);
	}
}