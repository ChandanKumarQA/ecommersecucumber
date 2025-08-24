Feature: Add to cart and checkout

  Scenario: Add product to cart and checkout successfully
    
    And search a product "HP LP3065"
    When the user selects a product
   
    And adds the product to the cart
    And click add to cart
    And clicks on the Shopping Cart button
    And validate Shopping Cart text is visible
    And fetch the total amount
    And clicks on checkout
    Then validate checkout text is visible
    Then click Guest Checkout
    And fill Billing Details 
   
