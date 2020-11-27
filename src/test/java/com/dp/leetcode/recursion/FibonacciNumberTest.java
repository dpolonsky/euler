package com.dp.leetcode.recursion;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class FibonacciNumberTest {

	@Test
	void fib() {
		FibonacciNumber fibonacciNumber = new FibonacciNumber();
		Assert.check(fibonacciNumber.fib(2) == 1);
		Assert.check(fibonacciNumber.fib(3) == 2);
		Assert.check(fibonacciNumber.fib(4) == 3);


		Assert.check(fibonacciNumber.fibInteractive(2) == 1);
		Assert.check(fibonacciNumber.fibInteractive(3) == 2);
		Assert.check(fibonacciNumber.fibInteractive(4) == 3);

	}
}