package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	/**
	 * WebDriver Object
	 */
	protected WebDriver driver;
	
	/**
	 * Loads the driver
	 * @param browser
	 */
	private void setUp (String browser) {
		
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/chromedriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
	}
}
