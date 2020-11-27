package com.dp.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

	@Test
	void minDistance() {
		EditDistance editDistance = new EditDistance();
		int res = editDistance.minDistance("horse", "ros");
		Assert.check(res == 3);
	}
}