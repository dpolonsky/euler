package com.dp.leetcode.recursion;

import java.util.List;

import org.junit.jupiter.api.Test;

class SubsetsTest {

	@Test
	void subsets() {
		List<List<Integer>> subsets = new Subsets().subsets(new int[] { 1, 2, 3 });
		subsets.isEmpty();
	}
}