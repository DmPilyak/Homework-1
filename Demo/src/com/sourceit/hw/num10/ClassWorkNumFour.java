package com.sourceit.hw.num10;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ClassWorkNumFour implements Runnable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[][] matrix = new int[4][100];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 100; j++) {
				matrix[i][j] = ((int) (Math.random() * 100));
			}
		}

		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 100; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
        List<Callable<Integer>> task = new ArrayList<>();
        for (int[] row : matrix) {
			task.add(new FinderTask(row));
		}
		ExecutorService es = Executors.newFixedThreadPool(4);
		List<Future<Integer>> future = es.invokeAll(task);
		System.out.println("1. Speed-test of finding the maximum element in the array using 4 threads");
		int maxInt = calcMaxInt(future);
		System.out.println("Max value in array is: " + maxInt + "\n");
		System.out.println("2. Speed-test of finding the maximum element in the array without using threads");
		calcMaxIntInOneThread(matrix);
	}
	
	public static int calcMaxInt(List<Future<Integer>> future) throws InterruptedException, ExecutionException {
		double startTime = System.currentTimeMillis();
		Integer max = 0;
		for(Future<Integer> f : future) {
			Integer futRes = f.get();
			TimeUnit.MILLISECONDS.sleep(1);
			if(max < futRes) {
				max = futRes;
			}
		}
		double endTime = System.currentTimeMillis() - startTime;
		System.out.println("Works " + endTime / 1000 + " seconds");
		return max;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public static void calcMaxIntInOneThread(int[][] matrix){
		double startTime = System.nanoTime();
		int max = matrix[0][0];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 100; j++) {
				if(max < matrix[i][j]) {
					max = matrix[i][j];
				}
			}
		}
		double endTime = System.nanoTime() - startTime;
		System.out.println("Works " + endTime / 10 + " seconds");
		System.out.println("Max value in array is: " + max);
	}
	
}

class FinderTask implements Callable<Integer>{

	private int[] row;
	
	public FinderTask(int[] row) {
		this.row = row;
	}
	
	@Override
	public Integer call() throws Exception {
		return Arrays.stream(row).max().getAsInt();
	}
	
}

