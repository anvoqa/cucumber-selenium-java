package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import objects.Accounts;

public class RegisterPageObject extends BasePage{

	public RegisterPageObject(WebDriver newDriver) {
		super(newDriver);
	}
	
	//Locator xpath
	private static final String FIRST_NAME_TEXTBOX = "//input[@id='firstName']";
	private static final String LAST_NAME_TEXTBOX = "//input[@id='lastName']";
	private static final String EMAIL_TEXTBOX = "//input[@id='email']";
	private static final String PASSWORD_TEXTBOX = "//input[@id='password']";
	private static final String SUBMIT_BUTTON = "//button[@id='submit']";
	
	public void registerAnAccount(Accounts acc) {
		sendKeysToElement(FIRST_NAME_TEXTBOX, acc.getFirstName());
		sendKeysToElement(LAST_NAME_TEXTBOX, acc.getLastName());
		sendKeysToElement(EMAIL_TEXTBOX, acc.getEmail());
		sendKeysToElement(PASSWORD_TEXTBOX, acc.getPassword());
		clickElement(SUBMIT_BUTTON);
	}


	
}
