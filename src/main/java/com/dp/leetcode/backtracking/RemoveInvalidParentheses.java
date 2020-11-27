package com.dp.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

	private Set<String> validExpressions = new HashSet<>();

	private void recurse(
			String s,
			int index,
			int leftCount,
			int rightCount,
			int leftRem,
			int rightRem,
			StringBuilder expression) {

		// If we reached the end of the string, just check if the resulting expression is
		// valid or not and also if we have removed the total number of left and right
		// parentheses that we should have removed.
		if (index == s.length()) {
			if (leftRem == 0 && rightRem == 0) {
				this.validExpressions.add(expression.toString());
			}

		} else {
			char character = s.charAt(index);
			int length = expression.length();

			// The discard case. Note that here we have our pruning condition.
			// We don't recurse if the remaining count for that parenthesis is == 0.
			if ((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0)) {
				recurse(
						s,
						index + 1,
						leftCount,
						rightCount,
						leftRem - (character == '(' ? 1 : 0),
						rightRem - (character == ')' ? 1 : 0),
						expression);
			}

			expression.append(character);

			// Simply recurse one step further if the current character is not a parenthesis.
			if (character != '(' && character != ')') {

				recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);

			} else if (character == '(') {

				// Consider an opening bracket.
				recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);

			} else if (rightCount < leftCount) {

				// Consider a closing bracket.
				recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
			}

			// Delete for backtracking.
			expression.deleteCharAt(length);
		}
	}

	public List<String> removeInvalidParentheses(String s) {

		int left = 0, right = 0;

		// First, we find out the number of misplaced left and right parentheses.
		for (char c : s.toCharArray()) {

			// Simply record the left one.
			if (c == '(') {
				left++;
			} else if (c == ')') {
				if (left > 0) {
					left--;
				} else {
					right++;
				}
			}
		}

		recurse(s, 0, 0, 0, left, right, new StringBuilder());
		return new ArrayList<>(validExpressions);
	}
}
