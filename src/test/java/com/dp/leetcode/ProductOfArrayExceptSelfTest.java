package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ProductOfArrayExceptSelfTest
{
    @Test
    public void test()
    {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        int[] ints = p.productExceptSelf(new int[] {1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }
}