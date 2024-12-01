package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base{
	@Test(description="Login using valid credentials",groups={"smoke"},priority=1)
public void verifyLoginWithValidUsernameAndValidPassword() throws IOException
{
		String username=ExcelUtility.getStringData(1, 0,"Login");
		String password=ExcelUtility.getIntegerData(1, 1,"Login");
		LoginPage loginpage=new LoginPage(driver);	
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		
	
	   boolean isTodayButtonDisplayed=loginpage.isTodayButtonDisplayed();
	   Assert.assertTrue( isTodayButtonDisplayed,"User is unable to login with valid credentials");
			}
	@Test(groups={"smoke"},priority=2)
	public void verifyUnableToLoginWithInvalidUsernameAndValidPassword()
	{
		String username="admin123";
		String password="123456";
		
		LoginPage loginpage=new LoginPage(driver);	
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		String expectedResult="These credentials do not match our records.";
		String errorMessage=driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']")).getText();
		Assert.assertEquals(errorMessage, expectedResult,"User was able to Login with invalid credentials");
	}
	@Test(groups={"regression"})
	public void verifyUnableToLoginWithValidUsernameAndInvalidPassword()
	{
		String username="admin";
		String password="1234";
		
		LoginPage loginpage=new LoginPage(driver);	
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		String expectedResult="These credentials do not match our records.";
		String errorMessage=driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']")).getText();
		Assert.assertEquals(errorMessage, expectedResult,"User was able to Login with invalid credentials");
	}
	
	@Test
	public void verifyUnableToLoginWithInvalidUsernameAndInvalidPassword()
	{
		
		String username="admin123";
		String password="1234";
		
		LoginPage loginpage=new LoginPage(driver);	
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		String expectedResult="These credentials do not match our records.";
		String errorMessage=driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']")).getText();
		Assert.assertEquals(errorMessage, expectedResult,"User was able to Login with invalid credentials");
	}
}