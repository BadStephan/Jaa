package com.wgsh.codedesign.singleton;

import com.wgsh.codedesign.Log;

public class SingletonTestB {
	public static final String LOGTAG = SingletonTestB.class.getSimpleName();

	public static void main(String[] args) throws InterruptedException {
		Thread ta = new Thread() {
			@Override
			public void run() {
				SingletonB obj1 = SingletonB.reference(SingletonB.MODE_ONE);
				while (obj1.getNotify() <= 5) {
					Log.d(LOGTAG, obj1.contentDescription());
				}
				obj1.release();
				Log.d(LOGTAG, "here you are, i release it to you.");
			}
		};

		Thread tb = new Thread() {
			@Override
			public void run() {
				SingletonB obj2;
				do {
					obj2 = SingletonB.reference(SingletonB.MODE_TWO);
					if (obj2 == null) {
						SingletonB.pleaseRelease();
						Log.w(LOGTAG, "Somebody please release reference of SingletonB!");
					} else {
						break;
					}
				} while (true);
				Log.d(LOGTAG, "haha, i got the reference.");
				Log.d(LOGTAG, obj2.contentDescription());
				obj2.release();
			}
		};
		
		ta.start();
		Thread.sleep(100);		// let ta starts first
		tb.start();
		
		ta.join();
		tb.join();
	}
}
