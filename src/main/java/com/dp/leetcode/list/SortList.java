package com.dp.leetcode.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortList {
	public ListNode sortList(ListNode head) {
		List<ListNode> list = new ArrayList<>();
		while (head != null) {
			ListNode next = head.next;
			head.next = null;
			list.add(head);
			head = next;
		}
		Collections.sort(list, Comparator.comparingInt(o -> o.val));
		ListNode result = null;
		ListNode current = null;
		for ( ListNode node : list){
			if ( result == null){
				result = current = node;
			}else{
				current.next = node;
				current = current.next;
			}

		}
		return result;
	}
}
