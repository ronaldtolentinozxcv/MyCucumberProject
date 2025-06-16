Feature: Login Functionality

  @smoketest @regression
  Scenario Outline: Verify login
    Given user is on login page
    When user enters "<username>" and "<password>"
    And user clicks "Login" button
    Then user is redirected accordingly "<status>"

    Examples: 
      | username           | password     | status  |
      | testrtqa@gmail.com | testrttestrt | valid   |
      | testrtqa@gmail.com |              | invalid |
      |                    | testrttestrt | invalid |
      |                    |              | invalid |
