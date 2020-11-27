package com.dp.leetcode.recursion;

public class PowXN {
	public double myPow(double x, int n) {
		 // -100.0 < x < 100.0
		if (n == 0 ) {
			return 1;
		}

		double temp = myPow(x, n/2);

		if ( n % 2 == 0){
			return temp * temp;
		}
		else{
			if ( n > 0){
				return x * temp * temp;
			}else{
				return (temp * temp) /x;
			}
		}
	}
}
