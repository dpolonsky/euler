package com.dp.leetcode.list;

public class SwapPairs {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = head.next;
		ListNode curr = head.next;
		ListNode prev = head;
		ListNode prevPrev = new ListNode(-1); // dummy node
		while (curr != null) {
			prev.next = curr.next;
			curr.next = prev;
			prevPrev.next = curr;
			if (prev.next != null) {
				curr = prev.next.next;
				prev = prev.next;
				prevPrev = prevPrev.next.next;
			} else {
				curr = null;
			}
		}
		return newHead;
	}
}
