package com.coship.androidtestcase.test;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import android.app.Activity;
import android.test.AndroidTestRunner;
import android.util.Log;
import android.widget.TextView;

import com.coship.androidtestcase.R;

public class TestRunner implements Runnable, TestListener{

	private static final String TAG = TestRunner.class.getSimpleName();
	
	private Activity mParentActivity;
	
	private int mTestCounter;
	private int mErrorCounter;
	private int mFauilureCounter;
	
	private TextView mStatusText;
	private TextView mTestCounterText;
	private TextView mErrorCounterText;
	private TextView mFailureCounterText;
	

	public TestRunner(Activity activity) {
		super();
		this.mParentActivity = activity;
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		mStatusText = (TextView) mParentActivity.findViewById(R.id.status);
		mTestCounterText = (TextView) mParentActivity.findViewById(R.id.testCounter);
		mErrorCounterText = (TextView) mParentActivity.findViewById(R.id.errorCounter);
		mFailureCounterText = (TextView) mParentActivity.findViewById(R.id.failureCounter);
	}

	@Override
	public void run() {
		mTestCounter = 0;
		mErrorCounter = 0;
		mFauilureCounter = 0;
		
		Log.d(TAG, "Test started" );
		AndroidTestRunner mRunner = new AndroidTestRunner();
		mRunner.setTest(new ExampleSuite());
		mRunner.addTestListener(this);
		mRunner.setContext(mParentActivity);
		mRunner.runTest();
		Log.d(TAG, "Test ended" );
	}

	@Override
	public void addError(Test test, Throwable t) {
		Log.d(TAG, "addEror:" + test.getClass().getName());
		Log.d(TAG, t.getMessage(), t);
		mErrorCounter++;
		
		TestDisplay td = new TestDisplay(
                TestDisplay.displayEvent.ERROR,
                test.getClass().getName(),
                mTestCounter,
                mErrorCounter,
                mFauilureCounter,
                mStatusText,
                mTestCounterText,
                mErrorCounterText,
                mFailureCounterText );
        mParentActivity.runOnUiThread( td );
	}

	@Override
	public void addFailure(Test test, AssertionFailedError t) {
		Log.d(TAG, "addFailure:" + test.getClass().getName());
		Log.d(TAG, t.getMessage(), t);
		
		mFauilureCounter++;
		
		TestDisplay td = new TestDisplay(
                TestDisplay.displayEvent.START_TEST,
                test.getClass().getName(),
                mTestCounter,
                mErrorCounter,
                mFauilureCounter,
                mStatusText,
                mTestCounterText,
                mErrorCounterText,
                mFailureCounterText);
		 mParentActivity.runOnUiThread( td );
	}
	
	@Override
	public void startTest(Test test) {
		Log.i(TAG, "startTest:" + test.getClass().getName());
		mTestCounter++;
		
		 TestDisplay td = new TestDisplay(
                 TestDisplay.displayEvent.START_TEST,
                 test.getClass().getName(),
                 mTestCounter,
                 mErrorCounter,
                 mFauilureCounter,
                 mStatusText,
                 mTestCounterText,
                 mErrorCounterText,
                 mFailureCounterText);
		 mParentActivity.runOnUiThread( td );
	}

	@Override
	public void endTest(Test test) {
		Log.i(TAG, "endTest:" + test.getClass().getName());
		 TestDisplay td = new TestDisplay(
                 TestDisplay.displayEvent.END_TEST,
                 test.getClass().getName(),
                 mTestCounter,
                 mErrorCounter,
                 mFauilureCounter,
                 mStatusText,
                 mTestCounterText,
                 mErrorCounterText,
                 mFailureCounterText );
         mParentActivity.runOnUiThread( td );
	}
}
