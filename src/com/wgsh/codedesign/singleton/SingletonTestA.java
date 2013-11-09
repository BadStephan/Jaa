package com.wgsh.codedesign.singleton;

import com.wgsh.codedesign.Log;

public class SingletonTestA {

	public static void main(String[] args) {
		// Consume the object in turn.
		SingletonA obj = SingletonA.create(SingletonA.MODE_ONE);
		Log.d("1111", obj.contentDescription());
		SingletonA obj2 = SingletonA.create(SingletonA.MODE_TWO);
		Log.d("1111", obj2.contentDescription());
		SingletonA obj3 = SingletonA.create(SingletonA.MODE_TWO);
		Log.d("1111", obj3.contentDescription());
		SingletonA obj4 = SingletonA.create(SingletonA.MODE_THREE);
		Log.d("1111", obj4.contentDescription());

		Log.d(SingletonA.class.getSimpleName(),
				"Usage of mode MODE_TWO is " + SingletonA.getUsageOfMode(SingletonA.MODE_TWO));
		if (obj == obj3) {
			Log.d("1111", "obj == obj3");
		}

	}
}
