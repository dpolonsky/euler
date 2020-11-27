package com.dp.leetcode.cache;

import java.util.*;

/**
 * https://www.interviewcake.com/concept/java/lru-cache#:~:text=An%20LRU%20cache%20is%20built,list%20and%20a%20hash%20map.&text=This%20lets%20us%20access%20the,the%20tail%20of%20the%20list.&text=But%20the%20whole%20point%20of%20a%20cache%20is%20to%20get%20quick%20lookups.
 *
 *
 *
 Costs:
 Worst Case
 space	O(n)O(n)
 get least recently used item	O(1)O(1)
 access item	O(1)O(1)
 _____________
 A Least Recently Used (LRU) Cache organizes items in order of use,
 allowing you to quickly identify which item hasn't been used for the longest amount of time.

 Picture a clothes rack, where clothes are always hung up on one side. To find the least-recently used item,
 look at the item on the other end of the rack.

 Under the hood, an LRU cache is often implemented by pairing a doubly linked list with a hash map.

 _____________
 Strengths:
 Super fast accesses. LRU caches store items in order from most-recently used to least-recently used.
 That means both can be accessed in O(1)O(1) time.

 Super fast updates. Each time an item is accessed, updating the cache takes O(1)O(1) time.

 _____________
 Weaknesses
 Space heavy. An LRU cache tracking nn items requires a linked list of length nn, and a hash map holding nn items.
 That's O(n)O(n) space, but it's still two data structures (as opposed to one).
 */
public class LRUCache1 {

	private Deque<Integer> doublyQueue;

	// store references of key in cache
	private HashSet<Integer> hashSet;

	// maximum capacity of cache
	private final int CACHE_SIZE;

	LRUCache1(int capacity) {
		doublyQueue = new LinkedList<>();
		hashSet = new HashSet<>();
		CACHE_SIZE = capacity;
	}

	/* Refer the page within the LRU cache */
	public void put(int page) {
		if (!hashSet.contains(page)) {
			if (doublyQueue.size() == CACHE_SIZE) {
				int last = doublyQueue.removeLast();
				hashSet.remove(last);
			}
		}
		else {/* The found page may not be always the last element, even if it's an
               intermediate element that needs to be removed and added to the start
               of the Queue */
			doublyQueue.remove(page);
		}
		doublyQueue.push(page);
		hashSet.add(page);
	}

	// display contents of cache
	public void display() {
		Iterator<Integer> itr = doublyQueue.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}

	public static void main(String[] args) {
		LRUCache1 cache = new LRUCache1(4);
		cache.put(1);
		cache.put(2);
		cache.put(3);
		cache.put(1);
		cache.put(4);
		cache.put(5);
		cache.put(2);
		cache.put(2);
		cache.put(1);
		cache.display();
	}
}
