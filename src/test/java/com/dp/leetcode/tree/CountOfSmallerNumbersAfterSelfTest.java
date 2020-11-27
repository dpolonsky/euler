package com.dp.leetcode.tree;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class CountOfSmallerNumbersAfterSelfTest {

	@Test
	void countSmaller() {
		CountOfSmallerNumbersAfterSelf count = new CountOfSmallerNumbersAfterSelf();
		List<Integer> output = count.countSmaller(new int[] { 5, 2, 6, 1 });
		Assert.check(Arrays.toString(output.toArray()).equals("[2, 1, 1, 0]"));
	}
}