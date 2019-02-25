package com.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P18MaxPathSumTest
{
    @Test
    void findPath()
    {
        int[][] smallGrid = {{3, 0, 0, 0},
                {7, 4, 0, 0},
                {2, 4, 6, 0},
                {8, 5, 9, 3}};
        P18MaxPathSum p18MaxPathSum = new P18MaxPathSum();
        int sum = p18MaxPathSum.findPath(smallGrid, 4, 4);
        System.out.printf("for 4x4 matrix the sum is:%d\n", sum);
        assertEquals(23, sum);
    }
}