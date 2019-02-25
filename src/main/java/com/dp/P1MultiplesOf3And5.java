package com.dp;

import java.util.stream.IntStream;

/**
 * Multiples of 3 and 5
 * Problem 1
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class P1MultiplesOf3And5 {

	public static void main(String[] args) {
		P1MultiplesOf3And5 p1MultiplesOf3And5 = new P1MultiplesOf3And5();
		p1MultiplesOf3And5.process(1000);
	}

	private void process(int top) {
		System.out.println(IntStream.range(1, top) // create range
				.filter(i -> i % 3 == 0 || i % 5 == 0) // filter out
				.sum());
	}
}
