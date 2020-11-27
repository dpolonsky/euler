package com.dp.leetcode.recursion;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveMultiplyTest {

	@Test
	void multiply() {
		RecursiveMultiply recursiveMultiply = new RecursiveMultiply();
		Assert.check(recursiveMultiply.multiply(4,5) == 20);
		Assert.check(recursiveMultiply.multiply(7,3) == 21);
		Assert.check(recursiveMultiply.multiply(11,-4) == -44);
	}
}