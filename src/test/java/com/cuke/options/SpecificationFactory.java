package com.cuke.options;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class SpecificationFactory extends TestBase {
	
	public static ResponseSpecification getGenericResponseSpec() {
		
		ResponseSpecBuilder responseSpec = new ResponseSpecBuilder();

		responseSpec.expectHeader("Content-Type","application/json");
		responseSpec.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
		
		return responseSpec.build();
	}

	public static RequestSpecification getRequestSpecWithJSONContentType() {

		return new RequestSpecBuilder()
				.addHeader("Content-Type", "application/json")
				.build();
	}

	public static RequestSpecification getRequestSpecWithXMLContentType() {
		return new RequestSpecBuilder()
				.addHeader("Content-Type", "application/xml")
				.build();
	}
}
