@users
Feature: Manage Users
  As a user, I want to register a new account and login into the app
  so that I can manage my contact list
  
  @register
    Scenario: Register An Account
    Given open Contact List homepage
    When I click Sign up button
    And I register an account with random data
    Then system redirects to Contact List page
    And I logout
    And I clean up the account

  @login
  Scenario: Login Success
    Given open Contact List homepage
    When I login with email "teste.r@gmail.com" and password "1234567"
    Then system redirects to Contact List page
