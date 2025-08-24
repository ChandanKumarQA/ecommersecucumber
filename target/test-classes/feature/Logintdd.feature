Feature: Login functionality with Excel data

  Scenario Outline: Login with different sets of credentials from Excel
    Given the user is on the nopCommerce login page
    When the user enters credentials from excel row "<rowNumber>"
    Then the user should be redirected to the MyAccount Page by passing email and password with excel row "<rowNumber>"

    Examples:
  | rowNumber |
  | 1         |
  | 2         |
  | 3         |
  | 4         |
  | 5         |