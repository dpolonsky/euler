package com.dp.leetcode.cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	private int capacity;
	private Map<Integer, Node> map = new HashMap<>();
	private Node head = null;
	private Node tail = null;

	private static LRUCache instance;
	private LRUCache(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * synchronized on static method acquires class level lock
	 * @param capacity
	 * @return
	 */
	public static synchronized LRUCache getInstance(int capacity){
		if ( instance == null){
			instance = new LRUCache(capacity);
		}
		return instance;
	}


	/**
	 * Return the value and place at head
	 *
	 * @param key
	 * @return
	 */
	public int get(int key) {
		Node item = map.get(key);
		if (item == null)
			return -1;
		/* Move to front of list to mark as most recently used. */

		if (item != head) {
			removeFromLinkedList(item);
			insertAtFrontOfLinkedList(item);
		}
		return item.value;
	}

	private void removeFromLinkedList(Node node) {
		if (node == null)
			return;
		if (node.prev != null)
			node.prev.next = node.next;
		if (node.next != null)
			node.next.prev = node.prev;
		if (node == tail)
			tail = node.prev;
		if (node == head)
			head = node.next;
	}

	private void insertAtFrontOfLinkedList(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			head.prev = node;
			node.next = head;
			head = node;
			head.prev = null;
		}
	}

	public void put(int key, int value) {
		removeByKey(key);

		if (map.size() >= capacity) {
			remove(tail);
		}

		Node node = new Node(key, value);
		insertAtFrontOfLinkedList(node);
		map.put(key, node);
	}

	/* Remove key/value pair from cache, deleting from hashtable and linked list. */
	public void removeByKey(int key) {
		Node node = map.get(key);
		remove(node);
	}

	public void remove(Node node) {
		if (node != null) {
			removeFromLinkedList(node);
			map.remove(node.key);
		}
	}

	private static class Node {
		private Node next, prev;
		public int key;
		public int value;

		public Node(int k, int v) {
			key = k;
			value = v;
		}

	}

	@Override public String toString() {
		Node node = head;
		StringBuilder result = new StringBuilder();
		while (node != null) {
			result.append("(").append(node.key).append(":").append(node.value).append(")");
			node = node.next;
		}

		return result.toString();
	}

	public static void main(String[] args) {
		LRUCache cache = LRUCache.getInstance(4);
		cache.put(1, 11);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(6, 6);
		cache.put(14, 144);
		cache.put(1, 123);
		cache.put(2, 22);
		cache.put(3, 33);
		cache.put(3, 333);
		cache.put(2, 22);
		cache.put(3, 333);
		cache.put(2, 22);
		cache.put(3, 333);
		cache.put(2, 2);
		System.out.println(cache);

		LinkedHashMap linkedHashMap = new LinkedHashMap(6, 0.75f, true){
			@Override protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > 4;
			}
		};
		linkedHashMap.put(1, 11);
		linkedHashMap.put(2, 2);
		linkedHashMap.put(3, 3);
		linkedHashMap.put(6, 6);
		linkedHashMap.put(14, 144);
		linkedHashMap.put(1, 123);
		linkedHashMap.put(2, 22);
		linkedHashMap.put(3, 33);
		linkedHashMap.put(3, 333);
		linkedHashMap.put(2, 22);
		linkedHashMap.put(3, 333);
		linkedHashMap.put(2, 22);
		linkedHashMap.put(3, 333);
		linkedHashMap.put(2, 2);
		System.out.println(linkedHashMap);
	}
}
