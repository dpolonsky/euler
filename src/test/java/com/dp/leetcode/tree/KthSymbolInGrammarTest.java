package com.dp.leetcode.tree;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class KthSymbolInGrammarTest {

	@Test
	void kthGrammar() {
		KthSymbolInGrammar kthSymbolInGrammar = new KthSymbolInGrammar();
		Assert.check(kthSymbolInGrammar.kthGrammar(1, 1) == 0);
		Assert.check(kthSymbolInGrammar.kthGrammar(2, 1) == 0);
		Assert.check(kthSymbolInGrammar.kthGrammar(2, 2) == 1);
		Assert.check(kthSymbolInGrammar.kthGrammar(4, 5) == 1);
	}
}