package com.automationpractice.base;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;

public class BaseTest {

	/**
	 * WebDriver Object
	 */
	protected WebDriver driver;
	
	/**
	 * Loads the driver
	 * @param browser
	 */
	@BeforeMethod(alwaysRun = true)
	private void setUp (String browser) {
		BrowserDriverFactory factory = new BrowserDriverFactory();
		driver = factory.createDriver(browser);
		// Maximizes the browser window
		driver.manage().window().maximize();
	}
	
	/**
	 * Closes the driver instance
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
}
