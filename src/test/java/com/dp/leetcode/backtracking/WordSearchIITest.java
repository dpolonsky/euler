package com.dp.leetcode.backtracking;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class WordSearchIITest {

	@Test
	void findWords() {
		WordSearchII wordSearchII = new WordSearchII();
		List<String> output = wordSearchII.findWords(new char[][] {
				{ 'o', 'a', 'a', 'n' },
				{ 'e', 't', 'a', 'e' },
				{ 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' }
		}, new String[] { "oath", "pea", "eat", "rain" });

		Assert.check(String.join(",", output).equals("eat,oath"));
	}
}