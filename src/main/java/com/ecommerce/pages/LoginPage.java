package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
    By loginHeader = By.xpath("//h2[contains(text(),'Login to your account')]");
    By emailField = By.xpath("//input[@data-qa='login-email']");
    By passwordField = By.xpath("//input[@data-qa='login-password']");
    By loginButton = By.xpath("//button[@data-qa='login-button']");
    By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    By loginError = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
    By logoutButton = By.xpath("//a[contains(text(),'Logout')]");

    // Methods
    public void clickSignupLogin() {
        driver.findElement(signupLoginButton).click();
    }

    public void enterLoginCredentials(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoggedIn() {
        return driver.findElement(loggedInText).isDisplayed();
    }
    public boolean isLoginHeaderVisible() {
        return driver.findElement(loginHeader).isDisplayed();
    }

    public boolean isLoginErrorVisible() {
        return driver.findElement(loginError).isDisplayed();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

    public boolean isLoginPageVisible() {
        return driver.findElement(loginHeader).isDisplayed();
    }
}
