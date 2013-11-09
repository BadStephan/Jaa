package com.wgsh.example;

/**
 * Demonstrates daemon thread which would be interrupted by a expected or
 * not signal.
 * @author Wang Gensheng
 *
 */
public class DaemonThread {
	public static void Main(String[] args) throws InterruptedException{
		Thread t = new Thread(new ADaemon());
		System.out.println("State before signals " + t.getState());
		t.setName("[ADaemon]");
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		Thread.sleep(1000);
		System.out.println("State after an interrupt " + t.getState());
		Thread.sleep(1000);
		System.out.println("State after another interrupt " + t.getState());
		
	}
}

class ADaemon implements Runnable {
//	private String arg;
	
	@Override
	public void run(){
		Thread t = Thread.currentThread();
		System.out.print("Hi, my thread name is \"" + t.getName() 
				+ "\" and my priority is \"" + t.getPriority() 
				+ "\" my ID is \"" + t.getId() + "\"\n");
		
		while(true){
			try {
				Thread.sleep(5000);
				System.out.print("Job has finished successfully!\n");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
