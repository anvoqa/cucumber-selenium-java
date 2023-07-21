package stepDefinitions;


import apiHelpers.Users;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import cucumberOptions.TestContext;
import objects.Accounts;
import objects.DataBuilder;
import pageObjects.RegisterPageObject;

public class RegisterSteps{
	public RegisterPageObject registerPage;
	static Accounts acc;
	TestContext testContext;
	
	public RegisterSteps(TestContext context) {
		testContext = context;
		registerPage = testContext.getPageManager().getRegisterPage();
		acc = DataBuilder.getAccountDetails();
	}
	
	@When("^I register an account with random data$")
	public void iRegisterAnAccountWithRandomData(){
		registerPage.registerAnAccount(acc);
	}
	
	@Then("^I clean up the account$")
	public void iCleanUpTheAccount() {
	   Users.deleteUser(RegisterSteps.acc.getEmail(), RegisterSteps.acc.getPassword());
	}
	
	

}
