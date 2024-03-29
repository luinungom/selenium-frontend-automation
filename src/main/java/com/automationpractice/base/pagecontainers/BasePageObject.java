package com.automationpractice.base.pagecontainers;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

/**
 * Contains all testing common methods
 * @author Luis Núñez
 *
 */
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
		waitElementToBeClickable(locator);
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
	@Step("Waiting {1} seconds max until the element with locator {0} is visible")
	protected void waitForVisibilityOf(By locator, Integer timeInSeconds) {
		log.info("Waiting "+timeInSeconds+" seconds max until the element with locator "+locator+" is visible");
		for(int i = 0; i<2; i++) {
			try {
			waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(locator), (timeInSeconds));
			}catch(StaleElementReferenceException e) {
				log.info("Error, element is never visible");
			}
		}
	}
	
	/**
	 * Waits for the specified amount of seconds until the element is visible.
	 * @param locator of the element to check visibility
	 * @param timeInSeconds seconds to wait
	 */
	@Step("Waiting 30 seconds max until the element with locator {0} is clickable")
	protected void waitElementToBeClickable(By locator) {
		log.info("Waiting 30 seconds max until the element with locator "+locator+" is clickable");
		for(int i = 0; i<2; i++) {
			try {
			waitForExpectedCondition(ExpectedConditions.elementToBeClickable(locator), (30));
			}catch(StaleElementReferenceException e) {
				log.info("Error, element is never clickable");
			}
		}
	}
	
	/**
	 * Waits 30 seconds max until the element is visible. Overloaded version.
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
	//@Step("Waiting {0} second(s) max until condition {1} occurs")
	protected void waitForExpectedCondition(ExpectedCondition<WebElement>condition, Integer timeOutInSeconds) {
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
		driver.findElement(locator).sendKeys(Keys.CONTROL + "a");
		driver.findElement(locator).sendKeys(Keys.DELETE);
		driver.findElement(locator).sendKeys(text);
	}
	
	
	/**
	 * It selects an option from a drop down based on the option's visible text
	 * @param locator for the drop down
	 * @param value option's visible text
	 */
	@Step("Selecting value {1} from the drowpdown {0}")
	protected void dropDownSelector(By locator, String value) {
		log.info("Selecting value "+value+" from the drowpdown "+locator);
		Select dropDown = new Select(find(locator));
		dropDown.selectByVisibleText(value);
	}
	
	/**
	 * Hovers over an element
	 * @param locator for the element
	 */
	@Step("Hovering over {0} web element")
	protected void hoverOver(By locator) {
		log.info("Hovering over "+locator+" web element");
		waitForVisibilityOf(locator);
		Actions hover = new Actions(driver);
		WebElement target = driver.findElement(locator);
		hover.moveToElement(target);
		hover.perform();
		hover.build();
	}
	
	/**
	 * Overloaded version of the hoverOver method to accept a WebElement as
	 * parameter
	 * @param element WebElement
	 */
	@Step("\"Hovering over {0} web element\"")
	protected void hoverOver(WebElement element) {
		log.info("Hovering over "+element+" web element");
		Actions hover = new Actions(driver);
		hover.moveToElement(element);
		hover.perform();
		hover.build();
	}
	
	// Assertions
	
	/**
	 * Checks if 2 different texts match
	 * @param actualText
	 * @param expectedText
	 */
	@Step("Verifying if found text {0} matches expected text {1}")
	protected void assertEqualText(String actualText, String expectedText) {
		log.info("Verifying if found text \""+actualText+"\" matches expected text \""+expectedText+"\"");
		Assert.assertEquals(actualText, expectedText, "Found text "+actualText+" does not match expected text "+expectedText);
	}
	
	/**
	 * Checks if an specific string is contained in a sentence
	 * @param actualText
	 * @param textToBeFound
	 */
	@Step("Verifying if word {1} is contained in the sentence {0}")
	protected void assertContainsText(String actualText, String textToBeFound) {
		log.info("Verifying if word "+textToBeFound+" is contained in the sentence "+actualText);
		Assert.assertTrue(actualText.contains(textToBeFound), "Error, word "+textToBeFound+" is mising in the sentence '"+actualText+"'");
	}
	
}
