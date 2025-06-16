Feature: Purchase Product

  Background: 
    Given the user is logged in
    And user navigates to "Products" page

  @smoketest @regression
  Scenario: Successful purchase of a product
    When user clicks "Add to cart" on any product
    Then user should see "Added!" message box
    And user clicks "Continue Shopping" button
    And user navigates to "Cart" page
    Then user should see products added in cart
    When user clicks "Proceed To Checkout" link button
    Then user should be redirected to "checkout" page
    When user clicks "Place Order" link button
    Then user should be redirected to "payment" page
    When user enters details for Name on Card, Card Number, CVC, Expiration Month, Expiration Year
    And user clicks "Pay and Confirm Order" submit button
    Then user should see "Order Placed!" message
