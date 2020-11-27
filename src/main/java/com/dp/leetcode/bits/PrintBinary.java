package com.dp.leetcode.bits;

public class PrintBinary {
	String printBinary2(double num){
		if ( num < 0 || num > 1){
			return "0";
		}

		StringBuilder binary = new StringBuilder();
		binary.append(".");
		double frac = 0.5;
		while (num > 0)
		{
            /* Setting a limit on length: 32 characters,
               If the number cannot be represented
               accurately in binary with at most 32
               character  */
			if (binary.length() >= 32)
				return "ERROR";

			// Multiply by 2 in num to check it 1 or 0
			double r = num * 2;
			if (r >= 1)
			{
				binary.append(1);
				num = r - 1;
			}
			else
			{
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	} // 00110000 00101110 00110111 00110010
}
