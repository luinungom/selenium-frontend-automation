package com.automationpractice.base.pagecontainers;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.base.BaseTest;

/**
 * This class contains all web elements that belong to the web page header
 * 
 * @author Luis Núñez Gómez
 *
 */
public class HeaderContainer extends BaseTest{

	
	// Locators
	
	By logo = By.id("header_logo");
	By searchBar = By.id("search_query_top");
	
	
	// Constructor
	public HeaderContainer(WebDriver driver, Logger log) {
	

		}
}
