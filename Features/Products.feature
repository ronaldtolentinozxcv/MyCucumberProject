Feature: Products page functionality

  Background: 
    #Given the user is logged in
    And user navigates to "Products" page

  @smoketest @regression
  Scenario: Verify all images are displayed
    When user is on Products page
    Then user should see 34 product images displayed

  @smoketest @regression
  Scenario: Verify Search Product Functionality
    When user enters "Tshirt" in search field
    And clicks search button
    Then products related to Tshirt should be displayed

  @smoketest @regression
  Scenario Outline: Verify subcategory filter displays correct products
    When user selects subcategory "<MainCategory>" and "<SubCategory>"
    Then only products under "<SubCategory>" subcategory should be displayed

    Examples: 
      | MainCategory | SubCategory   |
      | Women        | Tops          |
      | Women        | Dress         |
      | Men          | Tshirts       |
      | Kids         | Tops & Shirts |

  @smoketest @regression
  Scenario Outline: Verify Brands displays correct page
    When user clicks "<Brands>"
    Then only products under "<Brands>" should be displayed
    Then user should see products displayed

    Examples: 
      | Brands             |
      | Polo               |
      | H&M                |
      | Madame             |
      | Mast & Harbour     |
      | Babyhug            |
      | Allen Solly Junior |
      | Kookie Kids        |
      | Biba               |

  @smoketest @regression
  Scenario: View details of the first product
    When the user clicks on "View Product" of the first product
    Then the user should be landed on the product detail page
    And the product name, category, rating, price, availability, condition, and brand should be visible
