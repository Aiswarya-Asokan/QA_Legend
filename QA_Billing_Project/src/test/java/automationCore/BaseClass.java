package automationCore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
@BeforeMethod
	public void intialiseBrowser()
	{
		 driver=new ChromeDriver();
	driver.get("https://qalegend.com/billing/public/login");
	driver.manage().window().maximize();
}
@AfterMethod
	public void driverQuit()
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
		
	}
}