package com.dp.leetcode.list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	/**
	 * 1->4->5->6,
	 * 1->8->9,
	 * 2->6
	 *
	 * with min heap
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {

		if (lists == null || lists.length == 0) {
			return null;
		}

		PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

		for (ListNode list : lists) {
			ListNode current = list;
			while (current != null) {
				ListNode next = current.next;
				current.next = null;
				heap.add(current);
				current = next;
			}
		}


		ListNode result = null;
		ListNode current = null;
		while(!heap.isEmpty()){
			ListNode node = heap.poll();
			if (result == null) {
				result = current = node;
			} else {
				current.next = node;
				current = current.next;
			}
		}

		return result;
	}

	public ListNode mergeKListsV2(ListNode[] lists) {

		if (lists == null || lists.length == 0) {
			return null;
		}

		ListNode result = null;
		for (int i=0; i<lists.length; i++){
			result = mergeTwoLists(result, lists[i]);
		}
		return result;
	}

	private ListNode mergeTwoLists(ListNode node1, ListNode node2) {
		if ( node1 == null){
			return node2;
		}

		if ( node2 == null){
			return node1;
		}

		ListNode result = new ListNode(0);
		ListNode curr = result;

		ListNode n1 = node1;
		ListNode n2 = node2;
		while( n1 != null && n2 != null){
			if ( n1.val < n2.val){
				curr.next = n1;
				n1 = n1.next;
			}else{
				curr.next = n2;
				n2 = n2.next;
			}
			curr = curr.next;
		}

		if ( n1 != null){
			curr.next = n1;
		}

		if ( n2 != null){
			curr.next = n2;
		}

		return result.next;
	}
}
