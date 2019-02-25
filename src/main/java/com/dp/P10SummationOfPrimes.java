package com.dp;

import java.util.List;

import com.dp.math.PrimeNumbers;

public class P10SummationOfPrimes {
	public static void main(String[] args){
	  P10SummationOfPrimes p10SummationOfPrimes = new P10SummationOfPrimes();
	  p10SummationOfPrimes.sumOfPrimesGeneratingPrimes(2_000_000);
	  p10SummationOfPrimes.getSumForLoop(2_000_000);
	}

	protected long getSumForLoop(int maxPrime) {
		long start = System.currentTimeMillis();
		long result = 0;
		for ( int num=1; num <= maxPrime; num ++){
			if ( PrimeNumbers.isPrime(num)){
				result += num;
			}
		}
		printResult(result, start);
		return result;
	}

	protected long sumOfPrimesGeneratingPrimes(int maxPrime) {
		long start = System.currentTimeMillis();
		List<Integer> primes = PrimeNumbers.generatePrimeNumbers(maxPrime);
		Long result = primes.stream().map(Long::valueOf).reduce((u, v) -> u + v).orElse(0L);
		printResult(result, start);
		return result;
	}

	private void printResult(long result, long start){
		System.out.printf("result:%d, took:%d ms\n", result, System.currentTimeMillis() - start);
	}
}
