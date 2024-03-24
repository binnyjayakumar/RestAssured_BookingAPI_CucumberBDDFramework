package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class runner 
{
	@CucumberOptions(
			features = "src/test/resources/Features/bookingAPI.feature",
			glue = {"BookingAPI_Stepdefinitions"},
			//tags ="@smoke",
			monochrome = true,
			plugin = "json:target/cucumber-reports/CucumberTestReport.json")

	public class TestRunner extends AbstractTestNGCucumberTests  {



	}

}
