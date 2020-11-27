package com.dp.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsWithoutDups {
	public List<String> permutation(String val) {
		if (val == null) {
			return null;
		}

		return permutationHelper(0, val);
	}

	private List<String> permutationHelper(int i, String val) {
		ArrayList<String> permutations = new ArrayList<>();

		if (val.length() == i) {
			permutations.add("");
			return permutations;
		}

		char c = val.charAt(i);
		List<String> words = permutationHelper(i + 1, val);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				permutations.add(insertCharAt(word, c, j));
			}
		}
		return permutations;
	}

	private String insertCharAt(String word, char c, int i) {
		String res = word.substring(0, i) + c + word.substring(i);
		return res;
	}
}
