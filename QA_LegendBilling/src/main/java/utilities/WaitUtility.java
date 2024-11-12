package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitUtility {
	// Wait Operations
    public static void waitForElement(WebDriver driver, WebElement element, long durationInSeconds) {
        if (driver == null || element == null) {
            throw new IllegalArgumentException("Driver and element must not be null");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Overloaded method with default duration
    public static void waitForElement(WebDriver driver, WebElement element) {
        waitForElement(driver, element, 10); // Default wait time of 10 seconds
    }
    public static void waitForElementToBeVisible(WebDriver driver, Function<WebDriver, Boolean> condition) {
        if (driver == null || condition == null) {
            throw new IllegalArgumentException("Driver and condition must not be null");
        }

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class); // Specify exceptions to ignore

        wait.until(condition); // Wait until the provided condition is true
    }
    public static void setImplicitWait(WebDriver driver, long durationInSeconds) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver must not be null");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(durationInSeconds));
    }

    public static FluentWait<WebDriver> setPollingInterval(WebDriver driver, long intervalInSeconds) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver must not be null");
        }

        return new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(intervalInSeconds)); // Set polling interval
    }

    // Overloaded method for default interval
    public static FluentWait<WebDriver> setPollingInterval(WebDriver driver) {
        return setPollingInterval(driver, 3); // Default polling interval of 3 seconds
    }
    public static FluentWait<WebDriver> configureWaitWithNoElementException(WebDriver driver, long timeoutInSeconds) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver must not be null");
        }

        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds)) // Set timeout
                .ignoring(NoSuchElementException.class); // Ignore NoSuchElementException
    }

    // Overloaded method for default timeout
    public static FluentWait<WebDriver> configureWaitWithNoElementException(WebDriver driver) {
        return configureWaitWithNoElementException(driver, 10); // Default timeout of 10 seconds
    }
}
