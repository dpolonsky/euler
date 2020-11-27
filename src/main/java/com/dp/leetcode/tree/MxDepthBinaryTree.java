package com.dp.leetcode.tree;

public class MxDepthBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = (root.left == null) ? 0 : maxDepth(root.left) + 1;
		int right = (root.right == null) ? 0 : maxDepth(root.right) + 1;

		return Math.max(1, Math.max(left, right));
	}
}
