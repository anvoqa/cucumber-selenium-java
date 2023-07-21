package pageObjects;

import org.openqa.selenium.WebDriver;

import objects.ContactDetails;
import objects.DataBuilder;

public class ViewContactDetailsPageObject extends CommonPageObject{
	
	public ViewContactDetailsPageObject(WebDriver newDriver) {
		super(newDriver);
	}
	
	//Locator
	private static final String EDIT_CONTACT_BUTTON = "//button[@id='edit-contact']";
	private static final String DELETE_CONTACT_BUTTON = "//button[@id='delete']";
	private static final String RETURN_TO_CONTACT_LIST_BUTTON = "//button[@id='return']";
	
	private static final String FIRST_NAME_VALUE = "//span[@id='firstName']";
	private static final String LAST_NAME_VALUE = "//span[@id='lastName']";
	private static final String DOB_VALUE = "//span[@id='birthdate']";
	private static final String EMAIL_VALUE = "//span[@id='email']";
	private static final String PHONE_VALUE = "//span[@id='phone']";
	private static final String ADDRESS1_VALUE = "//span[@id='street1']";
	private static final String ADDRESS2_VALUE = "//span[@id='street2']";
	private static final String CITY_VALUE = "//span[@id='city']";
	private static final String STATE_PROVINCE_VALUE = "//span[@id='stateProvince']";
	private static final String POSTAL_CODE_VALUE = "//span[@id='postalCode']";
	private static final String COUNTRY_VALUE = "//span[@id='country']";
	
	
	public void clickEditContact() {
		clickElement(EDIT_CONTACT_BUTTON);
	}
	
	public void returnToContactList() {
		clickElement(RETURN_TO_CONTACT_LIST_BUTTON);
	}
	
	public ContactDetails getContactDetails() {
		ContactDetails contact = DataBuilder.getContactDetails();
		contact.setFirstName(getTextFromElement(FIRST_NAME_VALUE));
		contact.setLastName(getTextFromElement(LAST_NAME_VALUE));
		contact.setDob(getTextFromElement(DOB_VALUE));
		contact.setEmail(getEmailText());
		contact.setPhoneNumber(getTextFromElement(PHONE_VALUE));
		contact.setAddress1(getTextFromElement(ADDRESS1_VALUE));
		contact.setAddress2(getTextFromElement(ADDRESS2_VALUE));
		contact.setCity(getTextFromElement(CITY_VALUE));
		contact.setStateProvince(getTextFromElement(STATE_PROVINCE_VALUE));
		contact.setPostalCode(getTextFromElement(POSTAL_CODE_VALUE));
		contact.setCountry(getTextFromElement(COUNTRY_VALUE));
		
		return contact;
	}
	
	public String getEmailText() {
		return getTextFromElement(EMAIL_VALUE);
	}

	public void clickDeleteContact() {
		clickElement(DELETE_CONTACT_BUTTON);
	}

	public void acceptDeleteAlert() {
		acceptAlert();
	}

	
}
