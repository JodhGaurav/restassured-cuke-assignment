package com.cuke.stepdefs;

import com.cuke.requests.RequestFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ExchangeRateSD {

    RequestFactory requests = new RequestFactory();
    Response response;
    RequestSpecification req;

    @Given("I submit the Rate API to get {string} exchange rates")
    public void i_submit_the_Rate_API_to_get_exchange_rates(String period) {
        response = requests.getExchangeRates(period);
    }

    @Then("I should get {int} response status code")
    public void i_should_get_response_status_code(Integer code) {
        response.then().statusCode(code);
    }

    @Then("I should get exchange rate of multiple countries for {string} date")
    public void i_should_get_exchange_rate_of_multiple_countries_for_date(String period) {
        if(period.equalsIgnoreCase("current")){
            period = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        response.then()
                .body("base", equalTo("EUR"))
                .body("date",equalTo(period))
                .body("rates.size()", greaterThan(1));
    }

    @Given("The endpoint is incorrect")
    public void the_endpoint_is_incorrect() {
        req = requests.setIncorrectEndpoint();
    }

    @And("I submit the Rate API to exchange rates")
    public void iSubmitTheRateAPIToExchangeRates() {
        response = req.get();
    }
}
