package com.dp.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetsBits {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
		int n = nums.length;

		for (int i = 0; i < (1 << n); i++) {

			List<Integer> curr = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0) {
					curr.add(nums[j]);
				}
			}
			output.add(curr);
		}

		return output;
	}
}
