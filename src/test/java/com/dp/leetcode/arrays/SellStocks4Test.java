package com.dp.leetcode.arrays;

import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;

class SellStocks4Test
{

    @Test
    void maxProfit()
    {
        SellStocks4 sellStocks = new SellStocks4();
        final int res = sellStocks.maxProfit(2, new int[] {2, 4, 1});
        Assert.check(res == 2);
    }
}