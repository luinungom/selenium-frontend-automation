package com.automationpractice.base.pagecontainers;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class BasePageObject{

	protected WebDriver driver;
	protected Logger log;
	
	/**
	 * Constructor
	 * @param driver
	 * @param log
	 */
	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}
	
	/**
	 * Waits until the specified element is visible and then clicks.
	 * on it.
	 * @param locator for the web element
	 */
	@Step("Clicking element {0}")
	protected void click(By locator) {
		log.info("Clicking element "+locator);
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

	/**
	 * Waits for the specified amount of seconds until the element is visible.
	 * @param locator of the element to check visibility
	 * @param timeInSeconds seconds to wait
	 */
	@Step("Waiting {1} seconds until the element with locator {0} is visible")
	protected void waitForVisibilityOf(By locator, Integer timeInSeconds) {
		log.info("Waiting "+timeInSeconds+" seconds until the element with locator "+locator+" is visible");
		for(int i = 0; i<2; i++) {
			try {
			waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(locator), (timeInSeconds));
			}catch(StaleElementReferenceException e) {
				log.info("Error, element is never visible");
			}
		}
	}
	
	/**
	 * Waits 30 seconds until the element is visible. Overloaded version.
	 * @param locator of the element to check visibility
	 */
	protected void waitForVisibilityOf(By locator) {
		waitForVisibilityOf(locator, 30);
	}
	
	/**
	 * Waits for the specified amount of seconds until the expected condition
	 * happens.
	 * @param contition that must occur
	 * @param timeOutInSeconds seconds to wait
	 */
	@Step("Waiting {0} second(s) until condition {1} occurs")
	protected void waitForExpectedCondition(ExpectedCondition<WebElement>condition, Integer timeOutInSeconds) {
		log.info("Waiting "+timeOutInSeconds+" second(s) until condition "+condition+" occurs");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(condition);
		}
	
	/**
	 * Waits for 30 seconds until the expected condition happens. Overloaded version.
	 * @param contition that must occur 
	 */
	protected void waitForExpectedCondition(ExpectedCondition<WebElement>condition) {
		waitForExpectedCondition(condition, 30);
	}
	
	/**
	 * Returns the current URL.
	 * @return Sting URL
	 */
	@Step("Retrieving the current URL")
	protected String getURL() {
		log.info("Retrieving the current URL");
		return driver.getCurrentUrl();
	}
	
	/**
	 * Insert text, first checks if the text box is clear, if not it will clear it
	 * before inserting the text.
	 * @param locator for the text box
	 * @param text to be inserted
	 */
	@Step("Inserting text \"{1}\" in the textbox")
	protected void cleanAndTypeTextbox(By locator, String text) {
		log.info("Inserting text \""+text+"\" in the textbox");
		String oldText = driver.findElement(locator).getText();
		if(oldText.length() !=0) {
			driver.findElement(locator).clear();
		}
		driver.findElement(locator).sendKeys(text);
	}
	
	
}
