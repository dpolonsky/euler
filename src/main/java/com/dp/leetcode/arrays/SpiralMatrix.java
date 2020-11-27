package com.dp.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix
{
    enum direction
    {
        right, down, left, up
    }

    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> result = new ArrayList<>();
        if ( matrix == null || matrix.length == 0)
            return result;

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i =0;i<rows;i++){
            Arrays.fill(visited[i], false);
        }

        int currentRow = 0;
        int currentCol = 0;
        for (; currentRow < rows && currentCol < cols; currentCol++, currentRow++) {
            result.addAll(iterate(matrix, visited, direction.right, currentRow, currentCol, rows, cols));
            result.addAll(iterate(matrix, visited,  direction.down, currentRow, currentCol, rows, cols));
            if ( cols > 1 && rows > 1) {
                result.addAll(iterate(matrix, visited,  direction.left, currentRow, currentCol, rows, cols));
                result.addAll(iterate(matrix, visited,  direction.up, currentRow, currentCol, rows, cols));
            }
        }

        return result;
    }

    private List<Integer> iterate(int[][] matrix, boolean[][] visited, direction dir, int currentRow, int currentCol, int rows, int cols)
    {
        List<Integer> result = new ArrayList<>();
        switch (dir) {
            case right:
                for (int i = currentCol; i < cols - currentCol; i++) {
                    if ( !visited[currentRow][i]) {
                        result.add(matrix[currentRow][i]);
                        visited[currentRow][i] = true;
                    }
                }
                break;
            case down:
                for (int i = currentRow + 1; i < rows - currentRow; i++) {
                    if ( !visited[i][cols-currentCol-1]) {
                        result.add(matrix[i][cols - currentCol - 1]);
                        visited[i][cols-currentCol-1] = true;
                    }
                }
                break;
            case left:
                for (int i = cols - currentCol - 2; i > currentCol; i--) {
                    if ( !visited[rows-currentRow-1][i]) {
                        result.add(matrix[rows - currentRow - 1][i]);
                        visited[rows - currentRow - 1][i] = true;
                    }
                }
                break;
            case up:
                for (int i = rows - currentRow - 1; i > currentRow; i--) {
                    if ( !visited[i][currentCol]) {
                        result.add(matrix[i][currentCol]);
                        visited[i][currentCol] = true;
                    }
                }
                break;
        }
        return result;
    }
}
