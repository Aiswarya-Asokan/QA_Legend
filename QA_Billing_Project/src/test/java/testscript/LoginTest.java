package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
	@Test(groups={"smoke"},priority=2,description="Login With Invalid Username And Valid Password")
	public void verifyUnableToLoginWithInvalidUsernameAndValidPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(2, 0,"Login");
		String password=ExcelUtility.getIntegerData(2, 1,"Login");
		
		LoginPage loginpage=new LoginPage(driver);	
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		String expectedResult="These credentials do not match our records.";
		String actualresult=loginpage.getTextFromErrorMessage();
		Assert.assertEquals(actualresult, expectedResult,"User was able to Login with invalid credentials");
	}
	@Test(groups={"regression"},description="Login With Valid Username And Invalid Password")
	public void verifyUnableToLoginWithValidUsernameAndInvalidPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(3, 0,"Login");
		String password=ExcelUtility.getIntegerData(3, 1,"Login");
		
		LoginPage loginpage=new LoginPage(driver);	
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		String expectedResult="These credentials do not match our records.";
		String actualresult=loginpage.getTextFromErrorMessage();
		Assert.assertEquals(actualresult, expectedResult,"User was able to Login with invalid credentials");
	}
	
	@Test(dataProvider="loginProvider",description="Login With Invalid Username And Invalid Password")
	public void verifyUnableToLoginWithInvalidUsernameAndInvalidPassword(String username,String password) throws IOException
	{
		
			
		LoginPage loginpage=new LoginPage(driver);	
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickOnLoginButton();
		String expectedResult="These credentials do not match our records.";
		String actualresult=loginpage.getTextFromErrorMessage();
		Assert.assertEquals(actualresult, expectedResult,"User was able to Login with invalid credentials");
	}
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"admin123","admin123"},
			new Object[] {"123","123"},
			new Object[] {ExcelUtility.getStringData(3, 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}
}