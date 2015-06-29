package com.coship.androidtestcase.test;

import android.content.Context;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;

public class TestRunner implements Runnable, TestListener{

	private static final String TAG = TestRunner.class.getSimpleName();
	
	private Context mContext;
	
	public enum displayEvent{
		START_TEST,
		END_TEST,
		ERROR,
		FAILURE
	}
	
	private displayEvent mEvent;
	private String mTestName;
	private int mTestCounter;
	private int mErrorCounter;
	private int mFauilureCounter;
	
	public TestRunner(Context mContext) {
		super();
		this.mContext = mContext;
	}

	public TestRunner(Context mContext, displayEvent mEvent, String mTestName,
			int mTestCounter, int mErrorCounter, int mFauilureCounter) {
		super();
		this.mContext = mContext;
		this.mEvent = mEvent;
		this.mTestName = mTestName;
		this.mTestCounter = mTestCounter;
		this.mErrorCounter = mErrorCounter;
		this.mFauilureCounter = mFauilureCounter;
	}

	@Override
	public void run() {
		StringBuffer status = new StringBuffer();
		
		switch (mEvent) {
		case START_TEST:
			break;
			
		case END_TEST:
			break;
			
		case ERROR:
			break;
			
		case FAILURE:
			break;
			
		default:
			break;
		}
	}
	
	@Override
	public void addError(Test test, Throwable t) {
		
	}

	@Override
	public void addFailure(Test test, AssertionFailedError t) {
		
	}

	@Override
	public void endTest(Test test) {
		
	}

	@Override
	public void startTest(Test test) {
		
	}
}
