Feature: Image Validation
	
	@smoketest @regression
  Scenario Outline: Verify images are not broken on all main pages
    Given the user is logged in
    And user navigates to "<Page>" page
    Then all images should not be broken

    Examples: 
      | Page            |
      | Home            |
      | Products        |
      | Contact us      |
      | Cart            |
      | Test Cases      |
      | API Testing     |
      
