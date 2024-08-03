package com.automationpractice.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.GeckoDriverService;

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
	public WebDriver createDriver(String browser) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");

		switch (browser.toLowerCase()) {
			case "chrome":
				log.info("Creating Chrome browser instance");
				ChromeDriverService chromeService = ChromeDriverService.createDefaultService();
				driver.set(new ChromeDriver(chromeService, options));
				break;
			case "firefox":
				log.info("Creating Firefox browser instance");
				FirefoxDriverService firefoxService = GeckoDriverService.createDefaultService();
				driver.set(new FirefoxDriver(firefoxService));
				break;
			case "edge":
				log.info("Creating Edge browser instance");
				EdgeDriverService edgeService = EdgeDriverService.createDefaultService();
				driver.set(new EdgeDriver(edgeService));
				break;
			default:
				log.info("Unable to resolve specified browser, creating Chrome browser instance by default");
				ChromeDriverService defaultService = ChromeDriverService.createDefaultService();
				driver.set(new ChromeDriver(defaultService, options));
				break;
		}
		return driver.get();
	}
}
