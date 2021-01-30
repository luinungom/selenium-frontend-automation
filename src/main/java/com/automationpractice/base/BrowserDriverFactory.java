package com.automationpractice.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Handles driver creation
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
	 * Loads the driver
	 * @param browser browser that will be launched
	 */
	public WebDriver createDriver (String browser) {
		
		switch(browser) {
		case "chrome":
			log.info("Creating Chrome browser instance");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			log.info("Creating Firefox browser instance");
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver.set(new FirefoxDriver());
			break;
		default:
			log.info("Unable to resolve specified browser, creating Chrome browser instance by default");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		}
		
		return driver.get();
	}
}
