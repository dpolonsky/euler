package com.dp.leetcode.recursion;

import org.junit.jupiter.api.Test;

import com.dp.leetcode.list.SwapPairs;
import com.dp.leetcode.list.ListNode;
import com.dp.leetcode.list.ListNodeHelper;
import com.sun.tools.javac.util.Assert;

class SwapPairsTest {

	@Test
	void swapPairs1() {
		SwapPairs swapPairs = new SwapPairs();

		ListNode listNode = swapPairs.swapPairs(ListNodeHelper.prepareList(1, 5));
		Assert.check(listNode.val == 2);
	}

	@Test
	void swapPairs2() {
		SwapPairs swapPairs = new SwapPairs();

		ListNode listNode = swapPairs.swapPairs(ListNodeHelper.prepareList(2, 3));
		Assert.check(listNode.val == 3);
	}

	@Test
	void swapPairs3() {
		SwapPairs swapPairs = new SwapPairs();

		ListNode listNode = swapPairs.swapPairs(ListNodeHelper.prepareList(2, 2));
		Assert.check(listNode.val == 2);
	}

}