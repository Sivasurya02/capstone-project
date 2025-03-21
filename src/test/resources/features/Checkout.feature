Feature: Order and Checkout

  Background:
    Given User launches browser and navigates to the page
    Then User should verify that home page displayed successfully
    
     Scenario: Place Order - Login Before Checkout # TC 16
    When User clicks "Signup / Login" button to log in
    And User enters email and password from config file and clicks "Login"
    Then User should see Logged in as username verification appears

    Given User adds products to cart
    When User clicks the "Cart" button in cart detail page  
    Then User should verify that cart page appears   
    When User clicks "Proceed To Checkout" for checkout  
    Then User should verify Address Detail and Review Order  
    When User enters some description in comment text area and clicks "Place Order" 
    And User enters the payment details and clicks "Pay and Confirm Order"  
    Then User should see "Congratulations! Your order has been confirmed!" confirmation text

  Scenario: Place Order - Register While Checkout # TC 14
    When User logs in using existing credentials from config
    Then If account exists, User deletes the account and clicks "Continue"

    Given User adds products to the cart
    When User clicks the "Cart" button in detail page
    Then User should verify cart page displayed
    When User clicks "Proceed To Checkout" in cart
    And User clicks "Register / Login" button in cart alert
    And User fills all details in Signup and creates an account
    Then User should see ACCOUNT CREATED! message 
    When User clicks "Continue" button in signup
    Then User should see Logged in as username
    When User clicks "Cart" button again in home  
    And User clicks "Proceed To Checkout" button in cart page
    Then User should verify Address Details and Review Order
    When User enters a description in comment text area and clicks "Place Order"
    And User enters payment details and clicks "Pay and Confirm Order"
    Then User should see "Congratulations! Your order has been confirmed!" after order
    When User clicks "Delete Account" button for deletion
    Then User should see "ACCOUNT DELETED!" message and clicks "Continue"
    
    Scenario: Place Order - Register Before Checkout # TC 15
    When User clicks "Signup / Login" button before checkout
    And User fills all details in Signup and creates account
    Then User should see the ACCOUNT CREATED! message 
    When User clicks "Continue" button in that page
    Then User should see Logged in as username text

    Given User scrolls to the first product and clicks "View Product"
    When User clicks "Add to Cart" button in page
    And User clicks "View Cart" button in alert to add

    Then User should verify cart page is pop up
    When User clicks "Proceed To Checkout" in cartt
    Then User should verify Address Details and Review the Order
    When User enters a description in comment text area and clicks "Place Order" button
    And User enters payment details and click "Pay and Confirm Order"
    Then User should see "Congratulations! Your order has been confirmed!" after click
    When User clicks "Delete Account" button for deleting account
    Then User should see "ACCOUNT DELETED!" message and clicks "Continue" option
    
     Scenario: Verify Address Details in Checkout Page # TC 23 
    When User clicks "Signup / Login" button to register
    And User fills all details in Signup to creates an account
    Then User should see the ACCOUNT CREATED! message displayed 
    When User clicks "Continue" button after account creation
    Then User should see Logged in as username content

    Given User scrolls to the first product and click "View Product"
    When User clicks "Add to Cart" button in product detail page
    And User clicks "View Cart" button in alert popup

    Then User should verify cart page appears
    When User clicks "Proceed To Checkout" button in cart detail page
    Then User should verify that the Delivery and Billing addresses match the registered address
    When User clicks "Delete Account" button for account removal
    Then User should see "ACCOUNT DELETED!" message and clicks "Continue" to exit
    
    Scenario: Download Invoice after Purchase Order # TC 24  
    Given User adds products to the cart from home
    When User click the "Cart" button in detail page  
    Then User should verify cart page is shown   
    When User click "Proceed To Checkout" in cart  
    And User click "Register / Login" button in cart alert  
    And User fill all details in Signup and creates an account  
    Then User should see ACCOUNT CREATED! message after  
    When User click "Continue" button in signup  
    Then User should see Logged in as username verification 
    When User click "Cart" button again in home  
    And User click "Proceed To Checkout" button in cart page  
    Then User should verify the Address Details and Review the Order  
    When User enter a description in comment text area and clicks "Place Order" 
    And User enter payment details and clicks "Pay and Confirm Order"  
    Then User should see "Congratulations! Your order has been confirmed!" confirmation  
    When User click "Download Invoice" button  
    Then User should verify that the invoice is downloaded successfully text  
    When User click "Continue" button after invoice download  
    When User click "Delete Account" button for deletion  
    Then User should see "ACCOUNT DELETED!" message and clicks "Continue" in end 

