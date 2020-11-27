package com.dp.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildcardMatchingTest
{

    @Test
    void isMatch()
    {
        WildcardMatching wildcardMatching = new WildcardMatching();
        assertFalse(wildcardMatching.isMatch("aa", "a"));
        assertTrue(wildcardMatching.isMatch("b", "?"));
        assertFalse(wildcardMatching.isMatch("", "?"));
        assertTrue(wildcardMatching.isMatch("aa", "*"));
        assertTrue(wildcardMatching.isMatch("ho", "ho****"));
        assertFalse(wildcardMatching.isMatch("cb", "?a"));
        assertTrue(wildcardMatching.isMatch("adceb", "*a*b"));
        assertFalse(wildcardMatching.isMatch("acdcb", "a*c?b"));
        assertFalse(wildcardMatching.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
        assertFalse(wildcardMatching.isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
    }
}