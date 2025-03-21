Feature: User Login and Logout

  Background:
    Given User is on the home page
    When User clicks on Signup Login button
    Then 'Login to your account' is visible
    
    @MediumPriority
    Scenario: Login User with correct email and password #TC2
    When User enters valid login credentials from config file
    And User clicks 'Login' button
    Then User sees 'Logged in as username' 
    
  @LowPriority  
  Scenario: Login User with incorrect email and password #TC3
    When User enters invalid login credentials
    And User clicks 'Login' button
    Then 'Your email or password is incorrect!' error is displayed

   @MediumPriority
    Scenario: Logout User #TC4
    Given User is logged in
    When User logs out from the application
    Then User is navigated to the login page
