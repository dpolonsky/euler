package com.dp.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UniqueBinarySearchTreesIITest {

	@Test
	void generateTrees() {
		UniqueBinarySearchTreesII trees = new UniqueBinarySearchTreesII();
		List<TreeNode> treeNodes = trees.generateTrees(3);
		List<List<Integer>> results= new ArrayList<>();
		for ( TreeNode node : treeNodes){
			results.add(node.toBSTList());
		}
	}
}