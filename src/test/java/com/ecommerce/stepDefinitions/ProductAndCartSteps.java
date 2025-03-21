package com.ecommerce.stepDefinitions;

import com.ecommerce.pages.ProductAndCartPage;
import com.ecommerce.utils.ConfigReader;
import com.ecommerce.utils.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductAndCartSteps {
	WebDriver driver = DriverManager.getDriver();
	ProductAndCartPage productAndCartPage = new ProductAndCartPage(driver);

	// Background Steps - Executed Before Each Scenario
	@Given("User launches browser and navigates to home page")
	public void user_launches_browser_and_navigates_to_home_page() {
		driver.get(ConfigReader.getProperty("base.url"));
	}

	@Then("User verify home page is visible")
	public void user_verify_home_page_is_visible() {
		Assert.assertTrue(productAndCartPage.isHomePageVisible(), "Home page is not displayed.");
	}

	// TC 8: Verify All Products and Product Detail Page
	@When("User clicks the {string} button in home")
	public void user_clicks_button_in_home(String button) {
		productAndCartPage.clickButton(button);
	}

	@Then("User should be navigate to the ALL PRODUCTS page successfully")
	public void user_should_be_navigated_to_all_products_page() {
		Assert.assertTrue(productAndCartPage.isAllProductsPageVisible(), "ALL PRODUCTS page is not displayed.");
	}

	@Then("User should see the products list")
	public void user_should_see_the_products_list() {
		Assert.assertTrue(productAndCartPage.isProductsListVisible(), "Products list is not visible.");
	}

	@When("User clicks {string} of the first product")
	public void user_clicks_view_product_of_first_product(String button) {
		productAndCartPage.clickFirstProductView();
	}

	@Then("User should be navigated to the product detail page")
	public void user_should_be_navigated_to_product_detail_page() {
		Assert.assertTrue(productAndCartPage.isProductDetailPageVisible(), "Product detail page is not displayed.");
	}

	@Then("User should see product details including name, category, price, availability, condition, and brand")
	public void user_should_see_product_details() {
		Assert.assertTrue(productAndCartPage.areProductDetailsVisible(), "Product details are missing or incorrect.");
	}

	// TC 9: Search Product
	@When("User clicks the {string} button in home window")
	public void user_clicks_products_button_in_home_window(String button) {
		productAndCartPage.clickButton(button);
	}

	@Then("User should be navigate to the ALL PRODUCTS page")
	public void user_should_be_navigated_to_all_products_page_TC9() {
		Assert.assertTrue(productAndCartPage.isAllProductsPageVisible(), "ALL PRODUCTS page is not displayed.");
	}

	@When("User enters a product name in the search input and clicks search button")
	public void user_enters_product_name_and_clicks_search() {
		productAndCartPage.searchProduct(ConfigReader.getProperty("product.searchKeyword"));
	}

	@Then("User should see {string} in page")
	public void user_should_see_text(String expectedText) {
		Assert.assertTrue(productAndCartPage.isSearchResultsVisible(expectedText), 
				"Expected text not found: " + expectedText);
	}

	@Then("User should verify that all products related to the search are visible")
	public void user_should_verify_all_products_related_to_search_are_visible() {
		Assert.assertTrue(productAndCartPage.areSearchResultsValid(ConfigReader.getProperty("product.searchKeyword")), 
				"Search results do not match the expected product.");
	}

	// TC 12: Add Products in Cart
	@When("User clicks the {string} button in main page")
	public void user_clicks_products_button_in_main_page(String button) {
		productAndCartPage.clickButton(button);
	}

	@Then("User should be navigate to the ALL PRODUCTS")
	public void user_should_be_navigated_to_all_products() throws InterruptedException {
		Assert.assertTrue(productAndCartPage.isAllProductsPageVisible(), "ALL PRODUCTS page is not displayed.");
		Thread.sleep(2000); 
	}

	@When("User hovers over the first product and clicks {string}")
	public void user_hovers_over_first_product_and_clicks_add_to_cart(String button) {
		productAndCartPage.hoverAndAddFirstProduct();
	}

	@And("User clicks {string} button in alert box")
	public void user_clicks_continue_shopping_in_alert(String button) {
		productAndCartPage.handleAlertButton(button);
	}

	@When("User hovers over the second product and clicks {string}")
	public void user_hovers_over_second_product_and_clicks_add_to_cart(String button) {
		productAndCartPage.hoverAndAddSecondProduct();
	}

	@And("User clicks {string} button in alert")
	public void user_clicks_view_cart_in_alert(String button) {
		productAndCartPage.handleAlertButton(button);
	}

	@Then("User should verify both products are added to the Cart")
	public void user_should_verify_products_added_to_cart() {
		Assert.assertTrue(productAndCartPage.areProductsInCart(), "Products are not added to the cart.");
	}

	@And("User should verify their prices, quantity, and total price")
	public void user_should_verify_prices_quantity_total_price() {
		Assert.assertTrue(productAndCartPage.isCartSummaryCorrect(), "Cart prices, quantity, or total are incorrect.");
	}

	//  TC 13: Verify Product Quantity in Cart
	@When("User clicks {string} for any product on home page")
	public void user_clicks_view_product_for_any_product(String button) throws InterruptedException {
		Thread.sleep(2000);
		productAndCartPage.clickFirstProductView();
	}

	@Then("User should see the product detail page")
	public void user_should_see_the_product_detail_page() {
		Assert.assertTrue(productAndCartPage.isProductDetailPageVisible(), "Product detail page is not displayed.");
	}

	@When("User increases the quantity to {string}")
	public void user_increases_the_quantity(String quantity) {
		productAndCartPage.setProductQuantity(quantity);
	}

	@And("User clicks {string} button in product page")
	public void user_clicks_add_to_cart_in_product_page(String button) {
		productAndCartPage.clickAddToCartInProductPage();
	}

	@And("User clicks {string} button from alert")
	public void user_clicks_view_cart_from_alert(String button) {
		productAndCartPage.handleAlertButton(button);
	}

	@Then("User should verify that the product is displayed in the cart with exact quantity {string}")
	public void user_verifies_product_quantity_in_cart(String expectedQuantity) {
		Assert.assertEquals(productAndCartPage.getCartProductQuantity(), expectedQuantity,
				"Product quantity in cart does not match expected.");
	}
	
	//  TC 17: Remove Products From Cart
    @Given("User adds a product to the cart")
    public void user_adds_a_product_to_cart() throws InterruptedException {
    	Thread.sleep(2000);        
    	productAndCartPage.scrollToAndHoverFirstProduct();
        productAndCartPage.clickAddToCart();
       // productAndCartPage.clickViewCartInAlert();
    }

    @When("User clicks {string} button in product detail")
    public void user_clicks_cart_button(String button) {
        productAndCartPage.clickViewCartInAlert();
    }

    @Then("User should verify that the cart page is displayed")
    public void user_should_verify_cart_page_displayed() {
        Assert.assertTrue(productAndCartPage.isCartPageVisible(), "Cart page is not displayed.");
    }

    @When("User clicks the {string} button to remove the product")
    public void user_clicks_x_button_to_remove_product(String button) {
        productAndCartPage.removeProductFromCart();
    }

    @Then("User should verify that the cart is empty")
    public void user_should_verify_cart_is_empty() {
        Assert.assertTrue(productAndCartPage.isCartEmpty(), "Product was not removed from the cart.");
    }
    
 // TC 22: Add to Cart from Recommended Items
    @When("User scrolls down to the recommended items section")
    public void user_scrolls_down_to_recommended_items_section() {
        productAndCartPage.scrollToRecommendedItems();
    }

    @Then("User should see {string} section")
    public void user_should_see_recommended_items_section(String section) {
        Assert.assertTrue(productAndCartPage.isRecommendedItemsVisible(), "'Recommended Items' section not found.");
    }

    @When("User clicks {string} on a recommended product")
    public void user_clicks_add_to_cart_on_recommended_product(String button) {
        productAndCartPage.clickAddToCartOnRecommendedItem();
    }

    @When("User clicks {string} button in alert shown")
    public void user_clicks_view_cart_button_in_alert(String button) {
        productAndCartPage.clickViewCartInAlert();
    }

    @Then("User should verify that product is displayed in the cart")
    public void user_should_verify_product_displayed_in_cart() {
        Assert.assertTrue(productAndCartPage.isProductInCart(), "Product not found in the cart.");
    }
}
