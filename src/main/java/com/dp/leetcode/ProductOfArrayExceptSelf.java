package com.dp.leetcode;

public class ProductOfArrayExceptSelf
{
    public int[] productExceptSelf(int[] nums)
    {
        int[] result = new int[nums.length];
        int[] lefts = new int[nums.length];
        int[] rights = new int[nums.length];

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            lefts[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rights[i] = right;
            right *= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = lefts[i] * rights[i];
        }
        return result;
    }
}
