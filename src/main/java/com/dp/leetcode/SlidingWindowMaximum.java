package com.dp.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

	public int[] maxSlidingWindowDynamic(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];

		int n = nums.length;
		if ( n * k == 0)
			return new int[0];

		if (k == 1)
			return nums;


		int resultCapacity = n - k + 1;
		int [] left = new int[n];
		left[0] = nums[0];
		int [] right = new int[n];
		right[n - 1] = nums[n - 1];
		for (int i = 1; i < n; i++) {
			// from left to right
			if (i % k == 0) left[i] = nums[i];  // block_start
			else left[i] = Math.max(left[i - 1], nums[i]);

			// from right to left
			int j = n - i - 1;
			if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
			else right[j] = Math.max(right[j + 1], nums[j]);
		}

		int [] output = new int[resultCapacity];
		for (int i = 0; i < n - k + 1; i++)
			output[i] = Math.max(left[i + k - 1], right[i]);

		return output;
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];

		if ( nums.length * k == 0)
			return new int[0];

		if (k == 1)
			return nums;

		int resultCapacity = nums.length - k + 1;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

		int[] result = new int[resultCapacity];
		int resultIndex = 0;
		int outOfWindow = 0;
		for (int i = 0; i < nums.length; i++) {
			maxHeap.add(nums[i]);
			if (maxHeap.size() == k) {
				result[resultIndex++] = maxHeap.peek();
				maxHeap.remove(nums[outOfWindow++]);
			}
		}
		return result;
	}
}
