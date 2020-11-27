package com.dp.leetcode.tree;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class AlienDictionaryTest {

	@Test
	void alienOrder() {
		AlienDictionary dictionary = new AlienDictionary();
		String output = dictionary.alienOrder(new String[] { "wrt",
				"wrf",
				"er",
				"ett",
				"rftt" });
		Assert.check(output.equals("wertf"));
	}

	@Test
	void alienOrder2() {
		AlienDictionary dictionary = new AlienDictionary();
		String output = dictionary.alienOrder(new String[] { "wrty" });
		Assert.check(output.equals("wrty"));
	}
}