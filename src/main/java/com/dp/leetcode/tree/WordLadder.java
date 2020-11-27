package com.dp.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (null == beginWord || null == endWord || null == wordList || wordList.isEmpty()) {
			return 0;
		}

		if (!wordList.contains(endWord)) {
			return 0;
		}

		TreeNode<String> root = new TreeNode<>(beginWord);
		LinkedList<TreeNode<String>> stack = new LinkedList<>();
		stack.push(root);

		ArrayList<String> input = new ArrayList<>(wordList);
		while (!stack.isEmpty()) {
			TreeNode<String> current = stack.pollFirst();
			List<TreeNode<String>> nextLevel = findNextLevel(current.val, input);
			current.children = nextLevel;
			nextLevel.forEach(stack::offerLast);
		}

		int pathLength = findPathLength(root, endWord, 1);
		if (pathLength == Integer.MAX_VALUE) {
			pathLength = 0;
		}
		return pathLength;
	}

	private int findPathLength(TreeNode<String> root, String value, int level) {
		if (root == null) {
			return 0;
		}

		if (root.val.equals(value)) {
			return level;
		}

		int result = 0;
		for (TreeNode<String> node : root.children) {
			int res = findPathLength(node, value, level + 1);
			if (res != 0)
				result = res;
		}
		return result;
	}

	private List<TreeNode<String>> findNextLevel(String value, ArrayList<String> wordList) {
		List<TreeNode<String>> result = new ArrayList<>();
		for (String word : wordList) {
			if (distance(value, word) == 1) {
				result.add(new TreeNode<>(word));
			}
		}
		for (TreeNode<String> node : result) {
			wordList.remove(node.val);
		}
		return result;
	}

	private int distance(String value, String word) {
		int distance = 0;
		for (int i = 0; i < value.length(); i++) {
			distance += (value.charAt(i) == word.charAt(i)) ? 0 : 1;
		}
		return distance;
	}

	static public class TreeNode<G> {
		G val;
		List<TreeNode<G>> children;

		TreeNode(G val) {
			this.val = val;
		}

		@Override public String toString() {
			return String.valueOf(val);
		}
	}
}