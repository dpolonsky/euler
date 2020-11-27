package com.dp.leetcode;

import java.util.Arrays;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 */
public class WildcardMatching
{
    public boolean isMatch(String s, String p)
    {
        p = squashPattern(p);
        return strmatch(s, p, s.length(), p.length());
    }

    static boolean strmatch(String str, String pattern,
            int n, int m)
    {
        // empty pattern can only match with
        // empty string
        if (m == 0)
            return (n == 0);

        // lookup table for storing results of
        // subproblems
        boolean[][] lookup = new boolean[n + 1][m + 1];

        // initailze lookup table to false
        for(int i = 0; i < n + 1; i++) {
            Arrays.fill(lookup[i], false);
        }

        // empty pattern can match with empty string
        lookup[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];

        // fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1] ||
                            lookup[i - 1][j];

                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match
                else if (pattern.charAt(j - 1) == '?' ||
                        str.charAt(i - 1) == pattern.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];

                    // If characters don't match
                else lookup[i][j] = false;
            }
        }

        return lookup[n][m];
    }

    private String squashPattern(String p)
    {
        StringBuilder result = new StringBuilder();
        char[] charArray = p.toCharArray();
        for (int i=0; i< charArray.length; i++) {
            if (charArray[i]== '*') {
                if ( i > 0 && charArray[i-1] == '*'){
                    continue;
                }
            }
            result.append(charArray[i]);
        }

        return result.toString();
    }

    private boolean match(String s, String p)
    {
        if ("" .equals(s) && "" .equals(p)) {
            return true;
        }

        if (s.equals(p)) {
            return true;
        }

        if (isAllAstrix(p)) {
            return true;
        }

        if ((p.length() >= 1 && p.charAt(0) == '?' && s.length() >= 1) ||
                (p.length() != 0 && s.length() != 0 && p.charAt(0) == s.charAt(0))) {
            return match(s.substring(1), p.substring(1));
        }

        if (p.length() > 0 && p.charAt(0) == '*' && s.length() > 0) { return match(s, p.substring(1)) || match(s.substring(1), p); }
        return false;
    }

    boolean isAllAstrix(String v)
    {
        if (v.equals("*")) {
            return true;
        }

        boolean result = false;
        for (int i = 0; i < v.toCharArray().length; i++) {
            if (v.toCharArray()[i] != '*') {
                return false;
            }
            else {
                result = true;
            }
        }
        return result;
    }
}
