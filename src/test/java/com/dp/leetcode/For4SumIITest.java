package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class For4SumIITest
{

    @Test
    void fourSumCount()
    {
        For4SumII for4SumII = new For4SumII();
        int i = for4SumII.fourSumCount(new int[] {1, 2}, new int[] {-2, -1}, new int[] {-1, 2}, new int[] {0, 2});
        assertEquals(2, i);
        System.out.println(i);
    }

    @Test
    void fourSumCount2()
    {
        For4SumII for4SumII = new For4SumII();
        int i = for4SumII.fourSumCount(new int[] {-1, -1}, new int[] {-1, 1}, new int[] {-1, 1}, new int[] {1, -1});
        assertEquals(6, i);
        System.out.println(i);
    }
}