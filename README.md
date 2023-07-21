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
- Use **page object model (POM)** to manage the elements and methods of each web page
- Use projeclombok to create constuctors and take care of getters and setters of **POJO** classes
- Use **Rest-Assured** to setup and clean up test data at **API** level
- **WebDriverManager** to manage web drivers

## 🏗️Project structure and components🏗️
<img width="204" alt="image" src="https://github.com/anvoqa/cucumber-selenium-java/assets/128540316/c2c9f638-1634-43c8-81b8-6226aef36579"> 

- `src/main/java`: Contains BasedPage (selenium wrapper), page objects and POJO classes
- `src/test/java`
  - `apiHelpers`: Contains classes having API methods to set up and clean up test data. These methods are implemented using Rest-Assured library
  -  `cucumberOptions`:  Contains TestContext (used to share the context across step definition classes), DriverManager (with methods to create and quit drivers) and TestRunner class - the configuration of test execution
  -  `features`: Contains feature files used to define the test scenarios
  -  `stepDefinitions`: Contains classes used to map steps from feature files to selenium java code to drive webdriver to interact with web elements
  - `pom.xml`: Used to manage project dependencies 
- `Cucumber html report` is being used for reporting and can be found under folder `/target/site/cucumber-reporting/cucumber-html-reports`. To view full report, use `overview-features.html` file. The report looks like as below

## Cucumber HTML Report
Cucumber html report is being used for reporting and can be found under folder `/target/site/cucumber-reporting/cucumber-html-reports`. 

To view full report, use `overview-features.html` file. 

The report looks like as below
<img width="916" alt="image" src="https://github.com/anvoqa/cucumber-selenium-java/assets/128540316/9ba964a6-e2b0-44ce-8734-7228d54f9f1e">
<img width="1092" alt="image" src="https://github.com/anvoqa/cucumber-selenium-java/assets/128540316/de6021ff-797b-4bf1-8e33-6816067fb95e">
<img width="930" alt="image" src="https://github.com/anvoqa/cucumber-selenium-java/assets/128540316/f39ea840-e76f-46e6-bee1-c9aca717c48f">

## 🏃How the test run🏃


## 💻How to clone this project and run tests on your local?💻
- Install java
- Clone this repo to a folder
- Open CLI and cd to project folder
- Run test using command `mvn test -DBROWSER="<chrome|headless_chrome|firefox|edge"`
  
## ⬆️Potential improvements⬆️
- Update driver manager class to either run test on local or gird (using docker or cross-browser cloud service, ect. BrowserStack)
- Move configuration to .properties files and implement a class to read the config from .properties file
- Using JSON Data Reader to implement data-driven testing
