package com.dp.leetcode.tree;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeMaximumPathSumTest {

	@Test
	void maxPathSum1() {
		BinaryTreeMaximumPathSum maximumPathSum = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		Assert.check(maximumPathSum.maxPathSum(root) == 6);
	}

	@Test
	void maxPathSum2() {
		BinaryTreeMaximumPathSum maximumPathSum = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		Assert.check(maximumPathSum.maxPathSum(root) == 42);
	}

	@Test
	void maxPathSum3() {
		BinaryTreeMaximumPathSum maximumPathSum = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(-3);

		Assert.check(maximumPathSum.maxPathSum(root) == -3);
	}

	@Test
	void maxPathSum4() {
		BinaryTreeMaximumPathSum maximumPathSum = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(-2);
		root.right = new TreeNode(-3);

		Assert.check(maximumPathSum.maxPathSum(root) == -2);
	}
}