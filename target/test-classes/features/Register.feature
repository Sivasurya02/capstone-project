Feature: User Registration

  Background:
    Given User is on the home page
    When User clicks on Signup Login button
    Then 'New User Signup!' is visible
  
   @HighPriority
   Scenario: Register a new user # TC 1
    When User enters name and email from config file
    And User clicks 'Signup' button
    Then 'ENTER ACCOUNT INFORMATION' is visible
    When User fills account details from config file
    And User selects newsletter and special offers checkboxes
    And User enters personal details from config file
    And User clicks 'Create Account' button
    Then 'ACCOUNT CREATED!' is visible
    When User clicks 'Continue' button
    Then 'Logged in as username' is visible
    When User clicks 'Logout' button  
    Then User is navigated to the login page
  
     @MediumPriority
    Scenario: Register User with an existing email # TC 5
    When User enters an already registered email from config file
    And User clicks 'Signup' button
    Then Email Address already exists! error is displayed
