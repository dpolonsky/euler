package com.dp.leetcode.backtracking;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class RemoveInvalidParenthesesTest {

	@Test
	void removeInvalidParentheses() {
		RemoveInvalidParentheses parentheses = new RemoveInvalidParentheses();
		List<String> result = parentheses.removeInvalidParentheses("()())()");
		Assert.check(result.size() == 2);
		Assert.check(result.contains("()()()"));
		Assert.check(result.contains("(())()"));
	}
}