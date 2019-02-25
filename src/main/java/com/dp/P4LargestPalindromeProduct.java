package com.dp;

import java.util.HashMap;
import java.util.Map;

import com.sun.tools.javac.util.Pair;

/**
 * Largest palindrome product
 * Problem 4
 *
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class P4LargestPalindromeProduct {
	public static void main(String[] args){
		P4LargestPalindromeProduct largestPalindromeProduct = new P4LargestPalindromeProduct();
		largestPalindromeProduct.process(3);
	}

	private void process(int numOfdigits) {
		Map<Long, Pair<Integer, Integer>> mapPolindromNumbers = new HashMap<>();
		Pair<Integer, Integer> numberRange = getNumberRange(numOfdigits);
		long maxPolyndrom = Integer.MIN_VALUE;
		for ( int i=numberRange.fst; i<numberRange.snd; i++){
			for ( int j=numberRange.fst; j<numberRange.snd; j++){
				long value = i * j;
				if ( value > maxPolyndrom && isPolyndrom(value)){
					maxPolyndrom = Math.max(maxPolyndrom, value);
					mapPolindromNumbers.put(maxPolyndrom, Pair.of(i, j));
				}
			}
		}

		System.out.println(String.format("Max polyndrom:%d produced by:%d * %d", maxPolyndrom, mapPolindromNumbers.get(maxPolyndrom).fst, mapPolindromNumbers.get(maxPolyndrom).snd));
	}

	protected boolean isPolyndrom(long value) {
		char[] charArray = String.valueOf(value).toCharArray();
		for ( int i =0; i<=charArray.length/2; i++){
			if ( charArray[i] != charArray[charArray.length - 1 - i])
				return false;
		}
		return true;
	}

	private Pair<Integer, Integer> getNumberRange(int numOfdigits) {
		if ( numOfdigits == 0)
			return Pair.of(0,0 );

		return Pair.of((int)Math.pow(10, numOfdigits-1), (int)Math.pow(10, numOfdigits));
	}
}
