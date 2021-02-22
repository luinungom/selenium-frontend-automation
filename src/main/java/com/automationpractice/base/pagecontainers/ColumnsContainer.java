package com.automationpractice.base.pagecontainers;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

/**
 * This class contains all web elements and related actions that belong to 
 * the web page columns container (authentication).
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
	By maleRadioButton = By.id("id_gender1");
	By stateDropDown = By.id("id_state");
	By zipCodeDropdown = By.id("postcode");
	By countryDropdown = By.id("id_country");
	By mobilePhoneTextbox = By.id("phone_mobile");
	By addressAliasTextbox = By.id("addressAlias");
	
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
	
	@Step("Selecting Male radio button")
	public void selectMaleRadioButton() {
		log.info("Selecting Male radio button");
		click(maleRadioButton);
	}
	
	@Step("Selecting state {0} in the 'State' dropdown")
	public void selectStateDropDown(String state) {
		log.info("Selecting state "+state+" in the 'State' dropdown");
		dropDownSelector(stateDropDown, state);
	}
	
	@Step("Inserting user's zip code {0} in the textbox")
	public void insertZipCode(String zipCode) {
		log.info("Inserting the user's zip code "+zipCode+" in the textbox");
		cleanAndTypeTextbox(zipCodeDropdown, zipCode);
	}
	
	@Step("Selecting country {0} in the 'Country' dropdown")
	public void selectCountryDropDown(String country) {
		log.info("Selecting country "+country+" in the 'Country' dropdown");
		dropDownSelector(countryDropdown, country);
	}
	
	@Step("Inserting user's mobile phone {0} in the textbox")
	public void insertMobilePhone(String phone) {
		log.info("Inserting the user's mobile phone "+phone+"in the textbox");
		cleanAndTypeTextbox(mobilePhoneTextbox, phone);
	}
	
	@Step("Inserting the user's address alias \"{0}\" in the textbox")
	public void insertAdressAlias(String addressAlias) {
		log.info("Inserting the user's address alias \""+addressAlias+"\" in the textbox");
		cleanAndTypeTextbox(addressAliasTextbox, addressAlias);
	}

}
