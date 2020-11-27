package com.dp.leetcode.string;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubstringTest {

	@Test
	void minWindow() {
		MinimumWindowSubstring minimumWindow = new MinimumWindowSubstring();
		Assert.check(minimumWindow.minWindow("ADOBECODEBANC","ABC").equals("BANC"));
	}
}