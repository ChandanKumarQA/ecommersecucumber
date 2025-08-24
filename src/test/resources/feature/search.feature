Feature: User Search a product

  Scenario: Successful search product
    Given the user is on the nopCommerce  page
    When the user enters valid product name in the serch box   "Iphone"
    And the user clicks on the serch button
    Then the user get same product 
    And the user click add to cart 
    And verify message to cart added
