package com.automationpractice;

import java.util.Map;

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
 * Login tests containing class
 * 
 * @author Luis Núñez Gómez
 *
 */
public class LoginTests extends BaseTest{
	
	@Test (priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class, description = "Create a new user in the system")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Users management")
	@Description("Test Description: This test creates a new user in the system")
	public void createNewUser(Map<String, String> testData) {
		
		// Data extracted from the csv file
		String email = testData.get("email");
		
		// Instance web site Components
		HeaderContainer header = new HeaderContainer(driver, log);
		ColumnsContainer columns = new ColumnsContainer(driver, log);
		
		// Navigates to the web site
		driver.get("http://automationpractice.com/index.php");
		// Clicks in the Sign In button
		header.clickSigInLink();
		// Filling the 'Email Address' text box
		columns.insertEmailAddress(email);
		// Clicking the 'Create an account' button
		columns.clickCreateAccountButton();
		TestUtilities.sleep(5000);
	}
}
