package automation_core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constants.Constants;

public class Base_Class {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream file;
	public void intialise_browse(String browserName) throws FileNotFoundException
	{
		prop=new Properties();
				{
			file=new FileInputStream(Constants.CONFIGFILE);
			try {
				prop.load(file);
			}catch (IOException e)
			{
				e.printStackTrace();
			}
				}
			if(browserName.equals("Chrome"))
			{
				driver=new ChromeDriver();
			}
		else if(browserName.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			throw new RuntimeException("Invalid Browser Received");
		}
		driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
				
	}
	@BeforeMethod(alwaysRun=true)
		public void setup() throws FileNotFoundException
		{
			intialise_browse("Chrome");
		}
@AfterMethod(alwaysRun=true)
public void closebrowser(ITestResult result) throws IOException
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		takescreenshot(result);
	}
}
public void takescreenshot(ITestResult result) throws IOException {
	// TODO Auto-generated method stub
	TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
	File screenshot=takesscreenshot.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshot,new File("./Screenshot/"+result.getName()+".png"));
}
}
