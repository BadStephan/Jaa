package com.wgsh.codedesign.singleton;

public class SingletonA {
	public static final int MODE_ONE = 1;
	public static final int MODE_TWO = 2;
	public static final int MODE_THREE = 3;
	
	private static int mCounterA;
	private static int mCounterB;
	private static int mCounterC;
	
	private int mMode;
	
	private static SingletonA mInstance = null;
	
	private SingletonA(int mode) {
		mMode = mode;
	}
	
	public static SingletonA create(int mode) {
		if(mInstance == null) {
			mInstance = new SingletonA(mode);
		} else {
			mInstance.mMode = mode;
		}
		
		switch(mode) {
		case MODE_ONE:
			mCounterA++;
			break;
			
		case MODE_TWO:
			mCounterB++;
			break;
			
		case MODE_THREE:
			mCounterC++;
			break;
			
			default:
				return null;
		}
		
		return mInstance;
	}
	
	public static double getUsageOfMode(int mode) {
		double r = 0.0;
		switch(mode) {
		case MODE_ONE:
			r = mCounterA/(mCounterA + mCounterB + mCounterC);
			break;
			
		case MODE_TWO:
			r = ((double)mCounterB)/(mCounterA + mCounterB + mCounterC);
			break;
			
		case MODE_THREE:
			r = mCounterC/(mCounterA + mCounterB + mCounterC);
			break;
			
			default:
				break;
		}
		return r;
	}
	
	public String contentDescription() {
		return SingletonA.class.getSimpleName() + " in mode " + mMode;
	}
}
