package com.dp.leetcode.tree;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class PascalsTriangle2Test {

	@Test
	void getRow() {
		PascalsTriangle2 pascalsTriangle2 = new PascalsTriangle2();
		List<Integer> row = pascalsTriangle2.getRow(0);
		Assert.check(Arrays.toString(row.toArray()).equals("[1]"));

		row = pascalsTriangle2.getRow(1);
		Assert.check(Arrays.toString(row.toArray()).equals("[1, 1]"));

		row = pascalsTriangle2.getRow(2);
		Assert.check(Arrays.toString(row.toArray()).equals("[1, 2, 1]"));

		row = pascalsTriangle2.getRow(3);
		Assert.check(Arrays.toString(row.toArray()).equals("[1, 3, 3, 1]"));

		row = pascalsTriangle2.getRow(4);
		Assert.check(Arrays.toString(row.toArray()).equals("[1, 4, 6, 4, 1]"));
	}
}