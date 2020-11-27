package com.dp.leetcode.recursion;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TowersHanoi {

	public static void main(String[] args) {
		TowersHanoi towersHanoi = new TowersHanoi();
		towersHanoi.arrangeTowers(3, 2);
	}

	public List<Tower> arrangeTowers(int n, int destination) {
		int bufer = destination == 2 ? 1 : 2;
		List<Tower> towers = IntStream.range(0, 3).mapToObj(Tower::new).collect(Collectors.toList());

		IntStream.rangeClosed(0, n).forEach(i -> towers.get(0).addDisk(n - i));
		towers.get(0).moveDisks(n, towers.get(destination), towers.get(bufer));
		return towers;
	}

	class Tower {
		Stack<Integer> disks = new Stack<>();
		private int index;

		public Tower(int index) {
			this.index = index;
		}

		public void addDisk(int disk) {
			if (!disks.isEmpty() && disks.peek() < disk) {
				throw new IllegalArgumentException("Erro placing disk:" + disk + " on top of:" + disks.peek());
			} else {
				disks.push(disk);
			}
		}

		public void moveTopTo(Tower tower) {
			tower.addDisk(disks.pop());
		}

		public void moveDisks(int n, Tower destination, Tower buffer) {
			if (n > 0) {
				moveDisks(n - 1, buffer, destination);
				moveTopTo(destination);
				buffer.moveDisks(n - 1, destination, this);
			}
		}
	}
}
