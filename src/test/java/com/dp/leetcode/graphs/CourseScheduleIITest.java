package com.dp.leetcode.graphs;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class CourseScheduleIITest {

	@Test
	void findOrder() {
		CourseScheduleII courseScheduleII = new CourseScheduleII();
		int[] order = courseScheduleII.findOrder(2, new int[][] { { 1, 0 } });
		Assert.check(Arrays.toString(order).equals("[0, 1]"));
	}

	@Test
	void findOrder2() {
		CourseScheduleII courseScheduleII = new CourseScheduleII();
		int[] order = courseScheduleII.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
		String s = Arrays.toString(order);
		Assert.check("[0, 1, 2, 3]".equals(s) || "[0, 2, 1, 3]".equals(s));
	}
}