package com.dp.leetcode.tree;

public class BinaryTreeMaximumPathSum {
	int answer = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		max_gain(root);
		return answer;
	}

	public int max_gain(TreeNode root) {
		if ( root == null){
			return 0;
		}

		int left = Math.max(max_gain(root.left), 0);
		int right = Math.max(max_gain(root.right), 0);

		int both = root.val + left + right;
		answer = Math.max(answer, both);
		return root.val + Math.max(left, right);

	}
}
