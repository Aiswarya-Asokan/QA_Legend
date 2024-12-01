package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import pages.KitchenPage;
import utility.ExcelUtility;

public class KitchenTest extends Base{
@Test
	public void verifyViewAllOrders() throws IOException
	{
	String username=ExcelUtility.getStringData(1, 0,"Kitchen");
	String password=ExcelUtility.getIntegerData(1, 1,"Kitchen");
	LoginPage loginpage=new LoginPage(driver);	
	loginpage.enterUsernameOnUsernameField(username);
	loginpage.enterPasswordOnPasswordField(password);
	loginpage.clickOnLoginButton();
	KitchenPage kitchenpage=new KitchenPage(driver);
	kitchenpage.clickOnKitchenMenu();
	}
@Test

public void verifyViewEachOrderDetail() throws IOException
{
	String username=ExcelUtility.getStringData(1, 0,"Kitchen");
	String password=ExcelUtility.getIntegerData(1, 1,"Kitchen");
	LoginPage loginpage=new LoginPage(driver);	
	loginpage.enterUsernameOnUsernameField(username);
	loginpage.enterPasswordOnPasswordField(password);
	loginpage.clickOnLoginButton();
	KitchenPage kitchenpage=new KitchenPage(driver);
	kitchenpage.clickOnKitchenMenu();
	
}
}
