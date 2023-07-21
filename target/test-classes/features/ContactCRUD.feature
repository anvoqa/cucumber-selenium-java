#Author: an.vo.tester@gmail.com
@contact
Feature: Manage contacts
  As a user, I want to perform CRUD operations on contat list
  so that I can keep it up to date

  Background: 
    Given I login with email "teste.r@gmail.com" and password "1234567"

  @add-contact, @smoketest, @regressiontest
  Scenario Outline: Add Contact Successfully
    When I click Add a new Contact button
    And I add a new contact
      | First Name   | Last Name   | DOB   | Email   | Phone   | Address 1   | Address 2   | City   | State Province   | Postal Code   | Country   |
      | <First Name> | <Last Name> | <DOB> | <Email> | <Phone> | <Address 1> | <Address 2> | <City> | <State Province> | <Postal Code> | <Country> |
    And I click Submit button
    Then I see a new contact displays in the contact list
      | First Name   | Last Name   | DOB   | Email   | Phone   | Address 1   | Address 2   | City   | State Province   | Postal Code   | Country   |
      | <First Name> | <Last Name> | <DOB> | <Email> | <Phone> | <Address 1> | <Address 2> | <City> | <State Province> | <Postal Code> | <Country> |
    And I logout

    Examples: 
      | First Name | Last Name | DOB        | Email                   | Phone      | Address 1         | Address 2 | City        | State Province | Postal Code | Country |
      | An         | Vo        | 1990-10-12 | anvoqa@gmail.com        | 4168232345 | 17 Success street | Unit 1234 | Toronto     | ON             | M4H3C8      | Canada  |
      | Cucumber   | Java      | 2000-02-20 | cucumber.java@gmail.com | 1234567891 | 1601 Alexander Dr | Unit 111  | Los Angeles | CA             |      952134 | US      |

  @view-contact
  Scenario: View Contact Details
    When I view a contact by email "anvoqa@gmail.com"
    Then I see the correct contact details in the View Contact Details page
      | First Name | Last Name | DOB        | Email            | Phone      | Address 1         | Address 2 | City    | State Province | Postal Code | Country |
      | An         | Vo        | 1990-10-12 | anvoqa@gmail.com | 4168232345 | 17 Success street | Unit 1234 | Toronto | ON             | M4H3C8      | Canada  |
    And I logout

  @edit-contact
  Scenario: Edit Contact Email
    When I view a contact by email "anvoqa@gmail.com"
    And click Edit Contact
    And I update the email "anvoqa_new@gmail.com"
    And I click Submit button
    Then I see the correct email "anvoqa_new@gmail.com" in the View Contact Details page
    And I logout

  @delete-contact
  Scenario: Delete Contacts
    When I view a contact by email "cucumber.java@gmail.com"
    And I click Delete Contact button
    And I click OK on the alert
    Then the contact with email "cucumber.java@gmail.com" disappears from the list
    And I logout
    And I delete all contacts using API
