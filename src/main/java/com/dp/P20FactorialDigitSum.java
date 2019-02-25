package com.dp;

import com.dp.math.MathUtils;

import java.math.BigInteger;

public class P20FactorialDigitSum
{
    public static void main(String[] args){
      P20FactorialDigitSum p20FactorialDigitSum = new P20FactorialDigitSum();
      int fact = 100;
      long result = p20FactorialDigitSum.factorialDigitSum(fact);
      System.out.printf("Factorial digit sum of %d is %d%n", fact, result);
    }

    private long factorialDigitSum(int factorial)
    {
        BigInteger factorialResult = MathUtils.factorial(1, factorial);
        long result = 0;
        for ( char c : factorialResult.toString().toCharArray()){
            result += c -'0';
        }
        return result;
    }
}
