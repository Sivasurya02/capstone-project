Feature: Categories and Brands

  Background:
    Given User launches the browser and navigate to home panel
    Then User should verify that the home page is visible

  Scenario: Search Products and Verify Cart After Login # TC 20
    When User clicks the "Products" button in home header
    Then User should be navigated to ALL PRODUCT page

    When User enters a product name in the search input and clicks the search button
    Then User should see "SEARCHED PRODUCTS" text shown
    And User should verify that all products related to the search are visible there

    When User adds the searched products to the cart by hover
    And User clicks the "Cart" button by hover
    Then User should verify that searched products are visible inside cart

    When User clicks "Signup / Login" button from cart page
    And User enters login details from config and clicks the "Login" option
    When User clicks the "Cart" button in home page again after login
    Then User should verify that searched products are still visible in the cart

    When User removes all products from the cart by clicking X 
    Then User should see "Cart is empty! Click here to buy products." confirmation shown

    Scenario: View Category Products # TC 18
    Then User should verify that categories are visible on the left sidebar

    # Women's Category Navigation
    When User clicks on "Women" category 
    And User clicks on "Dress" sub-category under Women category
    Then User should verify that category page is displayed with the text "WOMEN - DRESS PRODUCTS"

    # Men's Category Navigation
    When User clicks on "Men" category section
    And User clicks on "T-Shirts" sub-category under Men category section
    Then User should verify that category page is displayed with the message "MEN - T-SHIRTS PRODUCTS"
    
     Scenario: View & Cart Brand Products # TC 19
    When User clicks the "Products" button in the mainpage
    Then User should verify that brands are visible on the left sidebar

    # First Brand Selection
    When User clicks on "Polo" brand
    Then User should verify that user is navigated to "POLO PRODUCTS" brand page

    # Second Brand Selection
    When User clicks on "H&M" brand next
    Then User should verify that user is navigated to the "H&M PRODUCTS" brand page
