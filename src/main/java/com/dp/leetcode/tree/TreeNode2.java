package com.dp.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode2<G> {
	public G val;
	public List<TreeNode2<G>> children;

	public TreeNode2(G val) {
		this.val = val;
	}

	List<G> toBSTList() {
		return toBSTList(this);
	}

	private List<G> toBSTList(TreeNode2<G> treeNode) {
		if (treeNode == null) {
			List<G> res = new ArrayList<>();
			res.add(null);
			return res;
		}

		List<G> res = new ArrayList<>();
		res.add(treeNode.val);
		if ( children == null || children.size() == 0){
			return res;
		}

		for ( TreeNode2 node : children) {
			res.addAll(toBSTList(node));
		}

		return res;
	}
}
