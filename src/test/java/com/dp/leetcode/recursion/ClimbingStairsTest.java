package com.dp.leetcode.recursion;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

	@Test
	void climbStairs() {
		ClimbingStairs climbingStairs = new ClimbingStairs();
		Assert.check(climbingStairs.climbStairs(1) == 1);
		Assert.check(climbingStairs.climbStairs(2) == 2);
		Assert.check(climbingStairs.climbStairs(3) == 3);
		// 1,1,1,1| 1,2,1 | 1,1,2 | 2,1,1 | 2,2
		Assert.check(climbingStairs.climbStairs(4) == 5);
	}
}