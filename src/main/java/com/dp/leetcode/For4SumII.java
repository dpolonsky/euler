package com.dp.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class For4SumII
{
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D)
    {
        if ( A.length ==0 || B.length ==0 || C.length == 0|| D.length == 0)
            return 0;

        Map<Integer, Integer> ab = new HashMap<>();
        Map<Integer, Integer> cd = new HashMap<>();
        for (int a = 0; a < A.length; a++) {
            for (int b = 0; b < B.length; b++) {
                Integer key = A[a] + B[b];
                ab.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        for (int c = 0; c < C.length; c++) {
            for (int d = 0; d < D.length; d++) {
                Integer key = C[c] + D[d];
                cd.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        AtomicInteger result = new AtomicInteger(0);
        ab.forEach((key1, value) -> {
            int key = -1 * key1;
            if (cd.containsKey(key) && cd.get(key) > 0) {
                int incr = value * cd.get(key);
                result.addAndGet(incr);
                cd.compute(key, (k, v) -> v-=value);
            }
        });
        return result.get();
    }
}
