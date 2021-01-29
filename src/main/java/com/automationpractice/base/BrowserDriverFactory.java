package com.automationpractice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Handles driver creation
 */
public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	/**
	 * Constructor
	 */
	public BrowserDriverFactory () {
	}
	
	/**
	 * Loads the driver
	 * @param browser browser that will be launched
	 */
	public WebDriver createDriver (String browser) {
		
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/chromedriver.exe");
			driver.set(new FirefoxDriver());
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		}
		
		return driver.get();
	}
}
