package com.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P5SmallestMultipleTest {


	private P5SmallestMultiple p5SmallestMultiple = new P5SmallestMultiple();

	@Test
	void testProcess() {
		assertEquals(2520, p5SmallestMultiple.process(10));
		assertEquals(232792560, p5SmallestMultiple.process(20));
	}

	@Test
	void findLcmGCD() {
		assertEquals(6, p5SmallestMultiple.findLcmGCD(2, 3));
		assertEquals(15, p5SmallestMultiple.findLcmGCD(5, 3));
		assertEquals(77, p5SmallestMultiple.findLcmGCD(7, 11));
	}

	@Test
	void findLcmSlow() {
		assertEquals(6, p5SmallestMultiple.findLcmGCD(2, 3));
		assertEquals(15, p5SmallestMultiple.findLcmGCD(5, 3));
		assertEquals(77, p5SmallestMultiple.findLcmGCD(7, 11));
	}
}