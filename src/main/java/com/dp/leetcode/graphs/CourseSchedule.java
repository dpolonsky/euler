package com.dp.leetcode.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
	int NOT_VISITED = 0;
	int PATH = 1;
	int CHECKED = 2;

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		// course -> list of next courses
		HashMap<Integer, List<Integer>> courseDict = new HashMap<>();

		// build the graph first
		for (int[] relation : prerequisites) {
			// relation[0] depends on relation[1]
			if (courseDict.containsKey(relation[1])) {
				courseDict.get(relation[1]).add(relation[0]);
			} else {
				List<Integer> nextCourses = new LinkedList<>();
				nextCourses.add(relation[0]);
				courseDict.put(relation[1], nextCourses);
			}
		}

		int[] state = new int[numCourses];
//		boolean[] path = new boolean[numCourses];

		for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
			if (this.isCyclic(currCourse, courseDict, state))
				return false;
		}

		return true;
	}

	/*
	 * postorder DFS check that no cycle would be formed starting from currCourse
	 */
	protected boolean isCyclic(Integer currCourse, HashMap<Integer, List<Integer>> courseDict, int[] state) {

		// bottom cases
		if ((state[currCourse] & CHECKED) == 1)
			// this node has been checked, no cycle would be formed with this node.
			return false;
		if ((state[currCourse] & PATH) == 1) // path[currCourse]
			// come across a previously visited node, i.e. detect the cycle
			return true;

		// no following courses, no loop.
		if (!courseDict.containsKey(currCourse))
			return false;

		// before backtracking, mark the node in the path
//		path[currCourse] = true;
		state[currCourse] = PATH;

		boolean ret = false;
		// postorder DFS, to visit all its children first.
		for (Integer child : courseDict.get(currCourse)) {
			ret = this.isCyclic(child, courseDict, state);
			if (ret)
				break;
		}

		// after the visits of children, we come back to process the node itself
		// remove the node from the path
//		path[currCourse] = false;

		// Now that we've visited the nodes in the downstream,
		// we complete the check of this node.
//		checked[currCourse] = true;
		state[currCourse] = CHECKED;
		return ret;
	}
}
