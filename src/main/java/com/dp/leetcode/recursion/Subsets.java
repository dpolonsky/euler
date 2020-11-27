package com.dp.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	List<List<Integer>> output = new ArrayList<>();
	int n, k;

	public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
		// if the combination is done
		if (curr.size() == k) {
			output.add(new ArrayList<>(curr));
			return;
		}

		for (int i = first; i < n; ++i) {
			// add i into the current combination
			curr.add(nums[i]);
			// use next integers to complete the combination
			backtrack(i + 1, curr, nums);
			// backtrack
			curr.remove(curr.size() - 1);
		}
	}

	public List<List<Integer>> subsets(int[] nums) {
		n = nums.length;
		for (k = 0; k <= n ; ++k) {
			backtrack(0, new ArrayList<>(), nums);
		}
		return output;
	}
}
