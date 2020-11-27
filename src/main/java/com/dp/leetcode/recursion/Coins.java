package com.dp.leetcode.recursion;

public class Coins {

	public static void main(String[] args) {
		Coins coins = new Coins();
		int change = coins.change(100);
	}

	public int change(int n) {
		int[] denoms = { 25, 10, 5, 1 };
		int[][] map = new int[n + 1][denoms.length];
		int ways = change(n, denoms, 0, map);
		System.out.println("ways:" + ways);
		return ways;
	}

	private int change(int amount, int[] denoms, int index, int[][] map) {
		if (map[amount][index] > 0) {
			return map[amount][index];
		}

		if (index >= denoms.length - 1)
			return 1;

		int denomAmount = denoms[index];
		int ways = 0;
		for (int i = 0; i * denomAmount < amount; i++) {
			int amountRemaining = amount - i * denomAmount;
			ways += change(amountRemaining, denoms, index + 1, map);
		}
		map[amount][index] = ways;
		return ways;
	}
}
