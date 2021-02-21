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

	// WebElements
	By logo = By.id("header_logo");
	By searchBar = By.id("search_query_top");
	By sigInLink = By.linkText("Sign in");

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
}
