package com.automationpractice;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automationpractice.base.BaseTest;
import com.automationpractice.base.CsvDataProviders;
import com.automationpractice.base.TestUtilities;
import com.automationpractice.base.pagecontainers.ColumnsContainer;
import com.automationpractice.base.pagecontainers.HeaderContainer;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * This class contains all ordering/buying related tests.
 * 
 * @author Luis Núñez
 *
 */

public class OrderingTests extends BaseTest{
	
	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class, description = "Order a product in the web site")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Order/Buying functionality")
	@Description("Automate End to End Buy Order a product in the website")
	public void orderProduct(Map <String, String> testData) {
		
		// Data extracted from the .csv file
		String email = testData.get("email");
		String password = testData.get("password");
		String product = testData.get("product");
		int quantity = Integer.parseInt(testData.get("quantity"));
		String size = testData.get("size");
		String color = testData.get("color");
		
		// Instance necessary web site components	
		HeaderContainer header = new HeaderContainer(driver, log);
		ColumnsContainer columns = new ColumnsContainer(driver, log);
		
		// Automated Actions		
		// Navigate to the web site
		driver.get("http://automationpractice.com/index.php");
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Clicking in the Sign In button
		header.clickSigInLink();
		// Inserting user's email
		columns.insertEmailAddress(email);
		// Inserting user's password
		columns.insertPassword(password);
		// Clicking the Sign In button
		columns.clickSignInButton();
		// Clicking the women link
		header.hoverOverWomenLink();
		// Clicking the T-Shirt link
		header.clickTShirtLink();
		// Selecting product with the specified name
		columns.productListSelection(product);
		// Selecting the specified quantity
		columns.quantitySelector(quantity);
		// Selecting the specified size
		columns.sizeSelector(size);
		// Selecting the specified color
		columns.colorSelector(color);
		// Clicking the Add to card button
		columns.clickAddToCardButton();
		// Clicking the Proceed to checkout button
		header.clickCheckOutButton();
	
		TestUtilities.sleep(50000);
	}

}
