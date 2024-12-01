package automationCore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {
	public WebDriver driver;
@BeforeMethod(alwaysRun=true)
@Parameters("browser")
	public void intialiseBrowser(String browser) throws Exception
	{
	if(browser.equalsIgnoreCase("Chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("Firefox"))
	{
		 driver=new FirefoxDriver();
	}
	else if(browser.equalsIgnoreCase("Edge"))
	{
		 driver=new EdgeDriver();
	}
	else
	{
		throw new Exception("Invalid Browser");
	}
	driver.get("https://qalegend.com/billing/public/login");
	driver.manage().window().maximize();
}

@AfterMethod(alwaysRun=true)
	public void driverQuit()
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
		
	}
}