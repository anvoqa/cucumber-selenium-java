package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class CommonPageObject extends BasePage{
	public CommonPageObject(WebDriver newDriver) {
		super(newDriver);
	}
	
	private static final String LOG_OUT_BUTTON = "//button[@id='logout']";
	
	public boolean isLogOutButtonDisplayed() {
		return isElementDisplayed(LOG_OUT_BUTTON);
	}
	
	public void clickLogout() {
		clickElement(LOG_OUT_BUTTON);
	}
	
}
