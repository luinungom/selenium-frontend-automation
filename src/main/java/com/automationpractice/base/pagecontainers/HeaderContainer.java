package com.automationpractice.base.pagecontainers;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

/**
 * This class contains all web elements that belong to the web page header.
 * 
 * @author Luis Núñez Gómez
 *
 */
public class HeaderContainer extends BasePageObject {

	// Locators
	By logo = By.id("header_logo");
	By searchBar = By.id("search_query_top");
	By sigInLink = By.linkText("Sign in");
	By userName = By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a");
	By womenLink = By.linkText("WOMEN");
	By tShirtLink = By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul//a[@title='T-shirts']");
	By checkOutButton = By.linkText("Proceed to checkout");

	// Constructor
	public HeaderContainer(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	@Step("Performing a search in the header search bar with text \"{0}\"")
	public void headerSearchBar(String text) {
		log.info("Performing a search in the header search bar with text \""+text+"\"");
		cleanAndTypeTextbox(searchBar, text);
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
	}
	
	@Step("Clicking the Sign In link")
	public void clickSigInLink() {
		log.info("Clicking the Sign In link");
		click(sigInLink);
	}
	
	@Step("Verifying found user name against expected user name")
	public void verifyUserName(String expectedName) {
		log.info("Verifying found user name against expected user name");
		String actualUserName = driver.findElement(userName).getText();
		assertEqualText(actualUserName, expectedName);
	}
	
	@Step("Hover over the women link")
	public void hoverOverWomenLink() {
		log.info("Hover over the women link");
		hoverOver(womenLink);
	}
	
	/**
	 * Clicks the T-shirt link
	 */
	@Step("Clicking the T-Shirt link")
	public void clickTShirtLink() {
		log.info("Clicking the T-Shirt link");
		click(tShirtLink);
	}
	
	/**
	 * Clicks in the Proceed to checkout button
	 */
	@Step("Clicking the Proceed to checkout button")
	public void clickCheckOutButton() {
		log.info("Clicking the Proceed to checkout button");
		click(checkOutButton);
	}
}
