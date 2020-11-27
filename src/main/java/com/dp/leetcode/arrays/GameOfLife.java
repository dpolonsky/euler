package com.dp.leetcode.arrays;

public class GameOfLife
{

    public void gameOfLife(int[][] board){
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = getState(board, i, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = result[i][j];
            }
        }
    }

    private int getState(int[][] board, int i, int j)
    {
        int aliveNeighbours = 0;
        boolean isAlive = board[i][j] == 1;
        int maxRow = i + 1;
        int maxCol = j + 1;
        for (int row = i - 1; row <= maxRow; row++) {
            for (int col = j - 1; col <= maxCol; col++) {
                if (inBoundaries(row, col, board)) {
                    if (row == i && col == j){
                        // skip same cell
                    }else {
                        aliveNeighbours += (board[row][col] == 1) ? 1 : 0;
                    }
                }
            }
        }

        if (!isAlive && aliveNeighbours == 3) {
            return 1;
        }
        if (isAlive && (aliveNeighbours == 2 || aliveNeighbours == 3)) {
            return 1;
        }
        return 0;
    }

    private boolean inBoundaries(int row, int col, int[][] board){
        return row >= 0 && col >= 0 && row < board.length && col < board[row].length;
    }
}
