package com.dp.leetcode.recursion;

import java.util.HashSet;
import java.util.Set;

public class Parens {

	public static void main(String[] args) {
		Parens parens = new Parens();
		parens.print(4);
	}

	public void print(int n) {
		if (n <= 0) {
			return;
		}
		Set<String> res = getParens(n);
		System.out.println(String.join(",", res));
	}

	private Set<String> getParens(int n) {
		Set<String> res = new HashSet<>();
		if (n == 0) {
			res.add("");
			return res;
		}

		Set<String> prev = getParens(n - 1);

		for (String str : prev) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					res.add(insert(str, i));
				}
			}
			res.add("()" + str);
		}

		return res;
	}

	private String insert(String str, int i) {
		return str.substring(0, i + 1) + "()" + str.substring(i + 1);
	}
}
