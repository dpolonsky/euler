package com.dp.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
	Map<Integer, Integer> cache = new HashMap<>();

	public int fib(int N) {
		if (cache.containsKey(N)) {
			return cache.get(N);
		}

		if (N <= 1) {
			cache.put(N, N);
			return N;
		}

		int left = (cache.containsKey(N - 1)) ? cache.get(N - 1) : fib(N - 1);
		int right = (cache.containsKey(N - 2)) ? cache.get(N - 2) : fib(N - 2);
		cache.put(N, left + right);
		return left + right;
	}

	public long fibInteractive(long n) {
		if (n <= 1) {
			return n;
		}
		long x = 0, y = 1;
		long ans = 0;
		for (int i = 2; i <= n; i++) {
			ans = x + y;
			x = y;
			y = ans;
		}
		return ans;
	}
}
