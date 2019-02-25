package com.dp;

public class P18MaxPathSum
{
    static int[][] getGrid()
    {
        return new int[][] {
                {75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {95, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {17, 47, 82, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {18, 35, 87, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {20, 4, 82, 47, 65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {19, 1, 23, 75, 3, 34, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {88, 2, 77, 73, 7, 63, 67, 0, 0, 0, 0, 0, 0, 0, 0},
                {99, 65, 4, 28, 6, 16, 70, 92, 0, 0, 0, 0, 0, 0, 0},
                {41, 41, 26, 56, 83, 40, 80, 70, 33, 0, 0, 0, 0, 0, 0},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29, 0, 0, 0, 0, 0},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14, 0, 0, 0, 0},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57, 0, 0, 0},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48, 0, 0},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31, 0},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}};
    }

    public static void main(String[] args)
    {
        P18MaxPathSum p18MaxPathSum = new P18MaxPathSum();
        int sum = p18MaxPathSum.findPath(getGrid(), 15, 15);
        System.out.printf("for 15x15 matrix the sum is:%d%n", sum);
    }

    int findPath(int[][] grid, int row, int col)
    {
        int[][] costs = new int[row][col];

        for (int i = 0; i < row; i++) {
            if (col >= 0)
                System.arraycopy(grid[i], 0, costs[i], 0, col);
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                costs[i][j] = childCellsMax(costs[i + 1], j) + grid[i][j];
            }
        }
        return costs[0][0];
    }

    private int childCellsMax(int[] ints, int j)
    {
        int max = ints[j];
        if (j - 1 > 0) {
            Math.max(ints[j - 1], ints[j]);
        }
        if (j + 1 < ints.length - 1) {
            max = Math.max(max, ints[j + 1]);
        }
        return max;
    }
}
