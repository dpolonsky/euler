package com.dp.leetcode;

public class ContainerWithMostWater
{
    public int maxArea(int[] height)
    {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                result = Math.max(result, (Math.min(height[i], height[j])) * (j - i));
            }
        }
        return result;
    }
}
