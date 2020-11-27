package com.dp.leetcode.string;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class LongestSubstringWithoutRepeatingTest {

	@Test
	void lengthOfLongestSubstring() {
		LongestSubstringWithoutRepeating repeating = new LongestSubstringWithoutRepeating();
		Assert.check(repeating.lengthOfLongestSubstring("abcabcbb") == 3);
		Assert.check(repeating.lengthOfLongestSubstring(" ") == 1);
		Assert.check(repeating.lengthOfLongestSubstring("bbbbb") == 1);
		Assert.check(repeating.lengthOfLongestSubstring("pwwkew") == 3);
		Assert.check(repeating.lengthOfLongestSubstring("dvdf") == 3);
	}
}