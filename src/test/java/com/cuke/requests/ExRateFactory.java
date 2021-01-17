package com.cuke.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ExRateFactory {
	
	RestClient restClient = new RestClient();

	//Get the latest exchange rate
	public Response getLatestExchangeRates() {
		Response response = restClient.doGetRequest("/latest");
		return response;
	}

	//Get the exchange rate as per given time period
	public Response getExchangeRates(String period) {
		if(period.equalsIgnoreCase("future")){
			period = LocalDate.now().plusWeeks(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		Response response = restClient.doGetRequest("/"+period);
		return response;
	}

	//Get Specific date Foreign Exchange Rates with Symbols and Base
	public Response getExchangeRatesWithQueryParams(String period, Map<String, String> query) {
		if(period.equalsIgnoreCase("future")){
			period = LocalDate.now().plusWeeks(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		Response response = restClient.doGetRequestWithQueryParam("/"+period, query);
		return response;
	}

	//get Request with newly provided endpoint
	public RequestSpecification setNewEndpoint(String endpoint) {
		return restClient.createRequestWithNewEndpoint(endpoint);
	}
	
}
