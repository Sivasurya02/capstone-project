package com.ecommerce.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/ProductAndCart.feature",
    glue = {"com.ecommerce.stepDefinitions", "com.ecommerce.hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports-html/productAndCart.html",
        "json:target/cucumber-reports-json/productAndCart.json",
        /*"json:target/allure-results/productAndCart.json",  // ✅ Important
	    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"*/  
        },
    monochrome = true,
    dryRun = false
)
public class ProductAndCartTestRunner extends AbstractTestNGCucumberTests {
}
