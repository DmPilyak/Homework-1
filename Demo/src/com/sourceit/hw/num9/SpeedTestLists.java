package com.sourceit.hw.num9;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class SpeedTestLists {

	private static final int DEFAULT_LIS_SIZE = 1_000_000;

	public static void main(String[] args) {
		LinkedList<String> arrL = new LinkedList<String>();
		for(int i = 0; i < DEFAULT_LIS_SIZE; i++) {
			arrL.add(new String("0"));
		}
		System.out.println(test(arrL, 10000, DEFAULT_LIS_SIZE));
	}
	
	public static long test(LinkedList<String> arrL, int n, int DEFAULT_LIS_SIZE) {
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < n; i++) {
			arrL.add(DEFAULT_LIS_SIZE - 100, new String("dp"));
			//arrL.remove(DEFAULT_LIS_SIZE - 10000);
			System.out.println(1);
		}
		long endTime = System.currentTimeMillis() - startTime;
		return endTime;
	}
 
}
