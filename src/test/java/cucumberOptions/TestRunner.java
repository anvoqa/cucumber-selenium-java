package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		//path to feature files
		features = "src/test/java/features",
		//path to step definitions package
		glue = "stepDefinitions",
		monochrome = true,
		plugin = {"pretty", "html:target/site/cucumber-report-default", "json:target/site/cucumber.json"},
		snippets = SnippetType.CAMELCASE,
		tags = "@users or @contact"
		)

public class TestRunner {

}
