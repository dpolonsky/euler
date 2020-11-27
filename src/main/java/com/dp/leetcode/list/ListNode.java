package com.dp.leetcode.list;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public static ListNode of(int... x) {
		ListNode root = new ListNode(-1);
		ListNode listNode = root;
		for ( int i : x) {
			listNode.next= new ListNode(i);
			listNode = listNode.next;
		}
		return root.next;
	}

	@Override public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(val);
		ListNode current = next;
		while(current != null){
			output.append(current.val);
			current = current.next;
		}
		return output.toString();
	}
}