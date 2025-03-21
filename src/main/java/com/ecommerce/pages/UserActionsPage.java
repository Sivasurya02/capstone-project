package com.ecommerce.pages;

import com.ecommerce.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UserActionsPage {
	WebDriver driver;
	WebDriverWait wait;

	public UserActionsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Locators
	private By contactUsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
	private By getInTouchHeader = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2");
	private By homePageBanner = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img"); 
	private By nameField = By.name("name");
	private By emailField = By.name("email");
	private By subjectField = By.name("subject");
	private By messageField = By.id("message");
	private By fileUploadField = By.name("upload_file");
	private By submitButton = By.name("submit");
	private By successMessage = By.xpath("//div[@class='status alert alert-success']");
	private By homeButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"); //  Added Home button locator
	private By testCasesMenu = By.xpath("//a[contains(text(),'Test Cases')]");  //  TC 7
	private By testCasesHeader = By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b");  //   TC 7
	private By subscriptionSection = By.id("susbscribe_email");  // TC 10
	private By subscriptionEmailField = By.id("susbscribe_email");  //TC 10
	private By subscriptionButton = By.id("subscribe");  // 10
	private By subscriptionSuccessMessage = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");
    private By cartButton = By.xpath("//a[contains(text(),'Cart')]"); // TC 11
    private By productsButton = By.xpath("//a[contains(text(),'Products')]"); // TC 21
    private By allProductsHeader = By.xpath("//h2[contains(text(),'All Products')]"); // TC 21
    private By viewProductButton = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[2]/ul/li/a"); // TC 21
    private By writeYourReviewSection = By.xpath("/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a"); // TC 21
    private By reviewNameField = By.id("name"); // TC 21
    private By reviewEmailField = By.id("email"); // TC 21
    private By reviewTextField = By.id("review"); // TC 21
    private By submitReviewButton = By.id("button-review"); // TC 21
    private By reviewSuccessMessage = By.xpath("//span[contains(text(),'Thank you for your review.')]"); // TC 21
    private By scrollUpButton = By.id("scrollUp"); // Scroll Up button
    private By homepageHeaderText = By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]");
	
    // Click Button ( using if-else approach)
	public void clickButton(String button) {
		if (button.equalsIgnoreCase("Contact Us")) {
			driver.findElement(contactUsButton).click();
		} else if (button.equalsIgnoreCase("Home")) {
			driver.findElement(homeButton).click(); // Clicks Home button
		} else if (button.equalsIgnoreCase("Submit")) {
			driver.findElement(submitButton).click();
		} else if (button.equalsIgnoreCase("Test cases")) { // tc 7
			driver.findElement(testCasesMenu).click();
		}else if (button.equalsIgnoreCase("Subscribe")) { // TC 10
			driver.findElement(subscriptionButton).click();
		}else if (button.equalsIgnoreCase("Cart")) { // TC 1
			driver.findElement(cartButton).click();
		}else if (button.equalsIgnoreCase("Products")) { // TC 1
			driver.findElement(productsButton).click();
		}else {
			throw new IllegalArgumentException("Button not found: " + button);
		}
	}

	// Check if Text is Visible (Now using if-else approach)
	public boolean isTextVisible(String text) {
		if (text.equalsIgnoreCase("GET IN TOUCH")) {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(getInTouchHeader)).isDisplayed();
		} else if (text.equalsIgnoreCase("Success! Your details have been submitted successfully.")) {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
		} else if(text.equalsIgnoreCase("Test Cases")) { // TC 7
			return wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesHeader)).isDisplayed();
		}else if (text.equalsIgnoreCase("SUBSCRIPTION")) {  // TC 10
			return wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionSection)).isDisplayed();
		}else {
			throw new IllegalArgumentException("Text not found: " + text);
		}
	}


	// Dedicated Method for Success Message
	public boolean isSuccessMessageVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
	}

	// Enter Contact Details
	public void enterContactDetails(String name, String email) {
		driver.findElement(nameField).sendKeys(name);
		driver.findElement(emailField).sendKeys(email);
	}

	// Enter Subject and Message
	public void enterSubjectAndMessage(String subject, String message) {
		driver.findElement(subjectField).sendKeys(subject);
		driver.findElement(messageField).sendKeys(message);
	}

	// Upload File (Uses full path from config.properties)
	public void uploadFile() {
		String filePath = System.getProperty("user.dir") + "/" + ConfigReader.getProperty("file.upload.path");
		driver.findElement(fileUploadField).sendKeys(filePath);
	}

	// Click Submit and Accept Alert
	public void clickSubmitAndAcceptAlert(String button) {
		if (button.equalsIgnoreCase("Submit")) {
			driver.findElement(submitButton).click();
			driver.switchTo().alert().accept();
		}
	}

	// Verify if Home Page is Visible
	public boolean isHomePageVisible() {
		return driver.findElement(homeButton).isDisplayed();
	}

	//  TC 7: Click Test Cases Menu
	public void clickTestCasesMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(testCasesMenu)).click();
		//driver.findElement(testCasesMenu).click();
	}

	//  TC 7: Verify Test Cases Page is Visible
	public boolean isTestCasesPageVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesHeader)).isDisplayed();
	}
	
	  // Verify if Home Page is Visible Added before scrolling
    public boolean HomePageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homePageBanner)).isDisplayed();
    }


	// TC 10
	public void scrollToSubscriptionSection() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", 
				driver.findElement(subscriptionSection));
	}

	// TC 10: Enter Subscription Email
	public void enterSubscriptionEmail(String email) {
		driver.findElement(subscriptionEmailField).sendKeys(email);
	}

	// TC 10: Check Subscription Success Message
	public boolean isSubscriptionMessageVisible() {
		return wait.until(ExpectedConditions.textToBe(subscriptionSuccessMessage, "You have been successfully subscribed!"));
	}
    
	//TC 11
	/*public void clickSubscriptionArrow() {
		driver.findElement(subscriptionButton).click();
	}*/
	
	 // TC 21
	// Verify ALL PRODUCTS Page is Visible
    public boolean isAllProductsPageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsHeader)).isDisplayed();
    }

    //  Click View Product Button
    public void clickViewProduct() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", 
                         driver.findElement(viewProductButton));
        wait.until(ExpectedConditions.elementToBeClickable(viewProductButton)).click();
    }

    //  Verify Write Your Review Section is Visible
    public boolean isReviewSectionVisible() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", 
                         driver.findElement(writeYourReviewSection));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(writeYourReviewSection)).isDisplayed();
    }

    //  Enter Review Details
    public void enterReviewDetails(String name, String email, String review) {
        driver.findElement(reviewNameField).sendKeys(name);
        driver.findElement(reviewEmailField).sendKeys(email);
        driver.findElement(reviewTextField).sendKeys(review);
    }

    //  Click Submit Review Button
    public void clickSubmitReview() {
        driver.findElement(submitReviewButton).click();
    }

    // Verify Review Success Message
    public boolean isReviewSuccessMessageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(reviewSuccessMessage)).isDisplayed();
    }
    
    // TC 25
    //  Scroll to Footer Section
    public void scrollToFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionSection));
    }

    //  Verify Subscription Section is Visible
    public boolean isSubscriptionSectionVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionSection)).isDisplayed();
    }

    //  Click Scroll Up Button
    public void clickScrollUpButton() {
        driver.findElement(scrollUpButton).click();
    }

    // Verify Homepage Header Text is Visible After Scrolling Up
    public boolean isHomePageHeaderVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homepageHeaderText)).isDisplayed();
    }
    
 // TC 26 : Scroll to Top of Page Automatically
    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(homepageHeaderText)); // Ensure visibility
    }
}

