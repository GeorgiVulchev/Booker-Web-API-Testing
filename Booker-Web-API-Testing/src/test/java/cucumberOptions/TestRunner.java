package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = { "stepDefinitions" }, tags = "@E2E", plugin = { "pretty",
		"html:target/cucumber-reports/report.html" }, monochrome = true)

//"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
public class TestRunner {
}