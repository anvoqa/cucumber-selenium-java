package stepDefinitions;


import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import cucumberOptions.TestContext;
import pageObjects.HomepageObject;

public class HomepageSteps {
	public static String email = "teste.r@gmail.com";
	public static String password = "1234567";
	public HomepageObject homepage;
	TestContext testContext;
	
	public HomepageSteps(TestContext context) {
		testContext = context;
		homepage = testContext.getPageManager().getHomepage();
	}
	
	@Given("^open Contact List homepage$")
	public void openContactListHomepage() {
	}
	
	@When("^I login with email and password$")
	public void iLoginWithEmailAndPassword(){
		homepage.login(email, password);   
	}
	
	@When("^I click Sign up button$")
	public void iClickSignUpButton() {
		homepage.clickSignUp();
	}

}
