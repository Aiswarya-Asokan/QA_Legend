package utilities;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebElement;

public class WebElementUtility {

    /**
     * Sends keys to the specified WebElement.
     *
     * @param element the WebElement to interact with
     * @param text    the text to send
     */
    public void sendKeysToElement(WebElement element, String text) {
        if (element != null && text != null) {
            element.sendKeys(text);
        } else {
            throw new IllegalArgumentException("Element and text must not be null");
        }
    }

    /**
     * Clicks on the specified WebElement.
     *
     * @param element the WebElement to click
     */
    public void clickElement(WebElement element) {
        if (element != null) {
            element.click();
        } else {
            throw new IllegalArgumentException("Element must not be null");
        }
    }

    /**
     * Checks if the specified radio button or checkbox is selected.
     *
     * @param element the WebElement to check
     * @return true if selected, false otherwise
     */
    public boolean isSelected(WebElement element) {
        if (element != null) {
            return element.isSelected();
        } else {
            throw new IllegalArgumentException("Element must not be null");
        }
    }

    /**
     * Checks if the specified WebElement is displayed.
     *
     * @param element the WebElement to check
     * @return true if displayed, false otherwise
     */
    public boolean isDisplayed(WebElement element) {
        if (element != null) {
            return element.isDisplayed();
        } else {
            throw new IllegalArgumentException("Element must not be null");
        }
    }

    /**
     * Checks if the specified WebElement is enabled.
     *
     * @param element the WebElement to check
     * @return true if enabled, false otherwise
     */
    public boolean isEnabled(WebElement element) {
        if (element != null) {
            return element.isEnabled();
        } else {
            throw new IllegalArgumentException("Element must not be null");
        }
    }
}

    

