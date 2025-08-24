package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
		@CucumberOptions(
	    features = "src/test/resources/feature/search.feature", // your .feature path
	    glue = {"stepDefinition"},  // your step definitions package
	    plugin = {
	        "pretty",
	        "html:target/cucumber-reports/cucumber_search.html",
	        "json:target/cucumber-reports/cucumber_search.json"
	    },
	    monochrome = true
	)
public class Searchrun

{

}
