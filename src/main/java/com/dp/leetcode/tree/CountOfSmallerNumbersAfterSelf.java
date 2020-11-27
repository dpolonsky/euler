package com.dp.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.util.Pair;

public class CountOfSmallerNumbersAfterSelf {
	// bas performance n^2
	public List<Integer> countSmaller1(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		List<Pair<Integer, Integer>> state = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int counter = 0;
			for (int j = nums.length - 1; j >= i; j--) {
				if (nums[j] < nums[i]) {
					counter++;
				}
			}
			result.add(0, counter);
		}
		return result;
	}

	public List<Integer> countSmaller(int[] nums) {

		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		Node root = new Node(nums[nums.length - 1]);
		root.count = 1;
		result.add(0);

		for (int i = nums.length - 2; i >= 0; i--) {
			result.add(insertNode(root, nums[i]));
		}

		Collections.reverse(result);

		return result;
	}

	public int insertNode(Node root, int value) {
		Node p = root;
		int result = 0;

		while (p != null) {
			if (value > p.value) {
				result += p.count + p.numLeft;
				if (p.right == null) {
					Node t = new Node(value);
					t.count = 1;
					p.right = t;
					return result;
				} else {
					p = p.right;
				}
			} else if (value == p.value) {
				p.count++;
				return result + p.numLeft;
			} else {
				p.numLeft++;

				if (p.left == null) {
					Node t = new Node(value);
					t.count = 1;
					p.left = t;
					return result;
				} else {
					p = p.left;
				}
			}
		}

		return 0;
	}

	class Node {
		Node left;
		Node right;

		int value;
		int count;
		int numLeft;

		public Node(int value) {
			this.value = value;
		}
	}
}
