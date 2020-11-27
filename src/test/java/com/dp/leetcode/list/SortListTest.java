package com.dp.leetcode.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortListTest {

	@Test
	void sortList() {
		SortList sortList = new SortList();

		ListNode l1 = new ListNode(11);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		l1.next.next.next = new ListNode(6);
		l1.next.next.next.next = new ListNode(20);

		ListNode listNode = sortList.sortList(l1);
	}
}