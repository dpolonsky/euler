package com.dp.leetcode.list;

public class ReverseList {
	public ListNode reverseList(ListNode head) {
		if ( head == null){
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode nextNode = head.next;
		head.next = null;
		ListNode listNode = reverseList(nextNode);
		nextNode.next = head;
		return listNode;
	}
}
