package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class SlidingWindowMaximumTest {
	@Test
	 public void maxSlidingWindow() {
		SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
		int[] result = slidingWindowMaximum.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3);
		Assert.check(compare(result, new int[] { 3, 3, 5, 5, 6, 7 }));
	}

	private boolean compare(int[] b1, int[] b2) {
		if (b1 == null && b2 == null) {
			return true;
		}

		if (b1 == null)
			return false;

		if (b2 == null)
			return false;

		if (b1.length != b2.length) {
			return false;
		}

		for (int i = 0; i < b1.length; i++) {
			if (b1[i] != b2[i]) {
				return false;
			}
		}
		return true;

	}

}