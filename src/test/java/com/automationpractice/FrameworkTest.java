package com.automationpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.base.BaseTest;
import com.automationpractice.base.TestUtilities;

/**
 * Tests containing class.
 * 
 * @author Luis Núñez Gómez
 *
 */
public class FrameworkTest extends BaseTest {

	@Test(priority = 0, description = "framework smoke test")
	public void smokeTest() {
		driver.get("http://automationpractice.com/index.php");
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://automationpracticom/index.php");
		TestUtilities.sleep(3000);
	}

}
