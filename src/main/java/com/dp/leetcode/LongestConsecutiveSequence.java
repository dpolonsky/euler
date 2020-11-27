package com.dp.leetcode;

import java.util.HashSet;

public class LongestConsecutiveSequence
{
    public int longestConsecutive(int[] nums)
    {
        if (nums.length == 0) { return 0; }

        HashSet<Integer> startingNumbers = new HashSet<>();

        for (int num : nums) {
            startingNumbers.add(num);
        }

        int max = 1;
        for (int num : startingNumbers) {
            if (startingNumbers.contains(num - 1)) { continue; }

            int currentMax = 0;
            while (startingNumbers.contains(num++)) {
                currentMax++;
            }
            max = Math.max(max, currentMax);
        }

        return max;
    }
}
