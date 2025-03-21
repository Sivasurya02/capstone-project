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
public class CategoriesAndBrandPage {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	public CategoriesAndBrandPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.actions = new Actions(driver);
	}

	// Home Page Locators
	private By homePageBanner = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img"); // Home page verification
	private By productsButton = By.xpath("//a[contains(text(),'Products')]"); // Products menu button
	private By allProductsHeader = By.xpath("//h2[contains(text(),'All Products')]"); // ALL PRODUCTS page header

	//Search Product 
	private By searchInput = By.id("search_product"); // Search input field
	private By searchButton = By.id("submit_search"); // Search button
	private By searchResultsHeader = By.xpath("//h2[contains(text(),'Searched Products')]"); // "SEARCHED PRODUCTS" text
	private By searchResultsItems = By.xpath("//div[@class='productinfo text-center']"); // List of searched products

	// Add to Cart from Search Results 
	private By firstSearchedProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]"); // First searched product
	private By secondSearchedProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]"); // Second searched product
	private By thirdSearchedProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[4]/div/div[1]/div[1]"); // Third searched product
	private By firstProductAddToCart = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a"); // Add to cart for first product
	private By secondProductAddToCart = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a"); // Add to cart for second product
	private By thirdProductAddToCart = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[4]/div/div[1]/div[2]/div/a"); // Add to cart for third product

	//  Cart Actions
	private By continueShoppingButton = By.xpath("//button[contains(text(),'Continue Shopping')]"); // Continue Shopping in alert
	private By viewCartButton = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"); // View Cart in alert
	private By cartPage = By.xpath("//h2[contains(text(),'Shopping Cart')]"); // Shopping cart page
	private By cartItems = By.xpath("//tbody/tr"); // Cart items
	private By removeProductButton = By.xpath("//a[@class='cart_quantity_delete']"); // Remove product (X button)
	private By emptyCartMessage = By.xpath("//*[@id=\"empty_cart\"]/p/b"); // "Cart is empty" message
	private By cartButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"); // "Cart is empty" message

	//  Login and Cart Verification
	private By signupLoginButton = By.xpath("//a[contains(text(),'Signup / Login')]"); // Sign up / Login button
	private By emailField = By.xpath("//input[@data-qa='login-email']"); // Email input field
	private By passwordField = By.xpath("//input[@data-qa='login-password']"); // Password input field
	private By loginButton = By.xpath("//button[@data-qa='login-button']"); // Login button

	//Locators for TC18
    private By categoriesSection = By.xpath("//div[@class='left-sidebar']//h2[contains(text(),'Category')]");
    private By womenCategory = By.xpath("//a[@href='#Women']");
    private By womenCategorySection = By.xpath("//*[@id='Women']/div/ul"); // Expanded section
    private By dressSubCategory = By.xpath("//*[@id='Women']/div/ul/li[1]/a"); // Dress under WomEN
    private By menCategory = By.xpath("//a[@href='#Men']");
    private By menCategorySection = By.xpath("//*[@id='Men']/div/ul"); // Expanded section
    private By tShirtSubCategory = By.xpath("//*[@id='Men']/div/ul/li[1]/a"); // T-Shirts under MeN
    private By womenDressProductsHeader = By.xpath("//h2[contains(text(),'Women - Dress Products')]");
    private By menTShirtsProductsHeader = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
    

    // Locators for TC 19
    private By mastAndHarbourBrand = By.xpath("/html/body/section[2]/div/div/div[1]/div[1]/div[2]/div/ul/li[4]/a"); // Used to check brand section visibility
    private By brandsSection = By.xpath("//h2[contains(text(),'Brands')]");
    private By poloBrand = By.xpath("/html/body/section[2]/div/div/div[1]/div[1]/div[2]/div/ul/li[1]/a");
    private By hAndMBrand = By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[2]/a");
    private By brandPageHeader = By.xpath("//h2[@class='title text-center']"); // Generic header for brand page verification

	// Methods Implementing TC 20

	// Verify Home Page is Visible
	public boolean isHomePageVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(homePageBanner)).isDisplayed();
	}

	// Click "Products" Button
	public void clickProductsButton() {
		driver.findElement(productsButton).click();
	}

	// Verify ALL PRODUCTS Page is Visible
	public boolean isAllProductsPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsHeader)).isDisplayed();
	}

	// Search for a Product
	public void searchForProduct(String productName) {
		driver.findElement(searchInput).sendKeys(productName);
		driver.findElement(searchButton).click();
	}

	// Verify "SEARCHED PRODUCTS" Text is Visible
	public boolean isSearchedProductsVisible() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsHeader)).isDisplayed();
	}

	// Verify All Searched Products are Displayed
	public boolean areAllSearchedProductsDisplayed() {
		List<WebElement> elements = driver.findElements(searchResultsItems);
		return elements.size() > 0;
	}

	// Hover and Add First Product to Cart
	public void hoverAndAddFirstProductToCart() {
		actions.moveToElement(driver.findElement(firstSearchedProduct)).perform();
		wait.until(ExpectedConditions.elementToBeClickable(firstProductAddToCart)).click();
	}

	// Hover and Add Second Product to Cart
	public void hoverAndAddSecondProductToCart() {
		actions.moveToElement(driver.findElement(secondSearchedProduct)).perform();
		wait.until(ExpectedConditions.elementToBeClickable(secondProductAddToCart)).click();
	}

	// Hover and Add Third Product to Cart
	public void hoverAndAddThirdProductToCart() {
		actions.moveToElement(driver.findElement(thirdSearchedProduct)).perform();
		wait.until(ExpectedConditions.elementToBeClickable(thirdProductAddToCart)).click();
	}

	// Handle Alert Buttons (Continue Shopping / View Cart)
	public void handleCartPopupButton(String button) {
		if (button.equalsIgnoreCase("Continue Shopping")) {
			wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
		} else if (button.equalsIgnoreCase("View Cart")) {
			wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
		}
	}

	// Verify Cart Page is Visible
	public boolean isCartPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage)).isDisplayed();
	}

	// Verify Products are Visible in Cart
	public boolean isSearchedProductInCart() {
		List<WebElement> cartProducts = driver.findElements(cartItems);
		return cartProducts.size() >= 3;
	}

	// Click "Signup/Login" Button
	public void clickSignupLoginButton() {
		driver.findElement(signupLoginButton).click();
	}

	// Enter Login Details and Click "Login"
	public void loginWithCredentials(String email, String password) {
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
	}

	// Click "Cart" Button Again After Login
	public void clickCartButtonAgainAfterLogin() {
		driver.findElement(cartButton).click();
	}

	// Verify Products Are Still in Cart After Login
	public boolean isProductStillInCartAfterLogin() {
		List<WebElement> cartProducts = driver.findElements(cartItems);
		return cartProducts.size() >= 3;
	}

	// Remove All Products from Cart
	public void removeAllProductsFromCart() {
		List<WebElement> removeButtons = driver.findElements(removeProductButton);
		for (WebElement button : removeButtons) {
			button.click();
			wait.until(ExpectedConditions.invisibilityOf(button));
		}
	}

	// Verify "Cart is Empty" Message
	public boolean isCartEmptyMessageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage)).isDisplayed();
	}
	 // Verify Categories Section is Visible
    public boolean isCategoriesSectionVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesSection)).isDisplayed();
    }

    // Click "Women" Category (With Scroll)
    public void clickWomenCategory() {
        WebElement womenCategoryElement = wait.until(ExpectedConditions.elementToBeClickable(womenCategory));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", womenCategoryElement);
        womenCategoryElement.click();
    }

    // Verify "Women" Category Section is Expanded
    public boolean isWomenCategorySectionDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(womenCategorySection)).isDisplayed();
    }

    // Click "Dress" Sub-Category Under Women**
    public void clickWomenDressSubCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(dressSubCategory)).click();
    }

    // Verify "WOMEN - DRESS PRODUCTS" Page**
    public boolean isWomenDressProductsPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(womenDressProductsHeader)).isDisplayed();
    }

    // Click "Men" Category (NO Scroll, Just Click)**
    public void clickMenCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(menCategory)).click();
    }

    // Verify "Men" Category Section is Expanded
    public boolean isMenCategorySectionDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(menCategorySection)).isDisplayed();
    }

    // Click "T-Shirts" Sub-Category Under Men
    public void clickMenTShirtSubCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(tShirtSubCategory)).click();
    }

    // Verify "MEN - T-SHIRTS PRODUCTS" Page

    public boolean isMenTShirtsProductsPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(menTShirtsProductsHeader)).isDisplayed();
    }
   
    //  Scroll to and Verify Brand Section - TC 19
    public boolean isBrandSectionVisible() {
        WebElement brandElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mastAndHarbourBrand));

        // Scroll to brand section
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", brandElement);

        // Check if Brands section is visible
        return brandElement.isDisplayed();
    }

    // Click on First Brand (Polo)
    public void clickPoloBrand() {
        wait.until(ExpectedConditions.elementToBeClickable(poloBrand)).click();
    }

    // Click on Second Brand (H&M)
    public void clickHAndMBrand() {
        wait.until(ExpectedConditions.elementToBeClickable(hAndMBrand)).click();
    }

    // Verify Brand Page is Displayed
    public boolean isBrandPageDisplayed(String expectedText) {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(brandPageHeader));
        return header.getText().contains(expectedText);
    }

}

