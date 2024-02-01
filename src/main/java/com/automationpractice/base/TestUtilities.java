package com.automationpractice.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class TestUtilities {

    /**
     * Pauses automation for the defined amount of time, only for checking steps while a new
     * test is being created
     *
     * @param millis long time in milliseconds
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for a defined amount of seconds until the JS script returns true. Could be useful for things like ajax loading.
     *
     * @param driver        Webdriver.
     * @param timeInSeconds Seconds to wait.
     * @param jsScript      JS script to be executed.
     */
    public static void waitJSExecutor(WebDriver driver, int timeInSeconds, String jsScript) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeInSeconds)) // Max seconds to wait.
                    .pollingEvery(Duration.ofMillis(500)); // Pooling interval between verifications.
            ExpectedCondition<Boolean> jsExecutorCondition = webDriver -> (Boolean) ((JavascriptExecutor) driver).executeScript(jsScript);
            wait.until(jsExecutorCondition);
        } catch (TimeoutException e) {
            throw new TimeoutException("JS script was not completed in the defined amount of time. Original error: " + e.getMessage(), e);
        }
    }
}
