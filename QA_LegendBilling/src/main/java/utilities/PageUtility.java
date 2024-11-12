package utilities;

import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

// IllegalArgumentException is a predefined exception class in Java. It is part of the java.lang package, and it is a subclass of RuntimeException.

public class PageUtility {
	 public static void selectByVisibleText(WebElement element, String text) {
	        if (element == null || text == null || text.isEmpty()) {
	            throw new IllegalArgumentException("Element or text must not be null or empty");
	        }

	        Select select = new Select(element);
	        select.selectByVisibleText(text);
	    }
	 public static void selectByValue(WebElement element, String value) {
	        if (element == null || value == null || value.isEmpty()) {
	            throw new IllegalArgumentException("Element or value must not be null or empty");
	        }

	        Select select = new Select(element);
	        select.selectByValue(value);
	    }
	 public static void selectByIndex(WebElement element,int index) {
	        if (element == null) {
	            throw new IllegalArgumentException("Element must not be null");
	        }

	        Select select = new Select(element);
	        select.selectByIndex(index);
	    }
	 public static List<WebElement> getOptions(WebElement element) {
	        if (element == null) {
	            throw new IllegalArgumentException("Element must not be null");
	        }

	        Select select = new Select(element);
	        return select.getOptions();
	    }
	 public static WebElement getFirstSelectedOption(WebElement element) {
	        if (element == null) {
	            throw new IllegalArgumentException("Element must not be null");
	        }

	        Select select = new Select(element);
	        return select.getFirstSelectedOption();
	    }
	 public static void rightClick(WebDriver driver, WebElement element) {
	        if (driver == null || element == null) {
	            throw new IllegalArgumentException("Driver and element must not be null");
	        }

	        Actions action = new Actions(driver);
	        action.contextClick(element).perform();
	    }
	 public static void doubleClick(WebDriver driver, WebElement element) {
	        if (driver == null || element == null) {
	            throw new IllegalArgumentException("Driver and element must not be null");
	        }

	        Actions action = new Actions(driver);
	        action.doubleClick(element).perform(); 
	    }
	 public static void moveToElement(WebDriver driver, WebElement element) {
	        if (driver == null || element == null) {
	            throw new IllegalArgumentException("Driver and element must not be null");
	        }

	        Actions action = new Actions(driver);
	        action.moveToElement(element).perform(); 
	    }
	 public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
	        if (driver == null || source == null || target == null) {
	            throw new IllegalArgumentException("Driver, source, and target elements must not be null");
	        }

	        Actions action = new Actions(driver);
	        action.dragAndDrop(source, target).perform(); // Correctly implement drag-and-drop
	    }
	 public static void dragAndDropBy(WebDriver driver, WebElement element, int xOffset, int yOffset) {
	        if (driver == null || element == null) {
	            throw new IllegalArgumentException("Driver and element must not be null");
	        }

	        Actions action = new Actions(driver);
	        action.dragAndDropBy(element, xOffset, yOffset).perform(); // Use offsets to drag element
	    }
	 public static void keyPress(Robot robot, int keyCode) {
	        if (robot == null) {
	            throw new IllegalArgumentException("Robot instance must not be null");
	        }

	        robot.keyPress(keyCode);
	        robot.keyRelease(keyCode); // Release the key after pressing
	    }
	
	}
	
	

