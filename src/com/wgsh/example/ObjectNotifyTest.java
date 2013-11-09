package com.wgsh.example;

public class ObjectNotifyTest {
	private String strResult = "";
	private PrinterThread mPrinter = new PrinterThread();
	private CalculateThread mCalculator = new CalculateThread();

	public static void main(String[] args) {
		ObjectNotifyTest debugger = new ObjectNotifyTest();
		debugger.doTest();
	}
	
	public void doTest(){
		mCalculator.start();
		mPrinter.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class PrinterThread extends Thread {
		@Override
		public void run() {
			synchronized (this) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (strResult != null && strResult != "") {
				System.out.println("result: " + strResult);
			}
		}
	}

	class CalculateThread extends Thread {
		@Override
		public void run() {
			long ret = 0;
			for (int i = 0; i < 10000; i++) {
				for (int j = 0; j < 10000; j++) {
					ret++;
				}
			}

			strResult = Long.toString(ret);
			synchronized (mPrinter) {
				mPrinter.notify();
			}
		}
	}
}
