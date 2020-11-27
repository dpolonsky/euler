package com.dp.leetcode.recursion;

import java.util.ArrayList;

public class PowerSet {
	ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		return getSubsets(set, 0);
	}

	private ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		if (set.size() == index) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<>();
			res.add(new ArrayList<>());
			return res;
		}

		Integer val = set.get(index);
		ArrayList<ArrayList<Integer>> subsets = getSubsets(set, index + 1);
		ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
		for (ArrayList<Integer> s : subsets) {
			ArrayList<Integer> newSubSet = new ArrayList<>(s);
			newSubSet.add(val);
			moreSubsets.add(newSubSet);
		}
		subsets.addAll(moreSubsets);
		return subsets;
	}

	ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int max = 1 << set.size(); // compute 2^n
		for (int i = 0; i < max; i++) {
			result.add(getSet(set, i));
		}
		return result;
	}

	private ArrayList<Integer> getSet(ArrayList<Integer> set, int i) {
		ArrayList<Integer> result = new ArrayList<>();
		int index = 0;
		for (int v = i; v > 0; v >>= 1) {
			if ((v & 1) == 1) {
				result.add(set.get(index));
			}
			index++;
		}
		return result;
	}
}
