package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	 public static void waitFor_Element(WebDriver driver, WebElement element)
	 {
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
	  public static void waitFor_Element_tobe_Visible(WebDriver driver)
	  {
			FluentWait wait=new FluentWait(driver);
			wait.withTimeout(Duration.ofSeconds(5)); 
	  }
	  public static void wait_implisitOperation(WebDriver driver)
	  {
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  }
	  public static void duration_interval(WebDriver driver)
	  {
		  FluentWait wait=new FluentWait(driver);
	      wait.pollingEvery(Duration.ofSeconds(3)); 
	  }
	  public static void noelement_exceptionoptions(WebDriver driver)
	  {
		  FluentWait wait=new FluentWait(driver);
		  wait.ignoring(NoSuchElementException.class);
	  }
}
