package com.wgsh.codedesign.singleton;

/**
 * Class One, Two, Three can be something like pure data storage while in {@link SingletonB} can deal with.
 * As a consequence, SingletonB is the only one interface that can access the unreadable data.
 * @author Batephan
 *
 */
public abstract class SingletonB {

	public static final int MODE_ONE = 1;
	public static final int MODE_TWO = 2;
	public static final int MODE_THREE = 3;
	
	private static int mCounterA;
	private static int mCounterB;
	private static int mCounterC;
	
	private static SingletonB mInstance = null;
	
	private static int mRefCounter = 0;
	
	private static int mNotify = 0;
	
	protected SingletonB() {}
	
	/**
	 * The only approach to get reference of this class.
	 * @param mode
	 * @return get reference of mode MODE
	 */
	public static synchronized SingletonB reference(int mode) {

		if(mRefCounter != 0) 
			return null;
		
		mRefCounter++;
		
		switch(mode) {
		case MODE_ONE:
			mCounterA++;
			mInstance = new One();
			break;
			
		case MODE_TWO:
			mCounterB++;
			mInstance = new Two();
			break;
			
		case MODE_THREE:
			mCounterC++;
			mInstance = new Three();
			break;
			
			default:
				return null;
		}
		
		return mInstance;
	}
	
	/**
	 * release the reference voluntary 
	 */
	public void release() {
		mRefCounter--;
		mNotify = 0;
	}
	
	/**
	 * get to know how many competitors are trying to get reference so that the owner can decide release it or not
	 * @return
	 */
	public int getNotify() {
		return mNotify;
	}
	
	/**
	 * notify the owner to release, that is to say "hey buddy, I am going to use it, please make free"
	 */
	public static void pleaseRelease() {
		mNotify++;
	}
	
	/**
	 * usage statistical analysis of each mode
	 * @param mode
	 * @return return ratio in double type
	 */
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
	
	public abstract String contentDescription();
}

class One extends SingletonB {
	private String desc = "One subclass of SingletonB";
	
	@Override
	public String contentDescription() {
		return desc;
	}
}

class Two extends SingletonB {
	private String desc = "Two subclass of SingletonB";
	
	@Override
	public String contentDescription() {
		return desc;
	}
}

class Three extends SingletonB {
	private String desc = "Three subclass of SingletonB";
	
	@Override
	public String contentDescription() {
		return desc;
	}
}