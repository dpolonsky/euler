package com.dp.leetcode.arrays;

public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		int i = 0, j = 1;
		while (j < nums.length) {
			if (nums[i] == nums[j]) {
				j++;
			} else {
				if (j > i + 1) {
					nums[++i] = nums[j++];
				} else {
					i++;
					j++;
				}
			}
		}
		return i + 1;
	}
}
