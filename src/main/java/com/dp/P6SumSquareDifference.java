package com.dp;

import java.util.stream.IntStream;

/**
 * Sum square difference
 * Problem 6
 *
 * The sum of the squares of the first ten natural numbers is,
 * <p>
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 * <p>
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * <p>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class P6SumSquareDifference {
	public static void main(String[] args) {
		P6SumSquareDifference p6SumSquareDifference = new P6SumSquareDifference();
		p6SumSquareDifference.process(10);
		p6SumSquareDifference.process(100);
	}

	private long process(int max) {
		long squareOfSums = squareofSumStream(max);
		long sumOfSquares = sumOfSquaresStream(max);
		long result = squareOfSums - sumOfSquares;
		System.out.printf("Delta:%d squareOfSums:%d sumOfSquares:%d\n---\n", result, squareOfSums, sumOfSquares);
		return result;
	}

	private long squareofSumStream(int max) {
		long sum = IntStream.rangeClosed(1, max).sum();
		return sum * sum;
	}

	private long sumOfSquaresStream(int max) {
		return IntStream.rangeClosed(1, max).map(i -> i * i).sum();
	}

	public long sumOfNSquaresFormula(int N) {
		return (long) (N * (N + 1) * (2 * N + 1)) / 6;
	}

	public long squareofSumFormula(int N) {
		return (long) Math.pow((N * (N + 1)) / 2, 2);
	}
}
