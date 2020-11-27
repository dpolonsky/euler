package com.dp.leetcode.string;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class LongestSubstringWhichContainsKֹUniqueCharactersTest {

	@Test
	void lengthOfLongestSubstringKDistinct() {
		LongestSubstringWhichContainsKֹUniqueCharacters uniqueCharacters = new LongestSubstringWhichContainsKֹUniqueCharacters();
		Assert.check(uniqueCharacters.lengthOfLongestSubstringKDistinct("abcbbbbcccbdddadacb", 2) == 10);
		Assert.check(uniqueCharacters.lengthOfLongestSubstringKDistinct("", 2) == 0);
		Assert.check(uniqueCharacters.lengthOfLongestSubstringKDistinct(null, 2) == 0);
		Assert.check(uniqueCharacters.lengthOfLongestSubstringKDistinct("qweqweqweqwedfcvfbtgt", 3) == 12);
		Assert.check(uniqueCharacters.lengthOfLongestSubstringKDistinct("ccaabbb", 2) == 5);
	}
}