package com.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * <p>
 * a(2) + b(2) = c(2)
 * For example, 3(2) + 4(2)= 9 + 16 = 25 = 5(2).
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class P9SpecialPythagoreanTriplet {
	public static void main(String[] args) {
		P9SpecialPythagoreanTriplet p9SpecialPythagoreanTriplet = new P9SpecialPythagoreanTriplet();
		p9SpecialPythagoreanTriplet.process(1000);
	}

	private List<Integer> process(int product) {
		for (int a = 2; a <= product / 2; a++) {
			for (int b = a + 1; b <= product / 2; b++) {
				double sumAnB = (a * a) + (b * b);
				double c = Math.pow(sumAnB, 0.5);
				if ((b < c) && (a + b + c == product)) {
					int intC = (int) Math.round(c);
					System.out.printf("%d, %d, %d, product:%d\n", a, b, intC, a * b * intC);
					return Arrays.asList(a, b, intC);
				}
			}
		}

		return Collections.emptyList();
	}
}
