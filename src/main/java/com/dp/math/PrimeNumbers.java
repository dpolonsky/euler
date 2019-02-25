package com.dp.math;

import java.util.ArrayList;
import java.util.List;

import com.dp.collections.BooleanLargeArray;

public class PrimeNumbers {
	public static List<Integer> generatePrimeNumbersInclusive(long maxNumber) {
		BooleanLargeArray primeNumbers = new BooleanLargeArray(maxNumber);
		primeNumbers.fill(true);

		for (int i = 2; i <= maxNumber; i++) {
			if (primeNumbers.get(i)) {
				for (int j = 2 * i; j < maxNumber; j += i) {
					primeNumbers.set(j, false);
				}
			}
		}

		return preparePrimes(maxNumber, primeNumbers);
	}

	private static List<Integer> preparePrimes(long maxNumber, BooleanLargeArray primeNumbers) {
		List<Integer> result = new ArrayList<>();
		for (int i = 2; i <= maxNumber; i++) {
			if (primeNumbers.get(i))
				result.add(i);
		}
		return result;
	}

	public static List<Integer> generatePrimeNumbers(long maxNumber) {
		BooleanLargeArray primeNumbers = new BooleanLargeArray(maxNumber);
		primeNumbers.fill(true);

		for (int i = 2; i < maxNumber; i++) {
			if (primeNumbers.get(i)) {
				for (int j = 2 * i; j < maxNumber; j += i) {
					primeNumbers.set(j, false);
				}
			}
		}

		return preparePrimes(maxNumber, primeNumbers);
	}

	public static long findLatgestPrimeFactor(long primeNumber) {
		while (primeNumber % 2 == 0) {
			primeNumber /= 2;
		}

		for (long factor = 3; factor < primeNumber; factor += 2) {
			while (primeNumber % factor == 0 && factor < primeNumber) {
				primeNumber /= factor;
			}
		}
		return primeNumber;
	}

	/**
	 * algorithm can be improved further by observing that all primes are of the form 6k ± 1,
	 * with the exception of 2 and 3. This is because all integers can be expressed as (6k + i)
	 * for some integer k and for i = ?1, 0, 1, 2, 3, or 4; 2 divides (6k + 0), (6k + 2), (6k + 4); and 3 divides (6k + 3).
	 * So a more efficient method is to test if n is divisible by 2 or 3, then to check through all the numbers of form 6k ± 1.
	 *
	 * @param num
	 * @return
	 */
	public static boolean isPrime(long num) {
		if (num <= 1)
			return false;
		if (num <= 3)
			return true;

		if (num % 2 == 0 || num % 3 == 0)
			return false;

		for (int i = 5; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
