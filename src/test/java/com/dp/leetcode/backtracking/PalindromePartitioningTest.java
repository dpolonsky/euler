package com.dp.leetcode.backtracking;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePartitioningTest {

	@Test
	void partition() {
		PalindromePartitioning partitioning = new PalindromePartitioning();
		List<List<String>> res = partitioning.partition("aab");
		Assert.check(res.size() == 2);
		Assert.check(String.join("", res.get(0)).equals("aab"));
	}
}