package stepDefinitions;


import apiHelpers.Contacts;
import io.cucumber.java.en.When;
import cucumberOptions.TestContext;
import pageObjects.ContactListPageObject;

public class CommonSteps {
	ContactListPageObject contactListPage;
	TestContext testContext;

	public CommonSteps(TestContext context) {
		testContext = context;
		contactListPage = testContext.getPageManager().getContactListPage();
	}
	
	@When("^I logout$")
	public void iLogOut() {
	    contactListPage.clickLogout();
	}
	
	@When("^I delete all contacts using API$")
	public void iDeleteAllContactsUsingAPI() {
		Contacts.deleteAllContacts(HomepageSteps.email, HomepageSteps.password);
	}

}
