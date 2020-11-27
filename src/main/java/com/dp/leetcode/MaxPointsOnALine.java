package com.dp.leetcode;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;



/**
 * https://github.com/interviewcoder
 * <p>
 * https://leetcode.com/problems/max-points-on-a-line/
 * <p>
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class MaxPointsOnALine
{
    static class Pair<A, B> {
        public final A fst;
        public final B snd;

        public Pair(A var1, B var2) {
            this.fst = var1;
            this.snd = var2;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(fst, pair.fst) &&
                    Objects.equals(snd, pair.snd);
        }

        @Override public int hashCode() {
            return Objects.hash(fst, snd);
        }
    }

    static class Point
    {
        int x;
        int y;

        Point(int a, int b)
        {
            x = a;
            y = b;
        }

        public Pair<Integer, Integer> slopBetween2Points(Point point)
        {
            int yDelta = y - point.y;
            int xDelta = x - point.x;
            if (xDelta == 0) {
                return new Pair<>(0, 0);
            }
            if (yDelta == 0) {
                return new Pair<>(Integer.MAX_VALUE, Integer.MAX_VALUE);
            }
            int gcd = BigInteger.valueOf(xDelta).gcd(BigInteger.valueOf(yDelta)).intValue();

            return new Pair<>(xDelta / gcd, yDelta / gcd);
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) { return true; }
            if (o == null || getClass() != o.getClass()) { return false; }
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(x, y);
        }

        @Override
        public String toString()
        {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public int maxPoints(int[][] pointsArray)
    {
        int result = 0;
        if (pointsArray.length == 0) { return result; }

        List<Point> points = Arrays.stream(pointsArray).map(i -> new Point(i[0], i[1]))
                .sorted((p1, p2) -> p1.x != p2.x ? p1.x - p2.x : p1.y - p2.y).collect(Collectors.toList());

        for (int i = 0; i < points.size(); i++) {
            Point pointa = points.get(i);
            int samePoint = 1;
            int sameX = 0;
            Map<Pair<Integer, Integer>, Integer> slopPoints = new HashMap<>();
            for (int j = i + 1; j < points.size(); j++) {
                Point pointb = points.get(j);
                if (pointa.y == pointb.y && pointa.x == pointb.x) {
                    samePoint++;
                }
                else if (pointa.x == pointb.x) {
                    sameX++;
                }
                else {
                    Pair<Integer, Integer> slop = pointa.slopBetween2Points(pointb);

                    slopPoints.compute(slop, (k, v) -> {
                        if (v == null) { v = 1; }
                        else { v++; }
                        return v;
                    });
                    result = Math.max(result, slopPoints.get(slop) + samePoint);
                }
            }
            result = Math.max(result, samePoint + sameX);
        }
        return result;
    }


    public static void main(String[] args)
    {
        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        maxPointsOnALine.process(args[0]);
    }


    private void process(String arg)
            throws IllegalArgumentException
    {
        if (arg == null || arg.isEmpty()) { return; }

        initPoints(arg);
    }

    // [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
    private void initPoints(String arg)
            throws IllegalArgumentException
    {
        Pattern compile = Pattern.compile("(\\d,\\d)");

        Matcher matcher = compile.matcher(arg);
        int[][] pointsArray = new int[][] {};
        while (matcher.find()) {
            String group = matcher.group();
            String[] split = group.split(",");

            System.out.printf("group:%s%n", group);
            int[] point = {Integer.valueOf(split[0]), Integer.valueOf(split[1])};
            pointsArray = Arrays.copyOf(pointsArray, pointsArray.length + 1);
            pointsArray[pointsArray.length - 1] = point;
        }
        int maxPoints = maxPoints(pointsArray);
        System.out.println(maxPoints);
    }

}
