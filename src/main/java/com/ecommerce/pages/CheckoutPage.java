package com.ecommerce.pages;


import com.ecommerce.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class CheckoutPage {
	WebDriver driver;
	WebDriverWait wait;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Locators
	private By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
	private By emailField = By.xpath("//input[@data-qa='login-email']");
	private By passwordField = By.xpath("//input[@data-qa='login-password']");
	private By loginButton = By.xpath("//button[@data-qa='login-button']");
	private By cartButton = By.xpath("//a[contains(text(),'Cart')]");
	private By proceedToCheckoutButton = By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a");
	private By registerLoginButton = By.xpath("//u[contains(text(),'Register / Login')]");
	private By accountCreatedMessage = By.xpath("//b[contains(text(),'Account Created!')]");
	private By continueButtonSignup = By.xpath("//a[@data-qa='continue-button']");
	private By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
	private By checkoutCartButton = By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a");
	private By addressDetailsSection = By.xpath("//h2[contains(text(),'Address Details')]");
	private By commentTextArea = By.xpath("//textarea[@name='message']");
	private By placeOrderButton = By.xpath("//a[contains(text(),'Place Order')]");
	private By nameOnCardField = By.xpath("//input[@name='name_on_card']");
	private By cardNumberField = By.xpath("//input[@name='card_number']");
	private By cvcField = By.xpath("//input[@name='cvc']");
	private By expiryMonthField = By.xpath("//input[@name='expiry_month']");
	private By expiryYearField = By.xpath("//input[@name='expiry_year']");
	private By payAndConfirmButton = By.xpath("//button[@id='submit']");
	private By orderConfirmationMessage = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
	private By deleteAccountButton = By.xpath("//a[contains(text(),'Delete Account')]");
	private By accountDeletedMessage = By.xpath("//b[contains(text(),'Account Deleted!')]");
	private By continueAfterDeleteButton = By.xpath("//a[contains(text(),'Continue')]");
	private By signupNameField = By.xpath("//input[@data-qa='signup-name']");
	private By signupEmailField = By.xpath("//input[@data-qa='signup-email']");
	private By signupButton = By.xpath("//button[@data-qa='signup-button']");
	private By addToCartButton = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
	private By homePageBanner = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img"); // Home page banner for verification
	private By firstProductViewButton = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a");  // Scroll to first product
	private By viewCartButton = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"); // View Cart in alert

	//Locators for Entering Account Details
	private By titleMrRadioButton = By.id("id_gender1");
	private By passwordSignupField = By.id("password");
	private By dobDay = By.id("days");
	private By dobMonth = By.id("months");
	private By dobYear = By.id("years");
	private By firstNameField = By.id("first_name");
	private By lastNameField = By.id("last_name");
	private By companyField = By.id("company");
	private By address1Field = By.id("address1");
	private By address2Field = By.id("address2");
	private By countryDropdown = By.id("country");
	private By stateField = By.id("state");
	private By cityField = By.id("city");
	private By zipcodeField = By.id("zipcode");
	private By mobileNumberField = By.id("mobile_number");
	private By createAccountButton = By.xpath("//button[@data-qa='create-account']");
	//Locator for Download Invoice Button
	private By downloadInvoiceButton = By.xpath("//a[contains(text(),'Download Invoice')]");

	// Verify Home Page is Displayed
	public boolean isHomePageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(homePageBanner)).isDisplayed();
	}

	// Click Signup/Login Button
	public void clickSignupLoginButton() {
		driver.findElement(signupLoginButton).click();
	}

	// Enter Login Credentials
	public void enterLoginCredentials(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
	/*public void loginButton() {
		driver.findElement(loginButton).click();

	}*/

	// Click Cart Button
	public void clickCartButton() {
		driver.findElement(cartButton).click();
	}

	// Verify Cart Page is Displayed
	public boolean isCartPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(cartButton)).isDisplayed();
	}

	// Click Proceed To Checkout Button
	public void clickProceedToCheckout() {
		driver.findElement(proceedToCheckoutButton).click();
	}

	// Click Register/Login Button in Cart Alert
	public void clickRegisterLoginButton() {
		driver.findElement(registerLoginButton).click();
	}

	public void enterSignupDetails() {
		String name = ConfigReader.getProperty("user.name");  // Fetching from config
		String email = ConfigReader.getProperty("user.email");  // Fetching from config

		driver.findElement(signupNameField).sendKeys(name);
		driver.findElement(signupEmailField).sendKeys(email);
		driver.findElement(signupButton).click();  // Click "Signup"
	}

	//  Fill Account Information (Password & DOB)
	public void fillAccountDetails() {
		driver.findElement(titleMrRadioButton).click(); // Select "Mr" title
		driver.findElement(passwordSignupField).sendKeys(ConfigReader.getProperty("user.password"));
		new Select(driver.findElement(dobDay)).selectByVisibleText(ConfigReader.getProperty("user.dob.day"));
		new Select(driver.findElement(dobMonth)).selectByVisibleText(ConfigReader.getProperty("user.dob.month"));
		new Select(driver.findElement(dobYear)).selectByVisibleText(ConfigReader.getProperty("user.dob.year"));
	}

	//  Enter Personal Details
	public void enterPersonalDetails() {
		driver.findElement(firstNameField).sendKeys(ConfigReader.getProperty("user.firstname"));
		driver.findElement(lastNameField).sendKeys(ConfigReader.getProperty("user.lastname"));
		driver.findElement(companyField).sendKeys(ConfigReader.getProperty("user.company"));
		driver.findElement(address1Field).sendKeys(ConfigReader.getProperty("user.address1"));
		driver.findElement(address2Field).sendKeys(ConfigReader.getProperty("user.address2"));
		new Select(driver.findElement(countryDropdown)).selectByVisibleText(ConfigReader.getProperty("user.country"));
		driver.findElement(stateField).sendKeys(ConfigReader.getProperty("user.state"));
		driver.findElement(cityField).sendKeys(ConfigReader.getProperty("user.city"));
		driver.findElement(zipcodeField).sendKeys(ConfigReader.getProperty("user.zipcode"));
		driver.findElement(mobileNumberField).sendKeys(ConfigReader.getProperty("user.mobile"));
	}

	// Click "Create Account" Button
	public void clickCreateAccountButton() {
		driver.findElement(createAccountButton).click();
	}


	// Verify Account Created Message
	public boolean isAccountCreatedMessageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedMessage)).isDisplayed();
	}

	// Click Continue Button after Signup
	public void clickContinueButtonAfterSignup() {
		driver.findElement(continueButtonSignup).click();
	}

	// Verify User is Logged In
	public boolean isUserLoggedIn() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInText)).isDisplayed();
	}

	// Click Cart Button Again
	public void clickCartButtonAgain() {
		driver.findElement(cartButton).click();
	}

	//  Click 'View Cart' in Alert
	public void clickViewCartInAlert() {
		wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
	}

	// Click Proceed to Checkout Button in Cart Page
	public void clickProceedToCheckoutInCartPage() {
		driver.findElement(checkoutCartButton).click();
	}

	// Verify Address Details Section
	public boolean isAddressDetailsDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(addressDetailsSection)).isDisplayed();
	}

	// Enter Comment in Text Area
	public void enterComment(String comment) {
		driver.findElement(commentTextArea).sendKeys(comment);
	}

	// Click Place Order Button
	public void clickPlaceOrderButton() {
		driver.findElement(placeOrderButton).click();
	}

	// Enter Payment Details
	public void enterPaymentDetails(String nameOnCard, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
		driver.findElement(nameOnCardField).sendKeys(nameOnCard);
		driver.findElement(cardNumberField).sendKeys(cardNumber);
		driver.findElement(cvcField).sendKeys(cvc);
		driver.findElement(expiryMonthField).sendKeys(expiryMonth);
		driver.findElement(expiryYearField).sendKeys(expiryYear);
	}

	// Click Pay and Confirm Order Button
	public void clickPayAndConfirmOrder() {
		driver.findElement(payAndConfirmButton).click();
	}

	// Verify Order Confirmation Message
	public boolean isOrderConfirmed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationMessage)).isDisplayed();
	}

	// Click Delete Account Button
	public void clickDeleteAccountButton() {
		driver.findElement(deleteAccountButton).click();
	}

	// Verify Account Deleted Message
	public boolean isAccountDeleted() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedMessage)).isDisplayed();
	}

	// Click Continue Button After Account Deletion
	public void clickContinueAfterDelete() {
		driver.findElement(continueAfterDeleteButton).click();
	}

	//  Scroll to First Product and Click View Product
	public void scrollToFirstProductAndClickView() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
				driver.findElement(firstProductViewButton));
		driver.findElement(firstProductViewButton).click();
	}

	//Click Add to Cart After Viewing Product**
	public void clickAddToCartButton() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	}

	//Verify Delivery and Billing Address Match (For TC 23)
	public boolean isAddressMatching() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		//  Wait for both address sections to be visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='address_delivery']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='address_invoice']")));

		// Extract each field from Delivery Address
		String deliveryName = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[2]")).getText().trim();
		String deliveryCompany = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[3]")).getText().trim();
		String deliveryAddress1 = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[4]")).getText().trim();
		String deliveryAddress2 = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[5]")).getText().trim();
		String deliveryCityStateZip = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[6]")).getText().trim();
		String deliveryCountry = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[7]")).getText().trim();
		String deliveryPhone = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[8]")).getText().trim();

		//  Extract each field from Billing Address
		String billingName = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]/li[2]")).getText().trim();
		String billingCompany = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]/li[3]")).getText().trim();
		String billingAddress1 = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]/li[4]")).getText().trim();
		String billingAddress2 = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]/li[5]")).getText().trim();
		String billingCityStateZip = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]/li[6]")).getText().trim();
		String billingCountry = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]/li[7]")).getText().trim();
		String billingPhone = driver.findElement(By.xpath("//*[@id=\"address_invoice\"]/li[8]")).getText().trim();

		// Compare each field
		return deliveryName.equalsIgnoreCase(billingName) &&
				deliveryCompany.equalsIgnoreCase(billingCompany) &&
				deliveryAddress1.equalsIgnoreCase(billingAddress1) &&
				deliveryAddress2.equalsIgnoreCase(billingAddress2) &&
				deliveryCityStateZip.equalsIgnoreCase(billingCityStateZip) &&
				deliveryCountry.equalsIgnoreCase(billingCountry) &&
				deliveryPhone.equalsIgnoreCase(billingPhone);
	}

	// Click the "Download Invoice" Button
	public void clickDownloadInvoiceButton() {
		wait.until(ExpectedConditions.elementToBeClickable(downloadInvoiceButton)).click();
	}

	// Verify Invoice is Downloaded Successfully (Assuming default download folder)
	public boolean isInvoiceDownloaded() {
		String downloadPath = System.getProperty("user.home") + "/Downloads/"; // Adjust path if needed
		File folder = new File(downloadPath);
		File[] files = folder.listFiles();

		if (files != null) {
			for (File file : files) {
				if (file.getName().startsWith("invoice") && file.getName().endsWith(".txt")) {
					return true; // Invoice found
				}
			}
		}
		return false; // Invoice not found
		/*public boolean isAddressMatching() {
        String deliveryAddress = driver.findElement(By.xpath("//ul[@id='address_delivery']")).getText();
        String billingAddress = driver.findElement(By.xpath("//ul[@id='address_invoice']")).getText();
        return deliveryAddress.equals(billingAddress);
    }*/
	}
}
