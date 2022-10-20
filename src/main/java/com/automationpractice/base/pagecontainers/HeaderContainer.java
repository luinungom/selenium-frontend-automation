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
	By userName = By.xpath("//a[@class='login']");
	By logedUserName = By.xpath("//a[@class='account']");
	By womenLink = By.linkText("WOMEN");
	By tShirtLink = By.xpath("//ul[contains(@class,'submenu-container')]//descendant::a[@title='T-shirts']");
	By checkOutButton = By.linkText("Proceed to checkout");

	// Constructor
	public HeaderContainer(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/**
	 * Performs a search in the search bar
	 * @param text String
	 */
	@Step("Performing a search in the header search bar with text \"{0}\"")
	public void headerSearchBar(String text) {
		log.info("Performing a search in the header search bar with text \""+text+"\"");
		cleanAndTypeTextbox(searchBar, text);
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
	}
	
	/**
	 * Clicks the Sign In link
	 */
	@Step("Clicking the Sign In link")
	public void clickSigInLink() {
		log.info("Clicking the Sign In link");
		click(sigInLink);
	}
	
	/**
	 * Checks if the visible user name matches the expected one
	 * @param expectedName String
	 */
	@Step("Verifying found user name against expected user name")
	public void verifyUserName(String expectedName) {
		log.info("Verifying found user name against expected user name");
		String actualUserName = find(logedUserName).getText();
		assertEqualText(actualUserName, expectedName);
	}
	
	/**
	 * Hover over the women link
	 */
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
