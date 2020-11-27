package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstMissingPositiveTest
{

    @Test
    void firstMissingPositive()
    {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int result = firstMissingPositive.firstMissingPositiveMinHeap(new int[] {1, 2, 0});
        assertEquals(3, result);
    }

    @Test
    void firstMissingPositive1()
    {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int result = firstMissingPositive.firstMissingPositiveMinHeap(new int[] {3, 4, -1, 1});
        assertEquals(2, result);
    }

    @Test
    void firstMissingPositive2()
    {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int result = firstMissingPositive.firstMissingPositiveMinHeap(new int[] {7, 8, 9, 11, 12});
        assertEquals(1, result);
    }

    @Test
    void firstMissingPositive3()
    {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int result = firstMissingPositive.firstMissingPositiveMinHeap(new int[] {1, 1});
        assertEquals(2, result);
    }


    @Test
    void firstMissingPositiveArray()
    {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int result = firstMissingPositive.firstMissingPositive(new int[] {1, 2, 0});
        assertEquals(3, result);

        result = firstMissingPositive.firstMissingPositive(new int[] {3, 4, -1, 1});
        assertEquals(2, result);

        result = firstMissingPositive.firstMissingPositiveMinHeap(new int[] {7, 8, 9, 11, 12});
        assertEquals(1, result);

        result = firstMissingPositive.firstMissingPositiveMinHeap(new int[] {1, 1});
        assertEquals(2, result);
    }
}