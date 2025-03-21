Feature: Product and Cart Actions

  Background: 
    Given User launches browser and navigates to home page
    Then User verify home page is visible 

  Scenario: Verify All Products and Product Detail Page # TC 8
    When User clicks the "Products" button in home 
    Then User should be navigate to the ALL PRODUCTS page successfully
    And User should see the products list
    When User clicks "View Product" of the first product
    Then User should be navigated to the product detail page
    And User should see product details including name, category, price, availability, condition, and brand

  Scenario: Search Product # TC 9 
    When User clicks the "Products" button in home window
    Then User should be navigate to the ALL PRODUCTS page
    When User enters a product name in the search input and clicks search button
    Then User should see "SEARCHED PRODUCTS" in page
    And User should verify that all products related to the search are visible

  Scenario: Add Products in Cart # TC 12 
    When User clicks the "Products" button in main page
    Then User should be navigate to the ALL PRODUCTS
    When User hovers over the first product and clicks "Add to cart"
    And User clicks "Continue Shopping" button in alert box
    When User hovers over the second product and clicks "Add to cart"
    And User clicks "View Cart" button in alert 
    Then User should verify both products are added to the Cart
    And User should verify their prices, quantity, and total price
    
    Scenario: Verify Product Quantity in Cart # TC 13 
    When User clicks "View Product" for any product on home page
    Then User should see the product detail page
    When User increases the quantity to "4"
    And User clicks "Add to cart" button in product page
    And User clicks "View Cart" button from alert
    Then User should verify that the product is displayed in the cart with exact quantity "4"
    
    Scenario: Remove Product from Cart # TC 17 
    Given User adds a product to the cart
    When User clicks "Cart" button in product detail
    Then User should verify that the cart page is displayed
    When User clicks the "X" button to remove the product
    Then User should verify that the cart is empty
    
    Scenario: Add to Cart from Recommended Items # TC 22 
    When User scrolls down to the recommended items section
    Then User should see "RECOMMENDED ITEMS" section
    When User clicks "Add to Cart" on a recommended product
    And User clicks "View Cart" button in alert shown
    Then User should verify that product is displayed in the cart