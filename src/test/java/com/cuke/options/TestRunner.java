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
//		tags = "@Regression",
        plugin = {"progress",
                "html:target/report/cucumber-reports/cucumber.html",
                "junit:target/report/junit/cucumber-report.xml",
                "json:target/jsonReports/cucumber-report.json"
        }
)
public class TestRunner extends TestBase{

}
