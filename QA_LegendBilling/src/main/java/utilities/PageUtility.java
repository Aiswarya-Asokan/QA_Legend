package utilities;

import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class PageUtility {
	 public static void select_TextOperation(WebElement element, String text )
	 {
		  Select select=new Select(element);
		  select.selectByVisibleText(text);
	 }
	 public static void select_ValueOperation(WebElement element, String value)
	 {
		 Select select=new Select(element);
		 select.selectByValue(value);
	 }
	 public static void select_IndexOperation(WebElement element, String index)
	 {
		 Select select=new Select(element);
		 select.selectByIndex(0);
	 }
	 public static void get_OptionOperation(WebElement element)
	 {
		 Select select=new Select(element);
		 select.getOptions();
	 }
	 public static void first_OptionOperation(WebElement element)
	 {
		 Select select=new Select(element);
		 select.getFirstSelectedOption();
	 }
	 public static void right_ClickOperation(WebDriver driver, WebElement element)
	 {
		 Actions action=new Actions(driver);
		 action.contextClick(element).build().perform();
	 }
	 public static void double_ClickOperation(WebDriver driver, WebElement element)
	 {
		 Actions action=new Actions(driver);
		 action.doubleClick(element).build().perform();
	 }
	 public static void move_Operation(WebDriver driver, WebElement element)
	 {
		 Actions action=new Actions(driver);
		 action.moveToElement(element).build().perform();
	 }
	 public static void dragdrop_Operation(WebDriver driver, WebElement element)
	 {
		 Actions action=new Actions(driver);
		 action.dragAndDrop(element, element).build().perform();
	 }
	 public static void dragdrop_by_Operation(WebDriver driver, WebElement element)
	 {
		 Actions action=new Actions(driver);
		 action.dragAndDropBy(element, 0, 0).build().perform();
		 
	 }
	 public static void key_press_Operation(Robot robot)
	 {
		
		 
	 }
}
