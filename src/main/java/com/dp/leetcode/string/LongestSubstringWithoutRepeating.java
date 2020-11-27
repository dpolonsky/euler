package com.dp.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
	/**
	 * The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps. Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index. Then we can skip the characters immediately when we found a repeated character.
	 * The reason is that if s[j]s[j] have a duplicate in the range [i, j)[i,j) with index j'j
	 *  , we don't need to increase ii little by little. We can skip all the elements in the range [i, j'][i,j] and let ii to be j' + 1j
	 * ′
	 *  +1 directly.
	 *
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}
}
