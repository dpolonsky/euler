package com.dp.leetcode.string;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class AtoiTest {

	@Test
	void myAtoi() {
		Atoi atoi = new Atoi();
		Assert.check(atoi.myAtoi("1234") == 1234);
		Assert.check(atoi.myAtoi("   -42") == -42);
		Assert.check(atoi.myAtoi(" ") == 0);

	}
}