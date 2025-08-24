package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/feature/checkout.feature", // your .feature path
glue={"stepDefinition","hooks"},  // your step definitions package
plugin = {
    "pretty",
    "html:target/cucumber-reports/cucumber_checkout.html",
    "json:target/cucumber-reports/cucumber_checkout.json",
    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
},
monochrome = true
)
public class CheckoutRun {
	
	

}
