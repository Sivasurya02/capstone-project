package com.ecommerce.stepDefinitions;

import com.ecommerce.pages.LoginPage;
import com.ecommerce.utils.ConfigReader;
import com.ecommerce.utils.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @When("User enters valid login credentials from config file")
    public void user_enters_valid_login_credentials() {
        loginPage.enterLoginCredentials(
            ConfigReader.getProperty("user.email"),   // Uses the registered email
            ConfigReader.getProperty("user.password") // Uses the registered password
        );
    }
    
    @Then("'Login to your account' is visible")
    public void login_to_your_account_is_visible() {
        Assert.assertTrue(loginPage.isLoginHeaderVisible());
    }

    @When("User enters invalid login credentials")
    public void user_enters_invalid_login_credentials() {
        loginPage.enterLoginCredentials("invalid@example.com", "WrongPass123");
    }

    @When("User clicks 'Login' button")
    public void user_clicks_login_button() {
        loginPage.clickLogin();
    }

    @Then("User sees 'Logged in as username'")
    public void user_sees_logged_in_as_username() {
        Assert.assertTrue(loginPage.isLoggedIn());
    }

    @Then("'Your email or password is incorrect!' error is displayed")
    public void incorrect_login_error_is_displayed() {
        Assert.assertTrue(loginPage.isLoginErrorVisible());
    }

    @Given("User is logged in")
    public void user_is_logged_in() {
        driver.get(ConfigReader.getProperty("base.url"));
        loginPage.clickSignupLogin();
        loginPage.enterLoginCredentials(
            ConfigReader.getProperty("user.email"),
            ConfigReader.getProperty("user.password")
        );
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.isLoggedIn());
    }

    @When("User logs out from the application")
    public void user_logs_out_from_application() {
        loginPage.clickLogout();
    }

    @Then("User is navigated to the login page")
    public void user_is_navigated_to_login_page() {
        Assert.assertTrue(loginPage.isLoginPageVisible());
    }
}
