package com.dp.collections;

import java.util.Arrays;

public class BooleanLargeArray {

	private final int rows;
	private final int cols;
	boolean[][] arr;

	public BooleanLargeArray(long capacity) {
		double sqrt = Math.sqrt(capacity);
		if (sqrt > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Size not supported, maximum capacity is:" + (long) Integer.MAX_VALUE * Integer.MAX_VALUE);
		}
		cols = rows = (int)Math.floor(sqrt + 1);
		long mem = Runtime.getRuntime().freeMemory();
		if ( mem < rows*cols){
			throw new IllegalArgumentException("Not enogh free memory, got:" + mem + ", requesting:" + rows*cols);
		}
		arr = new boolean[rows][cols];
	}

	public void fill(boolean value)
	{
		for ( int i=0; i< arr.length; i ++) {
			Arrays.fill(arr[i], value);
		}
	}

	public void set(long index, boolean value){
		try {
			arr[(int)index/rows][(int)index%cols] = value;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean get(long index){
		return arr[(int)index/rows][(int)index%cols];
	}

}
