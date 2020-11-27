package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumEqualsKTest {

	@Test
	void subarraySum() {
		SubarraySumEqualsK sub = new SubarraySumEqualsK();
		int res = sub.subarraySum(new int[] { 1, 1, 1 }, 2);
		Assert.check(res == 2);

		res = sub.subarraySum(new int[] { 1, 2, 3, 8, 9, 3, 10, 2, 7 ,1}, 22);
		Assert.check(res == 3);
	}
}