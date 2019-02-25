package com.dp;

import java.util.List;
import java.util.stream.Collectors;

import com.dp.math.PrimeNumbers;

/**
 * Largest prime factor
 * Problem 3
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 */
public class P3LargestPrimeFactor {
	public static void main(String[] args) {
		P3LargestPrimeFactor largestPrimeFactor = new P3LargestPrimeFactor();
		largestPrimeFactor.process(13195);
		largestPrimeFactor.process(600851475143L);
	}

	private void process(long primeNumber) {
		long prime = PrimeNumbers.findLatgestPrimeFactor(primeNumber);
		System.out.println(prime);
		List<Integer> primes = PrimeNumbers.generatePrimeNumbers(prime);
		List<Integer> result = findPrimeFactor(primes, primeNumber);
		System.out.println(result);
	}



	private List<Integer> findPrimeFactor(List<Integer> primes, long primeNumber) {
		return primes.stream().filter(p -> primeNumber % p == 0).collect(Collectors.toList());
	}


}
