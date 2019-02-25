package com.dp;

import com.dp.math.MathUtils;

/**
 * Smallest multiple
 * Problem 5
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class P5SmallestMultiple {
	public static void main(String[] args) {
		P5SmallestMultiple p5SmallestMultiple = new P5SmallestMultiple();
		p5SmallestMultiple.process(10);
	}

	protected long process(int limit) {

		long lcm = 1;
		for (int i = 2; i <= limit; i++) {
			lcm = findLcmGCD(lcm, i);
		}

		System.out.println(lcm);
		return lcm;
	}

	protected long findLcmGCD(long a, long b) {
		return (a * b) / MathUtils.euclideanGcd(a, b);
	}

	protected long findLcmSlow(long a, long b) {
		if ( a < 0 || b < 0)
			throw new IllegalArgumentException("Supporting only positive numbers");

		for ( long lcm = (a > b) ? a : b;; lcm++){
			if (lcm % a == 0 && lcm % b == 0) {
				System.out.printf("The LCM of %d and %d is %d.", a, b, lcm);
				return lcm;
			}
		}
	}
}
