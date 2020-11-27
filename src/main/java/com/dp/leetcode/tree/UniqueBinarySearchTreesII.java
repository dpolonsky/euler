package com.dp.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		if ( n == 0){
			return new ArrayList<>();
		}
		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<>();
		if (start > end) {
			result.add(null);
			return result;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> left = generateTrees(start, i - 1);
			List<TreeNode> right = generateTrees(i + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					result.add(root);
				}
			}
		}
		return result;
	}

	TreeNode insertNode(TreeNode node, int n) {
		if (node == null) {
			return new TreeNode(n);
		}

		if (n <= node.val) {
			if (node.left == null) {
				node.left = new TreeNode(n);
			} else {
				return insertNode(node.left, n);
			}
		} else {
			if (node.right == null) {
				node.right = new TreeNode(n);
			} else {
				return insertNode(node.right, n);
			}

		}
		return insertNode(node.left, n);
	}
}
