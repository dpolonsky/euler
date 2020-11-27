package com.dp.leetcode;

import java.util.*;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		List<Interval> intervalsList = new ArrayList<>();
		for (int index = 0; index < intervals.length; index++) {
			intervalsList.add(new Interval(intervals[index]));
		}

		intervalsList.sort(Comparator.comparingInt(o -> o.from));

		LinkedList<Interval> merged = new LinkedList<>();
		Interval lastInterval = null;
		for (Interval interval : intervalsList) {
			if (lastInterval == null) {
				lastInterval = interval;
			} else {
				if (lastInterval.intersect(interval)) {
					lastInterval.merge(interval);
				} else {
					merged.add(lastInterval);
					lastInterval = interval;
				}
			}
		}
		if ( lastInterval != null) {
			merged.add(lastInterval);
		}

		int[][] result = new int[merged.size()][2];
		for (int i = 0; i < merged.size(); i++) {
			result[i] = merged.get(i).toArray();
		}
		return result;
	}

	class Interval {
		int from;
		int to;

		public Interval(int[] interval) {
			from = interval[0];
			to = interval[1];
		}

		int[] toArray() {
			return new int[] { from, to };
		}

		@Override public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Interval interval = (Interval) o;
			return from == interval.from &&
					to == interval.to;
		}

		@Override public int hashCode() {
			return Objects.hash(from, to);
		}

		public boolean intersect(Interval interval) {
			return interval.from <= to;
		}

		public void merge(Interval interval) {
			from = Math.min(from, interval.from);
			to = Math.max(to, interval.to);
		}
	}
}
