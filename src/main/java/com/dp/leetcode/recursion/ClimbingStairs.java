package com.dp.leetcode.recursion;

import java.util.Arrays;

public class ClimbingStairs {
	int[] cache;

	public int climbStairs(int n) {
		cache = new int[n + 1];
		Arrays.fill(cache, -1);
		return innternalClimbStairs(n);
	}

	public int innternalClimbStairs(int n) {
		if (n <= 2) {
			return n;
		}

		int onestep = (cache[n - 1] != -1) ? cache[n - 1] : innternalClimbStairs(n - 1);
		cache[n - 1] = onestep;
		int twostep = (cache[n - 2] != -1) ? cache[n - 2] : innternalClimbStairs(n - 2);
		cache[n - 2] = twostep;
		cache[n] = onestep + twostep;
		return onestep + twostep;
	}
}
