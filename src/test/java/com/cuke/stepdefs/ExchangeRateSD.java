package com.cuke.stepdefs;

import com.cuke.options.SpecificationFactory;
import com.cuke.requests.ExRateFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ExchangeRateSD {

    ExRateFactory service = new ExRateFactory();
    Response response;
    RequestSpecification request;

    @Given("I submit the Rate API to get {string} exchange rates")
    public void getExchangeRatesWithPeriod(String period) {
        response = service.getExchangeRates(period);
    }

    @Then("I should get {int} response status code")
    public void validateStatusCode(Integer code) {
        response.then()
                .spec(SpecificationFactory.getGenericResponseSpec())
                .statusCode(code);
    }

    @Then("I should get exchange rate of multiple countries for {string} date")
    public void validateTheResponseOfRateAPI(String period) {
        if(period.equalsIgnoreCase("current")){
            period = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        response.then()
                .spec(SpecificationFactory.getGenericResponseSpec())
                .body("base", equalTo("EUR"))
                .body("date",equalTo(period))
                .body("rates.size()", greaterThan(1));
    }

    @Given("The endpoint is incorrect")
    public void setIncorrectEndpointOfRateAPI() {
        request = service.setNewEndpoint(baseURI+"s");
    }

    @And("I submit the Rate API to exchange rates")
    public void submitRequestSpecOfRateAPI() {
        response = request.get();
    }
}
