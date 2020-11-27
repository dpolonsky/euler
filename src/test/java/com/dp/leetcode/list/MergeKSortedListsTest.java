package com.dp.leetcode.list;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class MergeKSortedListsTest {

	@Test
	void mergeKLists() {
		MergeKSortedLists kSortedLists = new MergeKSortedLists();
		/**
		 * 1->4->5->6->20,
		 * 1->8->9->10->11->15,
		 * 2->6
		 */

		ListNode l1 = ListNode.of(1, 4, 5, 6, 20);
		ListNode l2 = ListNode.of(1, 8, 9, 10, 11, 15);
		ListNode l3 = ListNode.of(2, 6);

		ListNode[] list = new ListNode[] { l2, l3, l1 };
		ListNode listNode = kSortedLists.mergeKLists(list);
		Assert.check(listNode.toString().equals("11245668910111520"));
	}

	// [[-2,-1,-1,-1],[]]
	@Test
	void mergeKLists2() {
		MergeKSortedLists kSortedLists = new MergeKSortedLists();
		/**
		 * [[-2,-1,-1,-1],[]]
		 */

		ListNode l1 = new ListNode(-2);
		l1.next = new ListNode(-1);
		l1.next.next = new ListNode(-1);
		l1.next.next.next = new ListNode(-1);


		ListNode[] list = new ListNode[] { l1, null};
		ListNode listNode = kSortedLists.mergeKListsV2(list);
		Assert.check(listNode.toString().equals("-2-1-1-1"));
	}

}