package com.automationpractice.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Listeners({ TestListener.class })

/**
 * This class loads and closes the driver instance, it also provides a getter
 * method to get the driver's instance
 *
 * @author Luis Núñez
 *
 */
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
		driver.quit();
	}
	
	/**
	 * Getter to get driver's instances
	 * @return WebDriver;
	 */
	public WebDriver getDriver(){
		return driver;
	}
}
