package stepDefinitions;

import java.util.Map;

import org.junit.Assert;

import commons.GlobalConstants;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import cucumberOptions.TestContext;
import pageObjects.ContactListPageObject;

public class ContactListSteps {
	ContactListPageObject contactListPage;
	TestContext testContext;

	public ContactListSteps(TestContext context) {
		testContext = context;
		contactListPage = testContext.getPageManager().getContactListPage();
	}

	@Then("^system redirects to Contact List page$")
	public void systemRedirectsToContactListPage() {
		Assert.assertTrue(contactListPage.isLogOutButtonDisplayed());
	    Assert.assertEquals(contactListPage.getContactListPageUrl(), GlobalConstants.CONTACT_LIST_URL);
	}
	
	@When("^I click Add a new Contact button$")
	public void iClickAddANewContactButton() {
	    contactListPage.clickAddNewContact();
	}
	
	@When("^I view a contact by email \"([^\"]*)\"$")
	public void iViewAContactByEmail(String email) {
		contactListPage.viewAContact(email);
	}
	
	@Then("^I see a new contact displays in the contact list$")
	public void iSeeANewContactDisplaysInTheContactList(DataTable contact){
		for(Map<String, String> contactDetails: contact.asMaps(String.class, String.class)){
		String rowIndex = contactListPage.getRowIndexByEmail(contactDetails.get("Email"));
		
		Assert.assertEquals(contactListPage.getName(rowIndex), contactDetails.get("First Name") + " " + contactDetails.get("Last Name"));
		Assert.assertEquals(contactListPage.getBirthDate(rowIndex), contactDetails.get("DOB"));
		Assert.assertEquals(contactListPage.getEmail(rowIndex), contactDetails.get("Email"));
		Assert.assertEquals(contactListPage.getPhone(rowIndex), contactDetails.get("Phone"));
		Assert.assertEquals(contactListPage.getAddress(rowIndex), contactDetails.get("Address 1") + " " + contactDetails.get("Address 2"));
		Assert.assertEquals(contactListPage.getCityStateProvincePostalCode(rowIndex), contactDetails.get("City") 
				+ " " + contactDetails.get("State Province") + " " + contactDetails.get("Postal Code"));
		Assert.assertEquals(contactListPage.getCountry(rowIndex), contactDetails.get("Country"));
		}
	}
}
