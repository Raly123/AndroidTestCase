package com.coship.androidtestcase.test;

import junit.framework.TestSuite;

public class ExampleSuite extends TestSuite {

	public ExampleSuite() {
		super();
		addTestSuite(MathTest.class);
	}
}
