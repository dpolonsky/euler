package com.dp.leetcode.recursion;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsWithoutDupsTest {

	@Test
	void permutation() {
		PermutationsWithoutDups dups = new PermutationsWithoutDups();
		List<String> abc = dups.permutation("abcd");
		System.out.println(abc.size());
	}
}