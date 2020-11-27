package com.dp.leetcode.arrays;

import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;

class SellStocks3Test
{

    @Test
    void maxProfit()
    {
        SellStocks3 sellStocks3 = new SellStocks3();
        int res = sellStocks3.maxProfit(new int[] {3, 3, 5, 0, 0, 3, 1, 4});
        Assert.check(res == 6);

        res = sellStocks3.maxProfit(new int[] {1, 2, 3, 4, 5});
        Assert.check(res == 4);

        res = sellStocks3.maxProfit(new int[] {7, 6, 4, 3, 1});
        Assert.check(res == 0);

        res = sellStocks3.maxProfit(new int[] {1});
        Assert.check(res == 0);

        res = sellStocks3.maxProfit(new int[] {2, 1, 4});
        Assert.check(res == 3);

        // [2,1,4]
    }
}