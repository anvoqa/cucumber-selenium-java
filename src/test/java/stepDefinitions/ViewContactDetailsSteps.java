package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import cucumberOptions.TestContext;
import pageObjects.ContactListPageObject;
import pageObjects.ViewContactDetailsPageObject;

public class ViewContactDetailsSteps {
	public ViewContactDetailsPageObject viewContactDetailsPage;
	public ContactListPageObject contactListPage;
	TestContext testContext;
	
	public ViewContactDetailsSteps(TestContext context) {
		testContext = context;
		viewContactDetailsPage = testContext.getPageManager().getViewContactDetailsPage();
		contactListPage = testContext.getPageManager().getContactListPage();
	}
	
	@Then("^I see the correct contact details in the View Contact Details page$")
	public void iSeeTheCorrectContactDetailsInTheViewContactDetailsPage(DataTable contact){
		for(Map<String, String> contactDetails: contact.asMaps(String.class, String.class)){
			Assert.assertEquals(viewContactDetailsPage.getContactDetails().getFirstName(), contactDetails.get("First Name"));
			Assert.assertEquals(viewContactDetailsPage.getContactDetails().getLastName(), contactDetails.get("Last Name"));
			Assert.assertEquals(viewContactDetailsPage.getContactDetails().getDob(), contactDetails.get("DOB"));
			Assert.assertEquals(viewContactDetailsPage.getContactDetails().getEmail(), contactDetails.get("Email"));
			Assert.assertEquals(viewContactDetailsPage.getContactDetails().getPhoneNumber(), contactDetails.get("Phone"));
			Assert.assertEquals(viewContactDetailsPage.getContactDetails().getAddress1(), contactDetails.get("Address 1"));
			Assert.assertEquals(viewContactDetailsPage.getContactDetails().getAddress2(), contactDetails.get("Address 2"));
			Assert.assertEquals(viewContactDetailsPage.getContactDetails().getCity(), contactDetails.get("City"));
			Assert.assertEquals(viewContactDetailsPage.getContactDetails().getStateProvince(), contactDetails.get("State Province"));
			Assert.assertEquals(viewContactDetailsPage.getContactDetails().getPostalCode(), contactDetails.get("Postal Code"));
			Assert.assertEquals(viewContactDetailsPage.getContactDetails().getCountry(), contactDetails.get("Country"));
		}
	}
	
	@When("^click Edit Contact$")
	public void clickEditContact() {
	    viewContactDetailsPage.clickEditContact();
	}
	
	@When("^I click Delete Contact button$")
	public void iClickDeleteContactButton() {
		viewContactDetailsPage.clickDeleteContact();
	}

	@When("^I click OK on the alert$")
	public void iClickOKOnTheAlert() {
		viewContactDetailsPage.acceptDeleteAlert();
	}

	@Then("^the contact with email \"([^\"]*)\" disappears from the list$")
	public void theContactDisappearsFromTheList(String email) {
		Assert.assertFalse(contactListPage.isContactWithEmailDisplayed(email));
	}
	
	@Then("^I see the correct email \"([^\"]*)\" in the View Contact Details page$")
	public void iSeeTheCorrectEmailInTheViewContactDetailsPage(String email) {
		Assert.assertEquals(email, viewContactDetailsPage.getEmailText());
	}


}
