package com.dp.leetcode.arrays;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class FriendCirclesTest {

	@Test
	void findCircleNum() {
		FriendCircles friendCircles = new FriendCircles();
		int[][] M = new int[][] {
				{ 1, 1, 0 },
				{ 1, 1, 0 },
				{ 0, 0, 1 } };
		Assert.check(friendCircles.findCircleNum(M) == 2);
	}

	@Test
	void findCircleNum1() {
		FriendCircles friendCircles = new FriendCircles();
		int[][] M = new int[][] {
				{ 1, 1, 0 },
				{ 1, 1, 1 },
				{ 0, 1, 1 } };
		Assert.check(friendCircles.findCircleNum(M) == 1);
	}

	@Test
	void findCircleNum2() {
		FriendCircles friendCircles = new FriendCircles();
		int[][] M = new int[][] {
				{ 1, 0, 0, 1 },
				{ 0, 1, 1, 0 },
				{ 0, 1, 1, 1 },
				{ 1, 0, 1, 1 } };
		Assert.check(friendCircles.findCircleNum(M) == 1);
	}
	//[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
}