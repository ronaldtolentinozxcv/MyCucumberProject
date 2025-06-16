Feature: User registration
  
  As a user
  I want to register an account
  So that I can place orders on the website

  Background: 
    Given the user is on the registration page

  @smoketest @regression
  Scenario: Successful user registration
    When user Enter name and email address
    And click "Signup" button
    Then user should redirected to signup page
    When user enter details for Title, Name, Email, Password, Date of birth
    And user select checkbox Sign up for our newsletter!
    And user select checkbox Receive special offers from our partners!
    And user fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And user click on "Create Account" button
    Then user should see  "ACCOUNT CREATED!" message
    When user click "Continue" button
    Then user should see  "Logged in as" user

  @smoketest @regression
  Scenario: Register user with existing email
    When User Enter name and already registered email address "testrtqa@gmail.com"
    And click "Signup" button
    Then User should still be on login page
