package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class BasicCalculatorIITest {

	@Test
	void calculate() {
		BasicCalculatorII basicCalculator = new BasicCalculatorII();
		Assert.check(basicCalculator.calculate("3+2*2") == 7);
		Assert.check(basicCalculator.calculate("3 /2") == 1);
		Assert.check(basicCalculator.calculate("3+5 / 2") == 5);
		Assert.check(basicCalculator.calculate("1* 3 + 5/2+9") == 14);
		Assert.check(basicCalculator.calculate("1+ 0 - 10/2-2") == -6);
		Assert.check(basicCalculator.calculate("1*2-3/4+5*6-7*8+9/10") == -24);

	}
}