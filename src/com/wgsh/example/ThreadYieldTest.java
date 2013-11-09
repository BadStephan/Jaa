package com.wgsh.example;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ThreadYieldTest {
	private ThreadA mThreadA;
	private ThreadB mThreadB;
	
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		ThreadYieldTest test = new ThreadYieldTest();
		test.doTest();
	}
	
	public void doTest() throws FileNotFoundException, InterruptedException  {
		System.setOut(new PrintStream("./out.res"));
		
		mThreadA = new ThreadA();
		mThreadB = new ThreadB();
		
		Thread ta = new Thread(mThreadA);
		Thread tb = new Thread(mThreadB);
		
		ta.start();
		tb.start();
		
		ta.join();
		tb.join();
		
		System.out.flush();
	}

	private class ThreadA implements Runnable {
		public int mProgress = 0;
		public int mLoop = 0;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (; mLoop < 10000; mLoop++) {
				if (mThreadB.mProgress + 5 < this.mProgress && mThreadB.mProgress != 100) {
					System.out.println("mThreadB is out of date [A](" + this.mProgress + ","
							+ this.mLoop + ") " + "[B](" + mThreadB.mProgress + ","
							+ mThreadB.mLoop + ")\n");
					
					Thread.yield();
				}
				
				if(mLoop%100 == 0) {
					mProgress++;
				}
			}
		}

	}

	private class ThreadB implements Runnable {
		public int mProgress = 0;
		public int mLoop = 0;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (; mLoop < 10000; mLoop++) {
				if (mThreadB.mProgress + 5 < this.mProgress && mThreadB.mProgress != 100) {
					System.out.println("mThreadB is out of date [A](" + this.mProgress + ","
							+ this.mLoop + ") " + "[B](" + mThreadB.mProgress + ","
							+ mThreadB.mLoop + ")\n");
					
					Thread.yield();
				}

				if(mLoop%100 == 0) {
					mProgress++;
				}
			}
		
		}

	}
}
