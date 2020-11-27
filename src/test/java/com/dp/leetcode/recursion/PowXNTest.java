package com.dp.leetcode.recursion;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class PowXNTest {

	int precision = 100000;

	@Test
	void myPow() {
		PowXN powXN = new PowXN();
		Assert.check(powXN.myPow(2, 0) == 1);
		Assert.check(powXN.myPow(2, 1) == 2);
		Assert.check(alignPrecision(powXN.myPow(2.1, 3)) == 9.261);
		Assert.check(alignPrecision(powXN.myPow(2.0, -2)) == 0.25);
		Assert.check(alignPrecision(powXN.myPow(5.0, -4)) == 0.0016);
		double v = alignPrecision(powXN.myPow(0.00001, 2147483647));
		Assert.check(v == 0.0);


	}

	private double alignPrecision(double value){
		return Math.floor(value * precision + .5) / precision;
	}
}