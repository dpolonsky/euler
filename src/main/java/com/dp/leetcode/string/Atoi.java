package com.dp.leetcode.string;

public class Atoi {
	public int myAtoi(String str) {
		int sign = 1, base = 0, i = 0;

		if (str == null || "".equals(str)) {
			return 0;
		}

		if (!validInput(str.charAt(0))) {
			return 0;
		}

		// if whitespaces then ignore.
		for (; i < str.length(); i ++) {
			if ( str.charAt(i) != ' '){
				break;
			}
		}

		if (str.length() == i) {
			return 0;
		}

		// sign of number
		if (str.charAt(i) == '-' || str.charAt(i) == '+') {
			sign = 1 - 2 * (str.charAt(i++) == '-' ? 1 : 0);
		}

		// checking for valid input
		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			// handling overflow test case
			if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
				if (sign == 1)
					return Integer.MAX_VALUE;
				else
					return Integer.MIN_VALUE;
			}
			base = 10 * base + (str.charAt(i++) - '0');
		}
		return base * sign;
	}

	boolean validInput(char c) {
		return (c == ' ' || (c >= '0' && c <= '9') || c == '+' || c == '-');
	}
}
