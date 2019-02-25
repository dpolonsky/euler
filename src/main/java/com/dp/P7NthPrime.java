package com.dp;

import com.dp.math.PrimeNumbers;

/**
 * 10001st prime
 * Problem 7
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */
public class P7NthPrime {
	public static void main(String[] args) {
		P7NthPrime findPrime = new P7NthPrime();
		findPrime.process(10_001);

	}

	private long process(int primeNumberIndex) {
		int prime = 1;
		int index = 0;
		while (primeNumberIndex > index) {
			prime += 1;
			if (PrimeNumbers.isPrime(prime)) {
				index++;
			}
		}
		System.out.println(prime);
		return prime;
	}
}
