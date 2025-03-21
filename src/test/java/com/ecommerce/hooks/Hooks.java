package com.ecommerce.hooks;

import com.ecommerce.utils.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriver driver;

    @Before
    public void setupBrowser() {
        String browser = System.getProperty("browser", "chrome"); //  Defaults to Chrome if no browser is set
        DriverManager.setBrowser(browser);
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        System.out.println("✅ Browser initialized: " + browser);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
        System.out.println("Browser closed successfully.");
    }
}
