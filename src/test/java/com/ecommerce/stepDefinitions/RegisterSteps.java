package com.ecommerce.stepDefinitions;

import com.ecommerce.pages.RegisterPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.ecommerce.utils.ConfigReader;
import com.ecommerce.utils.DriverManager;


public class RegisterSteps {
	WebDriver driver = DriverManager.getDriver();
	RegisterPage registerPage = new RegisterPage(driver);

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        driver.get("http://automationexercise.com");
    }

    @When("User clicks on Signup Login button")
    public void user_clicks_on_signup_login_button() {
        registerPage.clickSignupLogin();
    }
    
    @Then("'New User Signup!' is visible")
    public void new_user_signup_is_visible() {
        Assert.assertTrue(registerPage.isSignupHeaderVisible());
    }

    @When("User enters name and email from config file")
    public void user_enters_name_and_email() {
        registerPage.enterNameAndEmail();
    }

    @When("User clicks 'Signup' button")
    public void user_clicks_signup_button() {
        registerPage.clickSignup();
    }

    @Then("'ENTER ACCOUNT INFORMATION' is visible")
    public void enter_account_information_is_visible() {
        Assert.assertTrue(registerPage.isAccountInfoVisible());
    }

    @When("User fills account details from config file")
    public void user_fills_account_details() throws InterruptedException {
        registerPage.fillAccountDetails(
            ConfigReader.getProperty("user.password"),
            ConfigReader.getProperty("user.dob.day"),
            ConfigReader.getProperty("user.dob.month"),
            ConfigReader.getProperty("user.dob.year")
        );
        Thread.sleep(1000);
    }


    @When("User selects newsletter and special offers checkboxes")
    public void user_selects_newsletter_and_special_offers_checkboxes() {
        registerPage.selectNewsletters();
    }

    @When("User enters personal details from config file")
    public void user_enters_personal_details() throws InterruptedException {
        registerPage.enterPersonalDetails(
            ConfigReader.getProperty("user.firstname"),
            ConfigReader.getProperty("user.lastname"),
            ConfigReader.getProperty("user.company"),
            ConfigReader.getProperty("user.address1"),
            ConfigReader.getProperty("user.address2"),
            ConfigReader.getProperty("user.country"),
            ConfigReader.getProperty("user.state"),
            ConfigReader.getProperty("user.city"),
            ConfigReader.getProperty("user.zipcode"),
            ConfigReader.getProperty("user.mobile")
        );
        Thread.sleep(2000);
    }


    @When("User clicks 'Create Account' button")
    public void user_clicks_create_account_button() {
        registerPage.clickCreateAccount();
    }

    @Then("'ACCOUNT CREATED!' is visible")
    public void account_created_is_visible() {
        Assert.assertTrue(registerPage.isAccountCreatedVisible());
    }

    @When("User clicks 'Continue' button")
    public void user_clicks_continue_button() {
        registerPage.clickContinue();
    }

    @Then("'Logged in as username' is visible")
    public void logged_in_as_username_is_visible() {
        Assert.assertTrue(registerPage.isLoggedIn());
    }

    /*@When("User clicks 'Delete Account' button")
    public void user_clicks_delete_account_button() {
        registerPage.clickDeleteAccount();
    }

    @Then("'ACCOUNT DELETED!' is visible")
    public void account_deleted_is_visible() {
        Assert.assertTrue(registerPage.isAccountDeletedVisible());
        //driver.quit(); Instead use Hooks
    }*/
    @When("User clicks 'Logout' button")
    public void user_clicks_logout_button() {
        registerPage.clickLogout();
    }

    /*@Then("User is navigated to the login page")
    public void user_is_navigated_to_login_page() {
        Assert.assertTrue(registerPage.isLoginPageVisible());
    }*/
    
    //TC2
    @When("User enters an already registered email from config file")
    public void user_enters_existing_email() {
        registerPage.enterExistingEmail(
            ConfigReader.getProperty("user.name"),
            ConfigReader.getProperty("user.existingEmail")  // Uses manually registered email
        );
    }

    @Then("Email Address already exists! error is displayed")
    public void email_already_exists_error_is_displayed() {
        Assert.assertTrue(registerPage.isEmailAlreadyExistsErrorVisible());
    }
}
