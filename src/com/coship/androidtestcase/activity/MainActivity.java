package com.coship.androidtestcase.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.coship.androidtestcase.R;
import com.coship.androidtestcase.test.TestRunner;

public class MainActivity extends Activity {

	private Thread mTestRunnerThread = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void startTestListener(View v){
		startTest();
	}
	
	private synchronized void startTest() {
        if( ( mTestRunnerThread != null ) &&
            !mTestRunnerThread.isAlive() )
        	mTestRunnerThread = null;
        if( mTestRunnerThread == null ) {
        	mTestRunnerThread = new Thread( new TestRunner(this));
        	mTestRunnerThread.start();
        } else
            Toast.makeText(
                        this, 
                        "Test is still running", 
                        Toast.LENGTH_SHORT).show();
    }
}
