package com.dp.leetcode.utils;

public class StringUtils
{

    public static int parseNumber(char[] input)
            throws IllegalArgumentException
    {
        int num = 0;
        for (char c : input) {
            if (c - '0' >= 0 && c - '0' <= 9) {
                num *= 10;
                num += c - '0';
            }
            else {
                throw new IllegalArgumentException();
            }
        }

        return num;
    }

    public static boolean isNumber(String input)
    {
        for (char c : input.toCharArray()) {
            if (c - '0' < 0 || c - '0' > 9) {
                return false;
            }
        }
        return true;
    }

    public static char[] getNumber(char[] input, int i)
    {
        int len = 0;
        for (int j = i; input[j] - '0' >= 0 && input[j] - '0' <= 9; j++, len++) { ; }

        char[] result = new char[len];
        int index = 0;
        for (int k = i; input[k] - '0' >= 0 && input[k] - '0' <= 9; k++, index++) {
            result[index] += input[k];
        }
        return result;
    }

    public static boolean isEmpty(String s)
    {
        return null == s || "".equals(s);
    }
}
