package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * <p>
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * <p>
 * Using the rule above and starting with 13, we generate the following sequence:
 * <p>
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * <p>
 * Which starting number, under one million, produces the longest chain?
 * <p>
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class P14LongestCollatzSequence {

	public static void main(String[] args) {
		P14LongestCollatzSequence collatzSequence = new P14LongestCollatzSequence();
		collatzSequence.findLongestChain(1_000_000);
	}

	private long findLongestChain(int limit) {
		long start = System.currentTimeMillis();
		List<Long> longestChain = Collections.emptyList();
		for (int j = 2; j < limit; j++) {
			List<Long> chain = collatz(j);

			if ( chain.size() > longestChain.size())
				longestChain = chain;
		}
		System.out.printf("Longest chain:%d of:%d items, took:%d", longestChain.get(0), longestChain.size() - 1, System.currentTimeMillis() - start);
		return longestChain.get(0);
	}

	private List<Long> collatz(int collatzBase) {
		List<Long> chain = new ArrayList<>();
		long num = collatzBase;
		chain.add(num);
		while(num > 1){
			if (num % 2 == 0) {
				num /= 2;
			} else {
				num = 3 * num + 1;
			}
			chain.add(num);
		}
		System.out.printf("chain:%d of:%d items\n", chain.get(0), chain.size() - 1);
		return chain;
	}
}
