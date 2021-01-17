package com.cuke.options;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestBase {
	
	public static PropertyListener prop;

	@Rule
	public TestRule listner = new TestWatcher() {
		
		@Override
		protected void succeeded(Description description) {
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println(description.getMethodName().toUpperCase());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		}
		
		@Override
		protected void failed(Throwable e, Description description) {
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.err.println("Test Failed : " + description.getMethodName().toUpperCase());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}

		@Override
		protected void starting(Description description) {
			

			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Starting Test: " + description.getMethodName().toUpperCase());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}

		@Override
		protected void finished(Description description) {
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Ending Test: " + description.getMethodName().toUpperCase());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}
	};
	
	@BeforeClass
	public static void initUrl() {
		prop = PropertyListener.getInstance();
		RestAssured.baseURI = prop.getProperty("baseUrl");
	}
	
}
