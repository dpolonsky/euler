package com.dp.leetcode.recursion;

import org.junit.jupiter.api.Test;

import com.dp.leetcode.list.ReverseList;
import com.dp.leetcode.list.ListNode;
import com.dp.leetcode.list.ListNodeHelper;
import com.sun.tools.javac.util.Assert;

class ReverseListTest {

	@Test
	void reverseList() {
		ReverseList reverseList = new ReverseList();
		ListNode head = reverseList.reverseList(ListNodeHelper.prepareList(1, 5));
		Assert.check(head.val == 5);
		Assert.check(head.next.val == 4);
		Assert.check(head.next.next.val == 3);
	}
}