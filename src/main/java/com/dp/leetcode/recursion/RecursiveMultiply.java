package com.dp.leetcode.recursion;

public class RecursiveMultiply {
	public long multiply(int a, int b){
		boolean minus = a < 0;
		minus =  b < 0 && !minus;
		a = Math.abs(a);
		b = Math.abs(b);

		int min = a < b ? a : b;
		int max = a > b ? a : b;
		int res = multiplyHelper(min, max);
		if ( minus){
			return -res;
		}else{
			return res;
		}
	}

	private int multiplyHelper(int min, int max) {
		if ( min == 0){
			return 0;
		}else if (min == 1){
			return max;
		}

		int val = min >> 1;
		int res = multiplyHelper(val, max);

		if ( min % 2 == 0){
			return res + res;
		}else{
			return res + res + max;
		}
	}
}
