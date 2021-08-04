package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/htmlReport.html"},
		features = "Features",
		glue = {"stepdef"},
		tags = "@expleo",
		stepNotifications = true)
public class TestRunner {

}
