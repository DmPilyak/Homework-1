package com.sourceit.hw.num10;


public class MyRunnable implements Runnable {
	 private static final int TIME = 100;
	 private static int ITER = 200;

	public static void main(String[] args) {
		
		thread1.start();
		
		thread2.start();
		
	}
	 
	static MyRunnable myRun1 = new MyRunnable();
	static Thread thread1 = new Thread(myRun1);
	
	static MyRunnable myRun2 = new MyRunnable();
	static Thread thread2 = new Thread(myRun2);
	
	@Override
	public void run() {
		Counter c = new Counter();
		try {
			while(!Thread.currentThread().isInterrupted() && (ITER >= 0)) {
				System.out.println(Thread.currentThread().getName() + ":  " + c.calculate());
				c.counter1();
			    //Thread.sleep(this.TIME);
			    thread1.sleep(this.TIME*TIME);
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
