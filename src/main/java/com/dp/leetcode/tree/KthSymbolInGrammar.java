package com.dp.leetcode.tree;

/**
 * row 1: 0
 * row 2: 01
 * row 3: 0110
 * row 4: 01101001
 */
public class KthSymbolInGrammar {
	public int kthGrammar(int N, int K) {
		if (N == 1)
			return 0;
		if (K % 2 == 0)
			return (kthGrammar(N - 1, K / 2) == 0) ? 1 : 0;
		else
			return (kthGrammar(N - 1, (K + 1) / 2) == 0) ? 0 : 1;
	}

}
