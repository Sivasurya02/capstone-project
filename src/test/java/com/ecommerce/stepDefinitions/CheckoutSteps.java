package com.ecommerce.stepDefinitions;

import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.utils.ConfigReader;
import com.ecommerce.utils.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutSteps {
    WebDriver driver = DriverManager.getDriver();
    CheckoutPage CheckoutPage = new CheckoutPage(driver);

    // Background Steps  
    @Given("User launches browser and navigates to the page")
    public void user_launches_browser_and_navigates_to_page() {
        driver.get(ConfigReader.getProperty("base.url"));
    }

    @Then("User should verify that home page displayed successfully")
    public void user_should_verify_home_page_displayed() {
        Assert.assertTrue(CheckoutPage.isHomePageDisplayed(), "Home page is not visible.");
    }
    // Step for Clicking Signup/Login Button
    @When("User clicks {string} button to log in")
    public void user_clicks_signup_login_button_to_log_in(String button) {
        CheckoutPage.clickSignupLoginButton();
    }

    // Step for Entering Login Credentials
    @When("User enters email and password from config file and clicks {string}")
    public void user_enters_email_and_password_from_config_and_clicks_login(String button) {
        CheckoutPage.enterLoginCredentials(
                ConfigReader.getProperty("user.email"),
                ConfigReader.getProperty("user.password")
        );

    }

    // Step for Verifying Logged in as Username
    @Then("User should see Logged in as username verification appears")
    public void user_should_see_logged_in_as_username3() {
        Assert.assertTrue(CheckoutPage.isUserLoggedIn(), "User is NOT logged in!");
    }

    // Step for Adding Products to Cart
    @Given("User adds products to cart")
    public void user_adds_products_to_cart2() throws InterruptedException {
    	Thread.sleep(2000);
        CheckoutPage.scrollToFirstProductAndClickView();  // Scroll to first product and click view
    }

    // Step for Clicking Cart Button
    @When("User clicks the {string} button in cart detail page")
    public void user_clicks_cart_button_in_cart_detail_page(String button) {
        CheckoutPage.clickAddToCartButton();  // Click Add to Cart
        CheckoutPage.clickViewCartInAlert(); 

    }

    // Step for Verifying Cart Page Appears
    @Then("User should verify that cart page appears")
    public void user_should_verify_cart_page_appears() {
        Assert.assertTrue(CheckoutPage.isCartPageDisplayed(), "Cart page is NOT displayed!");
    }

    // Step for Clicking Proceed To Checkout
    @When("User clicks {string} for checkout")
    public void user_clicks_proceed_to_checkout_for_checkout(String button) {
        CheckoutPage.clickProceedToCheckoutInCartPage();
    }

    // Step for Verifying Address Details and Review Order
    @Then("User should verify Address Detail and Review Order")
    public void user_should_verify_address_detail_and_review_order() {
        Assert.assertTrue(CheckoutPage.isAddressDetailsDisplayed(), "Address details are NOT visible!");
    }

    // Step for Entering Description and Clicking Place Order
    @When("User enters some description in comment text area and clicks {string}")
    public void user_enters_some_description_and_clicks_place_order(String button) {
        CheckoutPage.enterComment("Please deliver the order fast!");
        CheckoutPage.clickPlaceOrderButton();
    }

    // Step for Entering Payment Details and Confirming Order
    @When("User enters the payment details and clicks {string}")
    public void user_enters_payment_details_and_clicks_pay_and_confirm_order1(String button) {
        CheckoutPage.enterPaymentDetails(
                ConfigReader.getProperty("payment.name"),
                ConfigReader.getProperty("payment.cardNumber"),
                ConfigReader.getProperty("payment.cvc"),
                ConfigReader.getProperty("payment.expiryMonth"),
                ConfigReader.getProperty("payment.expiryYear")
        );
        CheckoutPage.clickPayAndConfirmOrder();
    }

    // Step for Verifying Order Confirmation
    @Then("User should see {string} confirmation text")
    public void user_should_see_order_confirmation_text(String expectedMessage) {
        Assert.assertTrue(CheckoutPage.isOrderConfirmed(), "Order was NOT confirmed!");
    }

    // Step 1: Login & Delete Account If Exists  
    @When("User logs in using existing credentials from config")
    public void user_logs_in_using_existing_credentials() {
        CheckoutPage.clickSignupLoginButton();
        CheckoutPage.enterLoginCredentials(
            ConfigReader.getProperty("user.email"),
            ConfigReader.getProperty("user.password")
        );
    }

    @Then("If account exists, User deletes the account and clicks {string}")
    public void user_deletes_account_and_clicks_continue(String button) {
        if (CheckoutPage.isUserLoggedIn()) {
            CheckoutPage.clickDeleteAccountButton();
            Assert.assertTrue(CheckoutPage.isAccountDeleted(), "Account was not deleted.");
            CheckoutPage.clickContinueAfterDelete();
        }
    }

    //Step 2: Add Products to Cart  
    @Given("User adds products to the cart")
    public void user_adds_products_to_cart() throws InterruptedException {
    	Thread.sleep(2000);
        CheckoutPage.scrollToFirstProductAndClickView();
    }

    @When("User clicks the {string} button in detail page")
    public void user_clicks_cart_button_in_detail_page(String button) {
        CheckoutPage.clickAddToCartButton();
        CheckoutPage.clickViewCartInAlert(); 
    }

    @Then("User should verify cart page displayed")
    public void user_should_verify_cart_page_displayed() {
        Assert.assertTrue(CheckoutPage.isCartPageDisplayed(), "Cart page is not displayed.");
    }

    // Step 3: Proceed to Checkout & Register  
    @When("User clicks {string} in cart")
    public void user_clicks_proceed_to_checkout(String button) {
        CheckoutPage.clickProceedToCheckout();
    }

    @And("User clicks {string} button in cart alert")
    public void user_clicks_register_login_in_cart_alert(String button) {
        CheckoutPage.clickRegisterLoginButton();
    }

    @And("User fills all details in Signup and creates an account")
    public void user_fills_all_details_in_signup() {
        CheckoutPage.enterSignupDetails();
        CheckoutPage.fillAccountDetails();
        CheckoutPage.enterPersonalDetails();
        CheckoutPage.clickCreateAccountButton();
    }

    @Then("User should see ACCOUNT CREATED! message")
    public void user_should_see_account_created_message() {
        Assert.assertTrue(CheckoutPage.isAccountCreatedMessageDisplayed(), "Account Created message not displayed.");
    }

    @When("User clicks {string} button in signup")
    public void user_clicks_continue_button_after_signup(String button) {
        CheckoutPage.clickContinueButtonAfterSignup();
    }

    @Then("User should see Logged in as username")
    public void user_should_see_logged_in_as_username() {
        Assert.assertTrue(CheckoutPage.isUserLoggedIn(), "User is not logged in.");
    }

    // Step 4: Complete Checkout  
    @When("User clicks {string} button again in home")
    public void user_clicks_cart_button_again_in_home(String button) {
        CheckoutPage.clickCartButtonAgain();
    }

    @And("User clicks {string} button in cart page")
    public void user_clicks_proceed_to_checkout_button_in_cart_page(String button) {
        CheckoutPage.clickProceedToCheckoutInCartPage();
    }

    @Then("User should verify Address Details and Review Order")
    public void user_should_verify_address_details_and_review_order() {
        Assert.assertTrue(CheckoutPage.isAddressDetailsDisplayed(), "Address details not displayed.");
    }

    @When("User enters a description in comment text area and clicks {string}")
    public void user_enters_comment_and_clicks_place_order(String button) {
        CheckoutPage.enterComment("Please deliver between 10 AM - 12 PM.");
        CheckoutPage.clickPlaceOrderButton();
    }

    @And("User enters payment details and clicks {string}")
    public void user_enters_payment_details_and_clicks_pay_and_confirm(String button) {
        CheckoutPage.enterPaymentDetails(
            ConfigReader.getProperty("payment.name"),
            ConfigReader.getProperty("payment.cardNumber"),
            ConfigReader.getProperty("payment.cvc"),
            ConfigReader.getProperty("payment.expiryMonth"),
            ConfigReader.getProperty("payment.expiryYear")
        );
        CheckoutPage.clickPayAndConfirmOrder();
    }

    @Then("User should see {string} after order")
    public void user_should_see_order_confirmation_message(String message) {
        Assert.assertTrue(CheckoutPage.isOrderConfirmed(), "Order confirmation message not displayed.");
    }

    // Step 5: Delete Account After Order  
    @When("User clicks {string} button for deletion")
    public void user_clicks_delete_account_button_for_deletion(String button) {
        CheckoutPage.clickDeleteAccountButton();
    }

    @Then("User should see {string} message and clicks {string}")
    public void user_should_see_account_deleted_message_and_clicks_continue(String message, String button) {
        Assert.assertTrue(CheckoutPage.isAccountDeleted(), "Account was not deleted.");
        CheckoutPage.clickContinueAfterDelete();
    }
    
// Scenario: Place Order - Register Before Checkout (TC 15)
    
    @When("User clicks {string} button before checkout")
    public void user_clicks_signup_login_button_before_checkout(String button) {
        CheckoutPage.clickSignupLoginButton();
    }

    @And("User fills all details in Signup and creates account")
    public void user_fills_all_details_in_signup_and_creates_account() throws InterruptedException {
        CheckoutPage.enterSignupDetails();
        CheckoutPage.fillAccountDetails();
        CheckoutPage.enterPersonalDetails();
        Thread.sleep(2000);
        CheckoutPage.clickCreateAccountButton();
    }

    @Then("User should see the ACCOUNT CREATED! message")
    public void user_should_see_the_account_created_message() {
        Assert.assertTrue(CheckoutPage.isAccountCreatedMessageDisplayed(), "Account Created message not displayed.");
    }

    @When("User clicks {string} button in that page")
    public void user_clicks_continue_button_in_that_page(String button) {
        CheckoutPage.clickContinueButtonAfterSignup();
    }

    @Then("User should see Logged in as username text")
    public void user_should_see_logged_in_as_username1() {
        Assert.assertTrue(CheckoutPage.isUserLoggedIn(), "User is not logged in.");
    }

    @Given("User scrolls to the first product and clicks {string}")
    public void user_scrolls_to_the_first_product_and_clicks_view_product(String button) {
        CheckoutPage.scrollToFirstProductAndClickView();
    }

    @When("User clicks {string} button in page")
    public void user_clicks_add_to_cart_button_in_product_page(String button) {
        CheckoutPage.clickAddToCartButton();
    }

    @And("User clicks {string} button in alert to add")
    public void user_clicks_view_cart_button_in_alert_to_add(String button) {
        CheckoutPage.clickViewCartInAlert();
    }

    @Then("User should verify cart page is pop up")
    public void user_should_verify_cart_page_is_pop_up() {
        Assert.assertTrue(CheckoutPage.isCartPageDisplayed(), "Cart page is not displayed.");
    }

    @When("User clicks {string} in cartt")
    public void user_clicks_proceed_to_checkout_in_cartt(String button) {
        CheckoutPage.clickProceedToCheckoutInCartPage();
    }

    @Then("User should verify Address Details and Review the Order")
    public void user_should_verify_address_details_and_review_order1() {
        Assert.assertTrue(CheckoutPage.isAddressDetailsDisplayed(), "Address details not visible.");
    }

    @When("User enters a description in comment text area and clicks {string} button")
    public void user_enters_a_description_in_comment_text_area_and_clicks_place_order_button(String button) {
        CheckoutPage.enterComment("This is a test order.");
        CheckoutPage.clickPlaceOrderButton();
    }

    @And("User enters payment details and click {string}")
    public void user_enters_payment_details_and_clicks_pay_and_confirm_order(String button) {
        CheckoutPage.enterPaymentDetails(
                ConfigReader.getProperty("payment.name"),
                ConfigReader.getProperty("payment.cardNumber"),
                ConfigReader.getProperty("payment.cvc"),
                ConfigReader.getProperty("payment.expiryMonth"),
                ConfigReader.getProperty("payment.expiryYear")
        );
        CheckoutPage.clickPayAndConfirmOrder();
    }

    @Then("User should see {string} after click")
    public void user_should_see_congratulations_your_order_has_been_confirmed_after_click(String message) {
        Assert.assertTrue(CheckoutPage.isOrderConfirmed(), "Order confirmation message not displayed.");
    }

    @When("User clicks {string} button for deleting account")
    public void user_clicks_delete_account_button_for_deleting_account(String button) {
        CheckoutPage.clickDeleteAccountButton();
    }

    @Then("User should see {string} message and clicks {string} option")
    public void user_should_see_account_deleted_message_and_clicks_continue_option(String message, String button) {
        Assert.assertTrue(CheckoutPage.isAccountDeleted(), "Account deleted message not displayed.");
        CheckoutPage.clickContinueAfterDelete();
    }
 // TC 23 - Register Before Checkout and Verify Address Details
    @When("User clicks {string} button to register")
    public void user_clicks_signup_login_button(String button) {
        CheckoutPage.clickSignupLoginButton();
    }

    @When("User fills all details in Signup to creates an account")
    public void user_fills_details_in_signup() throws InterruptedException {
        CheckoutPage.enterSignupDetails();
        CheckoutPage.fillAccountDetails();
        CheckoutPage.enterPersonalDetails();
        Thread.sleep(2000);
        CheckoutPage.clickCreateAccountButton();
    }

    @Then("User should see the ACCOUNT CREATED! message displayed")
    public void user_should_see_account_created_message1() {
        Assert.assertTrue(CheckoutPage.isAccountCreatedMessageDisplayed(), "Account creation message not displayed.");
    }

    @When("User clicks {string} button after account creation")
    public void user_clicks_continue_after_signup(String button) {
    	CheckoutPage.clickContinueButtonAfterSignup();
    }

    @Then("User should see Logged in as username content")
    public void user_should_see_logged_in_as_username2() {
        Assert.assertTrue(CheckoutPage.isUserLoggedIn(), "Logged in as username is not visible.");
    }

    // Add Product to Cart
    @Given("User scrolls to the first product and click {string}")
    public void user_scrolls_to_first_product_and_click(String button) {
    	CheckoutPage.scrollToFirstProductAndClickView();
    }

    @When("User clicks {string} button in product detail page")
    public void user_clicks_add_to_cart_button(String button) {
        CheckoutPage.clickAddToCartButton();
    }

    @When("User clicks {string} button in alert popup")
    public void user_clicks_view_cart_button_in_alert(String button) {
        CheckoutPage.clickViewCartInAlert();
    }

    // Proceed to Checkout and Verify Address
    @Then("User should verify cart page appears")
    public void user_should_verify_cart_page_displayed1() {
        Assert.assertTrue(CheckoutPage.isCartPageDisplayed(), "Cart page is not displayed.");
    }

    @When("User clicks {string} button in cart detail page")
    public void user_clicks_proceed_to_checkout1(String button) {
    	CheckoutPage.clickProceedToCheckoutInCartPage();
    }

    @Then("User should verify that the Delivery and Billing addresses match the registered address")
    public void user_should_verify_address_details_match() {
        Assert.assertTrue(CheckoutPage.isAddressMatching(), "Billing and Delivery addresses do not match.");
    }

    // Delete Account After Verification
    @When("User clicks {string} button for account removal")
    public void user_clicks_delete_account_button(String button) {
        CheckoutPage.clickDeleteAccountButton();
    }

    @Then("User should see {string} message and clicks {string} to exit")
    public void user_should_see_account_deleted_message_and_click_continue(String message, String button) {
        Assert.assertTrue(CheckoutPage.isAccountDeleted(), "Account Deleted message is not displayed.");
        CheckoutPage.clickContinueAfterDelete();
    }
    
    // Given: Add products to cart
    @Given("User adds products to the cart from home")
    public void user_adds_products_to_cart1() throws InterruptedException {
    	Thread.sleep(2000);
        CheckoutPage.scrollToFirstProductAndClickView();
        
    }

    // When: Click Cart Button
    @When("User click the {string} button in detail page")
    public void user_click_cart_button(String button) {
       // CheckoutPage.clickCartButton();
        CheckoutPage.clickAddToCartButton();
        CheckoutPage.clickViewCartInAlert();
    }

    // Then: Verify Cart Page is Displayed
    @Then("User should verify cart page is shown")
    public void user_should_verify_cart_page_displayed2() {
        Assert.assertTrue(CheckoutPage.isCartPageDisplayed(), "Cart page is not displayed.");
    }

    //  When: Click Proceed to Checkout
    @When("User click {string} in cart")
    public void user_click_proceed_to_checkout(String button) {
        CheckoutPage.clickProceedToCheckout();
    }

    // When: Click Register/Login
    @When("User click {string} button in cart alert")
    public void user_click_register_login(String button) {
        CheckoutPage.clickRegisterLoginButton();
    }

    //  When: Fill Signup Details
    @When("User fill all details in Signup and creates an account")
    public void user_fills_signup_details() {
        CheckoutPage.enterSignupDetails();
        CheckoutPage.fillAccountDetails();
        CheckoutPage.enterPersonalDetails();
        CheckoutPage.clickCreateAccountButton();
    }

    // Then: Verify Account Created
    @Then("User should see ACCOUNT CREATED! message after")
    public void user_should_verify_account_created() {
        Assert.assertTrue(CheckoutPage.isAccountCreatedMessageDisplayed(), "Account Created message not displayed.");
    }

    // When: Click Continue After Signup
    @When("User click {string} button in signup")
    public void user_click_continue_after_signup(String button) {
        CheckoutPage.clickContinueButtonAfterSignup();
    }

    // Then: Verify Logged in as Username
    @Then("User should see Logged in as username verification")
    public void user_should_see_logged_in() {
        Assert.assertTrue(CheckoutPage.isUserLoggedIn(), "User is not logged in.");
    }

    // When: Click Cart Again
    @When("User click {string} button again in home")
    public void user_click_cart_again(String button) {
        CheckoutPage.clickCartButtonAgain();
    }

    // When: Proceed to Checkout in Cart Page
    @When("User click {string} button in cart page")
    public void user_click_proceed_checkout_cart_page(String button) {
        CheckoutPage.clickProceedToCheckoutInCartPage();
    }

    //  Then: Verify Address Details and Order Review
    @Then("User should verify the Address Details and Review the Order")
    public void user_verify_address_and_review_order() {
        Assert.assertTrue(CheckoutPage.isAddressDetailsDisplayed(), "Address Details not displayed.");
    }

    // When: Enter Description and Place Order
    @When("User enter a description in comment text area and clicks {string}")
    public void user_enter_comment_and_place_order(String button) {
        CheckoutPage.enterComment("Please process my order quickly!");
        CheckoutPage.clickPlaceOrderButton();
    }

    // When: Enter Payment Details
    @When("User enter payment details and clicks {string}")
    public void user_enter_payment_details(String button) {
        CheckoutPage.enterPaymentDetails(
            ConfigReader.getProperty("payment.name"),
            ConfigReader.getProperty("payment.cardNumber"),
            ConfigReader.getProperty("payment.cvc"),
            ConfigReader.getProperty("payment.expiryMonth"),
            ConfigReader.getProperty("payment.expiryYear")
        );
        CheckoutPage.clickPayAndConfirmOrder();
    }

    // Then: Verify Order Confirmation
    @Then("User should see {string} confirmation")
    public void user_verify_order_confirmation(String message) {
        Assert.assertTrue(CheckoutPage.isOrderConfirmed(), "Order confirmation message not displayed.");
    }

    // When: Click Download Invoice
    @When("User click {string} button")
    public void user_click_download_invoice(String button) throws InterruptedException {
        CheckoutPage.clickDownloadInvoiceButton();
        Thread.sleep(2000);
    }

    // Then: Verify Invoice Download
    @Then("User should verify that the invoice is downloaded successfully text")
    public void user_verify_invoice_downloaded() {
        Assert.assertTrue(CheckoutPage.isInvoiceDownloaded(), "Invoice was not downloaded successfully.");
    }

    // When: Click Continue After Invoice Download
    @When("User click {string} button after invoice download")
    public void user_click_continue_after_invoice_download(String button) {
        CheckoutPage.clickContinueButtonAfterSignup();
    }

    // When: Click Delete Account
    @When("User click {string} button for deletion")
    public void user_click_delete_account(String button) {
        CheckoutPage.clickDeleteAccountButton();
    }

    // Then: Verify Account Deleted
    @Then("User should see {string} message and clicks {string} in end")
    public void user_verify_account_deleted(String message, String button) {
        Assert.assertTrue(CheckoutPage.isAccountDeleted(), "Account deleted message not displayed.");
        CheckoutPage.clickContinueAfterDelete();
    }
}
