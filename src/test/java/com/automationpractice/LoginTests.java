package com.automationpractice;

import com.automationpractice.base.BaseTest;
import com.automationpractice.base.CsvDataProviders;
import com.automationpractice.base.pagecontainers.ColumnsContainer;
import com.automationpractice.base.pagecontainers.HeaderContainer;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

/**
 * This class contains all user's management automated steps for the tests.
 * 
 * @author Luis Núñez
 *
 */
public class LoginTests extends BaseTest{
	
	@Test (priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class, description = "Create a new user in the system")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Users management functionality")
	@Description("Test Description: This test creates a new user in the system using only required fields")
	public void createNewUser(Map<String, String> testData) {
		
		// Data extracted from the .csv file		
		String email = testData.get("email");
		String firstName = testData.get("firstName");
		String lastName = testData.get("lastName");
		String password = testData.get("password");
		String address = testData.get("address");
		String city = testData.get("city");
		String state = testData.get("state");
		String zipCode = testData.get("zipCode");
		String country = testData.get("country");
		String phone = testData.get("phone");
		String addressAlias = testData.get("addressAlias");
		
		// Instance necessary website components
		HeaderContainer header = new HeaderContainer(driver, log);
		ColumnsContainer columns = new ColumnsContainer(driver, log);
		
		// Automated Actions		
		// Navigate to the website
		driver.get("http://automationpractice.com/index.php");
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Clicks in the SignIn button
		header.clickSigInLink();
		// Filling the 'Email Address' text box
		columns.insertCreateEmailAddress(email);
		// Clicking the 'Create an account' button
		columns.clickCreateAccountButton();
		// Selecting the male radio button
		columns.selectMaleRadioButton();
		// Inserting user's first name in the text box
		columns.insertFirstName(firstName);
		// Inserting user's last name in the text box
		columns.insertLastName(lastName);
		// Inserting user's password in the text box
		columns.insertCreatePassword(password);
		// Inserting user's address
		columns.insertAddress(address);
		// Inserting user's city
		columns.insertCity(city);
		// Selecting user's state
		columns.selectStateDropDown(state);
		// Inserting the user's zip/postal code
		columns.insertZipCode(zipCode);
		// Selecting user's country
		columns.selectCountryDropDown(country);
		// Inserting user's phone
		columns.insertMobilePhone(phone);
		// Inserting user's alias
		columns.insertAdressAlias(addressAlias);
		// Clicking the Register button
		columns.clickRegisterButton();
		
		//Assertions
		// Verifying the new user creation
		header.verifyUserName(firstName+" "+lastName);
	}
	
	@Test (priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class, description = "Log a existing user in the system")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Users management")
	@Description("Test Description: This test log an existing user in the system")
	public void logExistingUser(Map<String, String> testData) {
		
		// Data extracted from the .csv file		
		String email = testData.get("email");
		String password = testData.get("password");
		String firstName = testData.get("firstName");
		String lastName = testData.get("lastName");
		
		// Instance necessary website components
		HeaderContainer header = new HeaderContainer(driver, log);
		ColumnsContainer columns = new ColumnsContainer(driver, log);
		
		// Automated Actions		
		// Navigate to the website
		driver.get("http://automationpractice.com/index.php");
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Clicking in the SignIn button
		header.clickSigInLink();
		// Inserting user's email
		columns.insertEmailAddress(email);
		// Inserting user's password
		columns.insertPassword(password);
		// Clicking the SignIn button
		columns.clickSignInButton();
		
		// Assertions
		// Verifying the new user login
		header.verifyUserName(firstName+" "+lastName);
	}
	
	@Test (priority = 2, description = "Try to create a new user using an incorrect email")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Users management")
	@Description("Test Description: This test tries to create a new user using an incorrect email")
	public void incorrectEmail() {
		
		// Instance necessary website components
		HeaderContainer header = new HeaderContainer(driver, log);
		ColumnsContainer columns = new ColumnsContainer(driver, log);
		
		String expectedErrorMessage = "Invalid email address.";
		
		// Automated Actions		
		// Navigate to the website
		driver.get("http://automationpractice.com/index.php");
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Clicking in the SignIn button
		header.clickSigInLink();
		// Inserting user's email
		columns.insertCreateEmailAddress("incorrectEmail@fail");
		// Clicking the 'Create an account' button
		columns.clickCreateAccountButton();
		
		// Assertions
		columns.verifyIncorrectEmailErrorMessage(expectedErrorMessage);
	}
}
