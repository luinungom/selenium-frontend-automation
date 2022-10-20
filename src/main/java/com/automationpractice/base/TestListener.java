package com.automationpractice.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class TestListener implements ITestListener {
	
	Logger log;
	String testName;
	String testMethodName;

	  /**
	   * Invoked each time before a test will be invoked. The <code>ITestResult</code> is only partially
	   * filled with the references to class, method, start millis and status.
	   *
	   * @param result the partially filled <code>ITestResult</code>
	   * @see ITestResult#STARTED
	   */
	@Override  
	public void onTestStart(ITestResult result) {
	    this.testMethodName = result.getMethod().getMethodName();
	    log.info("[TEST "+testMethodName+" STARTED]");
	  }

	  /**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS
	   */
	@Override  
	public void onTestSuccess(ITestResult result) {
	    log.info("[TEST "+testMethodName+" PASSED]");
	  }

	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	@Override  
	public void onTestFailure(ITestResult result) {
		log.info("[TEST "+testMethodName+" FAILED]");
		// Get driver from BaseTest and assign to local webdriver variable
		Object testClass = result.getInstance();
		WebDriver driver = ((BaseTest) testClass).getDriver();
		
		//Allure ScreenshotRobot and SaveTestLog
		if (driver instanceof WebDriver) {
			log.info("Screenshot captures for test case: "+result.getInstanceName().toString().trim());
			saveScreenshotPNG(driver);
		}
		
		// Save a log on allure
		saveTextLog(result.getInstanceName().trim() + "failed, screenhot taken!");
	  }

	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	@Override  
	public void onTestSkipped(ITestResult result) {
		log.info("[TEST "+testMethodName+" SKIPPED]");
	  }

	  /**
	   * Invoked each time a method fails but has been annotated with successPercentage and this failure
	   * still keeps it within the success percentage requested.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	   */
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a test fails due to a timeout.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   */
	@Override  
	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt; tag
	   * and calling all their Configuration methods.
	   */
	@Override  
	public void onStart(ITestContext context) {
		this.testName = context.getCurrentXmlTest().getName();
		this.log = LogManager.getLogger(testName);
		log.info("[TEST " + testName + " STARTED]");
	  }

	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have run
	   * and all their Configuration methods have been called.
	   */
	@Override  
	public void onFinish(ITestContext context) {
		log.info("[ALL " + testName + " FINISHED]");
	  }
	
	// Attachments for Allure reports
	@Attachment (value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshotPNG (WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment (value = "{0}", type = "text/plain")
	public static String saveTextLog (String message) {
		return message;
	}
}
