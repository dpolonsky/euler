package com.dp.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class PowerSetTest {

	@Test
	void getSubsets2() {
		PowerSet powerSet = new PowerSet();
		ArrayList<Integer> arr = new ArrayList<>();
		IntStream.rangeClosed(1, 4).forEach(arr::add);
		ArrayList<ArrayList<Integer>> res = powerSet.getSubsets2(arr);
		System.out.println(res);
	}

	@Test
	void getSubsets() {
		PowerSet powerSet = new PowerSet();
		ArrayList<Integer> arr = new ArrayList<>();
		IntStream.rangeClosed(1, 3).forEach(arr::add);
		ArrayList<ArrayList<Integer>> res = powerSet.getSubsets(arr);
		System.out.println(res);
	}
}