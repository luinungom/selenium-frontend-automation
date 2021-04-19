package com.automationpractice.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class handles driver creation, it allows to generate different drivers
 * depending on the browser
 */
public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger log;
	
	/**
	 * Constructor
	 */
	public BrowserDriverFactory (Logger log) {
		this.log = log;
	}
	
	/**
	 * Loads the driver, it uses an accessory WebDriverManager library for the driver binaries
	 * @param browser that will be launched
	 */
	public WebDriver createDriver (String browser) {
		
		switch(browser.toLowerCase()) {
		case "chrome":
			log.info("Creating Chrome browser instance");
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			log.info("Creating Firefox browser instance");
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			break;
		default:
			log.info("Unable to resolve specified browser, creating Chrome browser instance by default");
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		}
		
		return driver.get();
	}
}
