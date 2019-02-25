package com.dp;

import org.junit.jupiter.api.Test;

import com.dp.math.PrimeNumbers;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersTest {

	@Test
	void generatePrimeNumbers() {
		assertEquals(1570, PrimeNumbers.generatePrimeNumbers(13195).size());
		assertEquals(4, PrimeNumbers.generatePrimeNumbers(11).size());
		assertEquals(8, PrimeNumbers.generatePrimeNumbers(21).size());
		assertEquals(0, PrimeNumbers.generatePrimeNumbers(1).size());
	}

	@Test
	void findLatgestPrimeFactor() {
		assertEquals(29, PrimeNumbers.findLatgestPrimeFactor(13195));
	}

	@Test
	void isPrime() {
		assertTrue(PrimeNumbers.isPrime(2));
		assertTrue(PrimeNumbers.isPrime(3));
		assertTrue(PrimeNumbers.isPrime(5));
		assertTrue(PrimeNumbers.isPrime(11));
		assertTrue(PrimeNumbers.isPrime(17));
		assertTrue(PrimeNumbers.isPrime(113));
		assertFalse(PrimeNumbers.isPrime(4));
		assertFalse(PrimeNumbers.isPrime(100));
	}
}