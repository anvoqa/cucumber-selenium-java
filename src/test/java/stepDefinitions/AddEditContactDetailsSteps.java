package stepDefinitions;

import java.util.Map;


import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import cucumberOptions.TestContext;
import pageObjects.AddEditContactPageObject;

public class AddEditContactDetailsSteps{
	public String email = "teste.r@gmail.com";
	public String password = "1234567";
	
	TestContext testContext;
	AddEditContactPageObject addEditContactPage;
	
	public AddEditContactDetailsSteps(TestContext context) {
		testContext = context;
		addEditContactPage = testContext.getPageManager().getAddContactPage();
	}

	@When("^I update the email \"([^\"]*)\"$")
	public void iUpdateTheEmail(String newEmail) {
		addEditContactPage.inputEmail(newEmail);
	}
	
	@When("^I click Submit button$")
	public void iClickSubmitButton() {
		addEditContactPage.clickSubmit();
	}
	
	@When("^I add a new contact$")
	public void iAddANewContact(DataTable contact) {
		for(Map<String, String> contactDetails: contact.asMaps(String.class, String.class)){
			addEditContactPage.inputFirstName(contactDetails.get("First Name"));
			addEditContactPage.inputLastName(contactDetails.get("Last Name"));
			addEditContactPage.inputDOB(contactDetails.get("DOB"));
			addEditContactPage.inputEmail(contactDetails.get("Email"));
			addEditContactPage.inputPhoneNumber(contactDetails.get("Phone"));
			addEditContactPage.inputAddress1(contactDetails.get("Address 1"));
			addEditContactPage.inputAddress2(contactDetails.get("Address 2"));
			addEditContactPage.inputCity(contactDetails.get("City"));
			addEditContactPage.inputStateProvince(contactDetails.get("State Province"));
			addEditContactPage.inputPostalCode(contactDetails.get("Postal Code"));
			addEditContactPage.inputCountry(contactDetails.get("Country"));
		}
		
	}


}
