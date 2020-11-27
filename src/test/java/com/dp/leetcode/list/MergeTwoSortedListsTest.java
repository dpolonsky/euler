package com.dp.leetcode.list;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class MergeTwoSortedListsTest {

	@Test
	void mergeTwoLists1() {
		MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
		ListNode l1 = ListNode.of(1, 2, 3);
		ListNode l2 = ListNode.of(1, 2, 3);

		ListNode listNode = mergeTwoSortedLists.mergeTwoLists(l1, l2);
		Assert.check(listNode.toString().equals("112233"));
	}

	@Test
	void mergeTwoListsInteractive1() {
		MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
		ListNode l1 = ListNode.of(1, 2, 3);
		ListNode l2 = ListNode.of(1, 2, 3);

		ListNode listNode = mergeTwoSortedLists.mergeTwoListsInteractive(l1, l2);
		Assert.check(listNode.toString().equals("112233"));
	}

	@Test
	void mergeTwoLists2() {
		MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
		ListNode l1 = ListNode.of(1, 2, 3);
		ListNode l2 = ListNode.of(2, 3);

		ListNode listNode = mergeTwoSortedLists.mergeTwoLists(l1, l2);
		Assert.check(listNode.toString().equals("12233"));
	}

	@Test
	void mergeTwoListsInteractive2() {
		MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
		ListNode l1 = ListNode.of(1, 2, 4);
		ListNode l2 = ListNode.of(2, 3, 4);

		ListNode listNode = mergeTwoSortedLists.mergeTwoListsInteractive(l1, l2);
		Assert.check(listNode.toString().equals("122344"));
	}

	@Test
	void mergeTwoLists3() {
		MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
		ListNode l1 = ListNode.of(1, 5);
		ListNode l2 = ListNode.of(2, 3, 4);

		ListNode listNode = mergeTwoSortedLists.mergeTwoLists(l1, l2);
		Assert.check(listNode.toString().equals("12345"));
	}
}