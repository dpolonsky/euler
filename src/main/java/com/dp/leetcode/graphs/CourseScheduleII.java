package com.dp.leetcode.graphs;

import java.util.LinkedList;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) {
			throw new IllegalArgumentException("illegal prerequisites array");
		}

		int len = prerequisites.length;

		//if there is no prerequisites, return a sequence of courses
		if (len == 0) {
			int[] res = new int[numCourses];
			for (int m = 0; m < numCourses; m++) {
				res[m] = m;
			}
			return res;
		}

		//records the number of prerequisites each course (0,...,numCourses-1) requires
		int[] pCounter = new int[numCourses];
		for (int[] prerequisite : prerequisites) {
			pCounter[prerequisite[0]]++;
		}

		//stores courses that have no prerequisites
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (pCounter[i] == 0) {
				queue.add(i);
			}
		}

		int numOfProcessedNodes = queue.size();

		//initialize result
		int[] result = new int[numCourses];
		int j = 0;

		while (!queue.isEmpty()) {
			int c = queue.remove();
			result[j++] = c;

			for (int[] prerequisite : prerequisites) {
				int src = prerequisite[1];
				if (src == c) {
					int dest = prerequisite[0];
					// Reduce the in-degree of destination by 1
					pCounter[dest]--;
					if (pCounter[dest] == 0) {
						queue.add(dest);
						numOfProcessedNodes++;
					}
				}

			}
		}

		//return result
		if (numOfProcessedNodes == numCourses) {
			return result;
		} else {
			return new int[0];
		}
	}
}
