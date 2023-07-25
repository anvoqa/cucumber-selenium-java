# cucumber-selenium-java <img src="https://github.com/devicons/devicon/blob/master/icons/cucumber/cucumber-plain.svg" title="Cucumber" alt="Cucumber" width="35" height="35"/> <img src="https://github.com/devicons/devicon/blob/master/icons/selenium/selenium-original.svg" title="Selenium" alt="Selenium" width="35" height="35"/> <img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original-wordmark.svg" title="Java" alt="Java" width="40" height="40"/>

## 🗞️Introduction 🗞️
This project demonstrates my technical expertise in developing automation framework using cucumber (7.13.0) with Selenium (4.10.0) and Java

The Application Under Test (AUT) that is used for this project is Contact List App `https://thinking-tester-contact-list.herokuapp.com/`

**Features to be tested:**
- _Manage users_ (registration and login)
  - Register a random account
  - Login
- _Manage contact list_ (CRUD operations)
  - Add a few contacts using data table
  - View details of one of the added contacts
  - Edit email of a contact
  - Delete a contact

## 👨‍🎓What is the knowledge used for this project?👨‍🎓
- **cucumber**: feature files, step defintions, cucumber regrex, data table, cucumber options, hooks, tags, cucumber report
- Use **scenario outline** and examples in feature files for **data-driven testing**
- Use **Page Object Model (POM)** to manage the elements and methods of each web page
- Use **projeclombok** to create constuctors and take care of getters and setters of **POJO** classes
- Use **Rest-Assured** to setup and clean up test data at **API** level
- **WebDriverManager** to manage web drivers

## 🏗️Project structure and components🏗️
<img width="947" alt="image" src="https://github.com/anvoqa/cucumber-selenium-java/assets/128540316/37aa113f-dbd7-47b9-afb7-bf2d1b4a8419">

- `src/main/java`: Contains BasedPage (selenium wrapper), page objects and POJO classes
- `src/test/java`
  - `apiHelpers`: Contains classes having API methods to set up and clean up test data. These methods are implemented using Rest-Assured library
  -  `cucumberOptions`:  Contains TestContext (used to share the context across step definition classes), DriverManager (with methods to create and quit drivers) and TestRunner class - the configuration of test execution
  -  `features`: Contains feature files used to define the test scenarios
  -  `stepDefinitions`: Contains classes used to map steps from feature files to selenium java code to drive webdriver to interact with web elements. Each step definition class also contains only steps of one web page and mapping with one respective page object
  - `pom.xml`: Used to manage project dependencies 

## 🏃How the test run🏃
<img width="739" alt="image" src="https://github.com/anvoqa/cucumber-selenium-java/assets/128540316/3cad3763-a2f4-472d-9d43-dd3084142058">

- Starting the test execution by Maven command `mvn test -DBROWSER="chrome"`, maven surfile pluggin is configured to run the **TestRunner.java** class.
- In the TestRunner file:
  - The **features** cucumberOptions is used to look for the feature files and **glues** is used to to map features with step definitions
  - The **tags = "@users or @contact"** option will make the tests having each tag run in parallel
- Before the first scenario is executed, the chrome driver is created through the **Driver Manager** class, and the **Page Generator Manager (PGM)** which is used to create page object instances in the step definition classes is instantiated. Since the test scenario will use multiple step definition classes, **PicoContainer** library and **singleton design** are used for instantiating these objects once to share the **Test Context** between multiple step definition classes
- After all the set up is done, the first step of scenario will be executed. A step from feature file will map with a method in a step defnition class using **cucumber regex**
- Inside a method of step definition class, it will call the methods through a **page object** class to perform actions.
- When a method of a page object is called, it will call the Selenium functions from parent **BasePage** class and pass the xpath defined in the page object, along with the test data from parameters (if any) to those functions to interact with the web elements of the application.
- When all steps of the scenario are executed, the **@After hook** is called to quit the driver
- After all tests are executed, **HTML report** is generated using cucumber reporting library. HTML uses default cucumber.json report as the input file

## Cucumber HTML Report
Cucumber html report is being used for reporting and can be found under folder `/target/site/cucumber-reporting/cucumber-html-reports`. 

To view full report, use `overview-features.html` file. 

The report looks like as below
<img width="916" alt="image" src="https://github.com/anvoqa/cucumber-selenium-java/assets/128540316/9ba964a6-e2b0-44ce-8734-7228d54f9f1e">
<img width="1092" alt="image" src="https://github.com/anvoqa/cucumber-selenium-java/assets/128540316/de6021ff-797b-4bf1-8e33-6816067fb95e">
<img width="930" alt="image" src="https://github.com/anvoqa/cucumber-selenium-java/assets/128540316/f39ea840-e76f-46e6-bee1-c9aca717c48f">

## 💻How to clone this project and run tests on your local?💻
- Install java, Maven and set the environment paths
- Clone this repo to a folder
- Open CLI and cd to project folder
- Run test using command `mvn test -DBROWSER="<chrome|headless_chrome|firefox|edge"`
  
## ⬆️Potential improvements⬆️
- Update driver manager class to either run test on local or gird (using docker or cross-browser cloud service, ect. BrowserStack)
- Move configuration to .properties files and implement a class to read the config from .properties file
- Using JSON Data Reader to implement data-driven testing
