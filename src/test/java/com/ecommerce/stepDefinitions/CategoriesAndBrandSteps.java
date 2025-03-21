package com.ecommerce.stepDefinitions;

import com.ecommerce.pages.CategoriesAndBrandPage;
import com.ecommerce.utils.ConfigReader;
import com.ecommerce.utils.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategoriesAndBrandSteps {
    WebDriver driver = DriverManager.getDriver();
    CategoriesAndBrandPage categoriesAndBrandPage = new CategoriesAndBrandPage(driver);

    // Background: Launch and Verify Home Page
    @Given("User launches the browser and navigate to home panel")
    public void user_launches_browser_and_navigates_to_home_page() {
        driver.get(ConfigReader.getProperty("base.url"));
    }

    @Then("User should verify that the home page is visible")
    public void user_should_verify_home_page_is_visible() {
        Assert.assertTrue(categoriesAndBrandPage.isHomePageVisible(), "Home page is not displayed.");
    }

    // Step 1: Click "Products" Button
    @When("User clicks the {string} button in home header")
    public void user_clicks_the_products_button_in_home_header(String button) {
    	categoriesAndBrandPage.clickProductsButton();
    }

    // Step 2: Verify Navigation to "ALL PRODUCTS" Page
    @Then("User should be navigated to ALL PRODUCT page")
    public void user_should_be_navigated_to_all_products_page() {
        Assert.assertTrue(categoriesAndBrandPage.isAllProductsPageDisplayed(), "ALL PRODUCTS page is not displayed.");
    }

    // Step 3: Search for a Product
    @When("User enters a product name in the search input and clicks the search button")
    public void user_enters_a_product_name_in_search_and_clicks_search_button() {
    	categoriesAndBrandPage.searchForProduct(ConfigReader.getProperty("product.searchKeyword"));
    }

    // Step 4: Verify "SEARCHED PRODUCTS" Text Appears
    @Then("User should see {string} text shown")
    public void user_should_see_searched_products_text_shown(String expectedText) {
        Assert.assertTrue(categoriesAndBrandPage.isSearchedProductsVisible(), "SEARCHED PRODUCTS text is not visible.");
    }

    // Step 5: Verify All Search Results are Displayed
    @Then("User should verify that all products related to the search are visible there")
    public void user_should_verify_all_products_related_to_search_are_visible() {
        Assert.assertTrue(categoriesAndBrandPage.areAllSearchedProductsDisplayed(),
                "Search results do not match the expected product.");
    }

    // Step 6: Add Searched Products to Cart
    @When("User adds the searched products to the cart by hover")
    public void user_adds_searched_products_to_cart_by_hover() throws InterruptedException {
    	Thread.sleep(3000);
    	categoriesAndBrandPage.hoverAndAddFirstProductToCart();
    	//Thread.sleep(2000);
        categoriesAndBrandPage.handleCartPopupButton("Continue Shopping");
    	//Thread.sleep(1000);

    	categoriesAndBrandPage.hoverAndAddSecondProductToCart();
    	Thread.sleep(1000);
    	categoriesAndBrandPage.handleCartPopupButton("Continue Shopping");
    	//Thread.sleep(1000);

    	categoriesAndBrandPage.hoverAndAddThirdProductToCart();
    	Thread.sleep(3000);
        categoriesAndBrandPage.handleCartPopupButton("View Cart");
    }

    // Step 7: Click "Cart" Button
    @And("User clicks the {string} button by hover")
    public void user_clicks_cart_button_by_hover(String button) {
    	//categoriesAndBrandPage.handleCartPopupButton("View Cart");
    	categoriesAndBrandPage.clickCartButtonAgainAfterLogin();
    }

    // Step 8: Verify Products Are in Cart
    @Then("User should verify that searched products are visible inside cart")
    public void user_should_verify_searched_products_are_visible_inside_cart() {
        Assert.assertTrue(categoriesAndBrandPage.isSearchedProductInCart(), "Products are not visible in the cart.");
    }

    // Step 9: Click "Signup/Login" from Cart Page
    @When("User clicks {string} button from cart page")
    public void user_clicks_signup_login_button_from_cart_page(String button) {
    	categoriesAndBrandPage.clickSignupLoginButton();
    }

    // Step 10: Enter Login Details
    @And("User enters login details from config and clicks the {string} option")
    public void user_enters_login_details_and_clicks_login(String button) {
    	categoriesAndBrandPage.loginWithCredentials(ConfigReader.getProperty("user.email"),
                ConfigReader.getProperty("user.password"));
    }

    // Step 11: Click "Cart" Again After Login
    @When("User clicks the {string} button in home page again after login")
    public void user_clicks_cart_button_in_home_page_again_after_login(String button) {
    	categoriesAndBrandPage.clickCartButtonAgainAfterLogin();
    }

    // Step 12: Verify Products Are Still in Cart
    @Then("User should verify that searched products are still visible in the cart")
    public void user_should_verify_searched_products_are_still_visible_in_cart() {
        Assert.assertTrue(categoriesAndBrandPage.isProductStillInCartAfterLogin(),
                "Products are not visible in the cart after login.");
    }

    //  Step 13: Remove All Products from Cart
    @When("User removes all products from the cart by clicking X")
    public void user_removes_all_products_from_cart_by_clicking_x() {
    	categoriesAndBrandPage.removeAllProductsFromCart();
    }

    // Step 14: Verify "Cart is Empty" Message
    @Then("User should see {string} confirmation shown")
    public void user_should_see_cart_is_empty_confirmation_text(String expectedMessage) {
        Assert.assertTrue(categoriesAndBrandPage.isCartEmptyMessageDisplayed(),
                "Cart is not empty, expected message: " + expectedMessage);
    }
    
 // Step 1: Verify Categories Section is Visible
    @Then("User should verify that categories are visible on the left sidebar")
    public void user_should_verify_categories_visible_on_left_sidebar() {
        Assert.assertTrue(categoriesAndBrandPage.isCategoriesSectionVisible(), 
                "❌ Categories section is NOT visible on the left sidebar.");
    }

    // Step 2: Click on "Women" Category
    @When("User clicks on {string} category")
    public void user_clicks_on_category(String category) {
        if (category.equalsIgnoreCase("Women")) {
            categoriesAndBrandPage.clickWomenCategory();
        }
        else {
            throw new IllegalArgumentException("Invalid category: " + category);
        }
    }

    // Step 3: Click on "Dress" Sub-Category Under Women
    @And("User clicks on {string} sub-category under Women category")
    public void user_clicks_on_women_sub_category(String subCategory) {
        if (subCategory.equalsIgnoreCase("Dress")) {
            categoriesAndBrandPage.clickWomenDressSubCategory();
        } else {
            throw new IllegalArgumentException("Invalid Women sub-category: " + subCategory);
        }
    }

    //  Step 4: Verify "WOMEN - DRESS PRODUCTS" Page is Displayed
    @Then("User should verify that category page is displayed with the text {string}")
    public void user_verifies_women_category_page(String expectedText) {
        Assert.assertTrue(categoriesAndBrandPage.isWomenDressProductsPageDisplayed(),
                "❌ Category page is NOT displayed with text: " + expectedText);
    }

    // Step 5: Click on "Men" Category
    @When("User clicks on {string} category section")
    public void user_clicks_on_men_category_section(String category) {
        if (category.equalsIgnoreCase("Men")) {
            categoriesAndBrandPage.clickMenCategory();
        } else {
            throw new IllegalArgumentException("Invalid category: " + category);
        }
    }

    //  Step 6: Click on "T-Shirts" Sub-Category Under Men
    @And("User clicks on {string} sub-category under Men category section")
    public void user_clicks_on_men_sub_category(String subCategory) {
        if (subCategory.equalsIgnoreCase("T-Shirts")) {
            categoriesAndBrandPage.clickMenTShirtSubCategory();
        } else {
            throw new IllegalArgumentException("Invalid Men sub-category: " + subCategory);
        }
    }

    // Step 7: Verify "MEN - T-SHIRTS PRODUCTS" Page is Displayed
    @Then("User should verify that category page is displayed with the message {string}")
    public void user_verifies_men_category_page(String expectedText) {
        Assert.assertTrue(categoriesAndBrandPage.isMenTShirtsProductsPageDisplayed(),
                "❌ Category page is NOT displayed with text: " + expectedText);
    }
    
    // TC 19
    // Step 1: Click on the "Products" Button
    @When("User clicks the {string} button in the mainpage")
    public void user_clicks_the_products_button(String button) {
        categoriesAndBrandPage.clickProductsButton();
    }

    // Step 2: Verify Brands Section is Visible	
    @Then("User should verify that brands are visible on the left sidebar")
    public void user_should_verify_brands_section_is_visible() throws InterruptedException {
    	Thread.sleep(2000);
        Assert.assertTrue(categoriesAndBrandPage.isBrandSectionVisible(), 
                "Brands section is not visible on the left sidebar.");
    }

    // Step 3: Click on "Polo" Brand
    @When("User clicks on {string} brand")
    public void user_clicks_on_polo_brand(String brand) {
        categoriesAndBrandPage.clickPoloBrand();
    }

    // Step 4: Verify User is Navigated to Polo Brand Page
    @Then("User should verify that user is navigated to {string} brand page")
    public void user_should_verify_polo_brand_page(String expectedText) {
        Assert.assertTrue(categoriesAndBrandPage.isBrandPageDisplayed(expectedText), 
                "User is not navigated to the correct brand page.");
    }

    // Step 5: Click on "H&M" Brand
    @When("User clicks on {string} brand next")
    public void user_clicks_on_hAndM_brand(String brand) {
        categoriesAndBrandPage.clickHAndMBrand();
    }

    // Step 6: Verify User is Navigated to H&M Brand Page
    @Then("User should verify that user is navigated to the {string} brand page")
    public void user_should_verify_hAndM_brand_page(String expectedText) {
        Assert.assertTrue(categoriesAndBrandPage.isBrandPageDisplayed(expectedText), 
                "User is not navigated to the correct brand page.");
    }
    }
