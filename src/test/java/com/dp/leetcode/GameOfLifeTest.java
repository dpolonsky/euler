package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import com.dp.leetcode.arrays.GameOfLife;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameOfLifeTest
{

    @Test
    void gameOfLife()
    {
        GameOfLife gameOfLife = new GameOfLife();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife.gameOfLife(board); //

        int[][] expected = new int[][] {
                {0, 0, 0},
                {1, 0, 1},
                {0, 1, 1},
                {0, 1, 0}
        };

        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], board[i][j], "failed on i:" + i + ", j:" + j);
            }
        }
    }
}