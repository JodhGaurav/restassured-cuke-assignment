# RestAssured-Cucumber framework
This automation suite is designed to test the Foreign currency exchange rates API with RestAssured and Cucumber.  

### Tools / libraries used :
- `Java`
- `RestAssured`
- `Cucumber`
- `JUnit`
- `Maven`
- `Extent Report Adapter`

### Reporting
- `Extent Report`
- `Cucumber PDF Report`
- `Cucumber HTML Report`

### To get started :
1. Clone or Download the project into your local.
2. Then, open the command prompt and navigate to project location.
3. Execute the following Maven commands
    - `mvn clean` : To clean the maven repo
    - `mvn install` : To install the maven requirements 
    - `mvn test` : To execute all the test scenarios
    - `mvn test extentreports-cucumberjson:extentreport` : To execute all the test scenarios and generate Extent Reports (json, html & pdf) in `test-output` dir.
