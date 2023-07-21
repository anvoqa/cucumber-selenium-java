package pageObjects;

import org.openqa.selenium.WebDriver;

public class ContactListPageObject extends CommonPageObject{
	
	public ContactListPageObject(WebDriver newDriver) {
		super(newDriver);
	}
	
	//Locator
	private static final String ADD_CONTACT_BUTTON = "//button[@id='add-contact']";
	
	public String getContactListPageUrl() {
		return getCurrentUrl();
	}

	
	public void clickAddNewContact() {
		clickElement(ADD_CONTACT_BUTTON);
	}
	
	public enum TableColumnXpath{
		NAME("2"),
		BIRTHDATE("3"),
		EMAIL("4"),
		PHONE("5"),
		ADDRESS("6"),
		CITY_STATE_PROVINCE_POSTALCODE("7"),
		COUNTRY("8");
		
		private String cellXpath;
		
		TableColumnXpath(String cellXpath) {
			this.cellXpath = cellXpath;
		}
		
		public String getCellXpath(String rowIndex) {
			return "//table[@id='myTable']/tr[" + rowIndex + "]/td[" + cellXpath + "]";
		}
	}
	
	public String getName(String rowIndex) {
		return getTextFromElement(TableColumnXpath.NAME.getCellXpath(rowIndex));
	}
	
	public String getBirthDate(String rowIndex) {
		return getTextFromElement(TableColumnXpath.BIRTHDATE.getCellXpath(rowIndex));
	}
	
	public String getEmail(String rowIndex) {
		return getTextFromElement(TableColumnXpath.EMAIL.getCellXpath(rowIndex));
	}
	
	public String getPhone(String rowIndex) {
		return getTextFromElement(TableColumnXpath.PHONE.getCellXpath(rowIndex));
	}
	
	public String getAddress(String rowIndex) {
		return getTextFromElement(TableColumnXpath.ADDRESS.getCellXpath(rowIndex));
	}
	
	public String getCityStateProvincePostalCode(String rowIndex) {
		return getTextFromElement(TableColumnXpath.CITY_STATE_PROVINCE_POSTALCODE.getCellXpath(rowIndex));
	}
	
	public String getCountry(String rowIndex) {
		return getTextFromElement(TableColumnXpath.COUNTRY.getCellXpath(rowIndex));
	}
	
	public void viewAContact(String email) {
		clickElement("//table[@id='myTable']//td[text()='" + email + "']");
	}
	
	public String getRowIndexByEmail(String email) {
		return String.valueOf(getRowIndexByText("//table[@id='myTable']//td[4]", email));
	}
	
	
	public boolean isContactWithEmailDisplayed(String email) {
		int size = getWebElementsByXpath("//table[@id='myTable']//td[text()='" + email + "']").size();
		return size == 0? false:true;
	}
	
	
	
	
}
