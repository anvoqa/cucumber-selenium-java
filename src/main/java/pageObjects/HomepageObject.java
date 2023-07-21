package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class HomepageObject extends BasePage{

	public HomepageObject(WebDriver newDriver) {
		super(newDriver);
	}
	
	//Locator xpath
	private static final String EMAIL_TEXTBOX = "//input[@id='email']";
	private static final String PASSWORD_TEXTBOX = "//input[@id='password']";
	private static final String SUBMIT_BUTTON = "//button[@id='submit']";
	private static final String SIGNUP_BUTTON = "//button[@id='signup']";
	
	public void login(String email, String password) {
		sendKeysToElement(EMAIL_TEXTBOX, email);
		sendKeysToElement(PASSWORD_TEXTBOX, password);
		clickElement(SUBMIT_BUTTON);
	}
	
	public void clickSignUp() {
		clickElement(SIGNUP_BUTTON);
	}

	
}
