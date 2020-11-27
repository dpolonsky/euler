package com.dp.leetcode;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;
import com.sun.xml.internal.ws.policy.AssertionSet;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

	@Test
	void threeSum() {
		ThreeSum threeSum = new ThreeSum();
		List<List<Integer>> lists = threeSum.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
		Assert.check(lists.size() == 2);
	}
}