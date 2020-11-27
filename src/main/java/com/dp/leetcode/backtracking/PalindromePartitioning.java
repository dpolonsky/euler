package com.dp.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/***
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> partitions = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		List<List<String>> res = addStrings(partitions, s, temp, 0);
		printSolution(res);
		return res;
	}

	// Goes through all indexes and recursively add remaining
	// partitions if current string is palindrome.
	static List<List<String>> addStrings(List<List<String>> v, String s, List<String> temp, int index) {
		int len = s.length();
		String str = "";
		List<String> current = new ArrayList<>(temp);

		if (index == 0)
			temp.clear();

		// Iterate over the string
		for (int i = index; i < len; ++i) {
			str = str + s.charAt(i);

			// check whether the substring is
			// palindromic or not
			if (checkPalindrome(str)) {
				// if palindrome add it to temp list
				temp.add(str);

				if (i + 1 < len) {
					// recurr to get all the palindromic
					// partitions for the substrings
					v = addStrings(v, s, temp, i + 1);
				} else {
					// if end of the string is reached
					// add temp to v
					v.add(temp);
				}

				// temp is reinitialize with the
				// current i.
				temp = new ArrayList<>(current);
			}
		}
		return v;
	}


	// Returns true if str is palindrome, else false
	static boolean checkPalindrome(String str) {
		int len = str.length();
		len--;
		for (int i = 0; i < len; i++, len--) {
			if (str.charAt(i) != str.charAt(len))
				return false;
//			len--;
		}
		return true;
	}

	// Prints the partition list
	static void printSolution(List<List<String>> partitions) {
		for (List<String> i : partitions) {
			for (String j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
