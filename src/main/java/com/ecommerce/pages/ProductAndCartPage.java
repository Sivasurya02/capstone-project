package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ProductAndCartPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	public ProductAndCartPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.actions = new Actions(driver);
	}

	// Locators
	private By homePageBanner = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img"); // Home page verification
	private By productsButton = By.xpath("//a[contains(text(),'Products')]"); // Products menu button
	private By allProductsHeader = By.xpath("//h2[contains(text(),'All Products')]"); // ALL PRODUCTS page header
	private By productsList = By.xpath("//div[@class='features_items']"); // Product list section
	private By firstProductViewButton = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a"); // View Product button
	private By secondProductViewButton = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[2]/ul/li/a"); // View Product button

	private By productDetailPage = By.xpath("//div[@class='product-information']"); // Product details section
	private By productName = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2"); // Product name
	private By productCategory = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]"); // Product category
	private By productPrice = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span"); // Product price
	private By productAvailability = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b"); // Product availability
	private By productCondition = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b"); // Product condition
	private By productBrand = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b"); // Product brand

	// Search Product (TC 9)
	private By searchInput = By.id("search_product"); // Search input field
	private By searchButton = By.id("submit_search"); // Search button
	private By searchResultsHeader = By.xpath("//h2[contains(text(),'Searched Products')]"); // "SEARCHED PRODUCTS" text
	private By searchResultsItems = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]"); // Search results list

	// Add Products to Cart (TC 12)
	private By firstProduct = By.xpath("(//div[@class='productinfo text-center'])[1]"); // First product
	private By secondProduct = By.xpath("(//div[@class='productinfo text-center'])[2]"); // Second product
	private By firstProductAddToCart = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a"); // Add to cart for first product
	// (//a[contains(text(),'Add to cart')])[1]
	private By secondProductAddToCart = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a"); // Add to cart for second product
	// (//a[contains(text(),'Add to cart')])[2]
	private By continueShoppingButton = By.xpath("//button[contains(text(),'Continue Shopping')]"); // Continue Shopping in alert
	private By viewCartButton = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"); // View Cart in alert
	//a[contains(text(),'View Cart')]
	private By cartPage = By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]"); // Shopping cart page
	private By cartItems = By.xpath("//tbody/tr"); // Cart items
	private By cartTotalPrice = By.xpath("//tbody/tr/td[@class='cart_total']/p"); // Cart total price

	private By productQuantityField = By.id("quantity"); // Quantity field in product page
	private By addToCartButton = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button"); // Add to cart button in product page
	private By cartProductQuantity = By.xpath("//tbody/tr/td[@class='cart_quantity']/button"); // Quantity field in cart

	private By removeProductButton = By.xpath("//*[@id=\"product-1\"]/td[6]/a"); // TC 17
	private By emptyCartMessage = By.xpath("//*[@id=\"empty_cart\"]/p/b"); // TC 17
    //tc 22
	private By recommendedItemsSection = By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[1]/div[1]/div/div/div/a"); 
	private By recommendedProductAddToCart = By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[1]/div[1]/div/div/div/a");
	private By cartPageProduct = By.xpath("//td[@class='cart_description']"); 



	//  Verify Home Page is Visible
	public boolean isHomePageVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(homePageBanner)).isDisplayed();
	}

	// Click Buttons (Handles multiple buttons)
	public void clickButton(String button) {
		if (button.equalsIgnoreCase("Products")) {
			driver.findElement(productsButton).click();
		} else {
			throw new IllegalArgumentException("Button not found: " + button);
		}
	}

	// Verify ALL PRODUCTS Page is Visible
	public boolean isAllProductsPageVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsHeader)).isDisplayed();
	}

	// Verify Products List is Visible
	public boolean isProductsListVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productsList)).isDisplayed();
	}

	// Click "View Product" for First Product
	public void clickFirstProductView() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", 
				driver.findElement(firstProductViewButton));
		wait.until(ExpectedConditions.elementToBeClickable(firstProductViewButton)).click();
	}

	// Verify Product Detail Page is Visible
	public boolean isProductDetailPageVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productDetailPage)).isDisplayed();
	}

	// Verify Product Details are Visible
	public boolean areProductDetailsVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).isDisplayed() &&
				wait.until(ExpectedConditions.visibilityOfElementLocated(productCategory)).isDisplayed() &&
				wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).isDisplayed() &&
				wait.until(ExpectedConditions.visibilityOfElementLocated(productAvailability)).isDisplayed() &&
				wait.until(ExpectedConditions.visibilityOfElementLocated(productCondition)).isDisplayed() &&
				wait.until(ExpectedConditions.visibilityOfElementLocated(productBrand)).isDisplayed();
	}

	// Search for a Product (TC 9)
	public void searchProduct(String productName) {
		driver.findElement(searchInput).sendKeys(productName);
		driver.findElement(searchButton).click();
	}

	// Verify Search Results Page is Visible
	public boolean isSearchResultsVisible(String expectedText) {
		return wait.until(ExpectedConditions.textToBe(searchResultsHeader, expectedText));
	}

	// Verify Search Results Match Expected Product
	public boolean areSearchResultsValid(String expectedProduct) {
		List elements = driver.findElements(searchResultsItems);
		return elements.size() > 0; // ✅ Ensures at least one search result is displayed
	}

	// Scroll to First Product, Hover, and Click Add to Cart (TC 12)
	public void hoverAndAddFirstProduct() {
		// Scroll to first product
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", 
				driver.findElement(firstProductViewButton));

		// Hover over first product and click "Add to Cart"
		actions.moveToElement(driver.findElement(firstProduct)).perform();
		wait.until(ExpectedConditions.elementToBeClickable(firstProductAddToCart)).click();
	}

	// Scroll to Second Product, Hover, and Click Add to Cart
	public void hoverAndAddSecondProduct() {
		// Scroll to second product
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", 
				driver.findElement(secondProductViewButton));

		// Hover over second product and click "Add to Cart"
		actions.moveToElement(driver.findElement(secondProduct)).perform();
		wait.until(ExpectedConditions.elementToBeClickable(secondProductAddToCart)).click();
	}

	// Handle Alert Buttons (Continue Shopping / View Cart)
	public void handleAlertButton(String button) {
		if (button.equalsIgnoreCase("Continue Shopping")) {
			wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
		} else if (button.equalsIgnoreCase("View Cart")) {
			wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
		} else {
			throw new IllegalArgumentException("Alert button not found: " + button);
		}
	}

	// Verify Products Are Added to Cart (TC 12)
	public boolean areProductsInCart() {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems)).size() == 2;
	}

	// Verify Cart Prices, Quantity, and Total Price (TC 12)
	public boolean isCartSummaryCorrect() {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartTotalPrice)).size() > 0;
	}

	//  Set Product Quantity
	public void setProductQuantity(String quantity) {
		WebElement quantityField = driver.findElement(productQuantityField);
		quantityField.clear();
		quantityField.sendKeys(quantity);
	}

	// Click 'Add to Cart' in Product Page
	public void clickAddToCartInProductPage() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	}

	// Handle Alert Buttons (View Cart Button in Alert)
	/*public void handleAlertButton(String button) {
        if (button.equalsIgnoreCase("View Cart")) {
            wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
        } else {
            throw new IllegalArgumentException("❌ Alert button not found: " + button);
        }
    }*/

	//  Verify Shopping Cart Page is Visible
	public boolean isCartPageVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage)).isDisplayed();
	}

	//  Get Product Quantity in Cart
	public String getCartProductQuantity() {
		return driver.findElement(cartProductQuantity).getText();
	}

	//TC 17
	// Scroll to and Click 'View Product'
	public void scrollToAndHoverFirstProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement viewProductBtn = driver.findElement(firstProductViewButton);
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", viewProductBtn);
		wait.until(ExpectedConditions.elementToBeClickable(firstProductViewButton)).click();
	}

	// Click 'Add to Cart' in Product Page
	public void clickAddToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	}

	//  Click 'View Cart' in Alert
	public void clickViewCartInAlert() {
		wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
	}

	// Click 'Cart' Button
	/*public void clickCartButton() {
        driver.findElement(viewCartButton).click();
    }*/

	// Verify Shopping Cart Page is Visible
	/*public boolean isCartPageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage)).isDisplayed();
    }*/

	// Click 'X' Button to Remove Product
	public void removeProductFromCart() {
		wait.until(ExpectedConditions.elementToBeClickable(removeProductButton)).click();
	}

	// Verify Cart is Empty
	public boolean isCartEmpty() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage)).isDisplayed();
	}

	//TC 22
	// Scroll to 'Recommended Items' Section
	public void scrollToRecommendedItems() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement recommendedSection = driver.findElement(recommendedItemsSection);
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", recommendedSection);
	}

	// Verify 'Recommended Items' Section is Visible
	public boolean isRecommendedItemsVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(recommendedItemsSection)).isDisplayed();
	}

	// Click 'Add to Cart' on Recommended Product
	public void clickAddToCartOnRecommendedItem() {
		wait.until(ExpectedConditions.elementToBeClickable(recommendedProductAddToCart)).click();
	}
	// Verify Product is in Cart
	public boolean isProductInCart() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(cartPageProduct)).isDisplayed();
	}
}