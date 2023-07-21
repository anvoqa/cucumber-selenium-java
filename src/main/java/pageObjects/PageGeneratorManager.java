package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private WebDriver driver;
	private HomepageObject homepage;
	private ContactListPageObject contactListPage;
	private AddEditContactPageObject addEditContactPage;
	private ViewContactDetailsPageObject viewContactDetailsPage;
	private RegisterPageObject registerPage;
	
	public PageGeneratorManager(WebDriver driver) {
		this.driver = driver;
	}
	public HomepageObject getHomepage() {
		return (homepage == null) ? new HomepageObject(driver) : homepage;
	}
	
	public ContactListPageObject getContactListPage() {
		return (contactListPage == null) ? new ContactListPageObject(driver) : contactListPage;
	}
	
	public AddEditContactPageObject getAddContactPage() {
		return (addEditContactPage == null) ? new AddEditContactPageObject(driver) : addEditContactPage;
	}

	public ViewContactDetailsPageObject getViewContactDetailsPage() {
		return (viewContactDetailsPage == null) ? new ViewContactDetailsPageObject(driver) : viewContactDetailsPage;
	}

	public RegisterPageObject getRegisterPage() {
		return (registerPage == null) ? new RegisterPageObject(driver) : registerPage;
	}
}
