package com.dp.leetcode.arrays;

import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles {
	public int findCircleNum(int[][] M) {
		if (M == null || M.length == 0) {
			return 0;
		}

		int len = M.length;

		int[] visited = new int[len];
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < len; i++) {
			if (visited[i] == 0) {
				queue.add(i);
				while (!queue.isEmpty()) {
					int s = queue.remove();
					visited[s] = 1;
					for (int j = 0; j < len; j++) {
						if (M[s][j] == 1 && visited[j] == 0)
							queue.add(j);
					}
				}
				count++;
			}
		}
		return count;
	}
}
