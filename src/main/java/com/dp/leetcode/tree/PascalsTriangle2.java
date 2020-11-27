package com.dp.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
	public List<Integer> getRow(int rowIndex) {
		if (rowIndex == 0) {
			ArrayList<Integer> res = new ArrayList<>();
			res.add(1);
			return res;
		}

		if (rowIndex == 1) {
			ArrayList<Integer> res = new ArrayList<>();
			res.add(1);
			res.add(1);
			return res;
		}

		List<Integer> row = getRow(rowIndex - 1);
		ArrayList<Integer> res = new ArrayList<>();
		res.add(1);
		for (int i = 0; i < row.size() - 1; i++) {
			res.add(row.get(i) + row.get(i + 1));
		}
		res.add(1);
		return res;
	}
}
