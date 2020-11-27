package com.dp;

import com.dp.math.MathUtils;
import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class P21AmicableNumbers
{
    public static void main(String[] args){
        P21AmicableNumbers p21AmicableNumbers = new P21AmicableNumbers();
        p21AmicableNumbers.sumOfAmicableNumbers(10_000);
    }

    private void sumOfAmicableNumbers(int limit)
    {
        // find all divisors of number under limit
        // put number and sum of divisors in hash, check for matching pairs
//        HashMap<Integer, Integer> mapping = new HashMap<>();
//        IntStream.range(1, limit).forEach(n ->{
//            List<Integer> divisors =  MathUtils.findDivisors(n);
//            if ( divisors != null && !divisors.isEmpty())
//                mapping.put(n, divisors.stream().reduce((i, v) -> i + v).get());
//        });
//
//        Set<Map.Entry<Integer, Integer>> result = new HashSet<>();
//        long sum = 0;
//        for (Map.Entry<Integer, Integer> entry : mapping.entrySet()){
//            if ( entry.getKey().equals(mapping.get(entry.getValue()))){
//                System.out.printf("%d:%d%n", entry.getKey(), entry.getValue());
//                sum += entry.getKey() + entry.getValue();
//                result.add(entry);
//            }
//        }
        long start = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 10000; i++)
        {
            Pair<Boolean, Integer> amicable = getAmicable(i);
            if (amicable.fst)
            {
                sum += amicable.snd;
            }
        }
        //31626
        System.out.printf("total sum is:%d, took:%d %n", sum, System.currentTimeMillis() - start);
    }

    private static ArrayList<Integer> createList(int n)
    {
        // Creates a list of integers that evenly divide into n excluding n itself
        long root = Math.round(Math.sqrt(n)) + 1;

        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(1);

        for (int i = 2; i <= root; i++)
        {
            if (n % i == 0)
            {
                test.add(i);		// Add the divisor & its complement
                test.add(n/i);
            }
        }

        return test;
    }

    private static Pair<Boolean, Integer> getAmicable(int n)
    {
        List<Integer> divisorsOfA = MathUtils.findDivisors(n);
        Integer sumA = divisorsOfA.stream().reduce((i, v) -> i + v).get();

        List<Integer> divisorsOfB = MathUtils.findDivisors(sumA);
        Integer sumB = divisorsOfB.stream().reduce((i, v) -> i + v).get();
        // Create a list of n's proper divisors

        return (sumB == n) && !sumB.equals(sumA) ? Pair.of(true, sumA) : Pair.of(false, null);
    }

//    public static void main(String[] args)
//    {
//        long begin = System.currentTimeMillis();
//
//        int sum = 0;
//        for (int i = 0; i < 10000; i++)
//        {
//            Pair<Boolean, Integer> amicable = getAmicable(i);
//            if (amicable.fst)
//            {
//                sum += amicable.snd;
//            }
//        }
//
//        System.out.println(sum);
//
//        long end = System.currentTimeMillis();
//        System.out.println(end-begin + "ms");
//    }
}
