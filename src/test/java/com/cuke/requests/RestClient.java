package com.cuke.requests;

import com.cuke.options.SpecificationFactory;
import com.cuke.options.TestBase;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import static io.restassured.RestAssured.given;


public class RestClient extends TestBase{
	
	/**
	 * @param requestPath
	 * @return Response
	 */
	public Response doGetRequest(String requestPath) {
		
		return given()
		   		   .when()
		   		   .get(requestPath);
	}
	
	/**
	 * @param uri
	 * @param body
	 * @return Response
	 */
	public Response doPostRequest(String uri, Object body) {
		
		return given()
				.spec(SpecificationFactory.getRequestSpecWithJSONContentType())
				.when()
				.body(body)
				.post(uri);
	}
	
	/**
	 * @param res
	 * @param params
	 * @return Response
	 */
	public Response doGetRequestWithQueryParam(String res, Map<String, String> params) {

		return given()
				.queryParams(params)
				.when()
				.get(res);
	}
	
	/**
	 * @param res
	 * @param body
	 * @return Response
	 */
	public Response doPutRequest(String res , Object body) {

		return given()
				.when()
				.body(body)
				.put(res);
	}
	
	/**
	 * @param res
	 * @return Response
	 */
	public Response doDeleteRequest(String res) {

		return given()
				.when()
				.delete(res);
	}

	/**
	 * @param endpoint
	 * @return RequestSpecification
	 */
	public RequestSpecification createRequestWithNewEndpoint(String endpoint) {

		 return given()
				.spec(new RequestSpecBuilder().setBaseUri(endpoint).build())
				.when();
	}

}
