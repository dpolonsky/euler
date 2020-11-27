package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class MergeIntervalsTest {

	@Test
	void merge() {
		MergeIntervals mergeIntervals = new MergeIntervals();
		int[][] merge = mergeIntervals.merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } });
		Assert.check(merge.length == 3);
		Assert.check(merge[0][0] == 1);
		Assert.check(merge[0][1] == 6);
		Assert.check(merge[1][0] == 8);
		Assert.check(merge[1][1] == 10);
	}

	@Test
	void merge1() {
		MergeIntervals mergeIntervals = new MergeIntervals();
		int[][] merge = mergeIntervals.merge(new int[][] { { 1, 4 }, { 4, 5 }});
		Assert.check(merge.length == 1);
		Assert.check(merge[0][0] == 1);
		Assert.check(merge[0][1] == 5);
	}
}