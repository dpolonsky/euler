package com.dp.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	public Integer val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(Integer val) {
		this.val = val;
	}

	List<Integer> toBSTList() {
		return toBSTList(this);
	}

	private List<Integer> toBSTList(TreeNode treeNode) {
		if (treeNode == null) {
			List<Integer> res = new ArrayList<>();
			res.add(null);
			return res;
		}

		List<Integer> res = new ArrayList<>();
		res.add(treeNode.val);
		if (left == null && right == null) {
			return res;
		}

		res.addAll(toBSTList(treeNode.left));
		res.addAll(toBSTList(treeNode.right));
		return res;
	}
}
