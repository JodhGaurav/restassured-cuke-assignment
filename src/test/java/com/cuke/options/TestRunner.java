package com.cuke.options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/com/cuke/features",
        glue={"com.cuke.stepdefs"},
        dryRun = false,
        monochrome = true,
		//tags = "@Regression",
        plugin = {
                //"html:target/report/cucumber-reports/cucumber.html",
                //"json:target/jsonReports/cucumber-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
        //publish = true
)
public class TestRunner extends TestBase{

}
