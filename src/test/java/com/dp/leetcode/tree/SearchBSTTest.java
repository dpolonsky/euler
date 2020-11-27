package com.dp.leetcode.tree;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class SearchBSTTest {

	@Test
	void searchBST() {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(5);
		node.left.right = new TreeNode(6);
		node.right.right = new TreeNode(7);

		SearchBST searchBST = new SearchBST();
		TreeNode res = searchBST.searchBST(node, 6);
		Assert.check(res.val == 6);

		res = searchBST.searchBST(node, 7);
		Assert.check(res.val == 7);


		res = searchBST.searchBST(node, 1);
		Assert.check(res.val == 1);

		res = searchBST.searchBST(node, 4);
		Assert.check(res == null);
	}
}