package com.automationpractice.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	/**
	 * WebDriver Object
	 */
	protected WebDriver driver;
	protected Logger log;
	
	/**
	 * Loads the driver
	 * @param browser
	 */
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	public void setUp (@Optional("chrome") String browser, ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		BrowserDriverFactory factory = new BrowserDriverFactory(log);
		driver = factory.createDriver(browser);
		// Maximizes the browser window
		driver.manage().window().maximize();
	}
	
	/**
	 * Closes the driver instance
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		log.info("Closing driver instance");
		driver.close();
	}
	
	/**
	 * Getter to get driver instances
	 * @return WebDriver;
	 */
	public WebDriver getDriver(){
		return driver;
	}
}
