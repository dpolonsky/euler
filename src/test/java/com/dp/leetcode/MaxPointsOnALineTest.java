package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import javafx.util.Pair;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MaxPointsOnALineTest
{

    @Test
    public void testEmpty()
    {
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        int result = maxPointsOnALine.maxPoints(new int[][] {});
        assertEquals(0, result);
    }

    @Test
    public void testOnePoint()
    {
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        int result = maxPointsOnALine.maxPoints(new int[][] {{1, 1}});
        assertEquals(1, result);
    }

    // [[0,0],[0,0]]
    @Test
    public void testPoint2()
    {
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        int result = maxPointsOnALine.maxPoints(new int[][] {{0, 0}, {0,0}});
        assertEquals(2, result);
    }

    @Test
    public void testPoint3()
    {
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        int result = maxPointsOnALine.maxPoints(new int[][] {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}});
        assertEquals(4, result);
    }

    @Test
    public void testPoint4()
    {
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        int result = maxPointsOnALine.maxPoints(new int[][] {{0,0}, {1, 1}, {1, -1}});
        assertEquals(2, result);
    }

    @Test
    public void testPoint5()
    {
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();

        MaxPointsOnALine.Point p1 = new MaxPointsOnALine.Point(0,0);
        MaxPointsOnALine.Point p2 = new MaxPointsOnALine.Point( 94911150,94911151);
        MaxPointsOnALine.Point p3 = new MaxPointsOnALine.Point( 94911151,94911152);
        MaxPointsOnALine.Pair<Integer, Integer> slop1 = p1.slopBetween2Points(p2);
        MaxPointsOnALine.Pair<Integer, Integer> slop2 = p1.slopBetween2Points(p3);
        assertNotEquals(slop1, slop2);
        //[[0,0],[94911150,94911151],[94911151,94911152]]
        int result = maxPointsOnALine.maxPoints(new int[][] {{0,0}, {94911150,94911151}, {94911151,94911152}});
        assertEquals(2, result);
    }

    @Test
    public void testPoint6()
    {
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        int result = maxPointsOnALine.maxPoints(new int[][] {{1, 1}, {2,2}, {3,3}});
        assertEquals(3, result);
    }
}