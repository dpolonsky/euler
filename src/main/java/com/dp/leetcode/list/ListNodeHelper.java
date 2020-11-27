package com.dp.leetcode.list;

public class ListNodeHelper {

	public static ListNode prepareList(int from, int to) {
		ListNode head = new ListNode(from);
		ListNode last = head;
		for (int i = from + 1; i <= to; i++) {
			ListNode node = new ListNode(i);
			last.next = node;
			last = node;
		}
		return head;
	}
}
