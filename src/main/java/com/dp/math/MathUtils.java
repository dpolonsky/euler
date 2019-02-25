package com.dp.math;

import java.math.BigInteger;

public class MathUtils
{
    public static long gdcRecursive(long a, long b)
    {
        if (b == 0) { return a; }
        return gdcRecursive(b, a % b);
    }

    public static long euclideanGcd(long a, long b)
    {
        if (a == 0) { return b; }

        while (b != 0) {
            if (a > b) { a = a - b; }
            else { b = b - a; }
        }

        return a;
    }

    public static long gcdForLoop(long a, long b)
    {
        long result = 0;
        for (int i = 1; i <= a && i <= b; ++i) {
            // Checks if i is factor of both integers
            if (a % i == 0 && b % i == 0) { result = i; }
        }
        return result;
    }

    public static BigInteger factorial(long n)
    {
        return factorial(1, n);
    }

    public static BigInteger factorial(long start, long n)
    {
        if ( start == 0)
            start = 1;

        long i;
        if (n <= 16) {
            BigInteger r = new BigInteger(String.valueOf(start));
            for (i = start + 1; i < start + n; i++) { r = r.multiply(new BigInteger(String.valueOf(i))); }
            return r;
        }
        i = n / 2;
        return factorial(start, i).multiply(factorial(start + i, n - i));
    }


}
