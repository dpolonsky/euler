package com.dp.leetcode.arrays;

public class MaximumDifference {
	//
	int maxDiff(int[] arr) {
		//
		if ( arr.length < 2){
			throw new IllegalArgumentException("arr length less than 2");
		}

		int maxDiff = arr[1] - arr[0];
		int minIndex = arr[0];

		int i;
		for (i = 1; i < arr.length; i++) {
			if (arr[i] - minIndex > maxDiff) {
				maxDiff = arr[i] - minIndex	;
			}
			if (minIndex > arr[i]){
				minIndex = arr[i];
			}
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		MaximumDifference maxDiff = new MaximumDifference();
		int[] arr = { 1, 2, 90, 10, 110 };
		System.out.println("Maximum differnce is " + maxDiff.maxDiff(arr));
	}
}
