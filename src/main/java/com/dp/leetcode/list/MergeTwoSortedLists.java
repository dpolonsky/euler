package com.dp.leetcode.list;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode result;
		if (l1.val == l2.val) {
			ListNode res = mergeTwoLists(l1.next, l2.next);
			l1.next = l2;
			l2.next = res;
			result = l1;
		} else if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			result = l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			result = l2;
		}
		return result;
	}

	public ListNode mergeTwoListsInteractive(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode result = new ListNode(0);
		ListNode current = result;

		ListNode p1 = l1;
		ListNode p2 = l2;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				current.next = p1;
				p1 = p1.next;
			} else {
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}

		if (p1 != null) {
			current.next = p1;
		}

		if (p2 != null) {
			current.next = p2;
		}

		return result.next;
	}
}
