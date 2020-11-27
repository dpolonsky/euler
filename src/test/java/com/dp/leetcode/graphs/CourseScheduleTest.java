package com.dp.leetcode.graphs;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class CourseScheduleTest {

	@Test
	void canFinish() {
		CourseSchedule courseSchedule = new CourseSchedule();
		Assert.check(courseSchedule.canFinish(2, new int[][] { { 1, 0 } }));
	}

	@Test
	void canFinish2() {
		CourseSchedule courseSchedule = new CourseSchedule();
		Assert.check(!courseSchedule.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
	}
}