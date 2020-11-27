package com.dp.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class TrieTest {

	@Test
	void test() {
		Trie trie = new Trie();
		trie.insert("apple");
		Assert.check(trie.search("apple"));   // returns true
		Assert.check(!trie.search("app"));     // returns false
		Assert.check(trie.startsWith("app")); // returns true
		trie.insert("app");
		Assert.check(trie.search("app"));     // returns true
	}
}