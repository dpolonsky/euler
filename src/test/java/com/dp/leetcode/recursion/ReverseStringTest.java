package com.dp.leetcode.recursion;

import org.junit.jupiter.api.Test;

import com.dp.leetcode.string.ReverseString;
import com.sun.tools.javac.util.Assert;

class ReverseStringTest {

	@Test
	void reverseString1() {
		ReverseString reverseString = new ReverseString();
		char[] output = reverseString.reverseString(new char[] { 'h', 'e', 'l', 'l', 'o' });
		Assert.check(new String(output).equals("olleh"));
	}

	@Test
	void reverseString2() {
		ReverseString reverseString = new ReverseString();
		char[] output = reverseString.reverseString(new char[] { 'H', 'a', 'n', 'n', 'a', 'h' });
		Assert.check(new String(output).equals("hannaH"));
	}

	@Test
	void reverseString3() {
		ReverseString reverseString = new ReverseString();
		char[] output = reverseString.reverseString(new char[] { 'H' });
		Assert.check(new String(output).equals("H"));
	}

	@Test
	void reverseString4() {
		ReverseString reverseString = new ReverseString();
		char[] output = reverseString.reverseString(new char[] {});
		Assert.check(new String(output).equals(""));
	}
}