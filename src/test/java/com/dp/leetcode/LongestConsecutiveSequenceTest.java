package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestConsecutiveSequenceTest
{

    @Test
    void longestConsecutive1()
    {
        LongestConsecutiveSequence sequence = new LongestConsecutiveSequence();
        int result = sequence.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2});
        assertEquals(4 ,result);
    }

    @Test
    void longestConsecutive2()
    {
        LongestConsecutiveSequence sequence = new LongestConsecutiveSequence();
        int result = sequence.longestConsecutive(new int[] {0,-1});
        assertEquals(2 ,result);
    }
    // [0,-1]
}