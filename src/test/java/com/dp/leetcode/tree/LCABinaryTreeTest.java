package com.dp.leetcode.tree;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class LCABinaryTreeTest {

	@Test
	void lowestCommonAncestor() {
		 // [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
		TreeNode root = new TreeNode(3);
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(1);
		root.left = p;
		root.right = q;
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		LCABinaryTree lcaBinaryTree = new LCABinaryTree();
		TreeNode node = lcaBinaryTree.lowestCommonAncestor(root, p, q);
		Assert.check(node.val == 3);
	}

	/**
	 * [3,5,1,6,2,0,8,null,null,7,4]
	 * 5
	 * 4
	 *
	 *
	 */
}