package com.sourceit.hw.num10;

import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable {
	private int val1 = 0;
	private int val2 = 0;
	private int res = 0;
	public static void main(String[] args) throws InterruptedException {
		MyRunnable myRun = new MyRunnable();
		Thread thread1 = new Thread(myRun);
		Thread thread2 = new Thread(myRun);
		
		thread1.start();
		thread2.start();
		
		TimeUnit.SECONDS.sleep(5);
		
		thread1.interrupt();
		thread2.interrupt();
	}
	
	@Override
	public void run() {
		try {
			//synchronized(this) {
				while(true) {
					res = val1 - val2;
					System.out.println(res);
					val1++;
					//TimeUnit.MILLISECONDS.sleep(10);
					Thread.sleep(10);
					val2++;
			     } 
			//}
		
		}catch (InterruptedException e) {
			System.out.println("Stopped");
		}
	}
	

}
