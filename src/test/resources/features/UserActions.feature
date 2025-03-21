Feature: User Actions

  Scenario: Submit Contact Us Form #tc 6
    Given User opens the home page for Contact Us 
    When User clicks "Contact Us"
    Then User should see "GET IN TOUCH"
    When User enters contact details from config
    And User enters subject and message from config
    And User uploads file from config
    And User clicks "Submit" and accepts alert
    Then User should see "Success! Your details have been submitted successfully."
    When User clicks "Home"
    Then User should be redirected to the home page
    
    Scenario: Verify Test Cases Page #tc7
    Given User on the home page   
    When User clicks "Test Cases"    
    Then User should be navigated to the Test Cases page successfully 
    
    Scenario: Verify Subscription in Home Page #tc10
  Given User launches the browser and navigates to the home page 
  Then User should verify that the home page is displayed successfully
  When User scrolls down to the footer
  Then User should see "SUBSCRIPTION" text
  When User enters an email in the subscription input and clicks the subscribe button
  Then User should verify that the success message is visible
  
    Scenario: Verify Subscription in Cart Page # TC 11
    Given User launches the browser and goes to home page
    Then User should verify home page displayed
    When User clicks Cart
    When User scrolls down to the email
    Then User should see SUBSCRIPTION msg
    When User enters email and clicks arrow button
    Then User should see You have been successfully subscribed!
    
     Scenario: Add Review on Product # TC 21
    Given User launche browser and goes to the home page
    When User clicks Products
    Then User should be navigated to the ALL PRODUCTS page successfully
    When User clicks View Product
    Then User should see Write Your Review
    When User enters name, email, and review from config
    And User clicks Submit button
    Then User should see Thank you for your review.
    
     Scenario: Verify Scroll Up using Arrow button and Scroll Down functionality # TC 25
    Given User launche browser and navigate to the home page
    Then User should verify that home page is displayed
    When User scrolls down to footer
    Then User should see SUBSCRIPTION text
    When User clicks Scroll Up button
    Then User should see Full-Fledged practice website for Automation Engineers
    
      Scenario: Verify Scroll Up using Arrow button and Scroll Down functionality # TC 26
    Given User open browser to the home page
    Then User should verify home page is displayed
    When User scrolls down to bottom
    Then User should see the SUBSCRIPTION text
    When User scrolls up to the top of the page automatically
    Then User should see Full-Fledged practice website for Automation Engineers text
    
  