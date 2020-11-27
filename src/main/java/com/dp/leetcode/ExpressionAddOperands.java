package com.dp.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperands {
	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<String>();
		if (num == null || num.length() == 0)
			return result;
		StringBuilder sb = new StringBuilder();
		dfs(result, sb, num, target, 0, 0, 0);
		return result;
	}

	public void dfs(List<String> result, StringBuilder sb, String num, int target, int index, long total, long prev) {
		if (index == num.length()) {
			if (total == target) {
				result.add(sb.toString());
			}
			return;
		}
		for (int i = index; i < num.length(); i++) {
			if (i != index && num.charAt(index) == '0')
				continue;
			long cur = Long.parseLong(num.substring(index, i + 1));
			int len = sb.length();
			if (index == 0) {
				// get the first digit
				dfs(result, sb.append(cur), num, target, i + 1, cur, cur);
				sb.setLength(len);
			} else {
				// another operation is to grow the number
				dfs(result, sb.append(cur), num, target, i + 1, total*10 + cur, cur);
				sb.setLength(len);

				// add + operand and value
				dfs(result, sb.append("+").append(cur), num, target, i + 1, total + cur, cur);
				// remove operand
				sb.setLength(len);

				dfs(result, sb.append("-").append(cur), num, target, i + 1, total - cur, -cur);
				sb.setLength(len);

				// for example, if you have a sequence of 12345 and you have proceeded to 1 + 2 + 3, now your prev is 6 right?
				// If you want to add a * between 3 and 4, you would take 3 as the digit to be multiplied, so you want to take it out
				// from the existing prev. You have 1 + 2 + 3 * 4 and the prev now is (1 + 2 + 3) - 3 + (3 * 4).
				dfs(result, sb.append("*").append(cur), num, target, i + 1, total - prev + cur * prev, cur * prev);
				sb.setLength(len);
			}
		}
	}

}
