package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerWithMostWaterTest
{

    @Test
    void maxArea()
    {
        ContainerWithMostWater container = new ContainerWithMostWater();
        int result = container.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(result);
        assertEquals(49, result);
    }
}