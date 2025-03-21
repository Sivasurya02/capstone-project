package com.ecommerce.stepDefinitions;

import com.ecommerce.pages.UserActionsPage;
import com.ecommerce.utils.ConfigReader;
import com.ecommerce.utils.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserActionsSteps {
	WebDriver driver = DriverManager.getDriver();
	UserActionsPage userActionsPage = new UserActionsPage(driver);

	@Given("User opens the home page for Contact Us")
	public void user_opens_the_home_page_for_contact_us() {
		driver.get(ConfigReader.getProperty("base.url"));
	}

	@When("User clicks {string}")
	public void user_clicks(String button) {
		userActionsPage.clickButton(button);
	}

	@Then("User should see {string}")
	public void user_should_see(String text) {
		Assert.assertTrue(userActionsPage.isTextVisible(text), " Expected text not found: " + text);
	}

	@When("User enters contact details from config")
	public void user_enters_contact_details_from_config() {
		String name = ConfigReader.getProperty("user.name");
		String email = ConfigReader.getProperty("user.email");
		userActionsPage.enterContactDetails(name, email);
	}

	@When("User enters subject and message from config")
	public void user_enters_subject_and_message_from_config() {
		String subject = ConfigReader.getProperty("contact.subject");
		String message = ConfigReader.getProperty("contact.message");
		userActionsPage.enterSubjectAndMessage(subject, message);
	}

	@When("User uploads file from config")
	public void user_uploads_file_from_config() throws InterruptedException {
		userActionsPage.uploadFile();
		Thread.sleep(2000);
	}

	@When("User clicks {string} and accepts alert")
	public void user_clicks_and_accepts_alert(String button) throws InterruptedException {
		userActionsPage.clickSubmitAndAcceptAlert(button);
		Thread.sleep(1000);
	}

	@Then("User should see success message")
	public void user_should_see_success_message() throws InterruptedException {
		Assert.assertTrue(userActionsPage.isSuccessMessageVisible(), " Success message not found.");
		Thread.sleep(1000);

	}

	@When("User clicks Home button")
	public void user_clicks_home_button() {
		userActionsPage.clickButton("Home"); // 
	}

	@Then("User should be redirected to the home page")
	public void user_should_be_redirected_to_home_page() {
		Assert.assertTrue(userActionsPage.isHomePageVisible(), " Home page is not visible.");
	}

	// NEW for TC 7: Verify Test Cases Page
	@Given("User on the home page")
	public void user_is_on_the_home_page() {
		driver.get(ConfigReader.getProperty("base.url"));
	}

	@When("User clicks the Test Cases button")   // NEW for TC 7
	public void user_clicks_test_cases_button() {
		userActionsPage.clickTestCasesMenu();
	}

	@Then("User should be navigated to the Test Cases page successfully")
	public void user_should_be_navigated_to_test_cases_page() {
		Assert.assertTrue(userActionsPage.isTestCasesPageVisible(), "Test Cases page did not load successfully.");
	}
	

    // TC 10: Verify Subscription in Home Page
    @Given("User launches the browser and navigates to the home page")
    public void user_launches_browser_and_navigates_to_home_page() {
        driver.get(ConfigReader.getProperty("base.url"));
    }

    @Then("User should verify that the home page is displayed successfully")
    public void user_should_verify_home_page_displayed() {
        Assert.assertTrue(userActionsPage.HomePageVisible(), "Home page is not displayed.");
    }

    @When("User scrolls down to the footer")
    public void user_scrolls_down_to_footer() throws InterruptedException {
        userActionsPage.scrollToSubscriptionSection();
        Thread.sleep(1000);
    }

    @Then("User should see {string} text")
    public void user_should_see_text(String text) {
        Assert.assertTrue(userActionsPage.isTextVisible(text), "Expected text not found: " + text);
    }

    @When("User enters an email in the subscription input and clicks the subscribe button")
    public void user_enters_email_and_clicks_subscribe() throws InterruptedException {
        userActionsPage.enterSubscriptionEmail(ConfigReader.getProperty("user.email"));
        userActionsPage.clickButton("Subscribe");
        Thread.sleep(1000);
    }

    @Then("User should verify that the success message is visible")
    public void user_should_verify_subscription_success_message() {
        Assert.assertTrue(userActionsPage.isSubscriptionMessageVisible(), 
                          "Subscription success message not found: " + "You have been successfully subscribed!");
    }
    
    @Given("User launches the browser and goes to home page")
    public void user_launches_browser_and_goes_to_home_page() {
        driver.get(ConfigReader.getProperty("base.url"));
    }

    @Then("User should verify home page displayed")
    public void user_should_verify_home_page() {
        Assert.assertTrue(userActionsPage.HomePageVisible(), "Home page is not displayed.");
    }

    @When("User clicks Cart")
    public void user_clicks_cart() {
        userActionsPage.clickButton("Cart");
    }

    @When("User scrolls down to the email")
    public void user_scrolls_down_to_the_email() {
        userActionsPage.scrollToSubscriptionSection();
    }

    @Then("User should see SUBSCRIPTION msg")
    public void user_should_see_subscription_msg() {
        Assert.assertTrue(userActionsPage.isTextVisible("SUBSCRIPTION"), "Subscription message is not visible.");
    }

    @When("User enters email and clicks arrow button")
    public void user_enters_email_and_clicks_arrow_button() {
        userActionsPage.scrollToSubscriptionSection();
        userActionsPage.enterSubscriptionEmail(ConfigReader.getProperty("user.email"));
        userActionsPage.clickButton("Subscribe");

    }

    @Then("User should see You have been successfully subscribed!")
    public void user_should_see_success_msg() {
        Assert.assertTrue(userActionsPage.isSubscriptionMessageVisible(), 
                          "Subscription success message not found: " + "You have been successfully subscribed!");
    }
    // TC 21: Add Review on Product

    @Given("User launche browser and goes to the home page")
    public void user_launches_browser_and_to_home_page() {
        driver.get(ConfigReader.getProperty("base.url"));
    }

    @When("User clicks Products")
    public void user_clicks_products() throws InterruptedException {
        userActionsPage.clickButton("Products");
        Thread.sleep(1000);
    }

    @Then("User should be navigated to the ALL PRODUCTS page successfully")
    public void user_should_be_navigated_to_all_products_page() {
        Assert.assertTrue(userActionsPage.isAllProductsPageVisible(), 
                          "ALL PRODUCTS page did not load successfully.");
    }

    @When("User clicks View Product")
    public void user_clicks_view_product() {
        userActionsPage.clickViewProduct();
    }

    @Then("User should see Write Your Review")
    public void user_should_see_write_your_review() {
        Assert.assertTrue(userActionsPage.isReviewSectionVisible(), 
                          "'Write Your Review' section is not visible.");
    }

    @When("User enters name, email, and review from config")
    public void user_enters_name_email_and_review_from_config() throws InterruptedException {
        String name = ConfigReader.getProperty("user.name");
        String email = ConfigReader.getProperty("user.email");
        String review = ConfigReader.getProperty("user.review");
        userActionsPage.enterReviewDetails(name, email, review);
        Thread.sleep(1000);
    }

    @When("User clicks Submit button")
    public void user_clicks_submit_button() {
        userActionsPage.clickSubmitReview();
    }

    @Then("User should see Thank you for your review.")
    public void user_should_see_thank_you_for_your_review() {
        Assert.assertTrue(userActionsPage.isReviewSuccessMessageVisible(), 
                          "Review success message not found.");
    }
 // TC 25: Verify Scroll Up using Arrow button and Scroll Down functionality

    @Given("User launche browser and navigate to the home page")
    public void user_launches_browser_and_navigates_to_home_page1() {
        driver.get(ConfigReader.getProperty("base.url"));
    }

    @Then("User should verify that home page is displayed")
    public void user_should_verify_home_page_displayed1() {
        Assert.assertTrue(userActionsPage.HomePageVisible(), "Home page is not displayed.");
    }

    @When("User scrolls down to footer")
    public void user_scrolls_down_to_footer1() {
        userActionsPage.scrollToFooter();
    }

    @Then("User should see SUBSCRIPTION text")
    public void user_should_see_subscription_text() {
        Assert.assertTrue(userActionsPage.isSubscriptionSectionVisible(), "Subscription text is not visible.");
    }

    @When("User clicks Scroll Up button")
    public void user_clicks_scroll_up_button() {
        userActionsPage.clickScrollUpButton();
    }

    @Then("User should see Full-Fledged practice website for Automation Engineers")
    public void user_should_see_homepage_header_text() {
        Assert.assertTrue(userActionsPage.isHomePageHeaderVisible(), 
                          "'Full-Fledged practice website for Automation Engineers' text is not visible.");
    }
    
 // TC 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality

    @Given("User open browser to the home page")
    public void user_open_browser_to_home_page() {
        driver.get(ConfigReader.getProperty("base.url"));
    }

    @Then("User should verify home page is displayed")
    public void user_should_verify_home_page_is_displayed() {
        Assert.assertTrue(userActionsPage.HomePageVisible(), "Home page is not displayed.");
    }

    @When("User scrolls down to bottom")
    public void user_scrolls_down_to_bottom() {
        userActionsPage.scrollToFooter();
    }

    @Then("User should see the SUBSCRIPTION text")
    public void user_should_see_the_subscription_text() {
        Assert.assertTrue(userActionsPage.isSubscriptionSectionVisible(), "Subscription text is not visible.");
    }

    @When("User scrolls up to the top of the page automatically")
    public void user_scrolls_up_to_the_top_of_the_page_automatically() {
        userActionsPage.scrollToTop();
    }

    @Then("User should see Full-Fledged practice website for Automation Engineers text")
    public void user_should_see_full_fledged_practice_website_text() {
        Assert.assertTrue(userActionsPage.isHomePageHeaderVisible(), 
                          "'Full-Fledged practice website for Automation Engineers' text is not visible.");
    }

}







