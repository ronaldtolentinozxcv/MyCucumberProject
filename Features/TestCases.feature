Feature: Validate Test Cases Page

  Background: 
    Given the user is on the home page
    When the user clicks "Test Cases" from the top bar

  @smoketest @regression
  Scenario: Navigate to Test Cases page
    Then the Test Cases page should be displayed

  @smoketest @regression
  Scenario: Expand and verify all test cases
    When the user clicks each test case panel
    Then all test cases should expand and display their descriptions

  @smoketest @regression
  Scenario: Verify all test cases are displayed
    Then user should see 26 test cases
