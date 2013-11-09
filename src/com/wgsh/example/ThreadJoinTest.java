package com.wgsh.example;

public class ThreadJoinTest {

	public static void main(String[] args) {
		ThreadJoinTest test = new ThreadJoinTest();
		test.doTest();
	}
	
	public void doTest () {
		Thread ta, tb;
		Runnable rb = new ThreadB();
		tb = new Thread(rb);
		Runnable ra = new ThreadA(tb);
		ta = new Thread(ra);
		
		ta.start();
		tb.start();
	}
	
	private class ThreadB implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("ThreadB runs!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ThreadB terminates.");
		}
		
	}
	
	/*
	 * When ThreadA joins ThreadB, ThreadA has to wait until ThreadB is finished.
	 */
	private class ThreadA implements Runnable {
		
		private Thread mRefThread;
		
		public ThreadA(Thread refThread) {
			mRefThread = refThread;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

			System.out.println("ThreadA runs!");
			try {
				mRefThread.join();
			} catch (InterruptedException e) {	// JOIN triggers this interrupt.
				// TODO Auto-generated catch block
				System.out.println("ThreadA waits until ThreadB is finished!");
			}
			System.out.println("oops, finally B terminates");
		}
		
	}
}
