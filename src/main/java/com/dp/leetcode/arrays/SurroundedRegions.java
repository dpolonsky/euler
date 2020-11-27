package com.dp.leetcode.arrays;

public class SurroundedRegions {

	static int cols = 0;
	static int rows = 0;

	public void solve(char[][] board) {

		if (board == null || board.length == 0) {
			return;
		}

		rows = board.length;
		cols = board[0].length;

		// Step 1). mark the escaped cells from boarder
		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < cols; ++c) {
				if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1) {
					dfs(board, r, c);
				}
			}
		}

		// Step 2). flip the cells to their correct final states
		for (int r = 0; r < rows; ++r) {
			for (int c = 0; c < cols; ++c) {
				if (board[r][c] == 'O')
					board[r][c] = 'X';
				if (board[r][c] == 'E')
					board[r][c] = 'O';
			}
		}
	}

	protected void dfs(char[][] board, int row, int col) {
		if (board[row][col] != 'O')
			return;

		board[row][col] = 'E';
		if (col < cols - 1)
			dfs(board, row, col + 1);
		if (row < rows - 1)
			dfs(board, row + 1, col);
		if (col > 0)
			dfs(board, row, col - 1);
		if (row > 0)
			dfs(board, row - 1, col);
	}
}
//		X X X X
//		X O O X
//		X X O X
//		X O X X