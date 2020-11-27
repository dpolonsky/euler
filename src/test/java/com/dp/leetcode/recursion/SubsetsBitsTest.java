package com.dp.leetcode.recursion;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubsetsBitsTest {

	@Test
	void subsets() {
		List<List<Integer>> subsets = new SubsetsBits().subsets(new int[] { 1, 2, 3 });
		subsets.isEmpty();

	}
}