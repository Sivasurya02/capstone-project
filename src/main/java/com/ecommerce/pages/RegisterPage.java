package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.ecommerce.utils.ConfigReader;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
	By signupHeader = By.xpath("//h2[contains(text(),'New User Signup!')]");
	By nameField = By.name("name");
	By emailField = By.xpath("//input[@data-qa='signup-email']");
	By signupButton = By.xpath("//button[@data-qa='signup-button']");
	By accountInfoHeader = By.xpath("//b[contains(text(),'Enter Account Information')]");
	By passwordField = By.id("password");
	By dobDay = By.id("days");
	By dobMonth = By.id("months");
	By dobYear = By.id("years");
	By newsletterCheckbox = By.id("newsletter");
	By specialOffersCheckbox = By.id("optin");
	By firstNameField = By.id("first_name");
	By lastNameField = By.id("last_name");
	By companyField = By.id("company");
	By address1Field = By.id("address1");
	By address2Field = By.id("address2");
	By countryDropdown = By.id("country");
	By stateField = By.id("state");
	By cityField = By.id("city");
	By zipcodeField = By.id("zipcode");
	By mobileNumberField = By.id("mobile_number");
	By createAccountButton = By.xpath("//button[@data-qa='create-account']");
	By accountCreatedHeader = By.xpath("//b[contains(text(),'Account Created!')]");
	By continueButton = By.xpath("//a[@data-qa='continue-button']");
	By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
	By deleteAccountButton = By.xpath("//a[contains(text(),'Delete Account')]");
	By accountDeletedHeader = By.xpath("//b[contains(text(),'Account Deleted!')]");
	By emailExistsError = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");
	By logoutButton = By.xpath("//a[contains(text(),'Logout')]");
	By loginPageHeader = By.xpath("//h2[contains(text(),'Login to your account')]");


	// Methods
	public void clickSignupLogin() {
		driver.findElement(signupLoginButton).click();
	}

	public boolean isSignupHeaderVisible() {
		return driver.findElement(signupHeader).isDisplayed();
	}

	public void enterNameAndEmail() {
		driver.findElement(nameField).sendKeys(ConfigReader.getProperty("user.name"));
		driver.findElement(emailField).sendKeys(ConfigReader.getProperty("user.email"));
	}

	public void clickSignup() {
		driver.findElement(signupButton).click();
	}

	public boolean isAccountInfoVisible() {
		return driver.findElement(accountInfoHeader).isDisplayed();
	}

	public void fillAccountDetails(String password, String day, String month, String year) {
	    driver.findElement(By.id("id_gender1")).click();  
	    
	    driver.findElement(passwordField).sendKeys(password);
	    new Select(driver.findElement(dobDay)).selectByVisibleText(day);
	    new Select(driver.findElement(dobMonth)).selectByVisibleText(month);
	    new Select(driver.findElement(dobYear)).selectByVisibleText(year);
	}


	public void selectNewsletters() {
		driver.findElement(newsletterCheckbox).click();
		driver.findElement(specialOffersCheckbox).click();
	}

	public void enterPersonalDetails(String firstName, String lastName, String company, String address1,
			String address2, String country, String state, String city,
			String zipcode, String mobileNumber) {
		driver.findElement(firstNameField).sendKeys(firstName);
		driver.findElement(lastNameField).sendKeys(lastName);
		driver.findElement(companyField).sendKeys(company);
		driver.findElement(address1Field).sendKeys(address1);
		driver.findElement(address2Field).sendKeys(address2);
		new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
		driver.findElement(stateField).sendKeys(state);
		driver.findElement(cityField).sendKeys(city);
		driver.findElement(zipcodeField).sendKeys(zipcode);
		driver.findElement(mobileNumberField).sendKeys(mobileNumber);
	}
	public void clickCreateAccount() {
		driver.findElement(createAccountButton).click();
	}

	public boolean isAccountCreatedVisible() {
		return driver.findElement(accountCreatedHeader).isDisplayed();
	}

	public void clickContinue() {
		driver.findElement(continueButton).click();
	}

	public boolean isLoggedIn() {
		return driver.findElement(loggedInText).isDisplayed();
	}

	/*public void clickDeleteAccount() {
		driver.findElement(deleteAccountButton).click();
	}

	public boolean isAccountDeletedVisible() {
		return driver.findElement(accountDeletedHeader).isDisplayed();
	}*/
	public void clickLogout() {
	    driver.findElement(logoutButton).click();
	}

	public boolean isLoginPageVisible() {
	    return driver.findElement(loginPageHeader).isDisplayed();
	}
	
	//TC2
	public void enterExistingEmail(String name, String existingEmail) {
	    driver.findElement(nameField).sendKeys(name);
	    driver.findElement(emailField).sendKeys(existingEmail);
	}

	
	public boolean isEmailAlreadyExistsErrorVisible() {
	    return driver.findElement(emailExistsError).isDisplayed();
	}
}
