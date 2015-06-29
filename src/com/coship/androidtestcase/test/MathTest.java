package com.coship.androidtestcase.test;

import android.test.AndroidTestCase;
import android.util.Log;

public class MathTest extends AndroidTestCase{

	private static final String TAG = "MathTest";
	
	protected int i1;
	protected int i2;
	
	@Override
	protected void setUp() throws Exception {
		i1 = 2;
		i2 = 3;
	}
	
	public void testAdd(){
		Log.d(TAG, "testAdd");
		assertTrue(TAG+"1", (( i1 + i2) == 5 ));
	}

	@Override
	public void testAndroidTestCaseSetupProperly() {
		super.testAndroidTestCaseSetupProperly();
		Log.d( TAG, "testAndroidTestCaseSetupProperly" );
	}

}
