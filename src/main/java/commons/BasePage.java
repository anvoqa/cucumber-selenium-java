package commons;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

/**
 * Grouping of all Selenium wrapper methods
 *
 * @author An Vo
 */

public class BasePage {
	public WebDriver driver;
	protected WebDriverWait wdw;

	/**
	 * Selenium Class Constructor
	 *
	 * @param newDriver Selenium Web Driver to be used by this class
	 */
	public BasePage(WebDriver newDriver) {
		driver = newDriver;
		wdw = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.MAX_TIMEOUT));
	}
	
	/**
	 * Get the url of current page
	 *
	 */
	protected String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * Returns the web element at the provided By locator. Method will try for
	 * {@link #maxTimeOut} before failing the test.
	 *
	 * @param by By locator of element
	 * @return webElement at location
	 */
	protected WebElement getWebElement(By by) {
		String message = "";
		try {
			wdw.until(ExpectedConditions.presenceOfElementLocated(by));
			return driver.findElement(by);
		} catch (TimeoutException e) {
			message = "Error: Timed out exception. Could not get webelement at " + by.toString();
			Assert.fail(message);
		} catch (NoSuchElementException e) {
			message = "Error: Unable to locate element. Could not get webelement at " + by.toString();
			Assert.fail(message);
		}
		return null;
	}

	/**
	 * Method that return a WebElement based on provided xpath
	 *
	 * @param xpath xpath to use to find element
	 */
	protected WebElement getWebElementByXpath(String xpath) {
		return getWebElement(By.xpath(xpath));
	}
	
	/**
	 * Return a list of WebElements based on provided xpath
	 *
	 * @param xpath xpath to use to find element
	 */
	protected List<WebElement> getWebElementsByXpath(String xpath) {
		return this.driver.findElements(By.xpath(xpath));
	}
	
	/**
	 * Find the row index of a table's cell based on its text/data
	 * Methods will get all the elements of a specific column of the table
	 * Use for loop to go through the list of elements; get text of element,
	 * check if it's equal to expected text, return its index in the list
	 *
	 * @param parentXpath xpath to use to find elements of a specific column
	 * @param text value of table's cell in a specific column
	 */
	protected int getRowIndexByText(String parentXpath, String text) {
		List<WebElement> elements = getWebElementsByXpath(parentXpath);
		int size = elements.size();
		for (int i = 0; i < size; i++) {
			if (elements.get(i).getText().equals(text)){
				return i + 1;
			}
		}
		return 0;
	}
	
	
    /**
     * Wait until the specified By locator is visible on the current page.
     *
     * @param by by locator to verify
     */
	protected void waitUntilElementVisible(By by) {
		String message= "";
		try {
			wdw.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		 catch (TimeoutException e) {
				message = "Error: Timed out exception. Could not get webelement at " + by.toString();
				Assert.fail(message);
			} catch (NoSuchElementException e) {
				message = "Error: Unable to locate element. Could not get webelement at " + by.toString();
				Assert.fail(message);
			}
	}
	
    /**
     * Wait until the specified xpath is visible on the current page.
     *
     * @param xpath xpath of element
     */
	protected void waitUntilElementVisible(String xpath) {
		waitUntilElementVisible(By.xpath(xpath));
	}
	
    /**
     * Return true if element is displayed
     *
     * @param xpath xpath of element
     * @return boolean
     */
	protected boolean isElementDisplayed(String xpath) {
		return getWebElementByXpath(xpath).isDisplayed();
	}
	
    /**
     * Input value to a texbox element.
     * wait until element visible, clear the existing value then input new value to element
     * @param xpath xpath of element
     * @param value value input to element
     */
	protected void sendKeysToElement(String xpath, String value) {
		waitUntilElementVisible(xpath);
		getWebElementByXpath(xpath).clear();
		getWebElementByXpath(xpath).sendKeys(value);
	}
	
    /**
     * Click to element (e.g. button, link)
     * @param xpath xpath of element
     */
	protected void clickElement(String xpath) {
		waitUntilElementVisible(xpath);
		getWebElementByXpath(xpath).click();
	}
	
	   /**
     * Get text from element
     * @param xpath xpath of element
     * @return text value of element
     */
	protected String getTextFromElement(String xpath) {
		waitUntilElementVisible(xpath);
		return getWebElementByXpath(xpath).getText();
	}
	
	/**
	 * Accept browser alert
	 * 
	 */
	public void acceptAlert() {
		this.driver.switchTo().alert().accept();
	}
	

}
