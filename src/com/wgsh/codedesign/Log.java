package com.wgsh.codedesign;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
	private static final String mTimeFormat = "[yyyy/MM/dd|HH:mm:ss|SSSS]";
	// private static final String mTagColor = "\033[7m";
	// private static final String mErrorColor = "\033[31m";

	public static final int PRIORITY_DEBUG = 5;
	public static final int PRIORITY_WARN = PRIORITY_DEBUG - 1;
	public static final int PRIORITY_ERROR = PRIORITY_DEBUG - 2;

	public static int iPriority = PRIORITY_DEBUG;

	public static void e(String tag, String str) {

		DateFormat format = new SimpleDateFormat(mTimeFormat);
		Date date = new Date();

		if (PRIORITY_ERROR <= iPriority) {
			System.out.println("E" + format.format(date) + " [" + tag + "] " + str);
		}
	}

	public static void d(String tag, String str) {
		DateFormat format = new SimpleDateFormat(mTimeFormat);
		Date date = new Date();

		if (PRIORITY_DEBUG <= iPriority) {
			System.out.println("D" + format.format(date) + " [" + tag + "] " + str);
		}
	}
	
	public static void w(String tag, String str) {
		DateFormat format = new SimpleDateFormat(mTimeFormat);
		Date date = new Date();

		if (PRIORITY_WARN <= iPriority) {
			System.out.println("W" + format.format(date) + " [" + tag + "] " + str);
		}
	}

}
