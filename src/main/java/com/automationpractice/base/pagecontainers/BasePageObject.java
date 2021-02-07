package com.automationpractice.base.pagecontainers;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject{

	protected WebDriver driver;
	protected Logger Log;
	
	/**
	 * Constructor
	 * @param driver
	 * @param log
	 */
	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.Log = log;
	}
	
	/**
	 * Waits until the specified element is visible and then clicks.
	 * on it.
	 * @param locator for the web element
	 */
	protected void click(By locator) {
		waitForVisibilityOf(locator);
		find(locator).click();
	}

	/**
	 * Returns the WebElement for the specified locator.
	 * @param locator for the web element
	 * @return WebElement
	 */
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}

	protected void waitForVisibilityOf(By locator) {
		
	}
	
	/**
	 * Waits for the specified amount of seconds until the expected condition
	 * happens.
	 * @param contition that must occur
	 * @param timeOutInSeconds seconds to wait
	 */
	@SuppressWarnings("unused")
	protected void waitForExpectedCondition(ExpectedCondition<WebElement>contition, Integer timeOutInSeconds) {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(contition);
		}
	
	/**
	 * Waits for 30 seconds until the expected condition happens.
	 * @param contition
	 */
	@SuppressWarnings("unused")
	protected void waitForExpectedCondition(ExpectedCondition<WebElement>contition) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(contition);
	}
	
	/**
	 * Returns the current URL.
	 * @return Sting URL
	 */
	protected String getURL() {
		return driver.getCurrentUrl();
	}
	
	/**
	 * Insert text, first checks if the text box is clear, if not it will clear it
	 * before inserting the text.
	 * @param locator for the text box
	 * @param text to be inserted
	 */
	protected void cleanAndWriteTextbox(By locator, String text) {
		String oldText = driver.findElement(locator).getText();
		if(oldText.length() !=0) {
			driver.findElement(locator).clear();
		}
		driver.findElement(locator).sendKeys(text);
	}
	
	
}
