package com.automationpractice;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automationpractice.base.BaseTest;
import com.automationpractice.base.CsvDataProviders;
import com.automationpractice.base.TestUtilities;
import com.automationpractice.base.pagecontainers.ColumnsContainer;
import com.automationpractice.base.pagecontainers.HeaderContainer;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * This class contains all automated steps for the test.
 * 
 * @author Luis Núñez Gómez
 *
 */
public class LoginTests extends BaseTest{
	
	@Test (priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class, description = "Create a new user in the system")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Users management")
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
		
		// Instance necessary web site components		
		HeaderContainer header = new HeaderContainer(driver, log);
		ColumnsContainer columns = new ColumnsContainer(driver, log);
		
		// Automated Actions		
		// Navigate to the web site
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Clicks in the Sign In button
		header.clickSigInLink();
		// Filling the 'Email Address' text box
		columns.insertEmailAddress(email);
		// Clicking the 'Create an account' button
		columns.clickCreateAccountButton();
		// Selecting the male radio button
		columns.selectMaleRadioButton();
		// Inserting user's first name in the text box
		columns.insertFirstName(firstName);
		// Inserting user's last name in the text box
		columns.insertLastName(lastName);
		// Inserting user's password in the text box
		columns.insertPassword(password);
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
		// Verifying the new user creation
		header.verifyUserName(firstName+" "+lastName);
	}
}
