package com.dp;

import com.dp.math.MathUtils;

import java.math.BigInteger;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 *
 * C(n,r) = n! / r!*(n-r)!
 *
 * http://joaoff.com/2008/01/20/a-square-grid-path-problem/
 */

public class P15LatticePaths
{
    public static void main(String[] args)
    {
        P15LatticePaths p15LatticePaths = new P15LatticePaths();
        p15LatticePaths.proccess(20);
    }

    private void proccess(int limit)
    {
        BigInteger counter = multiplicativeFormula(limit + limit, limit);
        System.out.println("number of paths:" + counter.toString());
    }

    private BigInteger multiplicativeFormula(int n, int k)
    {
        BigInteger top = MathUtils.factorial(1, n);
        BigInteger bottom = (MathUtils.factorial(1, k).multiply(MathUtils.factorial(1, (n-k))));

        return top.divide(bottom);
    }
}
