package com.dp.leetcode.string;

public class ReverseString {
	public static void main(String[] args) {
		ReverseString reverseString = new ReverseString();
		char[] input = new char[] { 'h', 'e', 'l', 'l', 'o' };
		char[] strings = reverseString.reverseString(input);
		System.out.println(new String(strings));
	}

	public char[] reverseString(char[] s) {
		if ( s == null || s.length == 0)
			return new char[]{};
		return reverseString(s, 0, s.length);
	}

	private char[] reverseString(char[] input, int i, int length) {
		if (i >= length)
			return input;

		char tmp = input[i];
		input[i] = input[length - 1];
		input[length - 1] = tmp;
		return reverseString(input, i + 1, length - 1);
	}
}
