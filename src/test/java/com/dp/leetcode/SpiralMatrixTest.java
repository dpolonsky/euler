package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import com.dp.leetcode.arrays.SpiralMatrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralMatrixTest
{

    @Test
    void spiralOrder1()
    {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] input = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        List<Integer> result = spiralMatrix.spiralOrder(input);
        String output = result.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(output);
        assertEquals("1,2,3,6,9,8,7,4,5", output);
    }

    @Test
    void spiralOrderEmpty()
    {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] input = new int[][] {};
        List<Integer> result = spiralMatrix.spiralOrder(input);
        String output = result.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(output);
        assertEquals("", output);
    }

    @Test
    void spiralOrder2()
    {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] input = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}};
        List<Integer> result = spiralMatrix.spiralOrder(input);
        String output = result.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(output);
        assertEquals("1,2,3,4,8,12,11,10,9,5,6,7", output);
    }

    @Test
    void spiralOrder3()
    {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] input = new int[][] {
                {3},
                {2}};
        List<Integer> result = spiralMatrix.spiralOrder(input);
        String output = result.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(output);
        assertEquals("3,2", output);
    }

    @Test
    void spiralOrder4()
    {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] input = new int[][] {
                {1, 2},
                {3, 4},
                {5, 6}};
        List<Integer> result = spiralMatrix.spiralOrder(input);
        String output = result.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(output);
        assertEquals("1,2,4,6,5,3", output);
    }

    @Test
    void spiralOrder5()
    {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] input = new int[][] {
                {6,9,7}};
        List<Integer> result = spiralMatrix.spiralOrder(input);
        String output = result.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(output);
        assertEquals("6,9,7", output);
    }
}