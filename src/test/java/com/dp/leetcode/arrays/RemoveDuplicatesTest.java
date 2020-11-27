package com.dp.leetcode.arrays;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

	@Test
	void removeDuplicates() {

		int[] input = { 1, 1, 2 };
		int res = new RemoveDuplicates().removeDuplicates(input);
		Assert.check(res == 2);
	}
	@Test
	void removeDuplicates1() {
		int []input = { 0,0,1,1,1,2,2,3,3,4};
		int res = new RemoveDuplicates().removeDuplicates(input);
		Assert.check(res == 5);

	}
}