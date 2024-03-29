package com.automationpractice.base.pagecontainers;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;

/**
 * This class contains all web elements and related actions that belong to 
 * the web page columns container
 * 
 * @author Luis Núñez Gómez
 *
 */

public class ColumnsContainer extends BasePageObject{

	// Locators
	By createEmailTextBox = By.id("email_create");
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
	By addressAliasTextbox = By.id("alias");
	By registerButton = By.id("submitAccount");
	By welcomeAccountText = By.xpath("//p[@class='info-account']");
	By emailTextbox = By.id("email");
	By loginButton = By.id("SubmitLogin");
	By incorrectCreateEmailErrorMessage = By.xpath("//div[@id='create_account_error']//li[.='Invalid email address.']");
	By productsList = By.xpath("//div[@id='center_column']/ul");
	By productMoreButton = By.xpath("//div[@id='center_column']/ul//div[@class='product-container']//a[@title='View']/span[.='More']");
	By quantityTextbox = By.id("quantity_wanted");
	By increaseQuantityButton = By.cssSelector("p#quantity_wanted_p > .btn.btn-default.button-plus.product_quantity_up");
	By decreaseQuantityButton = By.cssSelector("p#quantity_wanted_p > .btn.btn-default.button-minus.product_quantity_down");
	By sizeDropdown = By.id("group_1");
	By colorPicker = By.id("color_to_pick_list");
	By addToCartButton = By.xpath("//p[@id='add_to_cart']/button[@name='Submit']");
	By currentStepIndicator = By.id("order_step");
	By summaryProceedToCheckoutButton = By.xpath("//div[@id='center_column']//a[@title='Proceed to checkout']");
	By addressProceedToCheckoutButton = By.xpath("//button[contains(@class,'button') and @name='processAddress']");
	By termsCheckbox = By.id("uniform-cgv");
	By shippingProceedToCheckoutButton = By.xpath("//form[@id='form']//button[@name='processCarrier']/span");
	By payBankWireButton = By.linkText("Pay by bank wire (order processing will be longer)");
	By payCheckButton = By.linkText("Pay by check (order processing will be longer)");
	By orderConfirmationButton = By.xpath("//p[@id='cart_navigation']/button[@type='submit']");
	By orderResultText = By.xpath("//p[@class='cheque-indent']//strong[@class='dark']");
	
	// Constructor
	public ColumnsContainer(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	// Methods
	
	/**
	 * Inserts the email's text in the Create email text box
	 * @param emailAddress String
	 */
	@Step("Inserting email address {0} in the text box")
	public void insertCreateEmailAddress(String emailAddress) {
		log.info("Inserting email address "+emailAddress+" in the text box");
		cleanAndTypeTextbox(createEmailTextBox, emailAddress);
	}
	
	/**
	 * Clicks the Create account button
	 */
	@Step("Clicking the \"Create an account\" button")
	public void clickCreateAccountButton() {
		log.info("Clicking the \"Create an account\" button");
		click(createAccountButton);
	}
	
	/**
	 * Inserts the first name in the First Name text box
	 * @param firstName String
	 */
	@Step("Inserting user first name \"{0}\" in the text box")
	public void insertFirstName(String firstName) {
		log.info("Inserting user first name "+firstName+" in the text box");
		cleanAndTypeTextbox(firstNameTextbox, firstName);
	}
	
	/**
	 * Inserts the last name in the Last Name text box
	 * @param lastName String
	 */
	@Step("Inserting user last name \"{0}\" in the text box")
	public void insertLastName(String lastName) {
		log.info("Inserting user last name \""+lastName+"\" in the text box");
		cleanAndTypeTextbox(lastNameTextbox, lastName);
	}
	
	/**
	 * Inserts the password in the Password text box
	 * @param password String
	 */
	@Step("Inserting user password \"{0}\" in the text box")
	public void insertCreatePassword(String password) {
		log.info("Inserting user password \""+password+"\" in the text box");
		cleanAndTypeTextbox(passwordTextbox, password);
	}
	
	/**
	 * Inserts the user address in the Address text box
	 * @param address String
	 */
	@Step("Inserting user address \"{0}\" in the text box")
	public void insertAddress(String address) {
		log.info("Inserting user address \""+address+"\" in the text box");
		cleanAndTypeTextbox(addressTextbox, address);
	}
	
	/**
	 * Inserts the user city in the City text box
	 * @param city String
	 */
	@Step("Inserting user city \"{0}\" in the text box")
	public void insertCity(String city) {
		log.info("Inserting user city \""+city+"\" in the text box");
		cleanAndTypeTextbox(cityTextbox, city);
	}
	
	/**
	 * Selects the Male option
	 */
	@Step("Selecting Male radio button")
	public void selectMaleRadioButton() {
		log.info("Selecting Male radio button");
		click(maleRadioButton);
	}
	
	/**
	 * Selects the specified option in the State drop down
	 * @param state String
	 */
	@Step("Selecting state {0} in the 'State' dropdown")
	public void selectStateDropDown(String state) {
		log.info("Selecting state "+state+" in the 'State' dropdown");
		dropDownSelector(stateDropDown, state);
	}
	
	/**
	 * Inserts the zip code in the Zip Code text box
	 * @param zipCode String
	 */
	@Step("Inserting user's zip code {0} in the textbox")
	public void insertZipCode(String zipCode) {
		log.info("Inserting the user's zip code "+zipCode+" in the textbox");
		cleanAndTypeTextbox(zipCodeDropdown, zipCode);
	}
	
	/**
	 * Selects the country option in the Country drop down
	 * @param country String
	 */
	@Step("Selecting country {0} in the 'Country' dropdown")
	public void selectCountryDropDown(String country) {
		log.info("Selecting country "+country+" in the 'Country' dropdown");
		dropDownSelector(countryDropdown, country);
	}
	
	/**
	 * Inserts the mobile phone number in the Mobile Phone text box
	 * @param phone String
	 */
	@Step("Inserting user's mobile phone {0} in the textbox")
	public void insertMobilePhone(String phone) {
		log.info("Inserting the user's mobile phone "+phone+"in the textbox");
		cleanAndTypeTextbox(mobilePhoneTextbox, phone);
	}
	
	/**
	 * Inserts the address alias in the Address Alias text box
	 * @param addressAlias
	 */
	@Step("Inserting the user's address alias \"{0}\" in the textbox")
	public void insertAdressAlias(String addressAlias) {
		log.info("Inserting the user's address alias \""+addressAlias+"\" in the textbox");
		cleanAndTypeTextbox(addressAliasTextbox, addressAlias);
	}
	
	/**
	 * Clicks the 'Register' button
	 */
	@Step("Clicking the register button")
	public void clickRegisterButton() {
		log.info("Clicking the register button");
		click(registerButton);
	}
	
	/**
	 * Inserts the provided email
	 * @param String emailAddress
	 */
	@Step("Inserting email address {0} in the textbox")
	public void insertEmailAddress(String emailAddress) {
		log.info("Inserting email address "+emailAddress+" in the textbox");
		cleanAndTypeTextbox(emailTextbox, emailAddress);
	}
	
	/**
	 * Inserts the provided password string
	 * @param String password
	 */
	@Step("Inserting user password \"{0}\" in the textbox")
	public void insertPassword(String password) {
		log.info("Inserting user password \""+password+"\" in the textbox");
		cleanAndTypeTextbox(passwordTextbox, password);
	}
	
	/**
	 * Clicks the 'Sign In' button
	 */
	@Step("Clicking the \"Sign In\" button")
	public void clickSignInButton() {
		log.info("Clicking the \"Sign In\" button");
		click(loginButton);
	}
	
	/**
	 * Verifies if the incorrect email message is displayed and the present text
	 * @param String expectedErrorMessage
	 */
	@Step("Verifing the incorrect email error text")
	public void verifyIncorrectEmailErrorMessage(String expectedErrorMessage) {
		log.info("Verifing the incorrect email error text");
		String actualErrorMessage = driver.findElement(incorrectCreateEmailErrorMessage).getText();
		assertEqualText(actualErrorMessage, expectedErrorMessage);
	}
	
	/**
	 * Hovers and clicks the 'More' button of the specified product from the product
	 * list
	 * @param String productName
	 */
	@Step("Selecting 'More' view for the product '{0}'")
	public void productListSelection(String productName) {
		log.info("Selecting 'More' view for the product "+productName);
		WebElement productsGrid = driver.findElement(productsList);
		List <WebElement> productsList = productsGrid.findElements(By.className("product_img_link"));
		for(WebElement p : productsList) {
			if(p.getAttribute("title").equals(productName)) {
				hoverOver(p);
				click(productMoreButton);
			}
		}
	}
	
	/**
	 * Checks the initial units of the product and increases/decreases the quantity
	 * until it matches the expected one.
	 * @param int quantity
	 */
	@Step("Selecting {0} units of the product")
	public void quantitySelector(int quantity) {
		log.info("Selecting "+quantity+" units of the product");
		int selectedQuantity;
		do {
			selectedQuantity = Integer.parseInt(driver.findElement(quantityTextbox).getAttribute("value"));
			if(selectedQuantity < quantity) {
				click(increaseQuantityButton);
			}
			if(selectedQuantity > quantity) {
				click(decreaseQuantityButton);
			}
		}while(selectedQuantity != quantity);
	}
	
	/**
	 * Selects the specified size from the size drop down selector
	 * @param String size
	 */
	@Step("Selecting size {0}")
	public void sizeSelector(String size) {
		log.info("Selecting size "+size);
		dropDownSelector(sizeDropdown, size);
	}
	
	/**
	 * Selects the specified color from the color picker
	 * @param String color
	 */
	@Step("Selecting color {0}")
	public void colorSelector(String color) {
		log.info("Selecting color "+color);
		WebElement availableColors = find(colorPicker);
		List <WebElement> colorList = availableColors.findElements(By.className("color_pick"));
		for(WebElement c : colorList) {
			if(c.getAttribute("name").equalsIgnoreCase(color)) {
				c.click();
			}
		}
	}
	
	/**
	 * Clicks the Add to cart button
	 */
	@Step("Clicking the Add to cart button")
	public void clickAddToCardButton() {
		log.info("Clicking the Add to cart button");
		click(addToCartButton);
	}
	
	/**
	 * Clicks the Proceed to checkout button in the summary page
	 */
	@Step("Clicking the Proceed to checkout button in the summary page")
	public void clickSummaryProceedToCheckoutButton() {
		log.info("Clicking the Proceed to checkout button in the summary page");
		click(summaryProceedToCheckoutButton);
	}
	
	
	/**
	 * Clicks the Proceed to checkout button in the address page
	 */
	@Step("Clicking the Proceed to checkout button in the address page")
	public void clickAddressProceedToCheckoutButton() {
		log.info("Clicking the Proceed to checkout button in the address page");
		click(addressProceedToCheckoutButton);
	}
	
	/**
	 * Checks the Terms of service check box if it is unchecked
	 */
	@Step("Check the Terms of service check box")
	public void checkTermsCheckbox() {
		log.info("Check the Terms of service check box");
		WebElement checkbox = find(termsCheckbox);
		if(!checkbox.isSelected()) {
			click(termsCheckbox);
		}
	}
	
	
	/**
	 * Clicks the Proceed to checkout button in the shipping page
	 */
	@Step("Clicking the Proceed to checkout button in the shipping page")
	public void clickShippingProceedToCheckoutButton() {
		log.info("Clicking the Proceed to checkout button in the shipping page");
		click(shippingProceedToCheckoutButton);
	}
	
	/**
	 * Advances the checkout process trough the different checkout pages
	 */
	public void autoProceedToCheckoutClicker() {
		WebElement stepSelector = find(currentStepIndicator);
		List <WebElement> steps = stepSelector.findElements(By.className("step_todo"));
		if(steps.size()==4) {
			clickSummaryProceedToCheckoutButton();
		}else if(steps.size()==2) {
			clickAddressProceedToCheckoutButton();
		}else if(steps.size()==1) {
			clickShippingProceedToCheckoutButton();
		}
	}
	
	/**
	 * Selects one payment option based on the provided parameter, if the parameter is not provided it
	 * selects 'bank wire' as default option
	 * @param option payment method
	 */
	@Step("Clicking option '{0}' as payment method")
	public void paymentSelector(String option) {
		log.info("Clicking "+option+" as payment method");
		if(option.contains("wire")) {
			click(payBankWireButton);
		}else if(option.contains("check")) {
			click(payCheckButton);
		}else {
			log.info("Unable to identify the provided payment method, selecting 'bank wire' as default");
			click(payBankWireButton);
		}
	}
	
	/**
	 * Clicks the Confirm my order button
	 */
	@Step("Clicking Confirm my order button")
	public void clickConfirmOrderButton() {
		log.info("Clicking Confirm my order button");
		click(orderConfirmationButton);
	}
	
	/**
	 * Verifies if the order has been completed
	 * @param textToBeFound
	 */
	@Step("Verifying if the order has been completed")
	public void verifyOrderConfirmationText(String textToBeFound) {
		String actualOrderResult = find(orderResultText).getText();
		assertContainsText(actualOrderResult, textToBeFound);
	}
}
	
