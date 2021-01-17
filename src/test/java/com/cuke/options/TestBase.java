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
	
	@BeforeClass
	public static void initUrl() {
		prop = PropertyListener.getInstance();
		RestAssured.baseURI = prop.getProperty("baseUrl");
	}
	
}
