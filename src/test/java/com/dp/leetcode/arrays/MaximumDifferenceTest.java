package com.dp.leetcode.arrays;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class MaximumDifferenceTest {

	@Test
	void maxDiff() {
		MaximumDifference maxDiff = new MaximumDifference();
		int[] arr = { 1, 2, 90, 10, 110 };
		Assert.check(maxDiff.maxDiff(arr) == 109);
	}

	@Test
	void maxDiff1() {
		MaximumDifference maxDiff = new MaximumDifference();
		int[] arr = { 1, -2, -9, -10, -110 };
		int res = maxDiff.maxDiff(arr);
		Assert.check(res == -1);
	}
}