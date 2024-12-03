package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
//import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	    features = ".//Features/compose.feature",
	    glue = "stepDefinitions",
	    dryRun = true,
	    plugin = {
	        "pretty", 
	        "html:target/cucumber-reports/report.html", 
	        "json:target/cucumber-reports/Cucumber.json"
	    }
	)
	public class ComposeGmailTestRunner extends AbstractTestNGCucumberTests {
	    }
