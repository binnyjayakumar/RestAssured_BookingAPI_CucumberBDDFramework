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
			plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
					  	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			"html:target/HtmlReport/htmlreport.html"})

	public class TestRunner extends AbstractTestNGCucumberTests  {



	}

}
