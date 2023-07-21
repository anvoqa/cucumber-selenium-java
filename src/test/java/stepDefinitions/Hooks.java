package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import cucumberOptions.TestContext;

public class Hooks {
	TestContext testContext;
	
	public Hooks(TestContext context) {
		testContext = context;
	}
	
	@Before
	public void beforeScenario() {
		/*Use before when you want to:
		 * - Createn a new driver
		 * - Connect to database
		 * - Set up test data
		 * - etc.
		 * */
		
	}
	
	@After
	public void afterScenario() {
		testContext.getDriverManager().closeDriver();
	}

}
