package com.dp;

import java.math.BigInteger;

/**
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 21000?
 */
public class P16PowerDigitSum
{
    public static void main(String[] args){
      P16PowerDigitSum p16PowerDigitSum= new P16PowerDigitSum();
      long result = p16PowerDigitSum.processBigInts(2,1000);
      System.out.printf("sum is:%d", result);
    }

    private long processBigInts(long base, int exponent)
    {
        long sumResult = 0;
        BigInteger exponentResult = new BigInteger(base + "", 10).shiftLeft(exponent - 1);
        System.out.printf("exponentResult is:%s", exponentResult.toString());
        for ( char c : exponentResult.toString().toCharArray()) {
            sumResult += c - '0';
        }
        return sumResult;
    }

}
