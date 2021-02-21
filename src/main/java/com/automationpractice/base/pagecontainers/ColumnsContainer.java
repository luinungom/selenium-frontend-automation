package com.automationpractice.base.pagecontainers;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

/**
 * This class contains all web elements that belong to the web page columns container (authentication).
 * 
 * @author Luis Núñez Gómez
 *
 */

public class ColumnsContainer extends BasePageObject{

	// WebElements
	By emailTextBox = By.id("email_create");
	By createAccountButton = By.id("SubmitCreate");
	By firstNameTextbox = By.id("customer_firstname");
	By lastNameTextbox = By.id("customer_lastname");
	By passwordTextbox = By.id("passwd");
	By addressTextbox = By.id("address1");
	By cityTextbox = By.id("city");
	
	// Constructor
	public ColumnsContainer(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	@Step("Inserting email address {0} in the textbox")
	public void insertEmailAddress(String emailAddress) {
		log.info("Inserting email address "+emailAddress+" in the textbox");
		cleanAndTypeTextbox(emailTextBox, emailAddress);
	}
	
	@Step("Clicking the \"Create an account\" button")
	public void clickCreateAccountButton() {
		log.info("Clicking the \"Create an account\" button");
		click(createAccountButton);
	}
	
	@Step("Inserting user first name \"{0}\" in the textbox")
	public void insertFirstName(String firstName) {
		log.info("Inserting user first name "+firstName+" in the textbox");
		cleanAndTypeTextbox(firstNameTextbox, firstName);
	}
	
	@Step("Inserting user last name \"{0}\" in the textbox")
	public void insertLastName(String lastName) {
		log.info("Inserting user last name \""+lastName+"\" in the textbox");
		cleanAndTypeTextbox(lastNameTextbox, lastName);
	}
	
	@Step("Inserting user password \"{0}\" in the textbox")
	public void insertPassword(String password) {
		log.info("Inserting user password \""+password+"\" in the textbox");
		cleanAndTypeTextbox(passwordTextbox, password);
	}
	
	@Step("Inserting user address \"{0}\" in the textbox")
	public void insertAddress(String address) {
		log.info("Inserting user address \""+address+"\" in the textbox");
		cleanAndTypeTextbox(addressTextbox, address);
	}
	
	@Step("Inserting user city \"{0}\" in the textbox")
	public void insertCity(String city) {
		log.info("Inserting user city \""+city+"\" in the textbox");
		cleanAndTypeTextbox(cityTextbox, city);
	}
	

}
