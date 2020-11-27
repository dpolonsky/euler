package com.dp.leetcode.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.sun.tools.javac.util.Assert;

class SurroundedRegionsTest {

	@Test
	void solve() {
		SurroundedRegions surroundedRegions = new SurroundedRegions();
		//		X X X X
		//		X O O X
		//		X X O X
		//		X O X X
		char[][] board = { { 'X', 'X', 'X', 'X' },
				{ 'X', 'O', 'O', 'X' },
				{ 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		surroundedRegions.solve(board);
		String result = Arrays.stream(board).map(String::new).collect(Collectors.joining(","));
		Assert.check(result.equals("XXXX,XXXX,XXXX,XOXX"));
	}

	@Test
	void solve1() {
		//[["O","O","O"],["O","O","O"],["O","O","O"]]
		SurroundedRegions surroundedRegions = new SurroundedRegions();
		char[][] board = { { 'O', 'O', 'O', 'O' },
				{ 'O', 'O', 'O', 'O' },
				{ 'O', 'O', 'O', 'O' } };
		surroundedRegions.solve(board);
		String result = Arrays.stream(board).map(String::new).collect(Collectors.joining(","));
		Assert.check(result.equals("OOOO,OOOO,OOOO"));
	}

	@Test
	void solve2() {
		// [["O","X","X","O","X"],["X","O","O","X","O"],["X","O","X","O","X"],["O","X","O","O","O"],["X","X","O","X","O"]]
		SurroundedRegions surroundedRegions = new SurroundedRegions();
		char[][] board = {
				{ 'O', 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'O', 'X', 'O' },
				{ 'X', 'O', 'X', 'O', 'X' },
				{ 'O', 'X', 'O', 'O', 'O' },
				{ 'X', 'X', 'O', 'X', 'O' } };
		surroundedRegions.solve(board);
		String result = Arrays.stream(board).map(String::new).collect(Collectors.joining(","));
		// [["O","X","X","O","X"],["X","X","X","X","O"],["X","X","X","O","X"],["O","X","O","O","O"],["X","X","O","X","O"]]
		System.out.println(result);
		Assert.check(result.equals("OXXOX,XXXXO,XXXOX,OXOOO,XXOXO"));
	}
}