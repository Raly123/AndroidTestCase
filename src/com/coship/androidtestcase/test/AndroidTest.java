package com.coship.androidtestcase.test;

import java.util.Set;

import android.content.Context;
import android.test.AndroidTestRunner;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;

public class AndroidTest implements Runnable, TestListener{

	private Context mContext;
	
	private int mTestCounter;
	private int mFailureCounter;
	private int mErrorCounter;
	
	private AndroidTestRunner mRunner;
	private Set<String> mClassNameSet;
	
	
	public AndroidTest(Context mContext) {
		super();
		this.mContext = mContext;
	}
	
	@Override
	public void run() {
		//初始化计数器
		mTestCounter = 0;
		mFailureCounter = 0;
		mErrorCounter = 0;
		
		mRunner = new AndroidTestRunner();
		
		/**设置在testRunner上运行测试类套件中的多个测试类， 
         * 此处也可以单独运行一个测试类，如testRunner.setTest(new MathTest()); 
         */  
//		mRunner.setTest(new ExampleSuite());
//		mRunner.addTestListener(this);
//		mRunner.runTest();
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

	public int getTestCounter() {
		return mTestCounter;
	}

	public int getFailureCounter() {
		return mFailureCounter;
	}

	public int getErrorCounter() {
		return mErrorCounter;
	}
	
}
