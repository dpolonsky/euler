package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheDuplicateNumberTest
{
    @Test
    public void findDuplicateTest1()
    {
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        int res = findTheDuplicateNumber.findDuplicate(new int[] {1, 3, 4, 2, 2});
        assertEquals(2, res);
    }

    @Test
    public void findDuplicateTest2()
    {
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        int res = findTheDuplicateNumber.findDuplicate(new int[] {3, 1, 3, 4, 2});
        assertEquals(3, res);
    }

    @Test
    public void findDuplicateTest3()
    {
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        int res = findTheDuplicateNumber.findDuplicate(new int[] {1, 2, 2});
        assertEquals(2, res);
    }

    @Test
    public void findDuplicateTest4()
    {
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        int res = findTheDuplicateNumber.findDuplicate(new int[] {1, 3, 4, 2, 1});
        assertEquals(1, res);
    }

    @Test
    public void findDuplicateTest5()
    {
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        int res = findTheDuplicateNumber.findDuplicate(new int[] {1, 3, 4, 2, 4});
        assertEquals(4, res);
    }

    @Test
    public void findDuplicateTest6()
    {
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        int res = findTheDuplicateNumber.findDuplicate(new int[] {2, 2, 2, 2, 2});
        assertEquals(2, res);
    }
    // [1,3,4,2,1]
}