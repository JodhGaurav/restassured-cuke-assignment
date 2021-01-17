Feature: Exchange rate API validation

	@Regression
	Scenario: Verify that Rate API for latest exchange rates is working
		Given I submit the Rate API to get "latest" exchange rates
		Then I should get 200 response status code

	@Regression
	Scenario: Verify that Rate API for latest exchange rates sending correct response
		Given I submit the Rate API to get "latest" exchange rates
		Then I should get exchange rate of multiple countries for "current" date

	Scenario: Verify Rate API response code if endpoint is incorrect
		Given The endpoint is incorrect
		And I submit the Rate API to exchange rates
		Then I should get 400 response status code

	@Regression
	Scenario: Verify that Rate API for past date exchange rates is working
		Given I submit the Rate API to get "2010-01-12" exchange rates
		Then I should get 200 response status code

	Scenario: Verify that Rate API for past date exchange rates sending correct response
		Given I submit the Rate API to get "2010-01-12" exchange rates
		Then I should get exchange rate of multiple countries for "2010-01-12" date

	@Regression
	Scenario: Verify that Rate API with future date gives latest exchange rates
		Given I submit the Rate API to get "future" exchange rates
		Then I should get exchange rate of multiple countries for "current" date


	

	
	
	
	
	
	

	
	
	