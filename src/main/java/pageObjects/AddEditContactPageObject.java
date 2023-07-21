package pageObjects;

import org.openqa.selenium.WebDriver;

import objects.ContactDetails;

public class AddEditContactPageObject extends CommonPageObject{

	public AddEditContactPageObject(WebDriver newDriver) {
		super(newDriver);
	}
	
	//Locator
	private static final String FIRST_NAME_TEXTBOX = "//input[@id='firstName']";
	private static final String LAST_NAME_TEXTBOX = "//input[@id='lastName']";
	private static final String DOB_TEXTBOX = "//input[@id='birthdate']";
	private static final String EMAIL_TEXTBOX = "//input[@id='email']";
	private static final String PHONE_NUMBER_TEXTBOX = "//input[@id='phone']";
	private static final String ADDRESS_1_TEXTBOX = "//input[@id='street1']";
	private static final String ADDRESS_2_TEXTBOX = "//input[@id='street2']";
	private static final String CITY_TEXTBOX = "//input[@id='city']";
	private static final String STATE_PROVINCE_TEXTBOX = "//input[@id='stateProvince']";
	private static final String POSTAL_CODE_TEXTBOX = "//input[@id='postalCode']";
	private static final String COUNTRY_TEXTBOX = "//input[@id='country']";
	private static final String SUBMIT_BUTTON = "//button[@id='submit']";
	
	public void clickSubmit() {
		clickElement(SUBMIT_BUTTON);
	}
	
	public void addAContact(ContactDetails contact) {
	    sendKeysToElement(FIRST_NAME_TEXTBOX, contact.getFirstName());
	    sendKeysToElement(LAST_NAME_TEXTBOX, contact.getLastName());
	    sendKeysToElement(DOB_TEXTBOX, contact.getDob());
	    sendKeysToElement(EMAIL_TEXTBOX, contact.getEmail());
	    sendKeysToElement(PHONE_NUMBER_TEXTBOX, contact.getPhoneNumber());
	    sendKeysToElement(ADDRESS_1_TEXTBOX, contact.getAddress1());
	    sendKeysToElement(ADDRESS_2_TEXTBOX, contact.getAddress2());
	    sendKeysToElement(CITY_TEXTBOX, contact.getCity());
	    sendKeysToElement(STATE_PROVINCE_TEXTBOX, contact.getStateProvince());
	    sendKeysToElement(POSTAL_CODE_TEXTBOX, contact.getPostalCode());
	    sendKeysToElement(COUNTRY_TEXTBOX, contact.getCountry());
	    clickElement(SUBMIT_BUTTON);
	}
	
	public void inputFirstName(String firstName) {
		sendKeysToElement(FIRST_NAME_TEXTBOX, firstName);
	}
	
	public void inputLastName(String lastName) {
		sendKeysToElement(LAST_NAME_TEXTBOX, lastName);
	}
	
	public void inputDOB(String dob) {
		sendKeysToElement(DOB_TEXTBOX, dob);
	}
	
	public void inputEmail(String email) {
		sendKeysToElement(EMAIL_TEXTBOX, email);
	}
	
	public void inputPhoneNumber(String phoneNo) {
		sendKeysToElement(PHONE_NUMBER_TEXTBOX, phoneNo);
	}
	
	public void inputAddress1(String address1) {
		sendKeysToElement(ADDRESS_1_TEXTBOX, address1);
	}
	
	public void inputAddress2(String address2) {
		sendKeysToElement(ADDRESS_2_TEXTBOX, address2);
	}
	
	public void inputCity(String city) {
		sendKeysToElement(CITY_TEXTBOX, city);
	}
	
	public void inputStateProvince(String stateProvince) {
		sendKeysToElement(STATE_PROVINCE_TEXTBOX, stateProvince);
	}
	
	public void inputPostalCode(String postalCode) {
		sendKeysToElement(POSTAL_CODE_TEXTBOX, postalCode);
	}
	
	public void inputCountry(String country) {
		sendKeysToElement(COUNTRY_TEXTBOX, country);
	}
}
