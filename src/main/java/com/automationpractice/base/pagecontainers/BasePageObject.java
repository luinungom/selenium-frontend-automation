package com.automationpractice.base.pagecontainers;

import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.time.Duration;

import static com.automationpractice.base.TestUtilities.sleep;

/**
 * Contains all testing common methods.
 *
 * @author Luis Núñez
 */
public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    /**
     * Constructor.
     *
     * @param driver WebDriver.
     * @param log    Logger.
     */
    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    /**
     * Waits until the specified element is visible and then clicks.
     * on it.
     *
     * @param locator for the web element
     */
    @Step("Clicking element {0}")
    protected void click(By locator) {
        log.info("Clicking element {}", locator);
        waitElementToBeClickable(locator);
        find(locator).click();
    }

    /**
     * Returns the WebElement for the specified locator.
     *
     * @param locator for the web element
     * @return WebElement
     */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Waits for the specified amount of seconds until the element is present.
     *
     * @param locator       of the element to check presence
     * @param timeInSeconds seconds to wait
     */
    @Step("Waiting {1} seconds max until the element with locator {0} is present")
    protected void waitForPresenceOf(By locator, Duration timeInSeconds) {
        log.info("Waiting {1} seconds max until the element with locator {} is present", timeInSeconds, locator);
        for (int i = 0; i < 2; i++) {
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
                waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(locator), (timeInSeconds));
            } catch (NoSuchFrameException e) {
                log.info("Error, element is never present");
            } finally {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
        }
    }

    /**
     * Waits 30 seconds max until the element is present. Overloaded version.
     *
     * @param locator of the element to check presence
     */
    protected void waitForPresenceOf(By locator) {
        waitForPresenceOf(locator, Duration.ofSeconds(30));
    }

    /**
     * Waits for the specified amount of seconds until the element is visible.
     *
     * @param locator       of the element to check visibility
     * @param timeInSeconds seconds to wait
     */
    @Step("Waiting {1} seconds max until the element with locator {0} is visible")
    protected void waitForVisibilityOf(By locator, Duration timeInSeconds) {
        log.info("Waiting {} seconds max until the element with locator {} is visible", timeInSeconds, locator);
        waitForPresenceOf(locator, timeInSeconds);
        for (int i = 0; i < 2; i++) {
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
                waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(locator), (timeInSeconds));
            } catch (StaleElementReferenceException e) {
                log.info("Error, element is never visible");
            } finally {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
        }
    }

    /**
     * Waits 30 seconds max until the element is visible. Overloaded version.
     *
     * @param locator of the element to check visibility
     */
    protected void waitForVisibilityOf(By locator) {
        waitForVisibilityOf(locator, Duration.ofSeconds(30));
    }

    /**
     * Waits for the specified amount of seconds until the element is visible.
     *
     * @param locator of the element to check visibility
     */
    @Step("Waiting 30 seconds max until the element with locator {0} is clickable")
    protected void waitElementToBeClickable(By locator) {
        log.info("Waiting 30 seconds max until the element with locator {}, is clickable", locator);
        waitForPresenceOf(locator);
        for (int i = 0; i < 2; i++) {
            try {
                waitForExpectedCondition(ExpectedConditions.elementToBeClickable(locator), Duration.ofSeconds(30));
            } catch (StaleElementReferenceException e) {
                log.info("Error, element is never clickable");
            }
        }
    }

    /**
     * Waits for the specified amount of seconds until the expected condition
     * happens.
     *
     * @param condition        that must occur
     * @param timeOutInSeconds seconds to wait
     */
    //@Step("Waiting {0} second(s) max until condition {1} occurs")
    protected void waitForExpectedCondition(ExpectedCondition<WebElement> condition, Duration timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    /**
     * Waits for 30 seconds until the expected condition happens. Overloaded version.
     *
     * @param condition that must occur
     */
    protected void waitForExpectedCondition(ExpectedCondition<WebElement> condition) {
        waitForExpectedCondition(condition, Duration.ofSeconds(30));
    }

    /**
     * Returns the current URL.
     *
     * @return Sting URL
     */
    @Step("Retrieving the current URL")
    protected String getURL() {
        log.info("Retrieving the current URL");
        return driver.getCurrentUrl();
    }

    /**
     * Insert text, first checks if the text box is clear, if not it will clear it before inserting the text.
     *
     * @param locator for the text box
     * @param text    to be inserted
     */
    @Step("Inserting text \"{1}\" in the textbox")
    protected void cleanAndTypeTextbox(By locator, String text) {
        log.info("Inserting text \"{}\" in the textbox", text);
        driver.findElement(locator).sendKeys(Keys.CONTROL + "a");
        driver.findElement(locator).sendKeys(Keys.DELETE);
        driver.findElement(locator).sendKeys(text);
    }

    /**
     * It selects an option from a drop-down based on the option's visible text.
     *
     * @param locator for the drop-down.
     * @param value   option's visible text.
     */
    @Step("Selecting value {1} from the drop-down {0}")
    protected void dropDownSelector(By locator, String value) {
        log.info("Selecting value {} from the drop-down {}", value, locator);
        Select dropDown = new Select(find(locator));
        dropDown.selectByVisibleText(value);
    }

    /**
     * Hovers over an element.
     *
     * @param locator for the element.
     */
    @Step("Hovering over {0} web element")
    protected void hoverOver(By locator) {
        log.info("Hovering over {} web element", locator);
        waitForVisibilityOf(locator);
        Actions hover = new Actions(driver);
        WebElement target = driver.findElement(locator);
        hover.moveToElement(target);
        hover.perform();
        hover.build();
    }

    /**
     * Overloaded version of the hoverOver method to accept a WebElement as parameter.
     *
     * @param element WebElement.
     */
    @Step("Hovering over {0} web element")
    protected void hoverOver(WebElement element) {
        log.info("Hovering over {} web element", element);
        Actions hover = new Actions(driver);
        hover.moveToElement(element);
        hover.perform();
        hover.build();
    }

    /**
     * Switches to a new frame.
     *
     * @param newFrameName          New frame to switch.
     * @param timeoutInMilliSeconds Time in milliseconds to wait before switching.
     */
    @Step("Switch to frame {0}")
    protected void switchToFrame(String newFrameName, int timeoutInMilliSeconds) {
        log.info("Start switching to frame with name: {}", newFrameName);
        try {
            sleep(timeoutInMilliSeconds);
            driver.switchTo().frame(newFrameName);
        } catch (NoSuchFrameException e) {
            log.error("Frame not found{}", newFrameName);
            driver.switchTo().defaultContent();
        }
        log.info("Finished switching to frame: {}", newFrameName);
    }

    /**
     * Retrieves the value of an attribute from a web element.
     *
     * @param element   The web element from which the attribute is to be retrieved.
     * @param attribute The name of the attribute to retrieve.
     * @return The value of the specified attribute.
     */
    @Step("Getting attribute {1}")
    protected String getAttribute(WebElement element, String attribute) {
        log.info("Getting attribute {1}");
        String attributeValue = "";
        attributeValue = element.getAttribute(attribute);
        log.info("Attribute value {1} extracted = ", attributeValue);
        return attributeValue;
    }

    /**
     * Clicks on a web element using JavaScript.
     *
     * @param driver  The WebDriver instance to use.
     * @param element The locator of the web element to be clicked.
     */
    protected void clickJavaScript(WebDriver driver, By element) {
        log.info("Clicking using JavaScript");
        final String JAVA_SCRIPT_CLICK = "arguments[0].click();";
        waitElementToBeClickable(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript(JAVA_SCRIPT_CLICK, find(element));
        sleep(1000);
    }

    // Assertions

    /**
     * Checks if 2 different texts match.
     *
     * @param actualText   Text found.
     * @param expectedText Text to compare.
     */
    @Step("Verifying if found text {0} matches expected text {1}")
    protected void assertEqualText(String actualText, String expectedText) {
        log.info("Verifying if found text \"{}\" matches expected text \"{}\"", actualText, expectedText);
        Assert.assertEquals(actualText, expectedText, "Found text " + actualText + " does not match expected "
                + "text " + expectedText);
    }

    /**
     * Checks if a specific string is contained in a sentence.
     *
     * @param actualText    Text found.
     * @param textToBeFound Text to be found in the actual text.
     */
    @Step("Verifying if word {1} is contained in the sentence {0}")
    protected void assertContainsText(String actualText, String textToBeFound) {
        log.info("Verifying if word {} is contained in the sentence {}", textToBeFound, actualText);
        Assert.assertTrue(actualText.contains(textToBeFound), "Error, word " + textToBeFound + " is missing in "
                + "the sentence '" + actualText + "'");
    }

    /**
     * Compares the similarity between two images and asserts that the similarity
     * percentage is greater than or equal to the specified threshold.
     *
     * @param image1               the first image to compare
     * @param image2               the second image to compare
     * @param similarityPercentage the threshold percentage for similarity
     * @throws NoSuchElementException if the comparison fails
     */
    @Step("Comparing images similarity at {3}%")
    protected void imageComparer(BufferedImage image1, BufferedImage image2, float similarityPercentage) {
        log.info("Comparing images similarity at {}%", similarityPercentage);
        float percentage;
        try {
            // take buffer data from both images
            DataBuffer dataBufferA = image1.getData().getDataBuffer();
            DataBuffer dataBufferB = image2.getData().getDataBuffer();
            int count = 0;
            // compare data-buffer objects pixel by pixel
            for (int i = 0; i < dataBufferA.getSize(); i++) {
                if (dataBufferA.getElem(i) == dataBufferB.getElem(i)) {
                    count++;
                }
            }
            percentage = (float) (count * 100) / dataBufferA.getSize();
        } catch (Exception e) {
            throw new NoSuchElementException("Failed to compare images files");
        }
        Assert.assertTrue(percentage >= similarityPercentage, "Images are the same at " + similarityPercentage);
    }

    /**
     * Excecutes a JS script in a element.
     *
     * @param script Script to be executed.
     * @param element target.
     */
    @Step("Executing JavaScript on element")
    protected void executeJScript(String script, WebElement element) {
        log.info("Executing JavaScript on element");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, element);
    }

    /**
     * Creates an independent browser window, switches the driver's context to the new window, delete all cookies and
     * maximizes the window.
     *
     * @return the window handle of the newly created window.
     */
    @Step("Creating a new browser window")
    protected String openSecondBrowser() {
        log.info("Creating a new browser window");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver.getWindowHandle();
    }

    /**
     * Switches the driver contexts to the specified window handle.
     *
     * @param windowToHandle the window handle to switch to.
     */
    @Step("Switching the driver contect to the specified window handle")
    protected void switchWindow(String windowToHandle) {
        log.info("Switching the driver context to the specified window handle");
        driver.switchTo().window(windowToHandle);
    }

    /**
     * Retrieves the current window handle of the driver.
     *
     * @return the current window handle.
     */
    protected String getWindowHandle() {
        return driver.getWindowHandle();
    }

    /**
     * Refresh the browser.
     */
    @Step("Refreshing the browser ")
    protected void refreshBrowser() {
        log.info("Refreshing the browser");
        driver.navigate().refresh();
    }

}
