package com.sourceit.hw.num10;

import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable {
	 private static final int TIME = 10;
	 private static int ITER = 200;

	public static void main(String[] args) throws InterruptedException {
		MyRunnable myRun1 = new MyRunnable();
		Thread thread1 = new Thread(myRun1);
		thread1.start();
		
		MyRunnable myRun2 = new MyRunnable();
		Thread thread2 = new Thread(myRun2);
		thread2.start();
		///////////////////////////////////////////////////////////
		Thread t3 = new Thread(() -> {
			
			try {
			while(true) {
					System.out.println(Thread.currentThread().getName());
					Thread.sleep(10);
				} 
			
			}catch (InterruptedException e) {
				System.out.println("Stopped");
			}
		});
		t3.start();
		TimeUnit.SECONDS.sleep(5);     //stop main thread
		t3.interrupt();
		///////////////////////////////////////////////////////////////
		
	}
	 
	@Override
	public void run() {
		Counter c = new Counter();
		try {
			while(!Thread.currentThread().isInterrupted() && (ITER >= 0)) { //true
				System.out.println(Thread.currentThread().getName() + ":  " + c.calculate());
				c.counter1();
			    Thread.sleep(this.TIME);
			    c.counter2();
			    ITER--;
			    //System.out.println(ITER);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " is finish!");
			e.printStackTrace();
		}
	}
	
	class Counter{
		private int value1 = 0;
		private int value2 = 0;
		
		public void counter1() {
			this.value1++;
		}
		public void counter2() {
			this.value2++;
		}
		public double calculate() {
			return value1 - value2;
		}
		
		
	}

}
