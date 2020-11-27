package com.dp.leetcode.tree;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class MxDepthBinaryTreeTest {

	@Test
	void maxDepth() {
		MxDepthBinaryTree mxDepthBinaryTree = new MxDepthBinaryTree();

		TreeNode treeNode = new TreeNode(3);
		treeNode.left = new TreeNode(9);
		treeNode.right = new TreeNode(20);
		treeNode.right.left = new TreeNode(15);
		treeNode.right.right = new TreeNode(7);

		int i = mxDepthBinaryTree.maxDepth(treeNode);
		Assert.check(i == 3);


		treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(10);
		treeNode.left.left = new TreeNode(11);
		treeNode.left.right = new TreeNode(12);
		treeNode.left.right.left = new TreeNode(13);
		treeNode.left.right.left.left = new TreeNode(14);
		treeNode.right = new TreeNode(21);
		treeNode.right.left = new TreeNode(22);
		treeNode.right.right = new TreeNode(23);
		treeNode.right.right.left = new TreeNode(24);
		treeNode.right.right.left.left = new TreeNode(25);
		treeNode.right.right.left.left.right = new TreeNode(26);

		Assert.check(mxDepthBinaryTree.maxDepth(treeNode) == 6);
	}
}