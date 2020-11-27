package com.dp.leetcode.backtracking;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class AutocompleteSystemTest {

	@Test
	void input() {
		AutocompleteSystem system = new AutocompleteSystem(new String[] { "i love you", "island", "ironman", "i love leetcode" }, new int[] { 5, 3, 2, 2 });
		List<String> output = system.input('i');
		Assert.check(output.size() == 3);
 		// "i love you", "island","i love leetcode"
	}
}