package stepDefinitions;


import io.cucumber.java.en.Given;
import cucumberOptions.TestContext;
import pageObjects.HomepageObject;

public class BackgroundSteps {
	public HomepageObject homepage;
	TestContext testContext;
	
	public BackgroundSteps(TestContext context) {
		testContext = context;
		homepage = testContext.getPageManager().getHomepage();
	}
	
	@Given("^I login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void iLoginWithEmailAndPassword(String email, String password) {
		homepage.login(email, password); 
	}
}
