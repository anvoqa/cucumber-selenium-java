package cucumberOptions;

import pageObjects.PageGeneratorManager;

public class TestContext {
	private DriverManager driverManager;
	private PageGeneratorManager pageManager;
	
	public TestContext() {
		driverManager = new DriverManager();
		pageManager = new PageGeneratorManager(driverManager.getDriver());
	}
	
	public DriverManager getDriverManager() {
		return driverManager;
	}
	
	public PageGeneratorManager getPageManager() {
		return pageManager;
	}
}
