package com.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

class P4LargestPalindromeProductTest {

	private static P4LargestPalindromeProduct largestPalindromeProduct;

	@BeforeAll
	static void initAll() {
		largestPalindromeProduct = new P4LargestPalindromeProduct();
	}

	@org.junit.jupiter.api.Test
	void isPolyndrom() {
		Assertions.assertTrue(largestPalindromeProduct.isPolyndrom(101));
		Assertions.assertTrue(largestPalindromeProduct.isPolyndrom(1001));
		Assertions.assertTrue(largestPalindromeProduct.isPolyndrom(5531355));
		Assertions.assertFalse(largestPalindromeProduct.isPolyndrom(5531255));
		Assertions.assertFalse(largestPalindromeProduct.isPolyndrom(112));
	}
}