package com.dp.leetcode.graphs;

import org.junit.jupiter.api.Test;

import com.dp.leetcode.arrays.LongestIncreasingPathInAMatrix;
import com.sun.tools.javac.util.Assert;

class LongestIncreasingPathInAMatrixTest {

	@Test
	void longestIncreasingPath() {
		LongestIncreasingPathInAMatrix pathInAMatrix = new LongestIncreasingPathInAMatrix();
		int len = pathInAMatrix.longestIncreasingPath(new int[][] {
				{ 9, 9, 4 },
				{ 6, 6, 8 },
				{ 2, 1, 1 } });
		Assert.check(len == 4);
	}

	@Test
	void longestIncreasingPath1() {
		LongestIncreasingPathInAMatrix pathInAMatrix = new LongestIncreasingPathInAMatrix();
		int len = pathInAMatrix.longestIncreasingPath(new int[][] {
				{ 3, 4, 5 },
				{ 3, 2, 6 },
				{ 2, 2, 1 } });
		Assert.check(len == 4);
	}
}