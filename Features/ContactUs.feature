Feature: Contact Us Form Functionality

  Background:
    Given the user is on the Contact Us page

  @regression @smoketest
  Scenario: Submit contact form with valid details
    When the user enters name "QA tester"
    And enters email "test@gmail.com"
    And enters subject "Inquiry about product"
    And enters message "Please provide more details about the product."
    And uploads a file
    And clicks the Submit button
    And clicks Ok on Alert message
    Then a success message "Success! Your details have been submitted successfully." should be displayed
    And the user clicks the "Home" button
    Then the user should be navigated to the homepage

  @regression
  Scenario: Submit contact form with missing required fields
    When the user enters name ""
    And enters email ""
    And enters subject ""
    And enters message ""
    And clicks the Submit button
    Then user should not see Success message
